import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.io.File;
import java.io.PrintWriter;
import java.io.FileNotFoundException;

import java.util.Scanner;

/**
 * Lead Author(s):
 * @author Polina Mochalova
 *
 * Other Contributors:
 * N/A
 *
 * References:
 * Morelli, R., & Walde, R. (2016).
 * Java, Java, Java: Object-Oriented Problem Solving
 *
 * Date/Version: 05.12.2026
 *
 * Responsibilities of class:
 * RecipeGUI has-a RecipeManager.
 * RecipeGUI has-a JList of recipe names.
 * RecipeGUI has-a JTextArea to display recipe details.
 * RecipeGUI has buttons for adding, removing,
 * saving, and loading recipes.
 * RecipeGUI displays a graphical interface
 * for the Recipe Manager.
 */
public class RecipeGUI extends JFrame
{
    private RecipeManager manager;

    private JList<String> recipeList;
    private DefaultListModel<String> listModel;

    private JTextArea recipeDetails;

    public RecipeGUI(RecipeManager manager)
    {
        this.manager = manager;

        setTitle("Recipe Manager");
        setSize(700, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JLabel titleLabel =
            new JLabel("Recipe Manager", SwingConstants.CENTER);

        titleLabel.setFont(new Font("Arial", Font.BOLD, 22));

        add(titleLabel, BorderLayout.NORTH);

        listModel = new DefaultListModel<String>();

        recipeList = new JList<String>(listModel);

        JScrollPane listScrollPane =
            new JScrollPane(recipeList);

        listScrollPane.setPreferredSize(
            new Dimension(180, 0));

        add(listScrollPane, BorderLayout.WEST);

        recipeDetails = new JTextArea();

        recipeDetails.setEditable(false);

        recipeDetails.setFont(
            new Font("Arial", Font.PLAIN, 16));

        JScrollPane detailsScrollPane =
            new JScrollPane(recipeDetails);

        add(detailsScrollPane, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();

        JButton addButton =
            new JButton("Add Recipe");

        JButton removeButton =
            new JButton("Remove Recipe");

        JButton saveButton =
            new JButton("Save Recipes");

        JButton loadButton =
            new JButton("Load Recipes");

        buttonPanel.add(addButton);
        buttonPanel.add(removeButton);
        buttonPanel.add(saveButton);
        buttonPanel.add(loadButton);

        add(buttonPanel, BorderLayout.SOUTH);

        refreshRecipeList();

        recipeList.addListSelectionListener(
            new ListSelectionListener()
        {
            @Override
            public void valueChanged(ListSelectionEvent e)
            {
                if (!e.getValueIsAdjusting())
                {
                    showSelectedRecipe();
                }
            }
        });

        addButton.addActionListener(
            new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                String recipeName =
                    JOptionPane.showInputDialog(
                        "Enter recipe name:");

                String category =
                    JOptionPane.showInputDialog(
                        "Enter recipe category:");

                if (recipeName != null
                    && recipeName.length() > 0
                    && category != null
                    && category.length() > 0)
                {
                    MainCourseRecipe newRecipe =
                        new MainCourseRecipe(
                            recipeName,
                            category,
                            30,
                            "1. Add instructions here.");

                    newRecipe.addIngredient(
                        new Ingredient(
                            "Ingredient",
                            "Amount"));

                    manager.addRecipe(newRecipe);

                    refreshRecipeList();
                }
            }
        });

        removeButton.addActionListener(
            new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                String selected =
                    recipeList.getSelectedValue();

                if (selected != null)
                {
                    Recipe recipe =
                        manager.findRecipeByName(selected);

                    if (recipe != null)
                    {
                        manager.removeRecipe(recipe);

                        refreshRecipeList();

                        recipeDetails.setText("");
                    }
                }
                else
                {
                    JOptionPane.showMessageDialog(
                        null,
                        "Please select a recipe to remove.");
                }
            }
        });

        saveButton.addActionListener(
            new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                saveRecipesToFile();
            }
        });

        loadButton.addActionListener(
            new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                loadRecipesFromFile();
            }
        });

        setVisible(true);
    }

    private void refreshRecipeList()
    {
        listModel.clear();

        for (Recipe recipe :
            manager.getRecipeBook().getRecipes())
        {
            listModel.addElement(recipe.getName());
        }
    }

    private void showSelectedRecipe()
    {
        String selected =
            recipeList.getSelectedValue();

        if (selected != null)
        {
            Recipe recipe =
                manager.findRecipeByName(selected);

            if (recipe != null)
            {
                String details =
                    recipe.toString() + "\n\n";

                details += "Ingredients:\n";

                for (Ingredient ingredient :
                    recipe.getIngredients())
                {
                    details +=
                        "- " + ingredient + "\n";
                }

                details += "\n\nInstructions:\n";

                details += recipe.getInstructions();

                recipeDetails.setText(details);
            }
        }
    }

    private void saveRecipesToFile()
    {
        try
        {
            PrintWriter output =
                new PrintWriter(
                    new File("recipes.txt"));

            for (Recipe recipe :
                manager.getRecipeBook().getRecipes())
            {
                output.println("RECIPE");
                output.println(prepareForFile(recipe.getName()));
                output.println(prepareForFile(recipe.getCategory()));
                output.println(recipe.getCookTime());
                output.println(prepareForFile(recipe.getInstructions()));
                output.println(recipe.getIngredients().size());

                for (Ingredient ingredient : recipe.getIngredients())
                {
                    output.println(
                        prepareForFile(
                            ingredient.getQuantity()));

                    output.println(
                        prepareForFile(
                            ingredient.getName()));
                }
            }

            output.close();

            JOptionPane.showMessageDialog(
                null,
                "Recipes saved successfully.");
        }
        catch (FileNotFoundException e)
        {
            JOptionPane.showMessageDialog(
                null,
                "Error saving file.");
        }
    }

    private void loadRecipesFromFile()
    {
        try
        {
            manager.clearRecipes();

            recipeDetails.setText("");

            Scanner input =
                new Scanner(
                    new File("recipes.txt"));

            while (input.hasNextLine())
            {
                String marker =
                    input.nextLine();

                if (marker.equals("RECIPE"))
                {
                    String name =
                        restoreFromFile(
                            input.nextLine());

                    String category =
                        restoreFromFile(
                            input.nextLine());

                    int cookTime =
                        Integer.parseInt(
                            input.nextLine());

                    String instructions =
                        restoreFromFile(
                            input.nextLine());

                    int numberOfIngredients =
                        Integer.parseInt(
                            input.nextLine());

                    Recipe recipe;

                    if (category.equalsIgnoreCase("Dessert"))
                    {
                        recipe =
                            new DessertRecipe(
                                name,
                                category,
                                cookTime,
                                instructions);
                    }
                    else
                    {
                        recipe =
                            new MainCourseRecipe(
                                name,
                                category,
                                cookTime,
                                instructions);
                    }

                    for (int i = 0; i < numberOfIngredients; i++)
                    {
                        String quantity =
                            restoreFromFile(
                                input.nextLine());

                        String ingredientName =
                            restoreFromFile(
                                input.nextLine());

                        recipe.addIngredient(
                            new Ingredient(
                                ingredientName,
                                quantity));
                    }

                    manager.addRecipe(recipe);
                }
            }

            input.close();

            refreshRecipeList();

            JOptionPane.showMessageDialog(
                null,
                "Recipes loaded successfully.");
        }
        catch (FileNotFoundException e)
        {
            JOptionPane.showMessageDialog(
                null,
                "recipes.txt was not found.");
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(
                null,
                "Error loading recipes.");
        }
    }

    private String prepareForFile(String text)
    {
        return text.replace("\n", "<new line>");
    }

    private String restoreFromFile(String text)
    {
        return text.replace("<new line>", "\n");
    }
}
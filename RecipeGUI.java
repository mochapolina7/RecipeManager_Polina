import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

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
 * Date/Version: 05.07.2026
 *
 * Responsibilities of class:
 * RecipeGUI has-a RecipeManager.
 * RecipeGUI has-a JList of recipe names.
 * RecipeGUI has-a JTextArea to display recipe details.
 * RecipeGUI has buttons for adding and removing recipes.
 * RecipeGUI displays a simple graphical interface for the Recipe Manager.
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

        JLabel titleLabel = new JLabel("Recipe Manager", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 22));
        add(titleLabel, BorderLayout.NORTH);

        listModel = new DefaultListModel<String>();

        recipeList = new JList<String>(listModel);
        JScrollPane listScrollPane = new JScrollPane(recipeList);
        listScrollPane.setPreferredSize(new Dimension(180, 0));
        add(listScrollPane, BorderLayout.WEST);

        recipeDetails = new JTextArea();
        recipeDetails.setEditable(false);
        recipeDetails.setFont(new Font("Arial", Font.PLAIN, 16));
        JScrollPane detailsScrollPane = new JScrollPane(recipeDetails);
        add(detailsScrollPane, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();

        JButton addButton = new JButton("Add Recipe");
        JButton removeButton = new JButton("Remove Recipe");

        buttonPanel.add(addButton);
        buttonPanel.add(removeButton);

        add(buttonPanel, BorderLayout.SOUTH);

        refreshRecipeList();

        recipeList.addListSelectionListener(new ListSelectionListener()
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

        addButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                String recipeName = JOptionPane.showInputDialog("Enter recipe name:");

                if (recipeName != null && recipeName.length() > 0)
                {
                    DessertRecipe newRecipe = new DessertRecipe(
                        recipeName,
                        "Dessert",
                        30,
                        "1. Add instructions here."
                    );

                    newRecipe.addIngredient(new Ingredient("Ingredient", "Amount"));

                    manager.addRecipe(newRecipe);
                    refreshRecipeList();
                }
            }
        });

        removeButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                String selected = recipeList.getSelectedValue();

                if (selected != null)
                {
                    Recipe recipe = manager.findRecipeByName(selected);

                    if (recipe != null)
                    {
                        manager.removeRecipe(recipe);
                        refreshRecipeList();
                        recipeDetails.setText("");
                    }
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Please select a recipe to remove.");
                }
            }
        });

        setVisible(true);
    }

    private void refreshRecipeList()
    {
        listModel.clear();

        for (Recipe recipe : manager.getRecipeBook().getRecipes())
        {
            listModel.addElement(recipe.getName());
        }
    }

    private void showSelectedRecipe()
    {
        String selected = recipeList.getSelectedValue();

        if (selected != null)
        {
            Recipe recipe = manager.findRecipeByName(selected);

            if (recipe != null)
            {
                String details = recipe.toString() + "\n\n";
                details += "Ingredients:\n";

                for (Ingredient ingredient : recipe.getIngredients())
                {
                    details += "- " + ingredient + "\n";
                }

                details += "\n\nInstructions:\n";
                details += recipe.getInstructions();

                recipeDetails.setText(details);
            }
        }
    }
}
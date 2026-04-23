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
 * Date/Version: 04.23.2026
 *
 * Responsibilities of class:
 * RecipeApp is the main class that runs the application.
 */
public class RecipeApp
{
    public static void main(String[] args)
    {
        System.out.println("Recipe Manager started.");

        RecipeManager manager = new RecipeManager();

        DessertRecipe brownies = new DessertRecipe(
            "Brownies",
            "Dessert",
            35,
            "1. Preheat oven to 350F.\n"
            + "2. Melt butter in a large microwave-safe bowl.\n"
            + "3. Add sugar and cocoa powder, then whisk well.\n"
            + "4. Add eggs one at a time, then add vanilla.\n"
            + "5. Stir in flour and salt until combined.\n"
            + "6. Spread batter into the pan.\n"
            + "7. Bake for about 20 minutes.\n"
            + "8. Let cool before cutting and serving."
        );
        brownies.addIngredient(new Ingredient("Butter or Oil", "1/2 cup"));
        brownies.addIngredient(new Ingredient("Sugar", "1 cup"));
        brownies.addIngredient(new Ingredient("Unsweetened Cocoa Powder", "1/2 cup"));
        brownies.addIngredient(new Ingredient("Eggs", "2 large"));
        brownies.addIngredient(new Ingredient("Vanilla", "1 teaspoon"));
        brownies.addIngredient(new Ingredient("Flour", "1/4 cup"));
        brownies.addIngredient(new Ingredient("Salt", "1/4 teaspoon"));

        MainCourseRecipe pasta = new MainCourseRecipe(
            "Garlic Butter Pasta",
            "Main Course",
            25,
            "1. Combine the seasonings and set them aside.\n"
            + "2. Add 3 tablespoons of butter to a pot over medium heat.\n"
            + "3. Add garlic and seasonings, stirring until the butter foams.\n"
            + "4. Add chicken broth, half and half, soy sauce, and bouillon cube.\n"
            + "5. Bring to a boil and add the pasta.\n"
            + "6. Cook uncovered according to the package instructions, stirring occasionally.\n"
            + "7. Reduce heat to low and gradually stir in the Parmesan cheese.\n"
            + "8. Remove from heat and add the lemon juice.\n"
            + "9. Add the remaining 1 tablespoon of butter, cover, then stir and serve."
        );
        pasta.addIngredient(new Ingredient("Dried Basil", "3/4 teaspoon"));
        pasta.addIngredient(new Ingredient("Dried Oregano", "3/4 teaspoon"));
        pasta.addIngredient(new Ingredient("Dried Parsley", "3/4 teaspoon"));
        pasta.addIngredient(new Ingredient("Mustard Powder", "3/4 teaspoon"));
        pasta.addIngredient(new Ingredient("Dried Thyme", "1/4 teaspoon"));
        pasta.addIngredient(new Ingredient("Onion Powder", "1/4 teaspoon"));
        pasta.addIngredient(new Ingredient("Pepper", "1/4 teaspoon"));
        pasta.addIngredient(new Ingredient("Butter", "4 tablespoons"));
        pasta.addIngredient(new Ingredient("Fresh Garlic, minced", "4 cloves"));
        pasta.addIngredient(new Ingredient("Chicken Broth", "2 3/4 cups"));
        pasta.addIngredient(new Ingredient("Half and Half", "3/4 cup"));
        pasta.addIngredient(new Ingredient("Soy Sauce", "1 teaspoon"));
        pasta.addIngredient(new Ingredient("Chicken Bouillon Cube", "1/2 cube"));
        pasta.addIngredient(new Ingredient("Parmesan Cheese, freshly grated", "3/4 cup"));
        pasta.addIngredient(new Ingredient("Fresh Lemon Juice", "2 tablespoons"));
        pasta.addIngredient(new Ingredient("Shellbow Pasta", "1/2 lb."));

        manager.addRecipe(brownies);
        manager.addRecipe(pasta);

        System.out.println("Number of recipes: " + manager.getNumberOfRecipes());
        System.out.println();

        System.out.println("First recipe:");
        System.out.println(brownies);
        for (Ingredient ingredient : brownies.getIngredients())
        {
            System.out.println("- " + ingredient);
        }

        System.out.println();

        System.out.println("Second recipe:");
        System.out.println(pasta);
        for (Ingredient ingredient : pasta.getIngredients())
        {
            System.out.println("- " + ingredient);
        }

        System.out.println();

        Recipe foundRecipe = manager.findRecipeByName("Brownies");
        if (foundRecipe != null)
        {
            System.out.println("Found recipe: " + foundRecipe.getName());
        }

        new RecipeGUI(manager);
    }
}
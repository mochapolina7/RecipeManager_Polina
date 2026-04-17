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
 * Date/Version: 04.14.2026
 */

/**
 * Purpose: The responsibility of RecipeApp is to start the program.
 *
 * RecipeApp is the main class that runs the application.
 */
public class RecipeApp
{
    public static void main(String[] args)
    {
        System.out.println("Recipe Manager started.");

        Ingredient ingredient1 = new Ingredient("Flour", "2 cups");
        Ingredient ingredient2 = new Ingredient("Milk", "1 cup");

        System.out.println("Ingredients created:");
        System.out.println(ingredient1);
        System.out.println(ingredient2);

        RecipeManager manager = new RecipeManager();
        DessertRecipe dessert = new DessertRecipe("Brownies", "Dessert", 35);

        manager.addRecipe(dessert);

        System.out.println("Number of recipes: " + manager.getNumberOfRecipes());
        System.out.println("Recipe added: " + dessert.getName());
    }
}
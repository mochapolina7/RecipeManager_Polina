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
 * Date/Version: 04.07.2026
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

        // Temporary test objects (for Week 2 progress)
        Ingredient ingredient1 = new Ingredient("Flour", "2 cups");
        Ingredient ingredient2 = new Ingredient("Milk", "1 cup");

        System.out.println("Ingredients created:");
        System.out.println(ingredient1);
        System.out.println(ingredient2);
    }
}
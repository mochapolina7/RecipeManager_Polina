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
 * Purpose: The responsibility of DessertRecipe is to represent a dessert recipe.
 *
 * DessertRecipe is-a Recipe.
 */
public class DessertRecipe extends Recipe
{
    public DessertRecipe(String name, String category, int cookTime)
    {
        super(name, category, cookTime);
    }
}
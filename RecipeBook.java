import java.util.ArrayList;

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
 * Purpose: The responsibility of RecipeBook is to store and manage recipes.
 *
 * RecipeBook has-many Recipe objects.
 */
public class RecipeBook
{
    private ArrayList<Recipe> recipes;

    public RecipeBook()
    {
        recipes = new ArrayList<>();
    }

    public void addRecipe(Recipe recipe)
    {
        recipes.add(recipe);
    }

    public void removeRecipe(Recipe recipe)
    {
        recipes.remove(recipe);
    }

    public ArrayList<Recipe> getRecipes()
    {
        return recipes;
    }

    public int getNumberOfRecipes()
    {
        return recipes.size();
    }
}
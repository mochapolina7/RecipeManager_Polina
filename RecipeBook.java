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
 * Date/Version: 04.28.2026
 *
 * Responsibilities of class:
 * RecipeBook has-many recipes.
 * RecipeBook stores and manages a collection of recipes.
 */
public class RecipeBook
{
    private ArrayList<Recipe> recipes;

    public RecipeBook()
    {
        recipes = new ArrayList<Recipe>();
    }

    public void addRecipe(Recipe recipe)
    {
        recipes.add(recipe);
    }

    public void removeRecipe(Recipe recipe)
    {
        recipes.remove(recipe);
    }

    public int getNumberOfRecipes()
    {
        return recipes.size();
    }

    public ArrayList<Recipe> getRecipes()
    {
        return recipes;
    }

    public Recipe findRecipeByName(String name)
    {
        for (Recipe recipe : recipes)
        {
            if (recipe.getName().equalsIgnoreCase(name))
            {
                return recipe;
            }
        }
        return null;
    }
}
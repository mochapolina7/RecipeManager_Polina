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
 * RecipeManager has-a RecipeBook.
 * RecipeManager connects program logic to recipe data.
 */
public class RecipeManager
{
    private RecipeBook recipeBook;

    public RecipeManager()
    {
        recipeBook = new RecipeBook();
    }

    public RecipeBook getRecipeBook()
    {
        return recipeBook;
    }

    public void addRecipe(Recipe recipe)
    {
        recipeBook.addRecipe(recipe);
    }

    public void removeRecipe(Recipe recipe)
    {
        recipeBook.removeRecipe(recipe);
    }

    public int getNumberOfRecipes()
    {
        return recipeBook.getNumberOfRecipes();
    }

    public Recipe findRecipeByName(String name)
    {
        return recipeBook.findRecipeByName(name);
    }
}
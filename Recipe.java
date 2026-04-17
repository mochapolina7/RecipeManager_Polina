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
 * https://open.umn.edu/opentextbooks/textbooks/java-java-java-object-oriented-problem-solving
 *
 * Date/Version: 04.07.2026
 */

/**
 * Purpose: The responsibility of Recipe is to store shared information for all recipes.
 *
 * Recipe is-a abstract parent class.
 * Recipe has-a name, category, and cook time.
 * Recipe will eventually have-many Ingredient objects.
 * Recipe is a parent class for specific recipe types such as BreakfastRecipe,
 * MainCourseRecipe, and DessertRecipe.
 */
public abstract class Recipe
{
    private String name;
    private String category;
    private int cookTime;

    public Recipe(String name, String category, int cookTime)
    {
        this.name = name;
        this.category = category;
        this.cookTime = cookTime;
    }

    public String getName()
    {
        return name;
    }

    public String getCategory()
    {
        return category;
    }

    public int getCookTime()
    {
        return cookTime;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setCategory(String category)
    {
        this.category = category;
    }

    public void setCookTime(int cookTime)
    {
        this.cookTime = cookTime;
    }
}
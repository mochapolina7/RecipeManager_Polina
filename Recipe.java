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
 * Recipe is an abstract class that represents a general recipe.
 * Recipe is a parent class for specific recipe types such as BreakfastRecipe,
 * MainCourseRecipe, and DessertRecipe.
 */
public abstract class Recipe
{
    protected String name;
    protected String category;
    protected int cookTime;

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
}
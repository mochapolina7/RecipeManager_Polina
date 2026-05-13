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
 * https://open.umn.edu/opentextbooks/textbooks/java-java-java-object-oriented-problem-solving
 *
 * Date/Version: 05.12.2026
 *
 * Responsibilities of class:
 * Recipe is-an abstract parent class.
 * Recipe has-a name, category, cook time, and instructions.
 * Recipe has-many ingredients.
 * Recipe is a super class for specific recipe types.
 */
public abstract class Recipe
{
    private String name;
    private String category;
    private int cookTime;
    private String instructions;
    private ArrayList<Ingredient> ingredients;

    public Recipe(String name, String category, int cookTime, String instructions)
    {
        this.name = name;
        this.category = category;
        this.cookTime = cookTime;
        this.instructions = instructions;
        ingredients = new ArrayList<Ingredient>();
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

    public String getInstructions()
    {
        return instructions;
    }

    public ArrayList<Ingredient> getIngredients()
    {
        return ingredients;
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

    public void setInstructions(String instructions)
    {
        this.instructions = instructions;
    }

    public void addIngredient(Ingredient ingredient)
    {
        ingredients.add(ingredient);
    }

    public void removeIngredient(Ingredient ingredient)
    {
        ingredients.remove(ingredient);
    }

    @Override
    public String toString()
    {
        return name + " (" + category + ", " + cookTime + " minutes)";
    }
}
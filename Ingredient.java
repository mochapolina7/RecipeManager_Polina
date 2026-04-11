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
 * Purpose: The responsibility of Ingredient is to store information about a recipe ingredient.
 *
 * Ingredient is a simple class used within Recipe.
 */
public class Ingredient
{
    private String name;
    private String quantity;

    public Ingredient(String name, String quantity)
    {
        this.name = name;
        this.quantity = quantity;
    }

    public String getName()
    {
        return name;
    }

    public String getQuantity()
    {
        return quantity;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setQuantity(String quantity)
    {
        this.quantity = quantity;
    }

    @Override
    public String toString()
    {
        return quantity + " " + name;
    }
}
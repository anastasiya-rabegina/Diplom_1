package praktikum;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class IngredientTest {
    Ingredient ingredient;

    private final IngredientType testType = IngredientType.FILLING;
    private final String testName = "sausage";
    private final float testPrice = 300;

    @Before
    public void init() {
        ingredient = new Ingredient(testType, testName, testPrice);
    }

    @Test
    public void getPriceReturnsPrice() {
        Assert.assertEquals(testPrice, ingredient.getPrice(), 0);
    }

    @Test
    public void getNameReturnsCorrectName() {
        Assert.assertEquals(testName, ingredient.getName());
    }

    @Test
    public void getTypeReturnsType() {
        Assert.assertEquals(testType, ingredient.getType());
    }
}
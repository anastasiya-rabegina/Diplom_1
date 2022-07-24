package praktikum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class IngredientParamsTest {

    private final IngredientType type;

    public IngredientParamsTest(IngredientType type) {
        this.type = type;
    }

    @Parameterized.Parameters
    public static Object[][] getTypeData() {
        return new Object[][] {
                {IngredientType.FILLING},
                {IngredientType.SAUCE}
        };
    }

    @Test
    public void getTypeReturnsType() {
        Ingredient ingredient = new Ingredient(type, "test", 1F);
        Assert.assertEquals(type, ingredient.getType());
    }
}
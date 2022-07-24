package praktikum;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {


    @Mock
    private Bun bun;

    @Mock
    private Ingredient ingredient;

    private Burger burger;

    private List<Ingredient> ingredients;

    @Before
    public void init() {
        burger = new Burger();
        ingredients = new ArrayList<>();
        burger.ingredients = ingredients;
        burger.bun = bun;
    }

    @Test
    public void getPriceReturnsPrice() {
        Mockito.when(bun.getPrice()).thenReturn(2F);
        burger.addIngredient(new Ingredient(IngredientType.SAUCE, "testName", 10F));

        burger.bun = bun;

        Assert.assertEquals(14F, burger.getPrice(), 0);
    }

    @Test
    public void setBunsSetsBun() {
        burger.setBuns(bun);

        Assert.assertEquals(bun, burger.bun);
    }

    @Test
    public void addIngredientIncreasesListSize() {
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient);

        Assert.assertEquals(2, burger.ingredients.size());
    }

    @Test
    public void removeIngredientDecreasesListSize() {
        ingredients.add(ingredient);

        burger.removeIngredient(0);

        Assert.assertEquals(0, burger.ingredients.size());
    }

    @Test
    public void moveIngredientChangesIndex() {
        Ingredient ingredient1 = new Ingredient(IngredientType.SAUCE, "chili sauce", 300F);
        Ingredient ingredient2 = new Ingredient(IngredientType.FILLING, "sausage", 300F);
        ingredients.add(ingredient1);
        ingredients.add(ingredient2);

        burger.moveIngredient(0,1);

        Assert.assertEquals(ingredient1, burger.ingredients.get(1));
    }

    @Test
    public void getReceiptReturnsCorrectString() {
        Mockito.when(bun.getName()).thenReturn("red bun");
        Ingredient ingredient1 = new Ingredient(IngredientType.SAUCE, "chili sauce", 300F);
        Ingredient ingredient2 = new Ingredient(IngredientType.FILLING, "sausage", 300F);
        ingredients.add(ingredient1);
        ingredients.add(ingredient2);

        burger.getReceipt();

        Assert.assertFalse(burger.getReceipt().isEmpty());
        Assert.assertTrue(burger.getReceipt().contains("chili sauce")
                && burger.getReceipt().contains("sausage")
                && burger.getReceipt().contains("red bun")
                && burger.getReceipt().contains("Price"));
    }
}
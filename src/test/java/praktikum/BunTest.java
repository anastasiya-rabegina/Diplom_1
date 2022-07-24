package praktikum;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BunTest {

    Bun bun;

    private final String testName = "red bun";
    private final float price = 300F;

    @Before
    public void init() {
        bun = new Bun(testName, price);
    }

    @Test
    public void getNameReturnsName() {
        Assert.assertEquals(testName, bun.getName());
    }

    @Test
    public void getPriceReturnsPrice() {
        Assert.assertEquals(price, bun.getPrice(), 0);
    }
}
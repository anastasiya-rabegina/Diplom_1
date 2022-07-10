package praktikum;

import org.junit.Assert;
import org.junit.Test;

public class BunTest {

    @Test
    public void getNameReturnsName() {
        //change to random name later
        String testName = "Флюоресцентная булка R2-D3";

        Bun bun = new Bun(testName, 988);
        Assert.assertEquals(testName, bun.getName());
    }

    @Test
    public void getPriceReturnsPrice() {
        float price = 1;
        Bun bun = new Bun("Test", price);
        Assert.assertEquals(price, bun.getPrice(), 0);
    }
}

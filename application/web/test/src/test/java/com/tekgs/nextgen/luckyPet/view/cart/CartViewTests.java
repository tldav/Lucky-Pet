package com.tekgs.nextgen.luckyPet.view.cart;

import com.tekgs.nextgen.luckyPet.data.cart.Cart;
import com.tekgs.nextgen.luckyPet.data.cart.CartDefinition;
import com.tekgs.nextgen.luckyPet.data.cart.CartProvider;
import com.tekgs.nextgen.luckyPet.data.product.ProductDefinition;
import org.softwareonpurpose.gauntlet.GauntletTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@Test(groups = {GauntletTest.Application.LUCKY_PET_WEB, GauntletTest.View.SHOPPING_CART})
public class CartViewTests extends GauntletTest {
    @DataProvider
    public static Object[][] scenarios() {
        ProductDefinition zeroCostItem = ProductDefinition.getInstance().withPrice(0);
        ProductDefinition negativeCostItem = ProductDefinition.getInstance().withPrice(-100);
        ProductDefinition oneMillionDollarItem = ProductDefinition.getInstance().withPrice(100000000);
        ProductDefinition fiftyCentItem = ProductDefinition.getInstance().withPrice(50);
        ProductDefinition fortyNineCentItem = ProductDefinition.getInstance().withPrice(49);
        ProductDefinition oneLessThanAMillionItem = ProductDefinition.getInstance().withPrice(99999999);
        String sql = "SELECT * FROM CartItem";
        return new Object[][]{
                {CartDefinition.getInstance().withItem(oneLessThanAMillionItem)},
                {CartDefinition.getInstance().withItem(fortyNineCentItem)},
                {CartDefinition.getInstance().withItem(oneMillionDollarItem)},
                {CartDefinition.getInstance().withItem(negativeCostItem)},
                {CartDefinition.getInstance().withItem(zeroCostItem)},
                {CartDefinition.getInstance().withItem(fortyNineCentItem).withItem(fiftyCentItem)},
                {CartDefinition.getInstance().withItemCount(0)},
                {CartDefinition.getInstance().withItem(ProductDefinition.getInstance().withDescription(null))},
                {CartDefinition.getInstance().withItem(ProductDefinition.getInstance().withDescription(""))},
                {CartDefinition.getInstance().withItem(ProductDefinition.getInstance().withDescriptionContaining("<script>"))},
                {CartDefinition.getInstance().withItem(ProductDefinition.getInstance().withDescriptionContaining(sql))}
        };
    }

    @Test(groups = {TestSuite.SMOKE})
    public void smoke() {
        addRequirements("140-Cart View-empty message", "141-Cart View-Usd Formatting");
        CartViewExpected expected = CartViewExpected.getInstance();
        when();
        CartView actual = CartView.directNav();
        then(CartViewCalibrator.getInstance(expected, actual));
    }

    @Test(groups = {TestSuite.RELEASE}, dependsOnMethods = "smoke")
    public void release() {
        addRequirements("140-Cart View-empty message", "141-Cart View-Usd Formatting");
        CartDefinition shoppingCartDefinition =
                CartDefinition.getInstance().withItem(ProductDefinition.getInstance().withPrice(50));
        given(shoppingCartDefinition);
        Cart shoppingCart = CartProvider.getInstance().get(shoppingCartDefinition);
        CartViewExpected expected = CartViewExpected.getInstance(shoppingCart);
        when();
        CartView actual = CartView.directNav(shoppingCart.getId());
        then(CartViewCalibrator.getInstance(expected, actual));
    }

    @Test(dependsOnMethods = "smoke", dataProvider = "scenarios")
    public void directNav(CartDefinition shoppingCartDefinition) {
        addRequirements("140-Cart View-empty message", "141-Cart View-Usd Formatting");
        Cart shoppingCart = CartProvider.getInstance().get(shoppingCartDefinition);
        given(shoppingCart);
        CartViewExpected expected = CartViewExpected.getInstance(shoppingCart);
        when();
        CartView actual = CartView.directNav(shoppingCart.getId());
        then(CartViewCalibrator.getInstance(expected, actual));
    }
}

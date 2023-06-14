package com.tekgs.nextgen.luckyPet.view.cart;

import com.tekgs.nextgen.luckyPet.data.cart.Cart;
import com.tekgs.nextgen.luckyPet.data.cart.CartDefinition;
import com.tekgs.nextgen.luckyPet.data.cart.CartProvider;
import com.tekgs.nextgen.luckyPet.data.cart.item.ItemDefinition;
import com.tekgs.nextgen.luckyPet.data.product.ProductDefinition;
import org.softwareonpurpose.gauntlet.GauntletTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@Test(groups = {GauntletTest.Application.LUCKY_PET_WEB, GauntletTest.View.SHOPPING_CART})
public class CartViewTests extends GauntletTest {
    @DataProvider
    public static Object[][] scenarios() {
        ItemDefinition zeroCostItem = ItemDefinition.getInstance().withProduct(ProductDefinition.getInstance().withPrice(0));
        ItemDefinition negativeCostItem = ItemDefinition.getInstance().withProduct(ProductDefinition.getInstance().withPrice(-100));
        ItemDefinition oneMillionDollarItem = ItemDefinition.getInstance().withProduct(ProductDefinition.getInstance().withPrice(100000000));
        ItemDefinition fiftyCentItem = ItemDefinition.getInstance().withProduct(ProductDefinition.getInstance().withPrice(50));
        ItemDefinition fortyNineCentItem = ItemDefinition.getInstance().withProduct(ProductDefinition.getInstance().withPrice(49));
        ItemDefinition oneLessThanAMillionItem = ItemDefinition.getInstance().withProduct(ProductDefinition.getInstance().withPrice(99999999));
        ItemDefinition productDescriptionNull = ItemDefinition.getInstance().withProduct(ProductDefinition.getInstance().withDescription(null));
        ItemDefinition productDescriptionEmptyString = ItemDefinition.getInstance().withProduct(ProductDefinition.getInstance().withDescription(""));
        ItemDefinition productDescriptionScriptInjection = ItemDefinition.getInstance().withProduct(ProductDefinition.getInstance().withDescriptionContaining("<script>"));
        ItemDefinition productDescriptionSQLInjection = ItemDefinition.getInstance().withProduct(ProductDefinition.getInstance().withDescriptionContaining("SELECT * FROM CartItem"));
        return new Object[][]{
                {CartDefinition.getInstance().withItem(oneLessThanAMillionItem)},
                {CartDefinition.getInstance().withItem(fortyNineCentItem)},
                {CartDefinition.getInstance().withItem(oneMillionDollarItem)},
                {CartDefinition.getInstance().withItem(negativeCostItem)},
                {CartDefinition.getInstance().withItem(zeroCostItem)},
                {CartDefinition.getInstance().withItem(fortyNineCentItem).withItem(fiftyCentItem)},
                {CartDefinition.getInstance().withItemCount(0)},
                {CartDefinition.getInstance().withItem(productDescriptionNull)},
                {CartDefinition.getInstance().withItem(productDescriptionEmptyString)},
                {CartDefinition.getInstance().withItem(productDescriptionScriptInjection)},
                {CartDefinition.getInstance().withItem(productDescriptionSQLInjection)}
        };
    }
    
    @Test(groups = {TestSuite.SMOKE})
    public void smoke() {
        CartViewExpected expected = CartViewExpected.getInstance();
        when();
        CartView actual = CartView.directNav();
        then(CartViewCalibrator.getInstance(expected, actual));
    }
    
    @Test(groups = {TestSuite.RELEASE, TestSuite.ACCEPTANCE}, dependsOnMethods = "smoke")
    public void directNav() {
        addRequirements("53 - Cart View - line item total", "78 - Cart View - item quantity");
        CartDefinition shoppingCartDefinition =
                CartDefinition.getInstance().withItem(ItemDefinition.getInstance().withProduct(ProductDefinition.getInstance().withPrice(50)));
        given(shoppingCartDefinition);
        Cart shoppingCart = CartProvider.getInstance().get(shoppingCartDefinition);
        CartViewExpected expected = CartViewExpected.getInstance(shoppingCart);
        when();
        CartView actual = CartView.directNav(shoppingCart.getId());
        then(CartViewCalibrator.getInstance(expected, actual));
    }
    
    @Test(groups = {}, dependsOnMethods = "smoke", dataProvider = "scenarios")
    public void regression_directNav(CartDefinition shoppingCartDefinition) {
        addRequirements("53 - Cart View - line item total", "78 - Cart View - item quantity");
        Cart shoppingCart = CartProvider.getInstance().get(shoppingCartDefinition);
        given(shoppingCart);
        CartViewExpected expected = CartViewExpected.getInstance(shoppingCart);
        when();
        CartView actual = CartView.directNav(shoppingCart.getId());
        then(CartViewCalibrator.getInstance(expected, actual));
    }
}

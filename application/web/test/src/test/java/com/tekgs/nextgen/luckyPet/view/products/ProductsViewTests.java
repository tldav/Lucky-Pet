package com.tekgs.nextgen.luckyPet.view.products;

import com.tekgs.nextgen.luckyPet.data.cart.Cart;
import com.tekgs.nextgen.luckyPet.data.cart.CartDefinition;
import com.tekgs.nextgen.luckyPet.data.cart.CartProvider;
import org.softwareonpurpose.gauntlet.GauntletTest;
import org.testng.annotations.Test;

@Test(groups = {GauntletTest.Application.LUCKY_PET_WEB, GauntletTest.View.PRODUCTS})
public class ProductsViewTests extends GauntletTest {

    @Test(groups = {TestSuite.SMOKE, TestSuite.ACCEPTANCE,TestSuite.RELEASE})
    public void smoke() {
        addRequirements("71 - Products - Display from inventory");
        ProductsViewExpected expected = ProductsViewExpected.getInstance();
        ProductsView actual = ProductsView.directNav();
        then(ProductsViewCalibrator.getInstance(expected, actual));
    }

    @Test(groups = {TestSuite.ACCEPTANCE, TestSuite.RELEASE}, dependsOnMethods = "smoke")
    public void directNav(){
        addRequirements("70 - Products - 'add to cart UI'");
        CartDefinition cartDefinition = CartDefinition.getInstance();
        Cart cart = CartProvider.getInstance().get(cartDefinition);
        ProductsViewExpected expected = ProductsViewExpected.getInstance(cart);
        ProductsView actual = ProductsView.directNav(cart);
        then(ProductsViewCalibrator.getInstance(expected, actual));
    }
}

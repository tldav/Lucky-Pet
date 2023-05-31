package com.luckypet.user.cart;

import com.luckypet.user.data.cart.Cart;
import com.luckypet.user.data.cart.CartExpected;
import com.luckypet.user.data.cart.CartProvider;
import org.softwareonpurpose.gauntlet.GauntletTest;
import org.testng.annotations.Test;

@Test(groups = {GauntletTest.Service.USER, GauntletTest.Endpoint.CART})
public class CartResponseTests extends GauntletTest {
    @Test(groups = {TestSuite.SMOKE})
    public void smoke() {
        CartResponseExpected expected = CartResponseExpected.getInstance();
        CartResponse actual = CartRequest.getInstance().head();
        then(CartResponseCalibrator.getInstance(expected, actual));
    }

    @Test(groups = {TestSuite.RELEASE, TestSuite.DEBUG}, dependsOnMethods = "smoke")
    public void getById(){
        Cart cart = CartProvider.getInstance().get();
        // given(cart)
        CartExpected cartExpected = CartExpected.getInstance(cart);
        System.out.println(cartExpected);
        CartResponseExpected expected = CartResponseExpected.getInstance(cartExpected);
        // when()
        CartResponse actual = CartRequest.getInstance(cart).get();
        then(CartResponseCalibrator.getInstance(expected,actual));
    }
}




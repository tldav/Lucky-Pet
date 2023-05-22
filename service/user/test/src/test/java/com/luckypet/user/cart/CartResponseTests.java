package com.luckypet.user.cart;

import com.luckypet.user.cart.data.Cart;
import com.luckypet.user.cart.data.CartCalibratable;
import com.luckypet.user.cart.data.CartDefinition;
import com.luckypet.user.cart.data.CartExpected;
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

    @Test(groups = {TestSuite.RELEASE}, dependsOnMethods = "smoke")
    public void getById(){
        CartCalibratable cartDefinition = CartDefinition.getInstance();
        Cart cart = CartProvider.getInstance().get(cartDefinition);
        //given(cart)
        CartExpected cartExpected = CartExpected.getInstance(cart);
        CartResponseExpected expected = CartResponseExpected.getInstance(cartExpected);
        //when
        CartResponse actual = CartRequest.getInstance(cart).get();
        then(CartResponseCalibrator.getInstance(expected,actual));
    }
}

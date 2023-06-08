package com.luckypet.user.cart;

import com.luckypet.behavior.ToStringBehavior;
import com.luckypet.user.data.cart.Cart;
import com.luckypet.user.data.cart.CartExpected;
import com.luckypet.user.data.cart.CartProvider;
import com.luckypet.user.service.cart.CartRequest;
import com.luckypet.user.service.cart.CartResponse;
import com.luckypet.user.service.cart.CartResponseCalibrator;
import com.luckypet.user.service.cart.CartResponseExpected;
import org.softwareonpurpose.gauntlet.GauntletTest;
import org.testng.annotations.Test;

@Test(groups = {GauntletTest.Service.USER, GauntletTest.Endpoint.CART})
public class CartResponseTests extends GauntletTest {
    @Test(groups = {TestSuite.SMOKE})
    public void smoke() {
        CartResponseExpected expected = CartResponseExpected.getInstance();
//        System.out.println(ToStringBehavior.getInstance(expected.getCart()).execute());
        CartResponse actual = CartRequest.getInstance().head();
        then(CartResponseCalibrator.getInstance(expected, actual));
    }
    
    @Test(groups = {TestSuite.RELEASE}, dependsOnMethods = "smoke")
    public void getById() {
        Cart cart = CartProvider.getInstance().get();
        // given(cart)
        CartExpected cartExpected = CartExpected.getInstance(cart);
//        System.out.println(ToStringBehavior.getInstance(cart).execute());
//        System.out.println(ToStringBehavior.getInstance(cartExpected).execute());
        CartResponseExpected expected = CartResponseExpected.getInstance(cartExpected);
        // when()
        CartResponse actual = CartRequest.getInstance(cart).get();
//        System.out.println(ToStringBehavior.getInstance(expected).execute());
//        System.out.println("^^^^^^^^^^^^^^this is the expected ^^^^^^^^^^^^^^^^^^^^^^^");
//        System.out.println("************this is the actual ********************");
//        System.out.println(ToStringBehavior.getInstance(actual).execute());
//        System.out.println("^^^^^^^^^^^^^^this is the actual ^^^^^^^^^^^^^^^^^^^^^^^");
        then(CartResponseCalibrator.getInstance(expected, actual));
    }
    
    @Test(groups = {TestSuite.RELEASE}, dependsOnMethods = "smoke")
    public void addToCart() {
        CartResponseExpected expected = CartResponseExpected.getInstance();
        CartResponse actual = CartRequest.getInstance().put();
        then(CartResponseCalibrator.getInstance(expected, actual));
    }
}




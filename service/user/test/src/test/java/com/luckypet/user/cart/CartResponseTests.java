package com.luckypet.user.cart;

import org.softwareonpurpose.gauntlet.GauntletTest;
import org.testng.annotations.Test;

@Test(groups = {GauntletTest.Service.USER, GauntletTest.Endpoint.CART})
public class CartResponseTests extends GauntletTest {
    
    @Test(groups = {TestSuite.SMOKE, TestSuite.DEBUG})
    public void smoke() {
        CartResponseExpected expected = CartResponseExpected.getInstance();
        CartResponse actual = CartRequest.getInstance();
        then(CartResponseCalibrator.getInstance(expected, actual));
    }
}

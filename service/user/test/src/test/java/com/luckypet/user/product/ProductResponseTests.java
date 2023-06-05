package com.luckypet.user.product;

import com.luckypet.user.service.product.ProductRequest;
import com.luckypet.user.service.product.ProductResponse;
import com.luckypet.user.service.product.ProductResponseCalibrator;
import com.luckypet.user.service.product.ProductResponseExpected;
import org.softwareonpurpose.gauntlet.GauntletTest;
import org.testng.annotations.Test;

@Test(groups = {GauntletTest.Service.USER, GauntletTest.Endpoint.PRODUCT})
public class ProductResponseTests extends GauntletTest {

    @Test(groups = {GauntletTest.TestSuite.SMOKE})
    public void smoke() {
        ProductResponseExpected expected = ProductResponseExpected.getInstance();
        ProductResponse actual = ProductRequest.getInstance().head();
        then(ProductResponseCalibrator.getInstance(expected, actual));
    }
}

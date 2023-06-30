package com.luckypet.user.product;

import com.luckypet.user.data.product.Product;
import com.luckypet.user.data.product.ProductExpected;
import com.luckypet.user.data.product.ProductProvider;
import com.luckypet.user.service.product.*;
import org.softwareonpurpose.gauntlet.GauntletTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

@Test(groups = {GauntletTest.Service.USER, GauntletTest.Endpoint.PRODUCT})
public class ProductResponseTests extends GauntletTest {
    
    @Test(groups = {TestSuite.SMOKE})
    public void smoke() {
        ProductResponseExpected expected = ProductResponseExpected.getInstance();
        ProductResponse actual = ProductRequest.getInstance().head();
        then(ProductResponseCalibrator.getInstance(expected, actual));
    }
    
    @Test(groups = {TestSuite.ACCEPTANCE, TestSuite.DEBUG}, dependsOnMethods = "smoke")
    public void getAll() {
        List<Product> productList = ProductProvider.getInstance().getProducts();
        List<ProductExpected> productListExpected = new ArrayList<>();
        for (Product product : productList) {
            productListExpected.add(ProductExpected.getInstance(product));
        }
        given(productListExpected);
        ProductResponseExpected expected = ProductResponseExpected.getInstance(productListExpected);
        when();
        ProductResponse actual = ProductRequest.getInstance().getAll();
        then(ProductResponseCalibrator.getInstance(expected, actual));
    }

    @Test(groups = {TestSuite.ACCEPTANCE}, dependsOnMethods = "smoke")
    public void getById(){
        Product product = ProductProvider.getInstance().get();
        given(product);
        ProductExpected productExpected = ProductExpected.getInstance(product);
        ProductResponseExpected expected = ProductResponseExpected.getInstance(productExpected);
        ProductResponse actual = ProductRequest.getInstance(product).get();
        then(ProductResponseCalibrator.getInstance(expected, actual));
    }
}

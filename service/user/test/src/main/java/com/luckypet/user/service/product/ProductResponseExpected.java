package com.luckypet.user.service.product;

import com.luckypet.user.data.product.ProductCalibratable;
import com.luckypet.user.data.product.ProductExpected;

import java.util.ArrayList;
import java.util.List;

public class ProductResponseExpected implements ProductResponseCalibratable {
    private final List<ProductCalibratable> products;
    
    public ProductResponseExpected(List<ProductExpected> productExpectedList) {
        this.products = new ArrayList<>();
        
        if (productExpectedList != null) {
            this.products.addAll(productExpectedList);
        }
    }
    
    public static ProductResponseExpected getInstance() {
        return new ProductResponseExpected(null);
    }
    
    @Override
    public Boolean isSuccessful() {
        return true;
    }

    @Override
    public List<ProductCalibratable> getProducts() {
        return this.products;
    }
}
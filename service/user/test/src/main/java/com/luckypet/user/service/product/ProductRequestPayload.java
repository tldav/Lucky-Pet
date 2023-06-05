package com.luckypet.user.service.product;

import com.luckypet.user.data.product.ProductCalibratable;

public class ProductRequestPayload {
    private final ProductCalibratable product;
    
    public ProductRequestPayload(ProductCalibratable product) {
        this.product = product;
    }
    
    public static ProductRequestPayload getInstance(ProductCalibratable product) {
        return new ProductRequestPayload(product);
    }
}

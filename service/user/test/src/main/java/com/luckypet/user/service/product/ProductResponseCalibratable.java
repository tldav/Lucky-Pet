package com.luckypet.user.service.product;

import com.luckypet.user.data.product.ProductCalibratable;

import java.util.List;

public interface ProductResponseCalibratable {
    Boolean isSuccessful();
    List<ProductCalibratable> getProducts();
}

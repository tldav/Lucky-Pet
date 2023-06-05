package com.luckypet.user.product;

import com.luckypet.user.data.cart.CartRepository;

public class ProductProvider {

    private final CartRepository productRepository = CartRepository.getInstance();

    public static ProductProvider getInstance() {
        return new ProductProvider();
    }

    public Product get() {
        return productRepository.query(ProductDefinition.getInstance());
    }
}

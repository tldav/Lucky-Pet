package com.luckypet.user.data.product;

import com.luckypet.user.data.cart.CartRepository;

import java.util.List;

public class ProductProvider {

    private final ProductRepository productRepository = ProductRepository.getInstance();

    public static ProductProvider getInstance() {
        return new ProductProvider();
    }

    public Product get() {
        return productRepository.query(ProductDefinition.getInstance());
    }

    public List<Product> getProducts(){
        return productRepository.query();
    }
}

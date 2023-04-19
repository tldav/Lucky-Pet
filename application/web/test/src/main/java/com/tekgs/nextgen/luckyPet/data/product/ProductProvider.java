package com.tekgs.nextgen.luckyPet.data.product;

import java.util.List;

public class ProductProvider {
    private final ProductRepository repository = ProductRepository.getInstance();

    public static ProductProvider getInstance() {
        return new ProductProvider();
    }
    public List<Product> get() {
        return repository.query();
    }
}

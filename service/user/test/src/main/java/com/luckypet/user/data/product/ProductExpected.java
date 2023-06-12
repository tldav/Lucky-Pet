package com.luckypet.user.data.product;

public class ProductExpected implements ProductCalibratable {
    private final Integer id;
    private final String description;
    private final Integer price;
    private final Integer stock;

    private ProductExpected(Product product) {
        this.id = product.getId();
        this.description = product.getDescription();
        this.price = product.getPrice();
        this.stock = product.getStock();
    }

    public static ProductExpected getInstance(Product product) {
        return new ProductExpected(product);
    }

    @Override
    public Integer getId() {
        return this.id;
    }

    @Override
    public String getDescription() {
        return this.description;
    }

    @Override
    public Integer getPrice() {
        return this.price;
    }

    @Override
    public Integer getStock() {
        return this.stock;
    }

    @Override
    public boolean equivalent(ProductCalibratable comparator) {
        return false;
    }
}

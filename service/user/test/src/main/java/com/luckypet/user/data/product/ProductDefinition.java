package com.luckypet.user.data.product;

public class ProductDefinition implements ProductCalibratable {
    private Integer id;
    private String description;
    private Integer price;
    private Integer stock;

    public static ProductCalibratable getInstance() {
        return new ProductDefinition();
    }

    public ProductDefinition withDescription(String description) {
        this.description = description;
        return this;
    }

    public ProductDefinition withPrice(Integer price) {
        this.price = price;
        return this;
    }

    public ProductDefinition withStock(Integer stock) {
        this.stock = stock;
        return this;
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

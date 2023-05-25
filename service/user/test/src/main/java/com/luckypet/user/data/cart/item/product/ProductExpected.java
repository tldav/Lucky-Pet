package com.luckypet.user.data.cart.item.product;

public class ProductExpected implements ProductCalibratable {
    private String id;
    private String description;
    private Integer price;
    private Integer stock;

    @Override
    public String getId() {
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

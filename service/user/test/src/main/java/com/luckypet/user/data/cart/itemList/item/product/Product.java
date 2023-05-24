package com.luckypet.user.data.cart.itemList.item.product;

public class Product implements ProductCalibratable {
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
}

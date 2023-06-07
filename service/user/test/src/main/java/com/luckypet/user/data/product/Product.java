package com.luckypet.user.data.product;

public class Product implements ProductCalibratable {
    private Integer id;
    private Integer price;
    private String description;
    private Integer stock;

    public Product() {
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
        if (comparator == null){
            return false;
        }
        if (comparator.getId() != null && this.id.equals(comparator.getId())){
            return true;
        }

        boolean isEquivalent = comparator.getDescription() == null || this.description.equals(comparator.getDescription());
        isEquivalent &= comparator.getPrice() == null || this.price.equals(comparator.getPrice());
        isEquivalent &= comparator.getStock() == null || this.stock.equals(comparator.getStock());

        return isEquivalent;
    }
}

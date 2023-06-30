package com.luckypet.user.data.product;

public class Product implements ProductCalibratable {
    private Integer id;
    private Integer price;
    private String description;
    private Integer stock;

    public Product() {
    }

    private Product(Integer id, Integer price, String description, Integer stock) {
        this.id = id;
        this.price = price;
        this.description = description;
        this.stock = stock;
    }

    public static Product getInstance(ProductDefinition productDefinition) {
        return new Product(productDefinition.getId(), productDefinition.getPrice(), productDefinition.getDescription(), productDefinition.getStock());
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

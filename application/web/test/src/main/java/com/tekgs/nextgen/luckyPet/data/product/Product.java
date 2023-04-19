package com.tekgs.nextgen.luckyPet.data.product;

public class Product implements ProductCalibratable {
    private final String id;
    private final Integer price;
    private final String description;
    private final Integer stock;

    private Product(String id, Integer price, String description, Integer stock) {
        this.id = id;
        this.price = price;
        this.description = description;
        this.stock = stock;
    }
    
    @Override
    public String getInvalidDescription() {
        return null;
    }
    
    @Override
    public Integer getPrice() {
        return this.price;
    }
    
    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public Integer getStock() {
        return this.stock;
    }

    @Override
    public boolean equivalent(ProductCalibratable comparator) {
        if (comparator == null) {
            return false;
        }
        boolean isEquivalent = comparator.getPrice() == null || this.getPrice().equals(comparator.getPrice());
        isEquivalent &= comparator.getDescription() == null || this.getDescription().equals(comparator.getDescription());
        isEquivalent &= comparator.getStock() == null || this.getStock().equals(comparator.getStock());
        isEquivalent &= this.getDescription().contains(comparator.getInvalidDescription());
        return isEquivalent;
    }
    
    @Override
    public String getId() {
        return this.id;
    }
    
}

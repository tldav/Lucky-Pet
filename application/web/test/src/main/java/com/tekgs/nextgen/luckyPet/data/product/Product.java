package com.tekgs.nextgen.luckyPet.data.product;

public class Product implements ProductCalibratable {
    private final Integer id;
    private final Integer price;
    private final String description;
    private final Integer stock;
    
    private Product(Integer id, Integer price, String description, Integer stock) {
        this.id = id;
        this.price = price;
        this.description = description;
        this.stock = stock;
    }
    
    @Override
    public Integer getId() {
        return this.id;
    }
    
    @Override
    public Integer getPrice() {
        return this.price;
    }
    
    @Override
    public String getDescription() {
        return this.description;
    }
    
    @Override
    public Integer getStock() {
        return this.stock;
    }
    
    @Override
    public String getInvalidDescription() {
        return null;
    }
    
    @Override
    public boolean equivalent(ProductCalibratable comparator) {
        if (comparator == null) {
            return false;
        }
        boolean isEquivalent = comparator.getPrice() == null || this.price.equals(comparator.getPrice());
        isEquivalent &= comparator.getDescription() == null || this.description.equals(comparator.getDescription());
        isEquivalent &= comparator.getStock() == null || this.stock.equals(comparator.getStock());
        isEquivalent &= this.description.contains(comparator.getInvalidDescription());
        return isEquivalent;
    }
    
}

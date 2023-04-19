package com.tekgs.nextgen.luckyPet.data.product;

public class ProductDefinition implements ProductCalibratable {
    private Integer price;
    private String invalidDescription = "";
    private String description;
    private Integer stock;

    public static ProductDefinition getInstance() {
        return new ProductDefinition();
    }

    public ProductDefinition withPrice(int price) {
        this.price = price;
        return this;
    }

    public ProductDefinition withDescription(String description){
        this.description = description;
        return this;
    }

    public ProductDefinition withDescriptionContaining(String characters) {
        this.invalidDescription = characters;
        return this;
    }

    @Override
    public String getInvalidDescription() {
        return invalidDescription;
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
    public boolean equivalent(ProductCalibratable comparator) {
        return false;
    }
    
    @Override
    public String getId() {
        return null;
    }
}

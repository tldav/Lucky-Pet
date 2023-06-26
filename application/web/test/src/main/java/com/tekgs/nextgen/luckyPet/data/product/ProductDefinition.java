package com.tekgs.nextgen.luckyPet.data.product;

@SuppressWarnings({"FieldCanBeLocal", "unused"})
public class ProductDefinition implements ProductCalibratable {
    private Integer id;
    private Integer price;
    private String description;
    private Integer stock;
    private String invalidDescription = "";
    
    private ProductDefinition() {
    }
    
    public static ProductDefinition getInstance() {
        return new ProductDefinition();
    }
    
    public ProductDefinition withPrice(int price) {
        this.price = price;
        return this;
    }
    
    public ProductDefinition withDescription(String description) {
        this.description = description;
        return this;
    }
    
    public ProductDefinition withDescriptionContaining(String characters) {
        this.invalidDescription = characters;
        return this;
    }
    
    public ProductDefinition withId(Integer id) {
        this.id = id;
        return this;
    }
    
    public ProductDefinition withStock(Integer stock) {
        this.stock = stock;
        return this;
    }
    
    public Product toProduct() {
        return Product.getInstance(this);
    }
    
    @Override
    public Integer getId() {
        return null;
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
        return this.invalidDescription;
    }
    
    @Override
    public boolean equivalent(ProductCalibratable comparator) {
        return false;
    }
}

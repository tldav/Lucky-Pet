package com.luckypet.user.data.product;

public class ProductDefinition implements ProductCalibratable {
    private Integer id;
    private String description;
    private Integer price;
    private Integer stock;

    public ProductDefinition() {
    }

    public static ProductDefinition getInstance() {
        return new ProductDefinition();
    }

    public Product toProduct(){
        return Product.getInstance(this);
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

    public ProductDefinition withId(Integer id) {
        this.id = id;
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

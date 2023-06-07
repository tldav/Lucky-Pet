package com.luckypet.user.data.product;

public interface ProductCalibratable {
    Integer getId();
    String getDescription();
    Integer getPrice();
    Integer getStock();
    boolean equivalent(ProductCalibratable comparator);
}

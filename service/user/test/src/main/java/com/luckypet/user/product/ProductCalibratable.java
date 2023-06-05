package com.luckypet.user.product;

public interface ProductCalibratable {
    String getId();
    String getDescription();
    Integer getPrice();
    Integer getStock();
    boolean equivalent(ProductCalibratable comparator);
}

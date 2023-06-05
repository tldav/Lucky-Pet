package com.luckypet.user.data.product;

public interface ProductCalibratable {
    String getId();
    String getDescription();
    Integer getPrice();
    Integer getStock();
    boolean equivalent(ProductCalibratable comparator);
}

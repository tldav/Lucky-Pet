package com.luckypet.user.data.cart.item.product;

public interface ProductCalibratable {
    String getId();
    String getDescription();
    Integer getPrice();
    Integer getStock();
    boolean equivalent(ProductCalibratable comparator);
}

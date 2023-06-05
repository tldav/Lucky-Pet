package com.luckypet.user.data.cart.item;

import com.luckypet.user.product.Product;

public interface ItemCalibratable {
    Integer getQuantity();
    Product getProduct();
    boolean equivalent(ItemCalibratable comparator);
}

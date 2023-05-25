package com.luckypet.user.data.cart.item;

import com.luckypet.user.data.cart.item.product.Product;

public interface ItemCalibratable {
    Integer getQuantity();
    Product getProduct();
    boolean equivalent(ItemCalibratable comparator);
}

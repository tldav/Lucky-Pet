package com.luckypet.user.data.cart.itemList.item;

import com.luckypet.user.data.cart.itemList.item.product.Product;

public interface ItemCalibratable {
    Integer getQuantity();
    Product getProduct();
    boolean equivalent(ItemCalibratable comparator);
}

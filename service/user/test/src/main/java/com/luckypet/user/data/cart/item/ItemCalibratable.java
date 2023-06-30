package com.luckypet.user.data.cart.item;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.luckypet.user.data.product.Product;

@JsonDeserialize(using = ItemDeserializer.class)
public interface ItemCalibratable {
    Integer getQuantity();
    Product getProduct();
    boolean equivalent(ItemCalibratable comparator);
}

package com.luckypet.user.cart;

import com.luckypet.user.cart.data.CartCalibratable;

import java.util.List;

public interface CartResponseCalibratable {
    boolean isSuccessful();
    
    List<CartCalibratable> getCarts();
}

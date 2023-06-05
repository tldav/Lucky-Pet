package com.luckypet.user.service.cart;

import com.luckypet.user.data.cart.CartCalibratable;

import java.util.List;

public interface CartResponseCalibratable {
    Boolean isSuccessful();
    
    List<CartCalibratable> getCarts();
}

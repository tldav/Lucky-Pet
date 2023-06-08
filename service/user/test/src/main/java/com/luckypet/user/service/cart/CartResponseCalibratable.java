package com.luckypet.user.service.cart;

import com.luckypet.user.data.cart.CartCalibratable;

public interface CartResponseCalibratable {
    Boolean isSuccessful();

    CartCalibratable getCart();
}

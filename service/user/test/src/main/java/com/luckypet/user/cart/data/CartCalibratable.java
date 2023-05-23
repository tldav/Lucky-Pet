package com.luckypet.user.cart.data;

public interface CartCalibratable {
    String getId();
    
    String getUsername();
    
    boolean equivalent(CartCalibratable cartDefinition);
    
}

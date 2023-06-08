package com.luckypet.user.service.cart;

import com.luckypet.user.data.cart.Cart;
import com.luckypet.user.data.cart.CartCalibratable;
import jakarta.ws.rs.core.GenericType;
import jakarta.ws.rs.core.Response;

public class CartResponse implements CartResponseCalibratable {
    private final Response.StatusType statusInfo;
//    private List<Cart> carts = new ArrayList<>();
    
    private Cart cart;
    
    private CartResponse(Response response) {
        this.statusInfo = response.getStatusInfo();
        if (response.hasEntity()){
            this.cart = response.readEntity(new GenericType<>(){});
        }
    }

    public static CartResponse getInstance(Response response) {
        return new CartResponse(response);
    }

    @Override
    public Boolean isSuccessful() {
        return "OK".equals(this.statusInfo.getReasonPhrase());
    }
    
    @Override
    public CartCalibratable getCart() {
        return this.cart;
    }
}

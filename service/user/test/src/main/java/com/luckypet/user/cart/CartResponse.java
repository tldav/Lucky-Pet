package com.luckypet.user.cart;

import com.luckypet.user.cart.data.Cart;
import jakarta.ws.rs.core.GenericType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;
import java.util.List;

public class CartResponse implements CartResponseCalibratable {
    private final Response.StatusType statusInfo;
    private List<Cart> carts = new ArrayList<>();

    public CartResponse(Response response) {
        this.statusInfo = response.getStatusInfo();
        if (response.hasEntity()){
            this.carts = response.readEntity(new GenericType<>(){});
        }
    }

    public static CartResponse getInstance(Response response) {
        return new CartResponse(response);
    }

    @Override
    public boolean isSuccessful() {
        return "OK".equals(statusInfo.getReasonPhrase());
    }
}
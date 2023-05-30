package com.luckypet.user.cart;

import com.luckypet.user.data.cart.Cart;
import com.luckypet.user.data.cart.CartCalibratable;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.Response;

public class CartRequest {
    private static final String DOMAIN_URL = "http://localhost:8080";
    private static final String ENDPOINT = "cart";
    private static final String USER_SERVICE_URI = String.format("%s/%s", DOMAIN_URL, ENDPOINT);
    private final CartRequestPayload cartRequestPayload;
    Client client;

    public CartRequest(CartCalibratable cart) {
        this.client = ClientBuilder.newClient();
        this.cartRequestPayload = CartRequestPayload.getInstance(cart);
    }

    public static CartRequest getInstance() {
        return new CartRequest(null);
    }
    
    public static CartRequest getInstance(Cart cart) {
        return new CartRequest(cart);
    }
    
    public CartResponse head() {
        WebTarget target = client.target(USER_SERVICE_URI);
        CartResponse cartResponse;
        try (Response response = target.request().head()) {
            cartResponse = CartResponse.getInstance(response);
        } finally {
            client.close();
        }
        return cartResponse;
    }

    public CartResponse get() {
        String url = String.format("%s/%s", USER_SERVICE_URI, this.cartRequestPayload.getCart().getId());
        WebTarget target = client.target(url);
        CartResponse cartResponse;
        try (Response response = target.request().get()) {
            cartResponse = CartResponse.getInstance(response);
        } finally {
            client.close();
        }
        return cartResponse;
    }
}

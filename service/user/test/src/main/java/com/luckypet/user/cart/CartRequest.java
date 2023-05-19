package com.luckypet.user.cart;

import com.luckypet.user.cart.data.CartCalibratable;
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

    public CartResponse head() {
        WebTarget target = client.target(USER_SERVICE_URI);
        CartResponse cartResponse;
        try (Response response = target.request().head()){
            cartResponse = CartResponse.getInstance(response);
        } finally {
            client.close();
        }
        return cartResponse;
    }
}

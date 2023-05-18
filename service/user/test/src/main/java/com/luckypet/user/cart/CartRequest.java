package com.luckypet.user.cart;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;

public class CartRequest {
    private static final String DOMAIN_URL = "http://localhost:8080";
    private static final String ENDPOINT = "cart";
    private static final String USER_SERVICE_URI = String.format("%s/%s", DOMAIN_URL, ENDPOINT);
    private final CartRequestPayload cartReqeustPayload;
    Client client;

    public CartRequest(String cartId, String productId, Integer newQuantity) {
        this.client = ClientBuilder.newClient();
        this.cartReqeustPayload = CartRequestPayload.getInstance(cartId, productId, newQuantity);
    }

    public static CartRequest getInstance() {
        return new CartRequest(null,null,null);
    }
}

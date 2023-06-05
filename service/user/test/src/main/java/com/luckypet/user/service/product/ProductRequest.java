package com.luckypet.user.service.product;

import com.luckypet.user.data.product.ProductCalibratable;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.Response;

public class ProductRequest {
    private static final String DOMAIN_URL = "http://localhost:8080";
    private static final String ENDPOINT = "product";
    private static final String PRODUCT_SERVICE_URI = String.format("%s/%s", DOMAIN_URL, ENDPOINT);
    private final Client client;
    private final ProductRequestPayload productRequestPayload;
    
    private ProductRequest(ProductCalibratable product) {
        this.client = ClientBuilder.newClient();
        this.productRequestPayload = ProductRequestPayload.getInstance(product);
    }
    
    public static ProductRequest getInstance() {
        return new ProductRequest(null);
    }
    
    public ProductResponse head() {
        WebTarget target = client.target(PRODUCT_SERVICE_URI);
        ProductResponse productResponse;
        try (Response response = target.request().head()) {
            productResponse = ProductResponse.getInstance(response);
        } finally {
            client.close();
        }
        return productResponse;
    }
    
    public ProductResponse getAll() {
        return null;
    }
}

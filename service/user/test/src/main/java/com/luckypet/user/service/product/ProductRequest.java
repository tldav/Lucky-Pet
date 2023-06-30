package com.luckypet.user.service.product;

import com.luckypet.user.data.product.Product;
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

    public static ProductRequest getInstance(Product product){
        return new ProductRequest(product);
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
        WebTarget target = client.target(PRODUCT_SERVICE_URI);
        ProductResponse productResponse;
        try (Response response = target.request().get()) {
            productResponse = ProductResponse.getInstance(response);
        } finally {
            client.close();
        }
        return productResponse;
    }

    public ProductResponse get() {
        String url = String.format("%s/%s", PRODUCT_SERVICE_URI, this.productRequestPayload.getProduct().getId());
        WebTarget target = client.target(url);
        ProductResponse productResponse;
        try (Response response = target.request().get()) {
            productResponse = ProductResponse.getInstance(response);
        } finally {
            client.close();
        }

        return productResponse;
    }
}

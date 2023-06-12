package com.luckypet.user.service.product;

import com.luckypet.user.data.product.Product;
import com.luckypet.user.data.product.ProductCalibratable;
import jakarta.ws.rs.core.GenericType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;
import java.util.List;

public class ProductResponse implements ProductResponseCalibratable {
    private final Response.StatusType statusInfo;
    private List<Product> products = new ArrayList<>();
    
    private ProductResponse(Response response) {
        this.statusInfo = response.getStatusInfo();
        if (response.hasEntity()) {
            this.products = response.readEntity(new GenericType<>() {
            });
        }
    }
    
    public static ProductResponse getInstance(Response response) {
        return new ProductResponse(response);
    }
    
    @Override
    public Boolean isSuccessful() {
        return "OK".equals(this.statusInfo.getReasonPhrase());
    }

    @Override
    public List<ProductCalibratable> getProducts() {
        return new ArrayList<>(this.products);
    }
}

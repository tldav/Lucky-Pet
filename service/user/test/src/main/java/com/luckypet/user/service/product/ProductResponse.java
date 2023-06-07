package com.luckypet.user.service.product;

import com.luckypet.behavior.ToStringBehavior;
import com.luckypet.user.data.product.Product;
import jakarta.ws.rs.core.GenericType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;
import java.util.List;

public class ProductResponse implements ProductResponseCalibratable {
    private final Response.StatusType statusInfo;
    private List<Product> products = new ArrayList<>();
    
    private ProductResponse(Response response) {
        this.statusInfo = response.getStatusInfo();
        System.out.println("**************** response *************");
        System.out.println(ToStringBehavior.getInstance(response).execute());
        System.out.println("**************** response *************");
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
}

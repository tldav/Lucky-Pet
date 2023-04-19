package com.tekgs.nextgen.luckyPet.view.products.productListRegion;

import com.tekgs.nextgen.luckyPet.data.product.ProductCalibratable;
import com.tekgs.nextgen.luckyPet.data.cart.Cart;
import com.tekgs.nextgen.luckyPet.view.products.productListRegion.productRegion.ProductRegionCalibratable;
import com.tekgs.nextgen.luckyPet.view.products.productListRegion.productRegion.ProductRegionExpected;

import java.util.ArrayList;
import java.util.List;

public class ProductListRegionExpected implements ProductListRegionCalibratable {
    private final List<ProductCalibratable> productList = new ArrayList<>();
    private final Cart cart;
    
    private ProductListRegionExpected(List<ProductCalibratable> productList, Cart cart) {
        this.productList.addAll(productList);
        this.cart = cart;
    }
    
    public static ProductListRegionCalibratable getInstance(List<ProductCalibratable> productList, Cart cart) {
        return new ProductListRegionExpected(productList, cart);
    }
    
    @Override
    public List<ProductRegionCalibratable> getProductRegions() {
        List<ProductRegionCalibratable> productRegionExpectedList = new ArrayList<>();
        this.productList.forEach(product -> {
            boolean isInCart = isInCart(product);
            productRegionExpectedList.add(ProductRegionExpected.getInstance(product, isInCart));
        });
        return productRegionExpectedList;
    }

    private boolean isInCart(ProductCalibratable product) {
        boolean isInCart = false;
        if (cart != null) {
            for (ProductCalibratable item : cart.getItems()) {
                isInCart = product.getId().equals(item.getId());
            }
        }
        return isInCart;
    }
}

package com.tekgs.nextgen.luckyPet.view.products;

import com.tekgs.nextgen.luckyPet.data.cart.Cart;
import com.tekgs.nextgen.luckyPet.data.product.ProductCalibratable;
import com.tekgs.nextgen.luckyPet.data.product.ProductProvider;
import com.tekgs.nextgen.luckyPet.view.products.productListRegion.ProductListRegionCalibratable;
import com.tekgs.nextgen.luckyPet.view.products.productListRegion.ProductListRegionExpected;

import java.util.ArrayList;
import java.util.List;

public class ProductsViewExpected implements ProductsViewCalibratable {
    
    private final Cart cart;
    private final List<ProductCalibratable> productList = new ArrayList<>();
    
    private ProductsViewExpected(Cart cart) {
        this.productList.addAll(ProductProvider.getInstance().get());
        this.cart = cart;
        
    }
    
    public static ProductsViewExpected getInstance() {
        return new ProductsViewExpected(null);
    }
    
    public static ProductsViewExpected getInstance(Cart cart) {
        return new ProductsViewExpected(cart);
    }
    
    @Override
    public ProductListRegionCalibratable inProductListRegion() {
        return ProductListRegionExpected.getInstance(this.productList, this.cart);
    }
}

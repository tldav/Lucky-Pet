package com.tekgs.nextgen.luckyPet.view.products.productListRegion.productRegion;

import com.tekgs.nextgen.luckyPet.data.financial.Cents;
import com.tekgs.nextgen.luckyPet.data.product.ProductCalibratable;

public class ProductRegionExpected implements ProductRegionCalibratable {
    public static final String OUT_OF_STOCK_MESSAGE = "Out Of Stock";
    private final ProductCalibratable product;
    private final boolean isOutOfStock;
    private final boolean isInCart;

    private ProductRegionExpected(ProductCalibratable product, boolean isInCart) {
        this.product = product;
        this.isOutOfStock = this.product.getStock() <= 0;
        this.isInCart = isInCart;
    }

    public static ProductRegionCalibratable getInstance(ProductCalibratable product, boolean isInCart) {
        return new ProductRegionExpected(product,isInCart);
    }
    
    @Override
    public String getOutOfStockMessage() {
        return this.isOutOfStock ? OUT_OF_STOCK_MESSAGE : "";
    }

    @Override
    public boolean equivalent(ProductRegionCalibratable comparator) {
        return false;
    }
    
    @Override
    public String getId() {
        return this.product.getId();
    }

    @Override
    public String getPrice() {
        return Cents.getInstance(this.product.getPrice()).inUsdFormat();
    }

    @Override
    public String getProductDescription() {
        if(product != null && product.getDescription() == null) {
            return "";
        }
        return this.product.getDescription();
    }

    @Override
    public Boolean isAddToCartEnabled() {
        return !isInCart;
    }
}

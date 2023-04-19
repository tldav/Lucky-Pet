package com.tekgs.nextgen.luckyPet.view.inventoryDashboard.lowStockListRegion.lowStockRegion;

import com.tekgs.nextgen.luckyPet.data.product.ProductCalibratable;

public class LowStockRegionExpected implements LowStockRegionCalibratable {
    private final ProductCalibratable product;
    
    private LowStockRegionExpected(ProductCalibratable product) {
        this.product = product;
    }
    
    public static LowStockRegionExpected getInstance(ProductCalibratable product) {
        return new LowStockRegionExpected(product);
    }
    
    @Override
    public boolean equivalent(LowStockRegionCalibratable comparator) {
        return false;
    }
    
    @Override
    public String getProductStock() {
        return String.valueOf(this.product.getStock());
    }
    
    @Override
    public String getProductDescription() {
        return this.product.getDescription();
    }
    
    @Override
    public String getProductPrice() {
        return String.valueOf(this.product.getPrice());
    }
}

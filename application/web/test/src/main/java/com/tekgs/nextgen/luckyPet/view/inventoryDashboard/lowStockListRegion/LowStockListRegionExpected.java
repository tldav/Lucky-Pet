package com.tekgs.nextgen.luckyPet.view.inventoryDashboard.lowStockListRegion;

import com.tekgs.nextgen.luckyPet.data.product.Product;
import com.tekgs.nextgen.luckyPet.data.product.ProductProvider;
import com.tekgs.nextgen.luckyPet.view.inventoryDashboard.lowStockListRegion.lowStockRegion.LowStockRegionCalibratable;
import com.tekgs.nextgen.luckyPet.view.inventoryDashboard.lowStockListRegion.lowStockRegion.LowStockRegionExpected;

import java.util.ArrayList;
import java.util.List;

public class LowStockListRegionExpected implements LowStockListRegionCalibratable {

    private final List<Product> products = new ArrayList<>();

    private LowStockListRegionExpected() {
        this.products.addAll(ProductProvider.getInstance().get());
    }

    public static LowStockListRegionCalibratable getInstance() {
        return new LowStockListRegionExpected();
    }

    @Override
    public List<LowStockRegionCalibratable> getLowStockRegions() {
        List<LowStockRegionCalibratable> lowStockRegionsExpected = new ArrayList<>();
        this.products.forEach(product -> {
            boolean hasLowStock = this.hasLowStock(product);
            if (hasLowStock) {
                lowStockRegionsExpected.add(LowStockRegionExpected.getInstance(product));
            }
        });
        return lowStockRegionsExpected;
    }

    private boolean hasLowStock(Product product) {
        return product.getStock() < 6;
    }
}

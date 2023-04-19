package com.tekgs.nextgen.luckyPet.view.inventoryDashboard.lowStockListRegion.lowStockRegion;

import com.softwareonpurpose.uinavigator.UiElement;
import com.softwareonpurpose.uinavigator.UiLocatorType;
import com.softwareonpurpose.uinavigator.UiRegion;

public class LowStockRegion extends UiRegion implements LowStockRegionCalibratable {
    private LowStockRegion(UiElement regionElement) {
        super(regionElement);
    }
    
    public static LowStockRegion getInstance(UiElement regionElement) {
        return new LowStockRegion(regionElement);
    }
    
    private UiElement getStockElement() {
        return UiElement.getInstance("'Product' stock", UiLocatorType.CLASS, "product-stock-low", this.getElement());
    }
    
    private UiElement getDescriptionElement() {
        return UiElement.getInstance("'Product' description", UiLocatorType.CLASS, "product-description-low", this.getElement());
    }
    
    private UiElement getPriceElement() {
        return UiElement.getInstance("'Product' price", UiLocatorType.CLASS, "product-price-low", this.getElement());
    }
    
    @Override
    public String getProductStock() {
        return this.getStockElement().getText();
    }
    
    @Override
    public String getProductDescription() {
        return this.getDescriptionElement().getText();
    }
    
    @Override
    public String getProductPrice() {
        return this.getPriceElement().getText();
    }
    
    @Override
    public boolean equivalent(LowStockRegionCalibratable comparator) {
        if (comparator == null) {
            return false;
        }
        boolean isEquivalent = comparator.getProductDescription() == null || this.getProductDescription().equals(comparator.getProductDescription());
        isEquivalent &= comparator.getProductStock() == null || this.getProductStock().equals(comparator.getProductStock());
        isEquivalent &= comparator.getProductPrice() == null || this.getProductPrice().equals(comparator.getProductPrice());
        return isEquivalent;
    }
}

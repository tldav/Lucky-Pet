package com.tekgs.nextgen.luckyPet.view.products.productListRegion.productRegion;

import com.softwareonpurpose.uinavigator.UiElement;
import com.softwareonpurpose.uinavigator.UiLocatorType;
import com.softwareonpurpose.uinavigator.UiRegion;

public class ProductRegion extends UiRegion implements ProductRegionCalibratable {
    public ProductRegion(UiElement productRegionElement) {
        super(productRegionElement);
    }
    
    public static ProductRegion getInstance(UiElement productRegionElement) {
        return new ProductRegion(productRegionElement);
    }
    
    private UiElement getOutOfStockElement() {
        return UiElement.getInstance("'Out of Stock' message", UiLocatorType.CLASS, "out-of-stock", this.getElement());
    }
    
    private UiElement getPriceElement() {
        return UiElement.getInstance("Product 'Price'", UiLocatorType.CLASS, "price", this.getElement());
    }
    
    private UiElement getAddToCartButton() {
        return UiElement.getInstance("'Add to Cart' button", UiLocatorType.CLASS, "add-to-cart-button", this.getElement());
    }
    
    private UiElement getProductDescriptionElement() {
        return UiElement.getInstance("Product 'Description'", UiLocatorType.CLASS, "description", this.getElement());
    }
    
    @Override
    public String getId() {
        return this.getElement().getAttribute("data-product");
    }
    
    @Override
    public String getPrice() {
        return this.getPriceElement().getText();
    }
    
    @Override
    public String getProductDescription() {
        return this.getProductDescriptionElement().getText();
    }
    
    @Override
    public String getOutOfStockMessage() {
        return this.getOutOfStockElement().getText();
    }
    
    @Override
    public Boolean isAddToCartEnabled() {
        return this.getAddToCartButton().getAttribute("disabled") == null;
    }
    
    @Override
    public boolean equivalent(ProductRegionCalibratable comparator) {
        if (comparator == null) {
            return false;
        }
        boolean isEquivalent = comparator.getPrice() == null || this.getPrice().equals(comparator.getPrice());
        isEquivalent &= comparator.getProductDescription() == null || this.getProductDescription().equals(comparator.getProductDescription());
        return isEquivalent;
    }
}

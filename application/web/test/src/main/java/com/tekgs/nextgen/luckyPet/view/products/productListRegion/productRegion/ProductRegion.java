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
    
    @Override
    public String getOutOfStockMessage() {
        return getOutOfStockElement().getText();
    }
    
    private UiElement getOutOfStockElement() {
        return UiElement.getInstance("'Out Of Stock' message", UiLocatorType.CLASS, "out-of-stock", this.getElement());
    }
    
    @Override
    public boolean equivalent(ProductRegionCalibratable comparator) {
        return comparator.getId() == null || this.getId().equals(comparator.getId());
    }
    
    @Override
    public String getId() {
        return this.getElement().getAttribute("data-product");
    }
    
    @Override
    public String getPrice() {
        return getPriceElement().getText();
    }
    
    private UiElement getPriceElement() {
        return UiElement.getInstance("Product 'Price'", UiLocatorType.CLASS, "product-price", this.getElement());
    }
    
    @Override
    public String getProductDescription() {
        return getProductDescriptionElement().getText();
    }

    @Override
    public Boolean isAddToCartEnabled() {
        return getAddToCartButton().getAttribute("disabled")== null;
    }
    
    private UiElement getAddToCartButton() {
        return UiElement.getInstance("'Add to Cart' button", UiLocatorType.CLASS, "add-to-cart-button", this.getElement());
    }
    
    
    private UiElement getProductDescriptionElement() {
        return UiElement.getInstance("Product 'Description'", UiLocatorType.CLASS, "product-description", this.getElement());
    }
}

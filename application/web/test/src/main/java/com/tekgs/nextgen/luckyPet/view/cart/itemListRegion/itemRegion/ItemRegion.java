package com.tekgs.nextgen.luckyPet.view.cart.itemListRegion.itemRegion;

import com.softwareonpurpose.uinavigator.UiElement;
import com.softwareonpurpose.uinavigator.UiLocatorType;
import com.softwareonpurpose.uinavigator.UiRegion;

public class ItemRegion extends UiRegion implements ItemRegionCalibratable {
    protected ItemRegion(UiElement regionElement) {
        super(regionElement);
    }
    
    public static ItemRegion getInstance(UiElement itemElement) {
        return new ItemRegion(itemElement);
    }
    
    /*
     ***** Come up with better names for product in ItemRegion *****
     */
    private UiElement getAmountElement() {
        return UiElement.getInstance("Amount", UiLocatorType.CLASS, "product-price", this.getElement());
    }
    
    private UiElement getLineItemQuantityElement() {
        return UiElement.getInstance("'Line Item' quantity", UiLocatorType.CLASS, "line-item-quantity", this.getElement());
    }
    
    private UiElement getLineItemTotalElement() {
        return UiElement.getInstance("'Line Item' total", UiLocatorType.CLASS, "line-item-total", this.getElement());
    }
    
    private UiElement getItemDescriptionElement() {
        return UiElement.getInstance("Item Description", UiLocatorType.CLASS, "product-description", this.getElement());
    }
    
    @Override
    public String getLineItemQuantity() {
        return this.getLineItemQuantityElement().getText();
    }
    
    @Override
    public String getProductPrice() {
        return getAmountElement().getText();
    }
    
    @Override
    public String getProductDescription() {
        return getItemDescriptionElement().getText();
    }
    
    @Override
    public String getLineItemTotal() {
        return this.getLineItemTotalElement().getText();
    }
    
    @Override
    public boolean equivalent(ItemRegionCalibratable comparator) {
        return comparator.getProductPrice() == null || this.getProductPrice().equals(comparator.getProductPrice());
    }
    
}

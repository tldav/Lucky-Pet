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

    @Override
    public boolean equivalent(ItemRegionCalibratable comparator) {
        return comparator.getProductPrice() == null || this.getProductPrice().equals(comparator.getProductPrice());
    }

    @Override
    public String getProductPrice() {
        return getAmountElement().getText();
    }
    /*
     ***** Come up with better names for product in ItemRegion *****
     */
    private UiElement getAmountElement() {
        return UiElement.getInstance("Amount", UiLocatorType.CLASS, "product-price", this.getElement());
    }

    @Override
    public String getProductDescription() {
        return getItemDescriptionElement().getText();
    }
    
    @Override
    public String getLineItemTotal() {
        return this.getLineItemTotalElement().getText();
    }
    
    private UiElement getLineItemTotalElement() {
        return UiElement.getInstance("'Line Item' total", UiLocatorType.CLASS, "line-item-total", this.getElement());
    }
    
    private UiElement getItemDescriptionElement() {
        return UiElement.getInstance("Item Description", UiLocatorType.CLASS, "product-description", this.getElement());
    }

}

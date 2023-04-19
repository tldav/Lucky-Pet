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
        return comparator.getPrice() == null || this.getPrice().equals(comparator.getPrice());
    }

    @Override
    public String getPrice() {
        return getAmountElement().getText();
    }

    private UiElement getAmountElement() {
        return UiElement.getInstance("Amount", UiLocatorType.CLASS, "item-amount", this.getElement());
    }

    @Override
    public String getItemDescription() {
        return getItemDescriptionElement().getText();
    }

    private UiElement getItemDescriptionElement() {
        return UiElement.getInstance("Item Description", UiLocatorType.CLASS, "item-description", this.getElement());
    }

}

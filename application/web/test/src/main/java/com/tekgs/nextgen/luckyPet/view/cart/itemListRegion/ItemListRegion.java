package com.tekgs.nextgen.luckyPet.view.cart.itemListRegion;

import com.softwareonpurpose.uinavigator.UiElement;
import com.softwareonpurpose.uinavigator.UiLocatorType;
import com.softwareonpurpose.uinavigator.UiRegion;
import com.tekgs.nextgen.luckyPet.view.cart.itemListRegion.itemRegion.ItemRegion;
import com.tekgs.nextgen.luckyPet.view.cart.itemListRegion.itemRegion.ItemRegionCalibratable;

import java.util.ArrayList;
import java.util.List;

public class ItemListRegion extends UiRegion implements ItemListRegionCalibratable {

    protected ItemListRegion(UiElement parentElement) {
        super(UiElement.getInstance("'Item List' region",UiLocatorType.ID, "item-list-region", parentElement));
    }

    public static ItemListRegionCalibratable getInstance(UiElement element) {
        return new ItemListRegion(element);
    }

    @Override
    public List<ItemRegionCalibratable> getItemRegions() {
        List<ItemRegionCalibratable> items = new ArrayList<>();
        String description = "'Item' region";
        String locatorValue = "item-region";
        for (UiElement itemElement : UiElement.getList(description, UiLocatorType.CLASS, locatorValue, this.getElement())) {
            items.add(ItemRegion.getInstance(itemElement));
        }
        return items;
    }

    @Override
    public String getCartEmptyMessage() {
        return getCartEmptyMessageElement().getText();
    }

    private UiElement getCartEmptyMessageElement() {
        return UiElement.getInstance("'Empty Cart' message", UiLocatorType.ID, "cart-empty-message",this.getElement());
    }
}

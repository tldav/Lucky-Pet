package com.tekgs.nextgen.luckyPet.view.cart.itemListRegion;

import com.softwareonpurpose.uinavigator.UiElement;
import com.softwareonpurpose.uinavigator.UiLocatorType;
import com.softwareonpurpose.uinavigator.UiRegion;
import com.tekgs.nextgen.luckyPet.view.cart.itemListRegion.itemRegion.ItemRegion;
import com.tekgs.nextgen.luckyPet.view.cart.itemListRegion.itemRegion.ItemRegionCalibratable;

import java.util.ArrayList;
import java.util.List;

public class ItemListRegion extends UiRegion implements ItemListRegionCalibratable {
    private static final String DESCRIPTION = "'Item List' region";
    private static final String LOCATOR_TYPE = UiLocatorType.ID;
    private static final String LOCATOR_VALUE = "item-list-region";
    
    private ItemListRegion(UiElement parentElement) {
        super(UiElement.getInstance(DESCRIPTION, LOCATOR_TYPE, LOCATOR_VALUE, parentElement));
    }
    
    public static ItemListRegionCalibratable getInstance(UiElement element) {
        return new ItemListRegion(element);
    }
    
    private UiElement getCartEmptyMessageElement() {
        return UiElement.getInstance("'Empty Cart' message", UiLocatorType.ID, "cart-empty-message", this.getElement());
    }
    
    @Override
    public String getCartEmptyMessage() {
        return getCartEmptyMessageElement().getText();
    }
    
    @Override
    public List<ItemRegionCalibratable> getItemRegions() {
        List<ItemRegionCalibratable> items = new ArrayList<>();
        for (UiElement itemElement : UiElement.getList("'Item' region", UiLocatorType.CLASS, "item-region", this.getElement())) {
            items.add(ItemRegion.getInstance(itemElement));
        }
        return items;
    }
}

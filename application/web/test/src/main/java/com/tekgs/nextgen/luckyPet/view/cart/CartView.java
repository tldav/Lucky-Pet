package com.tekgs.nextgen.luckyPet.view.cart;

import com.softwareonpurpose.uinavigator.UiElement;
import com.softwareonpurpose.uinavigator.UiLocatorType;
import com.softwareonpurpose.uinavigator.UiView;
import com.tekgs.nextgen.luckyPet.view.LuckyPetView;
import com.tekgs.nextgen.luckyPet.view.cart.itemListRegion.ItemListRegion;
import com.tekgs.nextgen.luckyPet.view.cart.itemListRegion.ItemListRegionCalibratable;

public class CartView extends LuckyPetView implements CartViewCalibratable {
    private static final String RELATIVE_URL = "cart";
    private static final String URL_PARAM = "?cart_id=%s";
    private static final String DESCRIPTION = "'Shopping Cart' view";
    private static final String LOCATOR_TYPE = UiLocatorType.ID;
    private static final String LOCATOR_VALUE = "cart-view";
    
    public CartView() {
        super(RELATIVE_URL, UiElement.getInstance(DESCRIPTION, LOCATOR_TYPE, LOCATOR_VALUE));
    }
    
    public static CartView directNav() {
        new CartView().load();
        return LuckyPetView.expect(CartView.class);
    }
    
    public static CartView directNav(Integer cartId) {
        new CartView().load(String.format(URL_PARAM, cartId));
        return LuckyPetView.expect(CartView.class);
    }
    
    @Override
    protected boolean areKeyElementsLoaded() {
        return true;
    }
    
    private UiElement getTotalElement() {
        return UiElement.getInstance("'Cart' total", LOCATOR_TYPE, "cart-total", this.getElement());
    }
    
    @Override
    public String getTotal() {
        return this.getTotalElement().getText();
    }
    
    @Override
    public ItemListRegionCalibratable getItemListRegion() {
        return ItemListRegion.getInstance(this.getElement());
    }
    
}

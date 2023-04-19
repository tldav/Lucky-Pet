package com.tekgs.nextgen.luckyPet.view.cart;

import com.softwareonpurpose.uinavigator.UiElement;
import com.softwareonpurpose.uinavigator.UiLocatorType;
import com.softwareonpurpose.uinavigator.UiView;
import com.tekgs.nextgen.luckyPet.view.cart.itemListRegion.ItemListRegion;
import com.tekgs.nextgen.luckyPet.view.cart.itemListRegion.ItemListRegionCalibratable;
import org.softwareonpurpose.gauntlet.Environment;

public class CartView extends UiView implements CartViewCalibratable {
    private static final String DOMAIN_URI = Environment.getInstance().getDomainUrl();
    private static final String RELATIVE_URI = "cart";
    private static final String VIEW_URI = String.format("%s/%s", DOMAIN_URI, RELATIVE_URI);
    private static final String DESCRIPTION = "'Shopping Cart' view";
    private static final String LOCATOR_TYPE = UiLocatorType.ID;
    private static final String LOCATOR_VALUE = "cart";
    
    public CartView() {
        super(VIEW_URI, UiElement.getInstance(DESCRIPTION, LOCATOR_TYPE, LOCATOR_VALUE));
    }

    public static CartView directNav() {
        new CartView().load();
        return UiView.expect(CartView.class);
    }

    public static CartView directNav(String cartId) {
        new CartView().load(String.format("?cart_id=%s", cartId));
        return UiView.expect(CartView.class);
    }

    @Override
    protected boolean confirmElementStates() {
        return this.getElement().waitUntilVisible();
    }

    @Override
    public String getTotal() {
        return getTotalElement().getText();
    }

    @Override
    public ItemListRegionCalibratable inItemListRegion() {
        return ItemListRegion.getInstance(this.getElement());
    }

    private UiElement getTotalElement() {
        String description = "Total";
        String locatorValue = "total";
        return UiElement.getInstance(description, UiLocatorType.ID, locatorValue, this.getElement());
    }
}

package com.tekgs.nextgen.luckyPet.view.products;

import com.softwareonpurpose.uinavigator.UiElement;
import com.softwareonpurpose.uinavigator.UiLocatorType;
import com.softwareonpurpose.uinavigator.UiView;
import com.tekgs.nextgen.luckyPet.data.cart.Cart;
import com.tekgs.nextgen.luckyPet.view.products.productListRegion.ProductListRegion;
import com.tekgs.nextgen.luckyPet.view.products.productListRegion.ProductListRegionCalibratable;
import org.softwareonpurpose.gauntlet.Environment;

public class ProductsView extends UiView implements ProductsViewCalibratable {
    private static final String RELATIVE_URL = "products";
    private static final String DOMAIN_URL = Environment.getInstance().getDomainUrl();
    private static final String VIEW_URL = String.format("%s/%s", DOMAIN_URL, RELATIVE_URL);
    private static final String DESCRIPTION = "'Products' view";
    private static final String LOCATOR_TYPE = UiLocatorType.ID;
    private static final String LOCATOR_VALUE = "products-view";

    public ProductsView() {
        super(VIEW_URL, UiElement.getInstance(DESCRIPTION, LOCATOR_TYPE, LOCATOR_VALUE));
    }

    public static ProductsView directNav() {
        new ProductsView().load();
        return UiView.expect(ProductsView.class);
    }

    public static ProductsView directNav(Cart cart) {
        new ProductsView().load(String.format("?cart_id=%s", cart.getId()));
        return UiView.expect(ProductsView.class);
    }

    @Override
    protected boolean confirmElementStates() {
        return false;
    }

    @Override
    public ProductListRegionCalibratable inProductListRegion() {
        return ProductListRegion.getInstance(this.getElement());
    }
}

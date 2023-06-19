package com.tekgs.nextgen.luckyPet.view.products;

import com.softwareonpurpose.uinavigator.UiElement;
import com.softwareonpurpose.uinavigator.UiLocatorType;
import com.tekgs.nextgen.luckyPet.data.cart.Cart;
import com.tekgs.nextgen.luckyPet.view.LuckyPetView;
import com.tekgs.nextgen.luckyPet.view.products.productListRegion.ProductListRegion;
import com.tekgs.nextgen.luckyPet.view.products.productListRegion.ProductListRegionCalibratable;

public class ProductsView extends LuckyPetView implements ProductsViewCalibratable {
    private static final String RELATIVE_URL = "products";
    private static final String URL_PARAM = "?cart_id=%s";
    private static final String DESCRIPTION = "'Products' view";
    private static final String LOCATOR_TYPE = UiLocatorType.ID;
    private static final String LOCATOR_VALUE = "products-view";
    
    public ProductsView() {
        super(RELATIVE_URL, UiElement.getInstance(DESCRIPTION, LOCATOR_TYPE, LOCATOR_VALUE));
    }
    
    public static ProductsView directNav() {
        new ProductsView().load();
        return LuckyPetView.expect(ProductsView.class);
    }
    
    public static ProductsView directNav(Cart cart) {
        new ProductsView().load(String.format(URL_PARAM, cart.getId()));
        return LuckyPetView.expect(ProductsView.class);
    }
    
    @Override
    protected boolean areKeyElementsLoaded() {
        return true;
    }
    
    @Override
    public ProductListRegionCalibratable getProductListRegion() {
        return ProductListRegion.getInstance(this.getElement());
    }
    
}

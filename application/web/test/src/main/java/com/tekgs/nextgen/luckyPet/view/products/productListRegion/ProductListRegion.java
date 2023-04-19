package com.tekgs.nextgen.luckyPet.view.products.productListRegion;

import com.softwareonpurpose.uinavigator.UiElement;
import com.softwareonpurpose.uinavigator.UiLocatorType;
import com.softwareonpurpose.uinavigator.UiRegion;
import com.tekgs.nextgen.luckyPet.view.products.productListRegion.productRegion.ProductRegion;
import com.tekgs.nextgen.luckyPet.view.products.productListRegion.productRegion.ProductRegionCalibratable;

import java.util.ArrayList;
import java.util.List;

public class ProductListRegion extends UiRegion implements ProductListRegionCalibratable {
    private static final String DESCRIPTION = "'Product List' region";
    private static final String LOCATOR_TYPE = UiLocatorType.ID;
    private static final String LOCATOR_VALUE = "product-list-region";

    private ProductListRegion(UiElement parent) {
        super(UiElement.getInstance(DESCRIPTION, LOCATOR_TYPE, LOCATOR_VALUE, parent));
    }
    
    public static ProductListRegion getInstance(UiElement parent) {
        return new ProductListRegion(parent);
    }

    @Override
    public List<ProductRegionCalibratable> getProductRegions() {
        List<ProductRegionCalibratable> productRegions = new ArrayList<>();
        List<UiElement> productElementList = UiElement.getList("'Product' region", UiLocatorType.CLASS, "product-region",
                this.getElement());
        for(UiElement productElement : productElementList) {
            productRegions.add(ProductRegion.getInstance(productElement));
        }
        return productRegions;
    }
}

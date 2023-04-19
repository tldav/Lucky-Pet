package com.tekgs.nextgen.luckyPet.data.cart;

import com.google.gson.Gson;
import com.tekgs.nextgen.luckyPet.data.product.ProductCalibratable;

import java.util.ArrayList;
import java.util.List;

public class CartDefinition implements CartCalibratable {
    private final List<ProductCalibratable> items = new ArrayList<>();
    @SuppressWarnings("unused")
    private Integer total;
    private Integer itemCount;

    public static CartDefinition getInstance() {
        return new CartDefinition();
    }

    @Override
    public Integer getCartTotal() {
        return total;
    }

    @Override
    public List<ProductCalibratable> getItems() {
        return items;
    }

    @Override
    public String getId() {
        return null;
    }

    @Override
    public Integer getItemCount() {
        return itemCount;
    }

    @Override
    public String toString() {
        return String.format("ShoppingCartDefinition %s", new Gson().toJson(this));
    }

    public CartDefinition withItem(ProductCalibratable item) {
        this.items.add(item);
        return this;
    }

    public CartDefinition withItemCount(int itemCount) {
        this.itemCount = itemCount;
        return this;
    }
}

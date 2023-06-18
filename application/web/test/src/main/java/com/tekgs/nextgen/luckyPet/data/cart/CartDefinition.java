package com.tekgs.nextgen.luckyPet.data.cart;

import com.google.gson.Gson;
import com.tekgs.nextgen.luckyPet.data.cart.item.ItemCalibratable;

import java.util.ArrayList;
import java.util.List;

public class CartDefinition implements CartCalibratable {
    private final List<ItemCalibratable> items = new ArrayList<>();
    @SuppressWarnings("unused")
    private Integer total;
    private Integer itemCount;
    
    private CartDefinition() {
    }
    
    public static CartDefinition getInstance() {
        return new CartDefinition();
    }
    
    public CartDefinition withItem(ItemCalibratable item) {
        this.items.add(item);
        return this;
    }
    
    public CartDefinition withItemCount(int itemCount) {
        this.itemCount = itemCount;
        return this;
    }
    
    @Override
    public Integer getId() {
        return null;
    }
    
    @Override
    public List<ItemCalibratable> getItems() {
        return this.items;
    }
    
    @Override
    public Integer getTotal() {
        return this.total;
    }
    
    @Override
    public Integer getItemCount() {
        return this.itemCount;
    }
    
    @Override
    public String toString() {
        return String.format("ShoppingCartDefinition %s", new Gson().toJson(this));
    }
}

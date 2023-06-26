package com.tekgs.nextgen.luckyPet.data.cart;

import com.google.gson.Gson;
import com.tekgs.nextgen.luckyPet.data.cart.item.ItemCalibratable;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unused")
public class CartDefinition implements CartCalibratable {
    private final List<ItemCalibratable> itemList = new ArrayList<>();
    private Integer id;
    private Integer total;
    private Integer itemCount;
    
    private CartDefinition() {
    }
    
    public static CartDefinition getInstance() {
        return new CartDefinition();
    }
    
    public CartDefinition withItem(ItemCalibratable item) {
        this.itemList.add(item);
        return this;
    }
    
    public CartDefinition withItemCount(int itemCount) {
        this.itemCount = itemCount;
        return this;
    }
    
    public CartDefinition withId(Integer id) {
        this.id = id;
        return this;
    }
    
    public CartDefinition withItemList(List<ItemCalibratable> itemList) {
        this.itemList.addAll(itemList);
        return this;
    }
    
    public Cart toCart() {
        return Cart.getInstance(this);
    }
    
    @Override
    public Integer getId() {
        return this.id;
    }
    
    @Override
    public List<ItemCalibratable> getItemList() {
        return this.itemList;
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

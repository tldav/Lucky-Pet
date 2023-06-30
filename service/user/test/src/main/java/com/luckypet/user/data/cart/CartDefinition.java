package com.luckypet.user.data.cart;

import com.luckypet.user.data.cart.item.ItemCalibratable;

import java.util.ArrayList;
import java.util.List;

public class CartDefinition implements CartCalibratable {
    private Integer id;
    private List<ItemCalibratable> itemList = new ArrayList<>();

    private CartDefinition(){
    }

    public static CartDefinition getInstance() {
        return new CartDefinition();
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
    public boolean equivalent(CartCalibratable cartDefinition) {
        return false;
    }
}

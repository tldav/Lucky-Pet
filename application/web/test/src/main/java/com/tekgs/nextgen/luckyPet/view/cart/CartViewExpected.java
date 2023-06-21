package com.tekgs.nextgen.luckyPet.view.cart;

import com.tekgs.nextgen.luckyPet.data.cart.Cart;
import com.tekgs.nextgen.luckyPet.data.cart.item.ItemCalibratable;
import com.tekgs.nextgen.luckyPet.data.financial.Cents;
import com.tekgs.nextgen.luckyPet.view.cart.itemListRegion.ItemListRegionCalibratable;
import com.tekgs.nextgen.luckyPet.view.cart.itemListRegion.ItemListRegionExpected;

import java.util.ArrayList;
import java.util.List;

public class CartViewExpected implements CartViewCalibratable {
    private final Cart cart;
    
    private CartViewExpected(Cart cart) {
        this.cart = cart;
    }
    
    public static CartViewExpected getInstance() {
        return new CartViewExpected(null);
    }
    
    public static CartViewExpected getInstance(Cart shoppingCart) {
        return new CartViewExpected(shoppingCart);
    }
    
    @Override
    public String getTotal() {
        Integer total = this.cart == null ? 0 : this.cart.getTotal();
        return Cents.getInstance(total).inUsdFormat();
    }
    
    @Override
    public ItemListRegionCalibratable getItemListRegion() {
        List<ItemCalibratable> items = this.cart == null ? new ArrayList<>() : this.cart.getItemList();
        return ItemListRegionExpected.getInstance(items);
    }
}

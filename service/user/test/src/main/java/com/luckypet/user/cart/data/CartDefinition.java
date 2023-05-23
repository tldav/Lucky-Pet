package com.luckypet.user.cart.data;

public class CartDefinition implements CartCalibratable {
    //    private final List<ItemCalibratable> items = new ArrayList<>();
    private String id;
    private String username;
    
    public CartDefinition(CartCalibratable cart) {
        if (cart != null) {
//            this.items.addAll(cart.getItems());
            this.id = cart.getId();
        }
    }
    
    public static CartCalibratable getInstance() {
        return new CartDefinition(null);
    }
    
    public CartDefinition withId(String id) {
        this.id = id;
        return this;
    }
    
    public CartDefinition withUsername(String username) {
        this.username = username;
        return this;
    }
    
    
    @Override
    public String getId() {
        return this.id;
    }
    
    @Override
    public String getUsername() {
        return this.username;
    }
    
    @Override
    public boolean equivalent(CartCalibratable cartDefinition) {
        return false;
    }
}

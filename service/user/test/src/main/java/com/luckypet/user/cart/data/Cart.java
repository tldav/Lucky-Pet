package com.luckypet.user.cart.data;

public class Cart implements CartCalibratable {
    private String id;
    private String username;
    
    public String getId() {
        return this.id;
    }
    
    @Override
    public String getUsername() {
        return this.username;
    }
    
    @Override
    public boolean equivalent(CartCalibratable comparator) {
        if (comparator == null) {
            return false;
        }
        if (comparator.getId() != null && this.id.equals(comparator.getId())) {
            return true;
        }
//        boolean isEquivalent = comparator.getId() == null || this.id.equals(comparator.getId());
//        isEquivalent &= comparator.getUsername() == null || this.username.equals(comparator.getUsername());
        
        return comparator.getUsername() == null || this.username.equals(comparator.getUsername());
    }
}

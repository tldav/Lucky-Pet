package com.tekgs.nextgen.luckyPet.data.product;

public interface ProductCalibratable {
    Integer getId();
    
    Integer getPrice();
    
    String getDescription();
    
    Integer getStock();
    
    String getInvalidDescription();
    
    boolean equivalent(ProductCalibratable comparator);
    
}

package com.tekgs.nextgen.luckyPet.data.product;

public interface ProductCalibratable {
    String getInvalidDescription();
    
    Integer getPrice();
    
    String getDescription();

    Integer getStock();
    
    boolean equivalent(ProductCalibratable comparator);
    
    String getId();
}

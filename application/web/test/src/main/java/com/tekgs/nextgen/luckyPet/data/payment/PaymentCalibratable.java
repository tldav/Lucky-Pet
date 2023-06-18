package com.tekgs.nextgen.luckyPet.data.payment;

public interface PaymentCalibratable {
    Integer getAmount();
    
    String getSource();
    
    String getCurrency();
}

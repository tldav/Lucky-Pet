package com.tekgs.nextgen.luckyPet.data.payment;

import com.google.gson.Gson;

public class PaymentDefinition implements PaymentCalibratable {
    private int amount;
    private String currency;
    private String source;
    
    private PaymentDefinition() {
    }
    
    public static PaymentDefinition getInstance() {
        return new PaymentDefinition();
    }
    
    public PaymentDefinition withAmount(int amount) {
        this.amount = amount;
        return this;
    }
    
    public Payment toPayment() {
        return Payment.getInstance(this);
    }
    
    public PaymentDefinition withCurrency(String currency) {
        this.currency = currency;
        return this;
    }
    
    public PaymentDefinition withSource(String source) {
        this.source = source;
        return this;
    }
    
    @Override
    public Integer getAmount() {
        return this.amount;
    }
    
    @Override
    public String getSource() {
        return this.source;
    }
    
    @Override
    public String getCurrency() {
        return this.currency;
    }
    
    @Override
    public String toString() {
        return String.format("PaymentDefinition %s", new Gson().toJson(this));
    }
}

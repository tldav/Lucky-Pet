package com.tekgs.nextgen.luckyPet.data.payment;

public class Payment implements PaymentCalibratable {
    private final Integer amount;
    private final String currency;
    private final String source;
    
    private Payment(PaymentDefinition paymentDefinition) {
        this.amount = paymentDefinition == null ? null : paymentDefinition.getAmount();
        this.currency = paymentDefinition == null ? null : paymentDefinition.getCurrency();
        this.source = paymentDefinition == null ? null : paymentDefinition.getSource();
    }
    
    public static Payment getInstance() {
        return new Payment(null);
    }
    
    public static Payment getInstance(PaymentDefinition paymentDefinition) {
        return new Payment(paymentDefinition);
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
}

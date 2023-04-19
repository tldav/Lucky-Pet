package com.tekgs.nextgen.luckyPet.data.payment;

import com.tekgs.nextgen.luckyPet.behavior.ToStringBehavior;

public class Payment implements PaymentCalibratable {
    private final Integer amount;
    private final String currency;
    private final String type;
    private transient final ToStringBehavior toStringBehavior = ToStringBehavior.getInstance(this);

    public Payment(PaymentDefinition paymentDefinition) {
        this.amount = paymentDefinition == null ? null : paymentDefinition.getAmount();
        this.currency = paymentDefinition == null ? null : paymentDefinition.getCurrency();
        this.type = paymentDefinition == null ? null : paymentDefinition.getType();
    }

    public static Payment getInstance() {
        return new Payment(null);
    }

    public static Payment getInstance(PaymentDefinition paymentDefinition) {
        return new Payment(paymentDefinition);
    }

    @Override
    public Integer getAmount() {
        return amount;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public String getCurrency() {
        return currency;
    }

    @Override
    public String toString() {
        return toStringBehavior.execute();
    }
}

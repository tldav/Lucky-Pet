package com.tekgs.nextgen.luckyPet.data.payment;

import com.google.gson.Gson;

public class PaymentDefinition implements PaymentCalibratable {
    private int amount;
    private String currency;
    private String type;

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
        return String.format("PaymentDefinition %s", new Gson().toJson(this));
    }

    public PaymentDefinition withCurrency(String currency) {
        this.currency = currency;
        return this;
    }

    public PaymentDefinition withType(String type) {
        this.type = type;
        return this;
    }
}

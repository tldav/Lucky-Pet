package com.stripe.api.charges;

public class LuckyPetChargeExpected implements LuckyPetChargesResponseCalibratable {
    private final Long amount;

    public LuckyPetChargeExpected(long amount) {
        this.amount = amount;
    }

    public static LuckyPetChargeExpected getInstance(long amount) {
        return new LuckyPetChargeExpected(amount);
    }

    @Override
    public Boolean isPaymentSuccessful() {
        return amount > 49L && amount < 100000000L;
    }
}

package com.tekgs.nextgen.luckyPet.data.financial;

import java.text.NumberFormat;
import java.util.Locale;

public class Cents {
    private static final double ONE_DOLLAR_IN_CENTS = 100;
    private final double amount;

    public Cents(Long amount) {
        this.amount = amount == null ? 0d : amount;
    }

    public static Cents getInstance(long amount) {
        return new Cents(amount);
    }

    public String inUsdFormat() {
        NumberFormat numberFormatter = NumberFormat.getCurrencyInstance(Locale.US);
        return numberFormatter.format(this.amount / ONE_DOLLAR_IN_CENTS);
    }
}

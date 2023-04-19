package com.stripe.api.charges;

import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.Charge;
import com.stripe.param.ChargeCreateParams;
import org.softwareonpurpose.gauntlet.Environment;

@SuppressWarnings("unused")
public class LuckyPetCharge implements LuckyPetChargesResponseCalibratable {
    private static final String SUCCEEDED = "succeeded";
    private final String source;
    private final String currency;
    private final Long amount;
    private Charge charge;

    private LuckyPetCharge(long amount, String currency, String source) {
        this.source = source;
        this.currency = currency;
        this.amount = amount;
    }

    public static LuckyPetCharge getInstance(long amount, String currency, String source) {
        return new LuckyPetCharge(amount, currency, source);
    }

    @Override
    public Boolean isPaymentSuccessful() {
        return charge != null && charge.getPaid() && SUCCEEDED.equals(charge.getStatus());
    }

    public LuckyPetCharge submit() {
        Stripe.apiKey = Environment.getInstance().getPaymentServiceKey();
        try {
            ChargeCreateParams parameters =
                    ChargeCreateParams.builder()
                            .setAmount(amount)
                            .setCurrency(currency)
                            .setSource(source)
                            .build();
            charge = Charge.create(parameters);
        } catch (StripeException e) {
            e.printStackTrace();
        }
        return this;
    }
}

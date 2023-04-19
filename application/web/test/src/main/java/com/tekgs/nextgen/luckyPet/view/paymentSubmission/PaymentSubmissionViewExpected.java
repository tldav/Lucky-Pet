package com.tekgs.nextgen.luckyPet.view.paymentSubmission;

import com.tekgs.nextgen.luckyPet.data.payment.Payment;

public class PaymentSubmissionViewExpected implements PaymentSubmissionViewCalibratable {
    @SuppressWarnings({"FieldCanBeLocal", "unused"})
    private final Payment paymentData;

    public PaymentSubmissionViewExpected(Payment paymentData) {
        this.paymentData = paymentData;
    }

    public static PaymentSubmissionViewExpected getInstance() {
        return new PaymentSubmissionViewExpected(null);
    }

    public static PaymentSubmissionViewExpected getInstance(Payment paymentData) {
        return new PaymentSubmissionViewExpected(paymentData);
    }

    @Override
    public String getCurrencyError() {
        boolean paymentMade = paymentData != null;
        String currency = !paymentMade ? null : paymentData.getCurrency();
        return !paymentMade || "usd".equals(currency) ? "" : "Currency Error";
    }

    @Override
    public String getTypeError() {
        boolean paymentMade = paymentData != null;
        String type = !paymentMade ? null : paymentData.getType();
        return !paymentMade || "tok_amex".equals(type) ? "" : "Type Error";
    }
}

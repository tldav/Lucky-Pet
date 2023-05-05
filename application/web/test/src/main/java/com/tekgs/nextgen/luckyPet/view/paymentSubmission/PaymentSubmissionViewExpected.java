package com.tekgs.nextgen.luckyPet.view.paymentSubmission;

import com.tekgs.nextgen.luckyPet.data.financial.Cents;
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
//        String currency = paymentData != null ? paymentData.getCurrency() : "";
        boolean isCurrencyValid = this.paymentData.getCurrency() == null || "usd".equals(this.paymentData.getCurrency());
        return isCurrencyValid ? "" : "Invalid Currency";
    }

    @Override
    public String getSourceError() {
       // String source = this.paymentData != null ? this.paymentData.getSource() : "";
        boolean isSourceValid = this.paymentData.getSource() == null || "tok_amex".equals(this.paymentData.getSource());
        return isSourceValid ? "" : "Invalid Source";
    }

    @Override
    public String getTotalOwed() {
        int amount = this.paymentData == null ? 0 : this.paymentData.getAmount();
        Cents totalOwed = Cents.getInstance(amount);
        return totalOwed.inUsdFormat();
    }

    @Override
    public boolean isSubmitButtonDisplayed() {
        return true;
    }
}

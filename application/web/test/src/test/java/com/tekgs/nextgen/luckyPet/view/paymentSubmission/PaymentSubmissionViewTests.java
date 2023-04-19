package com.tekgs.nextgen.luckyPet.view.paymentSubmission;

import com.tekgs.nextgen.luckyPet.data.payment.Payment;
import com.tekgs.nextgen.luckyPet.data.payment.PaymentDefinition;
import org.softwareonpurpose.gauntlet.GauntletTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@Test(groups = {GauntletTest.Application.LUCKY_PET_WEB, GauntletTest.View.PAYMENT_SUBMISSION})
public class PaymentSubmissionViewTests extends GauntletTest {
    @DataProvider
    public static Object[][] scenarios() {
        String invalidType = "tok_kit";
        String validType = "tok_amex";
        String validCurrency = "usd";
        String invalidCurrency = "not";
        PaymentDefinition withInvalidType =
                PaymentDefinition.getInstance().withCurrency(validCurrency).withType(invalidType);
        PaymentDefinition withInvalidCurrency =
                PaymentDefinition.getInstance().withCurrency(invalidCurrency).withType(validType);
        PaymentDefinition withValidValues =
                PaymentDefinition.getInstance().withCurrency(validCurrency).withType(validType);
        PaymentDefinition withEmptyValues =
                PaymentDefinition.getInstance().withCurrency("").withType("");
        PaymentDefinition withInvalidTypeAndCurrency =
                PaymentDefinition.getInstance().withCurrency(invalidCurrency).withType(invalidType);
        return new Object[][]{
                {withInvalidType},
                {withValidValues},
                {withEmptyValues},
                {withInvalidCurrency},
                {withInvalidTypeAndCurrency}
        };
    }

    @Test(groups = {TestSuite.SMOKE})
    public void smoke() {
        PaymentSubmissionViewExpected expected = PaymentSubmissionViewExpected.getInstance();
        when();
        PaymentSubmissionView actual = PaymentSubmissionView.directNav();
        then(PaymentSubmissionViewCalibrator.getInstance(expected, actual));
    }

    @Test(groups = {TestSuite.RELEASE}, dependsOnMethods = "smoke")
    public void release() {
        PaymentDefinition paymentDefinition = PaymentDefinition.getInstance().withCurrency("usd").withType("tok_amex");
        Payment paymentData = paymentDefinition.toPayment();
        given(paymentData);
        PaymentSubmissionViewExpected expected = PaymentSubmissionViewExpected.getInstance(paymentData);
        when();
        PaymentSubmissionView actual = PaymentSubmissionView.directNav().enter(paymentData);
        then(PaymentSubmissionViewCalibrator.getInstance(expected, actual));
    }

    @Test(dependsOnMethods = "smoke", dataProvider = "scenarios")
    public void dataEntryValidation(PaymentDefinition paymentDefinition) {
        Payment paymentData = paymentDefinition.toPayment();
        given(paymentData);
        PaymentSubmissionViewExpected expected = PaymentSubmissionViewExpected.getInstance(paymentData);
        when();
        PaymentSubmissionView actual = PaymentSubmissionView.directNav().enter(paymentData);
        then(PaymentSubmissionViewCalibrator.getInstance(expected, actual));
    }
}

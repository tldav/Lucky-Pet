package com.tekgs.nextgen.luckyPet.view.paymentSubmission;

import com.tekgs.nextgen.luckyPet.data.payment.Payment;
import com.tekgs.nextgen.luckyPet.data.payment.PaymentDefinition;
import com.tekgs.nextgen.luckyPet.data.payment.PaymentProvider;
import org.softwareonpurpose.gauntlet.GauntletTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@Test(groups = {GauntletTest.Application.LUCKY_PET_WEB, GauntletTest.View.PAYMENT_SUBMISSION})
public class PaymentSubmissionViewTests extends GauntletTest {
    @DataProvider
    public static Object[][] scenarios() {
        String invalidSource = "tok_kit";
        String validSource = "tok_amex";
        String validCurrency = "usd";
        String invalidCurrency = "not";
        PaymentDefinition withInvalidSource = PaymentDefinition.getInstance().withCurrency(validCurrency).withSource(invalidSource);
        PaymentDefinition withInvalidCurrency = PaymentDefinition.getInstance().withCurrency(invalidCurrency).withSource(validSource);
        PaymentDefinition withValidValues = PaymentDefinition.getInstance().withCurrency(validCurrency).withSource(validSource);
        PaymentDefinition withEmptyValues = PaymentDefinition.getInstance().withCurrency("").withSource("");
        PaymentDefinition withInvalidSourceAndCurrency = PaymentDefinition.getInstance().withCurrency(invalidCurrency).withSource(invalidSource);
        return new Object[][]{{withInvalidSource}, {withValidValues}, {withEmptyValues}, {withInvalidCurrency}, {withInvalidSourceAndCurrency}};
    }

    @DataProvider
    public static Object[][] amountScenarios() {
        return new Object[][]{{PaymentDefinition.getInstance().withAmount(49)}, {PaymentDefinition.getInstance().withAmount(50)}, {PaymentDefinition.getInstance().withAmount(99999999)}, {PaymentDefinition.getInstance().withAmount(100000000)}, {PaymentDefinition.getInstance().withAmount(-500)}, {PaymentDefinition.getInstance().withAmount(0)}};
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
        PaymentDefinition paymentDefinition = PaymentDefinition.getInstance().withCurrency("usd").withSource("tok_amex").withAmount(50);
        Payment paymentData = paymentDefinition.toPayment();
        given(paymentData);
        PaymentSubmissionViewExpected expected = PaymentSubmissionViewExpected.getInstance(paymentData);
        when();
        PaymentSubmissionView actual = PaymentSubmissionView.directNav().enter(paymentData);
        then(PaymentSubmissionViewCalibrator.getInstance(expected, actual));
    }

    @Test(groups = {TestSuite.DEBUG}, dependsOnMethods = "smoke", dataProvider = "scenarios")
    public void dataEntryValidation(PaymentDefinition paymentDefinition) {
        Payment paymentData = paymentDefinition.toPayment();
        given(paymentData);
        PaymentSubmissionViewExpected expected = PaymentSubmissionViewExpected.getInstance(paymentData);
        when();
        PaymentSubmissionView actual = PaymentSubmissionView.directNav().enter(paymentData);
        then(PaymentSubmissionViewCalibrator.getInstance(expected, actual));
    }

    @Test(groups = {TestSuite.DEBUG}, dependsOnMethods = "smoke", dataProvider = "amountScenarios")
    public void amountDirectNav(PaymentDefinition paymentDefinition) {
        Payment payment = PaymentProvider.getInstance().get(paymentDefinition);
        PaymentSubmissionViewExpected expected = PaymentSubmissionViewExpected.getInstance(payment);
        PaymentSubmissionView actual = PaymentSubmissionView.directNav(payment.getAmount());
        then(PaymentSubmissionViewCalibrator.getInstance(expected, actual));
    }
}

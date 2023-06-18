package com.tekgs.nextgen.luckyPet.view.purchaseConfirmation;

import com.tekgs.nextgen.luckyPet.data.payment.Payment;
import com.tekgs.nextgen.luckyPet.data.payment.PaymentDefinition;
import com.tekgs.nextgen.luckyPet.data.payment.PaymentProvider;
import com.tekgs.nextgen.luckyPet.view.checkout.CheckoutView;
import org.softwareonpurpose.gauntlet.GauntletTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@Test(groups = {GauntletTest.Application.LUCKY_PET_WEB, GauntletTest.View.PURCHASE_CONFIRMATION})
public class PurchaseConfirmationViewTests extends GauntletTest {
    @DataProvider
    public static Object[][] validScenarios() {
        int fiftyCents = 50;
        int oneCentLessThanAMillionDollars = 99999999;
        return new Object[][]{
                {PaymentDefinition.getInstance().withAmount(fiftyCents).withCurrency("usd").withSource("tok_amex")}
                , {PaymentDefinition.getInstance().withAmount(oneCentLessThanAMillionDollars).withCurrency("usd").withSource("tok_amex")}
        };
    }
    
    @Test(groups = {TestSuite.SMOKE})
    public void smoke() {
        PaymentDefinition paymentDefinition = PaymentDefinition.getInstance().withCurrency("usd").withSource("tok_amex").withAmount(50);
        Payment paymentData = paymentDefinition.toPayment();
        PurchaseConfirmationViewExpected expected = PurchaseConfirmationViewExpected.getInstance(paymentData);
        PurchaseConfirmationView actual = CheckoutView.directNav(paymentData.getAmount()).enter(paymentData).submit(paymentData);
        then(PurchaseConfirmationViewCalibrator.getInstance(expected, actual));
    }
    
    @Test(groups = {TestSuite.RELEASE}, dependsOnMethods = "smoke", dataProvider = "validScenarios")
    public void fromCheckout(PaymentDefinition paymentDefinition) {
        Payment payment = PaymentProvider.getInstance().get(paymentDefinition);
        PurchaseConfirmationViewExpected expected = PurchaseConfirmationViewExpected.getInstance(payment);
        PurchaseConfirmationView actual = CheckoutView.directNav(payment.getAmount()).enter(payment).submit(payment);
        then(PurchaseConfirmationViewCalibrator.getInstance(expected, actual));
    }
}

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
                {PaymentDefinition.getInstance().withAmount(fiftyCents)}
                , {PaymentDefinition.getInstance().withAmount(oneCentLessThanAMillionDollars)}
        };
    }

    @Test(groups = {TestSuite.SMOKE})
    public void smoke() {
        Payment paymentData = PaymentProvider.getInstance().get();
        PurchaseConfirmationViewExpected expected = PurchaseConfirmationViewExpected.getInstance(paymentData);
        PurchaseConfirmationView actual = CheckoutView.directNav().submit(paymentData);
        then(PurchaseConfirmationViewCalibrator.getInstance(expected, actual));
    }

    @Test(groups = {TestSuite.RELEASE}, dependsOnMethods = "smoke", dataProvider = "validScenarios")
    public void fromCheckout(PaymentDefinition paymentDefinition) {
        Payment payment = PaymentProvider.getInstance().get(paymentDefinition);
        PurchaseConfirmationViewExpected expected = PurchaseConfirmationViewExpected.getInstance(payment);
        PurchaseConfirmationView actual = CheckoutView.directNav().submit(payment);
        then(PurchaseConfirmationViewCalibrator.getInstance(expected, actual));
    }
}

package com.tekgs.nextgen.luckyPet.view.checkout;

import com.tekgs.nextgen.luckyPet.data.payment.Payment;
import com.tekgs.nextgen.luckyPet.data.payment.PaymentDefinition;
import com.tekgs.nextgen.luckyPet.data.payment.PaymentProvider;
import org.softwareonpurpose.gauntlet.GauntletTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@Test(groups = {GauntletTest.Application.LUCKY_PET_WEB, GauntletTest.View.CHECKOUT})
public class CheckoutViewTests extends GauntletTest {
    @DataProvider
    public static Object[][] scenarios() {
        return new Object[][]{
                {PaymentDefinition.getInstance().withAmount(49)},
                {PaymentDefinition.getInstance().withAmount(50)},
                {PaymentDefinition.getInstance().withAmount(99999999)},
                {PaymentDefinition.getInstance().withAmount(100000000)},
                {PaymentDefinition.getInstance().withAmount(-500)},
                {PaymentDefinition.getInstance().withAmount(0)}
        };
    }

    @Test(groups = {TestSuite.SMOKE})
    public void smoke() {
        CheckoutViewExpected expected = CheckoutViewExpected.getInstance();
        CheckoutView actual = CheckoutView.directNav();
        then(CheckoutViewCalibrator.getInstance(expected, actual));
    }

    @Test(groups = {TestSuite.RELEASE}, dependsOnMethods = "smoke")
    public void release() {
        PaymentDefinition paymentDefinition = PaymentDefinition.getInstance().withAmount(50);
        Payment payment = PaymentProvider.getInstance().get(paymentDefinition);
        CheckoutViewExpected expected = CheckoutViewExpected.getInstance(payment);
        CheckoutView actual = CheckoutView.directNav(payment.getAmount());
        then(CheckoutViewCalibrator.getInstance(expected, actual));
    }

    @Test(dependsOnMethods = "smoke", dataProvider = "scenarios")
    public void directNav(PaymentDefinition paymentDefinition) {
        Payment payment = PaymentProvider.getInstance().get(paymentDefinition);
        CheckoutViewExpected expected = CheckoutViewExpected.getInstance(payment);
        CheckoutView actual = CheckoutView.directNav(payment.getAmount());
        then(CheckoutViewCalibrator.getInstance(expected, actual));
    }
}

package com.stripe.api.charges;

import org.softwareonpurpose.gauntlet.GauntletTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@Test(groups = {GauntletTest.Service.STRIPE, GauntletTest.Endpoint.CHARGES})
public class LuckyPetChargeTests extends GauntletTest {
    @DataProvider
    public static Object[][] scenarios() {
        long fiftyCents = 50L;
        long oneDollarLessThanOneMillion = 99999999L;
        long fortyNineCents = 49L;
        long oneMillionDollars = 100000000L;
        return new Object[][]{
                {"tok_amex", "usd", fiftyCents}
                , {"tok_amex", "usd", oneDollarLessThanOneMillion}
                , {"tok_amex", "usd", fortyNineCents}
                , {"tok_amex", "usd", oneMillionDollars}
        };
    }

    @Test(groups = {TestSuite.SMOKE, TestSuite.RELEASE, TestSuite.ACCEPTANCE})
    public void smoke() {
        addRequirements("54 - Purchase Confirmation");
        long amount = 100L;
        String currency = "usd";
        String source = "tok_amex";
        LuckyPetChargeExpected expected = LuckyPetChargeExpected.getInstance(amount);
        LuckyPetCharge actual = LuckyPetCharge.getInstance(amount, currency, source).submit();
        then(LuckyPetChargeResponseCalibrator.getInstance(expected, actual));
    }

    @Test(groups = {TestSuite.RELEASE}, dependsOnMethods = "smoke", dataProvider = "scenarios")
    public void submit(String source, String currency, long amount) {
        LuckyPetChargeExpected expected = LuckyPetChargeExpected.getInstance(amount);
        LuckyPetCharge actual = LuckyPetCharge.getInstance(amount, currency, source).submit();
        then(LuckyPetChargeResponseCalibrator.getInstance(expected, actual));
    }
}

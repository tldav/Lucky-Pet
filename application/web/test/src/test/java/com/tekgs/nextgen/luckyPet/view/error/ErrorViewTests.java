package com.tekgs.nextgen.luckyPet.view.error;

import com.tekgs.nextgen.luckyPet.view.invalid.ErrorGeneratorView;
import com.tekgs.nextgen.luckyPet.view.notFound.NotFoundView;
import org.softwareonpurpose.gauntlet.GauntletTest;
import org.testng.annotations.Test;

@Test(groups = {GauntletTest.Application.LUCKY_PET_WEB, GauntletTest.View.ERROR})
public class ErrorViewTests extends GauntletTest {

    @Test(groups = {TestSuite.SMOKE})
    public void smoke() {
        ErrorViewExpected expected = ErrorViewExpected.getNotFoundInstance();
        ErrorView actual = ErrorView.directNav();
        then(ErrorViewCalibrator.getInstance(expected, actual));
    }

    @Test(groups={}, dependsOnMethods = "smoke")
    public void fromNotFoundUrl(){
        ErrorViewExpected expected = ErrorViewExpected.getNotFoundInstance();
        ErrorView actual = NotFoundView.directNav();
        then(ErrorViewCalibrator.getInstance(expected, actual));
    }

    @Test(groups={TestSuite.ACCEPTANCE}, dependsOnMethods = "smoke")
    public void fromErrorGenerator(){
        ErrorViewExpected expected = ErrorViewExpected.getGenericInstance();
        ErrorView actual = ErrorGeneratorView.directNav();
        then(ErrorViewCalibrator.getInstance(expected, actual));
    }
}

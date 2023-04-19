package com.tekgs.nextgen.luckyPet.view.pets;

import org.softwareonpurpose.gauntlet.GauntletTest;
import org.testng.annotations.Test;

@Test(groups = {GauntletTest.Application.LUCKY_PET_WEB, GauntletTest.View.PETS})
public class PetsViewTests extends GauntletTest {

    @Test(groups = {TestSuite.SMOKE, TestSuite.ACCEPTANCE})
    public void smoke(){
        addRequirements("331 - Pets View - display pets");
        PetsView actual = PetsView.directNav();
        PetsViewExpected expected = PetsViewExpected.getInstance();
        then(PetsViewCalibrator.getInstance(expected, actual));
    }
}

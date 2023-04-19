package com.tekgs.nextgen.luckyPet.view.pets;

import com.softwareonpurpose.calibrator4test.Calibrator;
import com.softwareonpurpose.uinavigator.UiRegion;
import com.tekgs.nextgen.luckyPet.view.pets.petListRegion.PetListRegionCalibrator;

public class PetsViewCalibrator extends Calibrator {
    private static final String DESCRIPTION = "'Pets' view";

    private PetsViewCalibrator(PetsViewExpected expected, PetsView actual) {
        super(DESCRIPTION, expected, actual);
        UiRegion.suppressConstructionLogging(true);
        addChildCalibrator(PetListRegionCalibrator.getInstance(expected.getPetListRegion(), actual.getPetListRegion()));
        UiRegion.suppressConstructionLogging(false);
    }

    public static PetsViewCalibrator getInstance(PetsViewExpected expected, PetsView actual) {
        return new PetsViewCalibrator(expected, actual);
    }
    @Override
    protected void executeVerifications() {
    }
}

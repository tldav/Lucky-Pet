package com.tekgs.nextgen.luckyPet.view.pets.petListRegion.petRegion;

import com.softwareonpurpose.calibrator4test.Calibrator;
import com.tekgs.nextgen.luckyPet.data.pet.Pet;

public class PetRegionCalibrator extends Calibrator {
    private static final String DESCRIPTION = "'Pet' region";
    private PetRegionExpected expected;
    private PetRegion actual;

    private PetRegionCalibrator(PetRegionExpected expected, PetRegion actual) {
        super(DESCRIPTION, expected, actual);
        this.expected = expected;
        this.actual = actual;
    }

    public static PetRegionCalibrator getInstance(PetRegionExpected expected, PetRegion actual) {
        return new PetRegionCalibrator(expected, actual);
    }

    @Override
    protected void executeVerifications() {
        verify("'Pet' name", this.expected.getName(), this.actual.getName());
    }
}

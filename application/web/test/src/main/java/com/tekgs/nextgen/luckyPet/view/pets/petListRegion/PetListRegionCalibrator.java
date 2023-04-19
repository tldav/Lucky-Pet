package com.tekgs.nextgen.luckyPet.view.pets.petListRegion;

import com.softwareonpurpose.uinavigator.UiRegion;
import com.tekgs.nextgen.luckyPet.ListCalibrator;
import com.tekgs.nextgen.luckyPet.view.pets.petListRegion.petRegion.PetRegionCalibratable;
import com.tekgs.nextgen.luckyPet.view.pets.petListRegion.petRegion.PetRegionCalibrator;

import java.util.List;

public class PetListRegionCalibrator extends ListCalibrator<PetRegionCalibrator, PetRegionCalibratable> {

    private static final String DESCRIPTION = "'Pet List' region";

    private PetListRegionCalibrator(PetListRegionCalibratable expected, PetListRegionCalibratable actual) {
        super(DESCRIPTION, expected, actual, PetRegionCalibrator.class, PetRegionCalibratable.class);
        UiRegion.suppressConstructionLogging(true);
        List<PetRegionCalibratable> petsExpected = expected.getPetRegions();
        List<PetRegionCalibratable> petsActual = actual.getPetRegions();
        addCalibrationsExpected(petsExpected, petsActual);
        addCalibrationsUnexpected(petsActual);
        UiRegion.suppressConstructionLogging(false);
    }

    public static PetListRegionCalibrator getInstance(PetListRegionCalibratable expected, PetListRegionCalibratable actual) {
        return new PetListRegionCalibrator(expected, actual);
    }

    @Override
    protected void executeVerifications() {

    }
}

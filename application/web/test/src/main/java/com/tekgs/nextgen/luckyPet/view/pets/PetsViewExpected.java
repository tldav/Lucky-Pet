package com.tekgs.nextgen.luckyPet.view.pets;

import com.tekgs.nextgen.luckyPet.view.pets.petListRegion.PetListRegionCalibratable;
import com.tekgs.nextgen.luckyPet.view.pets.petListRegion.PetListRegionExpected;

public class PetsViewExpected implements PetsViewCalibratable {
    private PetsViewExpected() {

    }

    public static PetsViewExpected getInstance() {
        return new PetsViewExpected();
    }

    @Override
    public PetListRegionCalibratable getPetListRegion() {
        return PetListRegionExpected.getInstance();
    }
}

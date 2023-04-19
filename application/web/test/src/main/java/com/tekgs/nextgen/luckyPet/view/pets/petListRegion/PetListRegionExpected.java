package com.tekgs.nextgen.luckyPet.view.pets.petListRegion;

import com.tekgs.nextgen.luckyPet.data.pet.Pet;
import com.tekgs.nextgen.luckyPet.data.pet.PetProvider;
import com.tekgs.nextgen.luckyPet.view.pets.petListRegion.petRegion.PetRegionCalibratable;
import com.tekgs.nextgen.luckyPet.view.pets.petListRegion.petRegion.PetRegionExpected;

import java.util.ArrayList;
import java.util.List;

public class PetListRegionExpected implements PetListRegionCalibratable{
    private List<Pet> pets;

    private PetListRegionExpected() {
        this.pets = PetProvider.getInstance().get();
    }

    public static PetListRegionExpected getInstance() {
        return new PetListRegionExpected();
    }

    @Override
    public List<PetRegionCalibratable> getPetRegions() {
        List<PetRegionCalibratable> petRegions = new ArrayList<>();
        for(Pet pet : this.pets) {
            petRegions.add(PetRegionExpected.getInstance(pet));
        }
        return petRegions;
    }
}

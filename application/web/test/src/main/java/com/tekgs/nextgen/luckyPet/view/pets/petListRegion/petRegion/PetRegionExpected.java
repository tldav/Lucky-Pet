package com.tekgs.nextgen.luckyPet.view.pets.petListRegion.petRegion;

import com.tekgs.nextgen.luckyPet.data.pet.Pet;

public class PetRegionExpected implements PetRegionCalibratable {
    private final Pet pet;
    
    private PetRegionExpected(Pet pet) {
        this.pet = pet;
    }
    
    public static PetRegionExpected getInstance(Pet pet) {
        return new PetRegionExpected(pet);
    }
    
    @Override
    public String getName() {
        return this.pet.getName();
    }
    
    @Override
    public boolean equivalent(PetRegionCalibratable comparator) {
        return false;
    }
}

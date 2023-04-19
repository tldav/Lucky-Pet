package com.tekgs.nextgen.luckyPet.data.pet;

public class PetDefinition implements PetCalibratable {
    private String name;

    public static PetDefinition getInstance(){
        return new PetDefinition();
    }

    public PetDefinition withName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public boolean equivalent(PetCalibratable comparator) {
        return false;
    }
}

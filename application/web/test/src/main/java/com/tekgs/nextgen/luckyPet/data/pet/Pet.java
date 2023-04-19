package com.tekgs.nextgen.luckyPet.data.pet;

public class Pet implements PetCalibratable{

    private final String name;


    public Pet(String name) {
        this.name = name;
    }
    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public boolean equivalent(PetCalibratable comparator) {
        if(comparator == null){
            return false;
        }
        return comparator.getName() == null || this.getName().equals(comparator.getName());
    }
}

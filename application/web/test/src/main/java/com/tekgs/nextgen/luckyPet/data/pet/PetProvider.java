package com.tekgs.nextgen.luckyPet.data.pet;

import java.util.List;

public class PetProvider {
    private final PetRepository repository = PetRepository.getInstance();
    
    private PetProvider() {
    }
    
    public static PetProvider getInstance() {
        return new PetProvider();
    }
    
    public List<Pet> get() {
        return this.repository.query();
    }
}

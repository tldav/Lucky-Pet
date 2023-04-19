package com.tekgs.nextgen.luckyPet.data.pet;

import java.util.List;

public class PetProvider {
    private final PetRepository repo = PetRepository.getInstance();

    public static PetProvider getInstance() {
        return new PetProvider();
    }
    public List<Pet> get() {
        return repo.query();
    }
}

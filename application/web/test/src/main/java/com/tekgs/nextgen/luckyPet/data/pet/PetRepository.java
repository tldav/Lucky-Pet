package com.tekgs.nextgen.luckyPet.data.pet;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.tekgs.nextgen.luckyPet.data.product.Product;

import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class PetRepository {
    private static final String PET_DATA_FILE = "../source/src/data/pet.json";

    public static PetRepository getInstance() {
        return new PetRepository();
    }

    public List<Pet> query() {
        List<Pet> petList = new ArrayList<>();
        Path path = Paths.get(PET_DATA_FILE);
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            petList = new Gson().fromJson(reader, new TypeToken<List<Pet>>() {
            }.getType());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return petList;
    }
}

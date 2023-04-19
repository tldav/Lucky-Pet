package com.tekgs.nextgen.luckyPet.data.financial.revenue;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class RevenueRepository {
    private static final String REVENUE_DATA_FILE = "../source/src/data/revenue.json";

    public static RevenueRepository getInstance(){
        return new RevenueRepository();
    }

    public List<Revenue> query(){
        List<Revenue> revenueList = new ArrayList<>();
        Path path = Paths.get(REVENUE_DATA_FILE);
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            revenueList = new Gson().fromJson(reader, new TypeToken<List<Revenue>>() {
            }.getType());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return revenueList;
    }
}

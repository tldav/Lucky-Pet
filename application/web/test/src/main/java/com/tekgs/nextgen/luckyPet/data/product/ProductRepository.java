package com.tekgs.nextgen.luckyPet.data.product;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ProductRepository {

    private static final String PRODUCT_DATA_FILE = "../source/src/data/product.json";

    public static ProductRepository getInstance(){
        return new ProductRepository();
    }

    public List<Product> query() {
        List<Product> products = new ArrayList<>();
        Path path = Paths.get(PRODUCT_DATA_FILE);
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            products = new Gson().fromJson(reader, new TypeToken<List<Product>>() {
            }.getType());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return products;
    }
}

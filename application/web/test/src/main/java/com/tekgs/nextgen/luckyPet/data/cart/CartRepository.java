package com.tekgs.nextgen.luckyPet.data.cart;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class CartRepository {
    private static final String CART_DATA_FILE = "../source/src/data/cart.json";

    public static CartRepository getInstance() {
        return new CartRepository();
    }
    
    public Cart query(CartCalibratable definition) {
        for (Cart candidate : query()) {
            if (candidate.equivalent(definition)) {
                return candidate;
            }
        }
        return null;
    }
    
    public List<Cart> query() {
        List<Cart> carts = new ArrayList<>();
        Path path = Paths.get(CART_DATA_FILE);
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            carts = new Gson().fromJson(reader, new TypeToken<List<Cart>>() {
            }.getType());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return carts;
    }

}

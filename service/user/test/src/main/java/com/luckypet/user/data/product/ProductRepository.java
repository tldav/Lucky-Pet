package com.luckypet.user.data.product;

import org.softwareonpurpose.gauntlet.Environment;

import java.util.ArrayList;
import java.util.List;

public class ProductRepository {
    public static final String DB_URL = "jdbc:mysql://localhost:3306/lucky_pet_db";
    public static final String MYSQL_USER = Environment.getInstance().getProperty("user");
    public static final String MYSQL_PASSWORD = Environment.getInstance().getProperty("password");

    public static ProductRepository getInstance() {
        return new ProductRepository();
    }

    public Product query(ProductCalibratable instance) {
        return null;
    }

    public List<Product> query() {
        List<Product> products = new ArrayList<>();
        return products;
    }
}

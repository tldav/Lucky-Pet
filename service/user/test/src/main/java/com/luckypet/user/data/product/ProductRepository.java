package com.luckypet.user.data.product;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.softwareonpurpose.gauntlet.Environment;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductRepository {
    public static final String DB_URL = "jdbc:mysql://localhost:3306/lucky_pet_db";
    public static final String MYSQL_USER = Environment.getInstance().getProperty("user");
    public static final String MYSQL_PASSWORD = Environment.getInstance().getProperty("password");

    public static ProductRepository getInstance() {
        return new ProductRepository();
    }

    public Product query(ProductCalibratable productDefinition) {
        for (Product candidate : query()){
            if (candidate.equivalent(productDefinition)) {
                return candidate;
            }
        }
        return null;
    }

    public List<Product> query() {
        List<Product> products = new ArrayList<>();
        try{
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            Connection connection = DriverManager.getConnection(DB_URL, MYSQL_USER, MYSQL_PASSWORD);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from _product");

            JSONArray productList = new JSONArray();

            while(resultSet.next()){
                JSONObject product = new JSONObject();

                product.put("id",resultSet.getInt("product_id"));
                product.put("description", resultSet.getString("description"));
                product.put("price", resultSet.getInt("price"));
                product.put("stock", resultSet.getInt("stock"));

                productList.add(product);
            }

            products = new Gson().fromJson(productList.toJSONString(),new TypeToken<List<Product>>(){}.getType());
            connection.close();
        } catch (Exception e) {
            e.getStackTrace();
        }
        return products;
    }
}

package com.luckypet.user.data.cart;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.softwareonpurpose.gauntlet.Environment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CartRepository {
    public static final String DB_URL = "jdbc:mysql://localhost:3306/lucky_pet_db";
    public static final String MYSQL_USER = Environment.getInstance().getProperty("user");
    public static final String MYSQL_PASSWORD = Environment.getInstance().getProperty("password");
    
    public static CartRepository getInstance() {
        return new CartRepository();
    }
    
    public Cart query(CartCalibratable cartDefinition) {
        for (Cart candidate : query()) {
            if (candidate.equivalent(cartDefinition)) {
                return candidate;
            }
        }
        return null;
    }
    
    @SuppressWarnings({"UnusedReturnValue", "unchecked"})
    private List<Cart> query() {
        List<Cart> carts = new ArrayList<>();
        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            Connection connection = DriverManager.getConnection(DB_URL, MYSQL_USER, MYSQL_PASSWORD);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM _cart");
            JSONArray jsonArray = new JSONArray();
            while (resultSet.next()) {
                JSONObject record = new JSONObject();
                record.put("id", resultSet.getInt("id"));
                record.put("username", resultSet.getString("username"));
                jsonArray.add(record);
            }
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            carts = gson.fromJson(jsonArray.toJSONString(), new TypeToken<List<Cart>>() {
            }.getType());
            connection.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return carts;
    }
}

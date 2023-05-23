package com.luckypet.user.cart.data;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
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
    public static CartRepository getInstance() {
        return new CartRepository();
    }
    
    public Cart query(CartCalibratable cartDefinition) {
        return null;
    }
    
    public List<Cart> getCartsFromMySQLDB() {
        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/lucky_pet_db", Environment.getInstance().getProperty("user"), Environment.getInstance().getProperty("password"));
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM _cart");
            JSONObject jsonObject = new JSONObject();
            JSONArray jsonArray = new JSONArray();
            int columnCount = resultSet.getMetaData().getColumnCount();
            while (resultSet.next()) {
                JSONObject record = new JSONObject();
                record.put("id", resultSet.getInt("id"));
                record.put("username", resultSet.getString("username"));
                jsonArray.add(record);
            }
            jsonObject.put("cart data", jsonArray);

            List<Cart> carts;
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            carts = gson.fromJson(jsonArray.toJSONString(), new TypeToken<List<Cart>>() {
            }.getType());
            System.out.println(gson.toJson(carts));
            connection.close();
        } catch (Exception e) {
            System.out.println(e);
        }

        
        return null;
    }
}

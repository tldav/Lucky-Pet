package com.tekgs.nextgen.luckyPet.data.cart;

import com.google.gson.Gson;
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
    
    private CartRepository() {
    
    }
    
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
            ResultSet resultSet = statement.executeQuery("""
                    select c.cart_id as cart_id_from_cart, i.cart_id as cart_id_from_item, i.quantity, i.product_id, p.description, p.price, p.stock from _cart as c
                    LEFT JOIN _item i on c.cart_id=i.cart_id
                    LEFT JOIN _product p on p.product_id=i.product_id;""".indent(4));
            JSONArray jsonArrayCart = new JSONArray();
            JSONArray jsonArrayItemList = new JSONArray();
            JSONObject cart = new JSONObject();
            int lastId = 0;
            while (resultSet.next()) {
                JSONObject itemInCart = new JSONObject();
                
                int cartIdFromCart = resultSet.getInt("cart_id_from_cart");
                if (cartIdFromCart != lastId) {
                    jsonArrayItemList = new JSONArray();
                    cart = new JSONObject();
                    lastId = cartIdFromCart;
                    cart.put("id", cartIdFromCart);
                }
                
                if (resultSet.getObject("cart_id_from_item") != null) {
                    JSONObject product = new JSONObject();
                    product.put("id", resultSet.getInt("product_id"));
                    product.put("description", resultSet.getString("description"));
                    product.put("price", resultSet.getInt("price"));
                    product.put("stock", resultSet.getInt("stock"));
                    itemInCart.put("quantity", resultSet.getInt("quantity"));
                    itemInCart.put("product", product);
                    jsonArrayItemList.add(itemInCart);
                }
                
                cart.put("items", jsonArrayItemList);
                if (jsonArrayCart.contains(cart)) {
                    jsonArrayCart.remove(cart);
                }
                jsonArrayCart.add(cart);
            }
            carts = new Gson().fromJson(jsonArrayCart.toJSONString(), new TypeToken<List<Cart>>() {
            }.getType());
            connection.close();
        } catch (Exception e) {
            e.getStackTrace();
        }
        
        return carts;
    }
    
}

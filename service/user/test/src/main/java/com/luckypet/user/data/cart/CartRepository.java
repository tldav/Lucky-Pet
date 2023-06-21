package com.luckypet.user.data.cart;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.softwareonpurpose.gauntlet.Environment;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CartRepository {
    public static final String DB_URL = "jdbc:mysql://localhost:3306/lucky_pet_db";
    public static final String MYSQL_USER = Environment.getInstance().getProperty("user");
    public static final String MYSQL_PASSWORD = Environment.getInstance().getProperty("password");
    private Connection connection;

    public static CartRepository getInstance() {
        return new CartRepository();
    }

    public CartRepository() {
        try{
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            this.connection = DriverManager.getConnection(DB_URL, MYSQL_USER, MYSQL_PASSWORD);
        } catch (Exception e){
            e.getStackTrace();
        }
    }

    public Cart query(CartCalibratable cartDefinition) {
        for (Cart candidate : query()) {
            if (candidate.equivalent(cartDefinition)) {
                return candidate;
            }
        }
        return null;
    }

    @SuppressWarnings("unchecked")
    private List<Cart> query() {
        List<Cart> carts = new ArrayList<>();
        try {
            ResultSet resultSet = this.executeQuery();
            JSONArray jsonArrayCart = new JSONArray();
            JSONArray jsonArrayItemList = new JSONArray();
            JSONObject cart = new JSONObject();

            int lastId = 0;
            while (resultSet.next()) {
                JSONObject itemInCart = new JSONObject();
                JSONObject product = new JSONObject();

                int cartIdFromCart = resultSet.getInt("cart_id_from_cart");
                if (cartIdFromCart != lastId) {
                    jsonArrayItemList = new JSONArray();
                    cart = new JSONObject();
                    lastId = cartIdFromCart;
                    cart.put("id", cartIdFromCart);
                }

                product.put("id", resultSet.getInt("product_id"));
                product.put("description", resultSet.getString("description"));
                product.put("price", resultSet.getInt("price"));
                product.put("stock", resultSet.getInt("stock"));

                itemInCart.put("quantity", resultSet.getInt("quantity"));
                itemInCart.put("_product", product);
                jsonArrayItemList.add(itemInCart);

                cart.put("itemList", jsonArrayItemList);
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

    private ResultSet executeQuery() throws SQLException {
        Statement statement = connection.createStatement();
        return statement.executeQuery("    select c.cart_id as cart_id_from_cart, i.cart_id as cart_id_from_item, i.quantity, i.product_id, p.description, p.price, p.stock from _cart as c\n" +
                "    JOIN _item i on c.cart_id=i.cart_id\n" +
                "    JOIN _product p on p.product_id=i.product_id;");
    }
}

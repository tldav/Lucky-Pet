package com.luckypet.user.data.cart;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.luckypet.user.data.cart.item.Item;
import com.luckypet.user.data.product.Product;
import com.luckypet.user.data.product.ProductCalibratable;
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
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        for (Cart candidate : query()) {
            if (candidate.equivalent(cartDefinition)) {
//            System.out.println(gson.toJson(candidate));
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
            ResultSet resultSet = statement.executeQuery("    select c.cart_id as cart_id_from_cart, i.cart_id as cart_id_from_item, i.quantity, i.product_id, p.description, p.price, p.stock from _cart as c\n" +
                    "    JOIN _item i on c.cart_id=i.cart_id\n" +
                    "    JOIN _product p on p.product_id=i.product_id;");
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
                if(jsonArrayCart.contains(cart)){
                    jsonArrayCart.remove(cart);
                }
                jsonArrayCart.add(cart);
            }
//            System.out.println(jsonArrayCart);
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            carts = gson.fromJson(jsonArrayCart.toJSONString(), new TypeToken<List<Cart>>(){}.getType());
            connection.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return carts;
    }

    public Product query(ProductCalibratable instance) {
        return null;
    }
}


//                record.put("itemList", resultset( get the item list))
//                for (Cart cart : carts) {
//                    List<Item> items = new ArrayList<>();
//                    int cartIdFromCart = resultSet.getInt("cart_id_from_cart");
//                    int cartIdFromItem = resultSet.getInt("cart_id_from_item");
//                }
// need to create item object from data and
// create item list for each cart

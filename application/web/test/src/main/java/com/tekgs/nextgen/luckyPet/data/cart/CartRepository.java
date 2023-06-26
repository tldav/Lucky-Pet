package com.tekgs.nextgen.luckyPet.data.cart;

import com.tekgs.nextgen.luckyPet.behavior.ToStringBehavior;
import com.tekgs.nextgen.luckyPet.data.cart.item.ItemCalibratable;
import com.tekgs.nextgen.luckyPet.data.cart.item.ItemDefinition;
import com.tekgs.nextgen.luckyPet.data.product.ProductDefinition;
import org.softwareonpurpose.gauntlet.Environment;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CartRepository {
    public static final String DB_URL = "jdbc:mysql://localhost:3306/lucky_pet_db";
    public static final String MYSQL_USER = Environment.getInstance().getProperty("user");
    public static final String MYSQL_PASSWORD = Environment.getInstance().getProperty("password");
    private final ToStringBehavior tsb = ToStringBehavior.getInstance();
    private Connection connection;
    
    public CartRepository() {
        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            this.connection = DriverManager.getConnection(DB_URL, MYSQL_USER, MYSQL_PASSWORD);
        } catch (Exception e) {
            e.getStackTrace();
        }
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
    
    @SuppressWarnings("unchecked")
    private List<Cart> query() {
        
//        List<Cart> carts = new ArrayList<>();
        List<Cart> listOfCartsFromDB = new ArrayList<>();
        try {
            ResultSet resultSet = this.executeQuery();
//            JSONArray jsonArrayCart = new JSONArray(); // replace with List<Cart> new ArrayList
//            List<Cart> listOfCartsFromDB = new ArrayList<>();
//            JSONArray jsonArrayItemList = new JSONArray(); // replace with List<Item> new ArrayList
            List<ItemCalibratable> itemList = new ArrayList<>();
//            JSONObject cart = new JSONObject(); // replace with Cart made via CartDefinition
            
            CartDefinition cartDefinition = CartDefinition.getInstance();
            
            
            int lastId = 0;
            while (resultSet.next()) {
                int cartIdFromCart = resultSet.getInt("cart_id_from_cart");
                if (cartIdFromCart != lastId) {
//                    jsonArrayItemList = new JSONArray(); // replace with new ArrayList: itemList;
                    itemList = new ArrayList<>(); // <- should be List<ItemCalibratable> but will have to handle getting real Product before adding item to list

//                    cart = new JSONObject(); // replace with new cartDefinition
                    cartDefinition = CartDefinition.getInstance();
                    lastId = cartIdFromCart;
//                    cart.put("id", cartIdFromCart); // replace with withId(cartIdFromCart)
                    cartDefinition.withId(cartIdFromCart);
                }
                
                if (resultSet.getObject("cart_id_from_item") != null) {
//                    JSONObject itemInCart = new JSONObject(); // replace with ItemDefinition
                    ItemDefinition itemDefinition = ItemDefinition.getInstance();
//                    JSONObject product = new JSONObject(); // replace with *** REAL PRODUCT via DEFINITION ***: productDefinition.toProduct()
                    ProductDefinition productDefinition = ProductDefinition.getInstance();

//                    product.put("id", resultSet.getInt("product_id"));
//                    product.put("description", resultSet.getString("description"));
//                    product.put("price", resultSet.getInt("price"));
//                    product.put("stock", resultSet.getInt("stock")); // ^ replace all of these with withMethods for ProductDefinition
                    
                    productDefinition.withId(resultSet.getInt("product_id")).withDescription(resultSet.getString("description")).withPrice(resultSet.getInt("price")).withStock(resultSet.getInt("stock"));
                    
//                    itemInCart.put("quantity", resultSet.getInt("quantity"));
//                    itemInCart.put("product", product);
                    itemDefinition.withQuantity(resultSet.getInt("quantity")).withProduct(productDefinition.toProduct());

//                    jsonArrayItemList.add(itemInCart); // replace with itemList.add(itemDefinition.toItem()
                    itemList.add(itemDefinition.toItem());
//                    tsb.print(itemList);
                }

//                cart.put("itemList", jsonArrayItemList); // replace with cartDefinition.withItemList(itemList)
                cartDefinition.withItemList(itemList);
//                tsb.print(cartDefinition);

//                if (jsonArrayCart.contains(cart)) { // replace w/ same logic but with listOfCartsFromDB.contains(cartDefinition.toCart())
//                    jsonArrayCart.remove(cart);
//                }
                Cart meh = cartDefinition.toCart();
                if (listOfCartsFromDB.contains(meh)) {
                    listOfCartsFromDB.remove(meh);
                }
                
//                jsonArrayCart.add(cart); // replace with listOfCartsFromDB.add(meh);
                listOfCartsFromDB.add(meh);
                tsb.print(listOfCartsFromDB);
            }
//            carts = new Gson().fromJson(jsonArrayCart.toJSONString(), new TypeToken<List<Cart>>() {}.getType());
            
            
            connection.close();
        } catch (Exception e) {
            e.getStackTrace();
        }

        return listOfCartsFromDB;
    }
    
    private ResultSet executeQuery() throws SQLException {
        Statement statement = connection.createStatement();
        return statement.executeQuery("""
                select c.cart_id as cart_id_from_cart, i.cart_id as cart_id_from_item, i.quantity, i.product_id, p.description, p.price, p.stock from _cart as c
                LEFT JOIN _item i on c.cart_id=i.cart_id
                LEFT JOIN _product p on p.product_id=i.product_id;""".indent(4));
    }
}

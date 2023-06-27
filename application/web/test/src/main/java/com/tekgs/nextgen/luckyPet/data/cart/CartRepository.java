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
    
    private CartRepository() {
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
    
    private List<Cart> query() {
        List<Cart> carts = new ArrayList<>();
        try {
            ResultSet resultSet = this.executeQuery();
            List<ItemCalibratable> itemList;
            CartDefinition cartDefinition = CartDefinition.getInstance();

            int lastId = 0;
            while (resultSet.next()) {
                int cartIdFromCart = resultSet.getInt("cart_id_from_cart");
                itemList = new ArrayList<>();
                if (cartIdFromCart != lastId) {
                    cartDefinition = CartDefinition.getInstance();
                    lastId = cartIdFromCart;
                    cartDefinition.withId(cartIdFromCart);
                }
                
                if (resultSet.getObject("cart_id_from_item") != null) {
                    ItemDefinition itemDefinition = ItemDefinition.getInstance();
                    ProductDefinition productDefinition = ProductDefinition.getInstance();
                    productDefinition.withId(resultSet.getInt("product_id"))
                            .withDescription(resultSet.getString("description"))
                            .withPrice(resultSet.getInt("price"))
                            .withStock(resultSet.getInt("stock"));
                    
                    itemDefinition.withQuantity(resultSet.getInt("quantity")).withProduct(productDefinition.toProduct());
                    itemList.add(itemDefinition.toItem());
                }
                
                Cart cart = cartDefinition.withItemList(itemList).toCart();

                if (carts.contains(cart)) {
                    carts.remove(cart);
                }
                
                carts.add(cart);
            }
            connection.close();
        } catch (Exception e) {
            e.getStackTrace();
        }
        return carts;
    }
    
    private ResultSet executeQuery() throws SQLException {
        Statement statement = connection.createStatement();
        return statement.executeQuery("""
                select c.cart_id as cart_id_from_cart, i.cart_id as cart_id_from_item, i.quantity, i.product_id, p.description, p.price, p.stock from _cart as c
                LEFT JOIN _item i on c.cart_id=i.cart_id
                LEFT JOIN _product p on p.product_id=i.product_id;""".indent(4));
    }
}

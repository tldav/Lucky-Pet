package com.luckypet.user.cart.data;

import org.softwareonpurpose.gauntlet.Environment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
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
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/lucky_pet_db", Environment.getInstance().getProperty("user"), Environment.getInstance().getProperty("password"));
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM _cart");
            int columnCount = resultSet.getMetaData().getColumnCount();
            while (resultSet.next()) {
                for (int i = 1; i <= columnCount; i++) {
                    if (i > 1) System.out.println(", ");
                    String columnValue = resultSet.getString(i);
                    System.out.println(columnValue + " " + resultSet.getMetaData().getColumnName(i));
                }
            }
            connection.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        
        return null;
    }
}

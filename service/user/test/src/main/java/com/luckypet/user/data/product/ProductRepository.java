package com.luckypet.user.data.product;

import org.softwareonpurpose.gauntlet.Environment;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductRepository {
    public static final String DB_URL = "jdbc:mysql://localhost:3306/lucky_pet_db";
    public static final String MYSQL_USER = Environment.getInstance().getProperty("user");
    public static final String MYSQL_PASSWORD = Environment.getInstance().getProperty("password");
    private Connection connection;

    private ProductRepository(){
        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            this.connection = DriverManager.getConnection(DB_URL, MYSQL_USER, MYSQL_PASSWORD);
        } catch (Exception e){
            e.getStackTrace();
        }
    }

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
            ResultSet resultSet = this.executeQuery();
            while(resultSet.next()){
                Product product = ProductDefinition.getInstance()
                        .withId(resultSet.getInt("id"))
                        .withDescription(resultSet.getString("description"))
                        .withPrice(resultSet.getInt("price"))
                        .withStock(resultSet.getInt("stock"))
                        .toProduct();

                products.add(product);
            }
            connection.close();
        } catch (Exception e) {
            e.getStackTrace();
        }
        return products;
    }

    private ResultSet executeQuery() throws SQLException {
        Statement statement = connection.createStatement();
        return statement.executeQuery("select * from _product");
    }
}

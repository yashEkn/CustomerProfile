package com.example;

import java.sql.*;

public class App {
    public static void main(String[] args) {
        String url = "jdbc:mysql://mysql-db:3306/demo";
        String user = "root";
        String password = "rootpass";

        try {
            Connection conn = DriverManager.getConnection(url, user, password);
            Statement stmt = conn.createStatement();

            // Create table if not exists
            stmt.executeUpdate("CREATE TABLE IF NOT EXISTS customers (customerID INT PRIMARY KEY AUTO_INCREMENT, name VARCHAR(50))");

            // Insert sample data
            stmt.executeUpdate("INSERT INTO customers (name) VALUES ('Alice'), ('Bob'), ('Charlie')");

            // Query and display
            ResultSet rs = stmt.executeQuery("SELECT * FROM customers");
            System.out.println("Customer List:");
            while (rs.next()) {
                System.out.println(rs.getInt("customerID") + " - " + rs.getString("name"));
            }

            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

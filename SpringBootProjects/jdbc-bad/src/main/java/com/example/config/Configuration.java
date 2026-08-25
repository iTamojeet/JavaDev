package com.example.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Configuration {
    //    static {
//        try {
//            Class<?> x = Class.forName("com.mysql.cj.jdbc.Driver");
//            IO.println("Loaded: " + x);
//        } catch (ClassNotFoundException e) {
//            IO.println("Error is: " + e.getMessage());
//        }
//    }
    private Connection conn;

    public Configuration(String dbName) throws SQLException {
        this.conn = switch (dbName.toLowerCase()) {
            case "oracle" -> makeCon_oracle();
            case "mysql" -> makeCon_mysql();
            default -> throw new IllegalStateException("Wrong db name");
        };
    }

    public Connection getConn() {
        return conn;
    }

    public static Connection makeCon_mysql() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/classicmodels",
                "root",
                "garden");
    }

    public static Connection makeCon_oracle() throws SQLException {
        return DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE",
                "c##scott",
                "tiger");
    }
}

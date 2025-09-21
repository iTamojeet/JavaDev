package com.example;

import java.sql.Connection;
import java.sql.DriverManager;

public class Main {
    public static void main(String ...args) {
//        IO.println("Hello World");
        try{
            Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","c##scott","tiger");
            IO.println(con);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}

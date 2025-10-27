package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class EmpBackup {
    static void main() {
        copyEmpData();
    }

    static void copyEmpData() {
        try {
            Connection con = DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521:XE",
                    "c##scott",
                    "tiger"
            );
            System.out.println("Connected: " + con);

            Statement st = con.createStatement(
                    ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE
            );

            int rows = st.executeUpdate("INSERT INTO empbackup SELECT * FROM emp");

            IO.println(rows + " records copied successfully to empbackup!");

            con.close();
        }
        catch (Exception e) {
            IO.println(e.getMessage());
        }
    }
}

package com.grocery.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {

    public static Connection getDBConnection() {

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");

            String url = "jdbc:oracle:thin:@localhost:1522/XE";
            String user = "system";
            String password = "root";

            Connection con = DriverManager.getConnection(url, user, password);

            con.setAutoCommit(false);
            return con;

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}

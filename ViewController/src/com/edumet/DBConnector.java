package com.edumet;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnector {

    static String url = "jdbc:oracle:thin:@74.92.75.133:1521:";
    static String dbName = "web";
    static String driver = "oracle.jdbc.driver.OracleDriver";
    static String userName = "edumet";
    static String password = "edumet";

    public DBConnector() {
        super();
    }

    public static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName(driver).newInstance();
            conn = DriverManager.getConnection(url + dbName, userName, password);
            System.out.println("Connected to the database");
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;

    }
}

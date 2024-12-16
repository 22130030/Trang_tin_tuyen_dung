package com.vn.tim_viec_lam.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBconnect {
    static DBProperties dbProperties = new DBProperties();
    static Connection con = null;

    public DBconnect() {
    }

    public static Connection getConnection() {
        String driver = dbProperties.getDriver();
        String url = dbProperties.getUrl();
        String user = dbProperties.getUser();
        String password = dbProperties.getPassword();
        String option = dbProperties.getOption();
        try {
            Class.forName(driver);

            con = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
        return con;
    }

    public static void main(String[] args) {
        getConnection();
    }
}

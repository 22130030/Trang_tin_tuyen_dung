package com.vn.tim_viec_lam.database;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class DBProperties {
    private String driver;
    private String url;
    private String user;
    private String password;
    private String option;
    public DBProperties() {
        loadProperties();
    }
    public void loadProperties() {

        InputStream in = DBProperties.class.getClassLoader().getResourceAsStream("config.properties");
        Properties prop = new Properties();
        try {
            prop.load(in);

            driver = prop.getProperty("jdbc.driver");
            url = prop.getProperty("jdbc.url");
            user = prop.getProperty("jdbc.username");
            password = prop.getProperty("jdbc.password");
            option = prop.getProperty("jdbc.option");


            in.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String getDriver() {
        return driver;
    }

    public String getUrl() {
        return url;
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }

    public String getOption() {
        return option;
    }

    public static void main(String[] args) {
        DBProperties prop = new DBProperties();
        prop.loadProperties();
    }
}

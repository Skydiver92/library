package com.kuzmenko.readlist.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Factory {

//    private final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
    private final String DB_DRIVER = "org.postgresql.Driver";
//    private final String URL = "jdbc:mysql://localhost:3306/readlist_db?autoReconnect=true&useSSL=false&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private final String URL = "jdbc:postgresql://localhost:5432/readlist_db";
//    private final String USER = "root";
    private final String USER = "postgres";
//    private final String PASSWORD = "admin";
    private final String PASSWORD = "postgres";

    public Connection connection;


    public void establishConnection() {
        try {
            if (connection == null) {
                Class.forName(DB_DRIVER);
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
                if (!connection.isClosed()) {
                    System.out.println("Соединение установлено!");
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println("Соединение не установлено!");
            e.printStackTrace();
        }
    }


    public void closeConnection() {
        try {
            if (!connection.isClosed()) {
                connection.close();
            }
            if (connection.isClosed()) {
                System.out.println("Соединение разорвано!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}



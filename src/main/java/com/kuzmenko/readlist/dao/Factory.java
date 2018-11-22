package com.kuzmenko.readlist.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Factory {

    private final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
    private final String URL = "jdbc:mysql://localhost:3306/readlist_db?autoReconnect=true&useSSL=false&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private final String USER = "root";
    private final String PASSWORD = "admin";
    public Connection connection;


    public  Connection getConnection() {

        try {
            if (connection == null) {
                Class.forName(DB_DRIVER);
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
                if (!connection.isClosed())
                    System.out.println("Соединение установлено!");
            }
        } catch (ClassNotFoundException | SQLException e)

        {
            System.err.println("Соединение не установлено!");
            e.printStackTrace();

        }


        return connection;
    }


    public void closeConnection() {

        try {
            if (!connection.isClosed()) {

                connection.close();
            }
            if (connection.isClosed())
                System.out.println("Соединение разорвано!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}



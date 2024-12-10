package com.project.app.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBContext {

    static final String URL_DATABASE = "jdbc:mysql://localhost:3306/qlluong";
    static final String SERVERNAME = "root";
    static final String PASSWORD = "tunglam16";

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        System.out.println("Kết nối MY SQL thành công");
        return DriverManager.getConnection(URL_DATABASE, SERVERNAME, PASSWORD);
    }
}

package com.project.app.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class LoginDAO {
    private static final String SQL = "SELECT * FROM account WHERE username = ?";
    private static LoginDAO instance;
    public static LoginDAO getInstance() {
        if(instance == null) {
            instance = new LoginDAO();
        }
        return instance;
    }
    private LoginDAO() {
        
    }
    public Boolean login(String username, String password) {
        PreparedStatement ps = null;
        try (Connection cnt = DBContext.getConnection()) {
            if (cnt != null) {
                ps = cnt.prepareStatement(SQL);
                ps.setString(1, username);
                var rs = ps.executeQuery();
                if (rs.next()) {
                    return password.equals(rs.getString("password"));
                }
            }
        } catch (Exception e) {
            System.err.println("LoginDAO >> login >> " + e.getMessage());
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException e) {
            }
        }
        return false;
    }
}

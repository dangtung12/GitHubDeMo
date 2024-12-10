package com.project.app.dao;

import com.project.app.dto.Employee;
import com.project.app.dto.Manager;
import com.project.app.dto.SalesEmployee;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EmployeeDAO {

    private static EmployeeDAO instance;

    public static EmployeeDAO getInstance() {
        if (instance == null) {
            instance = new EmployeeDAO();
        }
        return instance;
    }

    private EmployeeDAO() {

    }

    public void delete(int id, String position) {
        PreparedStatement ps = null;
        try (Connection cnt = DBContext.getConnection()) {
            if (cnt != null) {

                String SQL1 = String.format("DELETE FROM %s WHERE employee_id = ?", position.equals("Quản lý") ? "salary_manager" : "salary_sale");
                String SQL2 = """
                                DELETE FROM employee
                                WHERE id = ?;
                             """;
                ps = cnt.prepareStatement(SQL1);
                ps.setInt(1, id);
                ps.executeUpdate();

                ps = cnt.prepareStatement(SQL2);
                ps.setInt(1, id);
                ps.executeUpdate();
                cnt.close();
            }
        } catch (Exception e) {
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    Logger.getLogger(EmployeeDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public Boolean update(Employee emp) {
        PreparedStatement ps = null;
        try (Connection cnt = DBContext.getConnection()) {
            if (cnt != null) {
                String sql = """
                             UPDATE employee
                             SET fullName = ?,
                                gender = ?,
                                phone = ?,
                                position = ?,
                                base_salary = ?
                             WHERE id = ?;
                             """;
                ps = cnt.prepareStatement(sql);
                ps.setString(1, emp.getFullName());
                ps.setString(2, emp.getGender());
                ps.setString(3, emp.getPhone());
                ps.setString(4, emp.getPosition());
                ps.setDouble(5, emp.getBaseSalary());
                ps.setInt(6, emp.getId());
                ps.executeUpdate();
                cnt.close();
            }
            return true;
        } catch (Exception e) {

        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    Logger.getLogger(EmployeeDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return false;
    }

    public Boolean add(Employee emp) {
        PreparedStatement ps = null;
        try (Connection cnt = DBContext.getConnection()) {
            if (cnt != null) {
                String sql = "INSERT INTO employee(fullName, gender, phone, position, base_salary) VALUES (?, ?, ?, ?, ?)";
                ps = cnt.prepareStatement(sql);
                ps.setString(1, emp.getFullName());
                ps.setString(2, emp.getGender());
                ps.setString(3, emp.getPhone());
                ps.setString(4, emp.getPosition());
                ps.setDouble(5, emp.getBaseSalary());
                ps.executeUpdate();
                cnt.close();
            }
            return true;
        } catch (Exception e) {

        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    Logger.getLogger(EmployeeDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return false;
    }

    public List<Employee> getAll() throws Exception {
        List<Employee> list = new ArrayList<>();
        PreparedStatement ps = null;
        Connection cnt = DBContext.getConnection();
        if (cnt != null) {
            String sql = "SELECT * FROM employee;";
            ps = cnt.prepareStatement(sql);
            var rs = ps.executeQuery();
            while (rs.next()) {
                String position = rs.getString("position");
                Employee item = position.equals("Quản lý") ? new Manager() : new SalesEmployee();
                item.setId(rs.getInt("id"));
                item.setFullName(rs.getString("fullName"));
                item.setGender(rs.getString("gender"));
                item.setPhone(rs.getString("phone"));
                item.setBaseSalary(rs.getDouble("base_salary"));
                item.setPosition(position);
                list.add(item);
            }
            cnt.close();
        }
        if (ps != null) {
            ps.close();
        }
        return list;
    }

    public List<Employee> getAll(String position) throws Exception {
        List<Employee> list = new ArrayList<>();
        PreparedStatement ps = null;
        Connection cnt = DBContext.getConnection();
        if (cnt != null) {
            String sql = "SELECT * FROM employee WHERE position = ?";
            ps = cnt.prepareStatement(sql);
            ps.setString(1, position);
            var rs = ps.executeQuery();
            while (rs.next()) {
                Employee item = position.equals("Quản lý") ? new Manager() : new SalesEmployee();
                item.setId(rs.getInt("id"));
                item.setFullName(rs.getString("fullName"));
                item.setGender(rs.getString("gender"));
                item.setPhone(rs.getString("phone"));
                item.setBaseSalary(rs.getDouble("base_salary"));
                item.setPosition(position);
                list.add(item);
            }
            cnt.close();
        }
        if (ps != null) {
            ps.close();
        }
        return list;
    }
}

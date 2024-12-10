package com.project.app.dao;

import com.project.app.dto.Manager;
import com.project.app.dto.SalesEmployee;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class SaleDAO {
    private static SaleDAO instance;
    public static SaleDAO getInstance() {
        if(instance == null)
            instance = new SaleDAO();
        return instance;
    }
    private SaleDAO() {
        
    }
    
    public Boolean add(SalesEmployee emp) {
        PreparedStatement ps = null;
        try (Connection cnt = DBContext.getConnection()) {
            if (cnt != null) {
                String sql = "INSERT INTO salary_sale(employee_id, date_received, ot_hours, hour_work, net_salary) VALUES(?, ?, ?, ?, ?);";
                ps = cnt.prepareStatement(sql);
                ps.setInt(1, emp.getId());
                ps.setString(2, emp.getDateReceived());
                ps.setDouble(3, emp.getOtHours());
                ps.setDouble(4, emp.getHourWork());
                ps.setDouble(5, emp.calculateSalary());
                ps.executeUpdate();
                cnt.close();
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
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

    public void delete(int id) {
        PreparedStatement ps = null;
        try (Connection cnt = DBContext.getConnection()) {
            if (cnt != null) {
                String SQL = """
                                DELETE FROM salary_sale
                                WHERE id = ?;
                             """;
                ps = cnt.prepareStatement(SQL);
                ps.setInt(1, id);
                ps.executeUpdate();
                cnt.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
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

    public List<SalesEmployee> getAll() throws Exception {
        List<SalesEmployee> list = new ArrayList<>();
        PreparedStatement ps = null;
        Connection cnt = DBContext.getConnection();
        if (cnt != null) {
            String sql = """
                         select ss.*, e.fullName, e.base_salary
                         from salary_sale ss
                         left join employee e ON e.id = ss.employee_id;
                         """;
            ps = cnt.prepareStatement(sql);
            var rs = ps.executeQuery();
            while (rs.next()) {
                SalesEmployee item = new SalesEmployee();
                item.setId(rs.getInt("employee_id"));
                item.set_id(rs.getInt("id"));
                item.setFullName(rs.getString("fullName"));
                item.setDateReceived(rs.getString("date_received"));
                item.setOtHours(rs.getInt("ot_hours"));
                item.setHourWork(rs.getInt("hour_work"));
                item.setNetSalary(rs.getDouble("net_salary"));
                item.setBaseSalary(rs.getDouble("base_salary"));
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

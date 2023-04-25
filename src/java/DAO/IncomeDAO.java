/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Income;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class IncomeDAO {

    Connection con = DAO.newConnect();

    public ArrayList<Income> getAllIncome() {
        ArrayList<Income> listIncome = new ArrayList<>();
        try {
            String sql = "select * from income";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Income income = new Income();
                income.setId(rs.getInt("id"));

                CustomerDAO customerDAO = new CustomerDAO();
                income.setCustomer(customerDAO.getCustomerById(rs.getInt("customer_id")));

                income.setMonth(rs.getInt("month"));
                income.setYear(rs.getInt("year"));
                income.setSalary(rs.getDouble("salary"));
                income.setBonus(rs.getDouble("bonus"));
                income.setPcanuong(rs.getDouble("pcanuong"));
                income.setPcvpp(rs.getDouble("pcvpp"));
                income.setPcctp(rs.getDouble("pcctp"));
                income.setPcctp(rs.getDouble("pcctp"));
                income.setPctangca(rs.getDouble("pctangca"));
                income.setPcdochai(rs.getDouble("pcdochai"));
                income.setPckcb(rs.getDouble("pckcb"));
                income.setPcbhkbb(rs.getDouble("pcbhkbb"));
                income.setTuthien(rs.getDouble("tuthien"));
                listIncome.add(income);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listIncome;
    }

    public Income getIncomeById(int incomeId) {
        Income income = new Income();
        try {
            String sql = "select * from income where id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, incomeId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                income.setId(rs.getInt("id"));

                CustomerDAO customerDAO = new CustomerDAO();
                income.setCustomer(customerDAO.getCustomerById(rs.getInt("customer_id")));

                income.setMonth(rs.getInt("month"));
                income.setYear(rs.getInt("year"));
                income.setSalary(rs.getDouble("salary"));
                income.setBonus(rs.getDouble("bonus"));
                income.setPcanuong(rs.getDouble("pcanuong"));
                income.setPcvpp(rs.getDouble("pcvpp"));
                income.setPcctp(rs.getDouble("pcctp"));
                income.setPcctp(rs.getDouble("pcctp"));
                income.setPctangca(rs.getDouble("pctangca"));
                income.setPcdochai(rs.getDouble("pcdochai"));
                income.setPckcb(rs.getDouble("pckcb"));
                income.setPcbhkbb(rs.getDouble("pcbhkbb"));
                income.setTuthien(rs.getDouble("tuthien"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return income;
    }

    public ArrayList<Income> getIncomeByYear(int year) {
        ArrayList<Income> listIncome = new ArrayList<>();
        try {
            String sql = "select * from income where year=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, year);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Income income = new Income();
                income.setId(rs.getInt("id"));

                CustomerDAO customerDAO = new CustomerDAO();
                income.setCustomer(customerDAO.getCustomerById(rs.getInt("customer_id")));

                income.setMonth(rs.getInt("month"));
                income.setYear(rs.getInt("year"));
                income.setSalary(rs.getDouble("salary"));
                income.setBonus(rs.getDouble("bonus"));
                income.setPcanuong(rs.getDouble("pcanuong"));
                income.setPcvpp(rs.getDouble("pcvpp"));
                income.setPcctp(rs.getDouble("pcctp"));
                income.setPcctp(rs.getDouble("pcctp"));
                income.setPctangca(rs.getDouble("pctangca"));
                income.setPcdochai(rs.getDouble("pcdochai"));
                income.setPckcb(rs.getDouble("pckcb"));
                income.setPcbhkbb(rs.getDouble("pcbhkbb"));
                income.setTuthien(rs.getDouble("tuthien"));
                listIncome.add(income);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listIncome;
    }
}

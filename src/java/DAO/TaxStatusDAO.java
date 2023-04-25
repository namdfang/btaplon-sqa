/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Income;
import Model.TaxStatus;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class TaxStatusDAO {
    Connection con = DAO.newConnect();    
    
    public ArrayList<TaxStatus> getTaxStatusByTime(int month, int year){
        ArrayList<TaxStatus> listTaxStatus = new ArrayList<>();
        try {
            String sql = "select tax_status.id,income_id,taxAmount,status from tax_status,income"
                    + " where income.year=?"
                    + " and income.month=?"
                    + " and income.id = tax_status.income_id";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, year);
            ps.setInt(2, month);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                TaxStatus taxStatus = new TaxStatus();
                taxStatus.setId(rs.getInt("id"));
                
                IncomeDAO incomeDAO = new IncomeDAO();
                Income income = incomeDAO.getIncomeById(rs.getInt("income_id"));
                taxStatus.setIncome(income);
                
                taxStatus.setTaxAmount(rs.getDouble("taxAmount"));
                taxStatus.setStatus(rs.getString("status"));
                listTaxStatus.add(taxStatus);
            }
        } catch (SQLException e) {
        }
        return listTaxStatus;
    }
    
//    public ArrayList<TaxStatus> getAllTaxStatus(){
//        ArrayList<TaxStatus> listTaxStatus = new ArrayList<>();
//        try {
//            String sql = "select * from tax_status";
//            PreparedStatement ps = con.prepareStatement(sql);
//            ResultSet rs = ps.executeQuery();
//            while(rs.next()){
//                TaxStatus taxStatus = new TaxStatus();
//                taxStatus.setId(rs.getInt("id"));
//                
//                IncomeDAO incomeDAO = new IncomeDAO();
//                Income income = incomeDAO.getIncomeById(rs.getInt("income_id"));
//                taxStatus.setIncome(income);
//                
//                taxStatus.setTaxAmount(rs.getDouble("taxAmount"));
//                taxStatus.setStatus(rs.getString("status"));
//                listTaxStatus.add(taxStatus);
//            }
//        } catch (SQLException e) {
//        }
//        return listTaxStatus;
//    }
    
    public TaxStatus getTaxStatusById(int id){
        TaxStatus taxStatus = new TaxStatus();
        try {
            String sql = "select * from tax_status where id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                taxStatus.setId(rs.getInt("id"));
                
                IncomeDAO incomeDAO = new IncomeDAO();
                Income income = incomeDAO.getIncomeById(rs.getInt("income_id"));
                taxStatus.setIncome(income);
                
                taxStatus.setTaxAmount(rs.getDouble("taxAmount"));
                taxStatus.setStatus(rs.getString("status"));
            }
        } catch (SQLException e) {
        }
        return taxStatus;
    }
    
    public boolean updateTaxStatus(TaxStatus taxStatus){
        try {
            String sql = "update tax_status set income_id=?, taxAmount=?, status=? where id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, taxStatus.getIncome().getId());
            ps.setDouble(2, taxStatus.getTaxAmount());
            ps.setString(3, taxStatus.getStatus());
            ps.setInt(4, taxStatus.getId());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
        }
        return false;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.TaxRatio;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class TaxRatioDAO {
    Connection con = DAO.newConnect();
    
    public ArrayList<TaxRatio> getListTaxRatio() {
        ArrayList<TaxRatio> listTaxRatio = new ArrayList<>();
        try {
            String sql = "select * from tax_ratio";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                TaxRatio taxRatio = new TaxRatio();
                taxRatio.setId(rs.getInt("id"));
                taxRatio.setLevel(rs.getInt("level"));
                taxRatio.setMinIncome(rs.getDouble("min_income"));
                taxRatio.setMaxIncome(rs.getDouble("max_income"));
                taxRatio.setDescription(rs.getString("description"));
                taxRatio.setRatio(rs.getDouble("ratio"));
                //taxRatio.setReduce(rs.getDouble("reduce"));
                listTaxRatio.add(taxRatio);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listTaxRatio;
    }
    
    public TaxRatio getTaxRatioById(int id) {
        TaxRatio taxRatio = new TaxRatio();
        try {
            String sql = "select * from tax_ratio where id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                taxRatio.setId(rs.getInt("id"));
                taxRatio.setLevel(rs.getInt("level"));
                taxRatio.setMinIncome(rs.getDouble("min_income"));
                taxRatio.setMaxIncome(rs.getDouble("max_income"));
                taxRatio.setDescription(rs.getString("description"));
                taxRatio.setRatio(rs.getDouble("ratio"));
                //taxRatio.setReduce(rs.getDouble("reduce"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return taxRatio;
    }
    
    // this function is written for testing only.
    public TaxRatio getTaxRatioByDescription(String des) {
        TaxRatio taxRatio = new TaxRatio();
        try {
            String sql = "select * from tax_ratio where description=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, des);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                taxRatio.setId(rs.getInt("id"));
                taxRatio.setLevel(rs.getInt("level"));
                taxRatio.setMinIncome(rs.getDouble("min_income"));
                taxRatio.setMaxIncome(rs.getDouble("max_income"));
                taxRatio.setDescription(rs.getString("description"));
                taxRatio.setRatio(rs.getDouble("ratio"));
                //taxRatio.setReduce(rs.getDouble("reduce"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return taxRatio;
    }
    
    public TaxRatio getTaxRatioByLevel (int level){
        TaxRatio ratio = new TaxRatio();
        try {
            String sql = "select * from tax_ratio where level=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, level);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                ratio.setId(rs.getInt("id"));
                ratio.setLevel(rs.getInt("level"));
                ratio.setMinIncome(rs.getDouble("min_income"));
                ratio.setMaxIncome(rs.getDouble("max_income"));
                ratio.setDescription(rs.getString("description"));
                ratio.setRatio(rs.getDouble("ratio"));
                //ratio.setReduce(rs.getDouble("reduce"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ratio;
    }
    
    public TaxRatio getTaxRatioByTNTT(double TNTT){
        TaxRatio ratio = new TaxRatio();
        try {
            String sql = "select * from tax_ratio where min_income<? and max_income>?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setDouble(1, TNTT);
            ps.setDouble(2, TNTT);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                ratio.setId(rs.getInt("id"));
                ratio.setLevel(rs.getInt("level"));
                ratio.setMinIncome(rs.getDouble("min_income"));
                ratio.setMaxIncome(rs.getDouble("max_income"));
                ratio.setDescription(rs.getString("description"));
                ratio.setRatio(rs.getDouble("ratio"));
                //ratio.setReduce(rs.getDouble("reduce"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ratio;
    }
    
    public boolean updateTaxRatio(TaxRatio taxRatio){
        try {
            String sql = "update tax_ratio set level=?, min_income=?, max_income=?, description=?, ratio=? where id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, taxRatio.getLevel());
            ps.setDouble(2, taxRatio.getMinIncome());
            ps.setDouble(3, taxRatio.getMaxIncome());
            ps.setString(4, taxRatio.getDescription());
            ps.setDouble(5, taxRatio.getRatio());
            ps.setInt(6, taxRatio.getId());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean addTaxRatio(TaxRatio taxRatio){
        try {
            String sql = "insert into tax_ratio(level,min_income,max_income,description,ratio) values(?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, taxRatio.getLevel());
            ps.setDouble(2, taxRatio.getMinIncome());
            ps.setDouble(3, taxRatio.getMaxIncome());
            ps.setString(4, taxRatio.getDescription());
            ps.setDouble(5, taxRatio.getRatio());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean deleteTaxRatio(int id) {
        try {
            String sql = "delete from tax_ratio where id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}

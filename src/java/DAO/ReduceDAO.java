/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Reduce;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class ReduceDAO {
    Connection con = DAO.newConnect();
    
    public ArrayList<Reduce> getListReduce() {
        ArrayList<Reduce> listReduce = new ArrayList<>();
        try {
            String sql = "select * from reduce";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Reduce reduce = new Reduce();
                reduce.setId(rs.getInt("id"));
                reduce.setName(rs.getString("name"));
                reduce.setKeyword(rs.getString("keyword"));
                reduce.setAmount(rs.getDouble("amount"));
                reduce.setMeasure(rs.getString("measure"));
                listReduce.add(reduce);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return listReduce;
    }
    
    
    public double getReduceAmountByKeyword(String keyword) {
        double amount = 0;
        try {
            String sql = "select amount from reduce where keyword like ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, keyword);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                amount = rs.getDouble("amount");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            amount = 0;
        }
        return amount;
    }
    
    public Reduce getReduceById(int id) {
        Reduce reduce = new Reduce();
        try {
            String sql = "select * from reduce where id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                reduce.setId(rs.getInt("id"));
                reduce.setName(rs.getString("name"));
                reduce.setKeyword(rs.getString("keyword"));
                reduce.setAmount(rs.getDouble("amount"));
                reduce.setMeasure(rs.getString("measure"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return reduce;
    }
    
    // this function is written for testing only.
    public Reduce getReduceByKeyword(String keyword) {
        Reduce reduce = new Reduce();
        try {
            String sql = "select * from reduce where keyword=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, keyword);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                reduce.setId(rs.getInt("id"));
                reduce.setName(rs.getString("name"));
                reduce.setKeyword(rs.getString("keyword"));
                reduce.setAmount(rs.getDouble("amount"));
                reduce.setMeasure(rs.getString("measure"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return reduce;
    }
    
    public boolean updateReduce(Reduce reduce){
        try {
            String sql = "update reduce set name=?, amount=?, measure=? where id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, reduce.getName());
            ps.setDouble(2, reduce.getAmount());
            ps.setString(3, reduce.getMeasure());
            ps.setInt(4, reduce.getId());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean addReduce(Reduce reduce){
        try {
            String sql = "insert into reduce(name,keyword,amount,measure) values(?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, reduce.getName());
            ps.setString(2, reduce.getKeyword());
            ps.setDouble(3, reduce.getAmount());
            ps.setString(4, reduce.getMeasure());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean deleteReduce(int id) {
        try {
            String sql = "delete from reduce where id=?";
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

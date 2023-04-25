/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Customer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class CustomerDAO {

    Connection con = DAO.newConnect();

    public ArrayList<Customer> getListCustomer() {
        ArrayList<Customer> listCustomer = new ArrayList<>();
        try {
            String sql = "select * from customer";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Customer customer = new Customer();
                customer.setId(rs.getInt("id"));
                customer.setName(rs.getString("name"));
                customer.setAge(rs.getInt("age"));
                customer.setSex(rs.getString("sex"));
                customer.setAddress(rs.getString("address"));
                customer.setCmt(rs.getString("cmt"));
                customer.setTaxId(rs.getString("tax_id"));
                customer.setEmail(rs.getString("email"));
                customer.setSdt(rs.getString("sdt"));
                customer.setGtgcbt(rs.getString("gtgcbt"));
                customer.setGtgcpt(rs.getInt("gtgcpt"));
                customer.setGtbhbb(rs.getString("gtbhbb"));
                listCustomer.add(customer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listCustomer;
    }
    
    public Customer getCustomerById(int id) {
        Customer customer = new Customer();
        try {
            String sql = "select * from customer where id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                customer.setId(rs.getInt("id"));
                customer.setName(rs.getString("name"));
                customer.setAge(rs.getInt("age"));
                customer.setSex(rs.getString("sex"));
                customer.setAddress(rs.getString("address"));
                customer.setCmt(rs.getString("cmt"));
                customer.setTaxId(rs.getString("tax_id"));
                customer.setEmail(rs.getString("email"));
                customer.setSdt(rs.getString("sdt"));
                customer.setGtgcbt(rs.getString("gtgcbt"));
                customer.setGtgcpt(rs.getInt("gtgcpt"));
                customer.setGtbhbb(rs.getString("gtbhbb"));
            }   
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customer;
    }
    

    public boolean updateCustomer(Customer customer) {
        try {
            String sql = "update customer set"
                    + " name=?, age=?, sex=?, address=?, cmt=?,"
                    + " tax_id=?,email=?, sdt=?, gtgcbt=?, gtgcpt=?, gtbhbb=?"
                    + " where id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            System.out.println("========================"+customer.getEmail()+customer.getSdt());
            ps.setString(1, customer.getName());
            ps.setInt(2, customer.getAge());
            ps.setString(3, customer.getSex());
            ps.setString(4, customer.getAddress());
            ps.setString(5, customer.getCmt());
            ps.setString(6, customer.getTaxId());
            ps.setString(7, customer.getEmail());
            ps.setString(8, customer.getSdt());
            ps.setString(9, customer.getGtgcbt());
            ps.setInt(10, customer.getGtgcpt());
            ps.setString(11, customer.getGtbhbb());
            ps.setInt(12, customer.getId());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
//    public boolean updateCustomer(Customer customer) {
//        try {
//            String sql = "update customer set"
//                    + " name=?, age=?, sex=?, address=?, cmt=?,"
//                    + " tax_id=?,email=?, sdt=? gtgcbt=?, gtgcpt=?, gtbhbb=?"
//                    + " where id=?";
//            PreparedStatement ps = con.prepareStatement(sql);
//            System.out.println("========================"+customer.getEmail()+customer.getSdt());
//            ps.setString(1, customer.getName());
//            ps.setInt(2, customer.getAge());
//            ps.setString(3, customer.getSex());
//            ps.setString(4, customer.getAddress());
//            ps.setString(5, customer.getCmt());
//            ps.setString(6, customer.getTaxId());
////            ps.setString(7, customer.getEmail());
////            ps.setString(8, customer.getSdt());
//            ps.setString(7, customer.getGtgcbt());
//            ps.setInt(8, customer.getGtgcpt());
//            ps.setString(9, customer.getGtbhbb());
//            ps.setInt(10, customer.getId());
//            ps.executeUpdate();
//            return true;
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return false;
//    }
    
    public int rowCount(){
        int count = 0;
        try  {
            String sql = "select * from customer";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            rs.last();
            count = rs.getRow();
        } catch (SQLException e) {
        }
        return count;
    }
    
    public boolean addCustomer(Customer customer) {
        try {
            String sql = "insert into customer(name,age,sex,address,cmt,tax_id,email,sdt,gtgcbt,gtgcpt,gtbhbb)"
                    + " values(?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, customer.getName());
            ps.setInt(2, customer.getAge());
            ps.setString(3, customer.getSex());
            ps.setString(4, customer.getAddress());
            ps.setString(5, customer.getCmt());
            ps.setString(6, customer.getTaxId());
            ps.setString(7, customer.getEmail());
            ps.setString(8, customer.getSdt());
            ps.setString(9, customer.getGtgcbt());
            ps.setInt(10, customer.getGtgcpt());
            ps.setString(11, customer.getGtbhbb());
            System.out.println("Added Customer");
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean deleteCustomer(int id) {
        try {
            String sql = "delete from customer where id=?";
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

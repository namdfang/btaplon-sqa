/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author DELL
 */
public class UserDAO {
    Connection con = DAO.newConnect();
    
    public User getUserByUsername(String username, String password){
        User user = new User();
        try {
            String sql = "select * from user where username=? and password=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
    public User checkAccountExist(String user){
        
        try{
            String query = "select * from user where username = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, user);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                return new User(rs.getInt(1), rs.getString(2), rs.getString(3));
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public void signup(String user, String pass){
        try{
            int n=2;
            String query = "insert into user (username, password) value(?,?)";
            System.out.println("đâsdasdasdas");
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, user);
            ps.setString(2, pass);
            ps.executeUpdate();
            
        }catch (SQLException e) {
            e.printStackTrace();
            System.out.println("ádasdasadsasdasda");
        }
    }
}

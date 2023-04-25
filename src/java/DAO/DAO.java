/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author DELL
 */
public class DAO {

    private static String url = "jdbc:mysql://localhost:3306/tax_management";

    public static Connection newConnect() {
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url, "root", "Vanminh200101");
            //con.setAutoCommit(false); // khi test mới cần, k test thì bỏ đi
            System.out.println("DB Connect Successfully!");
        } catch (ClassNotFoundException | SQLException e) {
        }
        return con;
    }
    
}

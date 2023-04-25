/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author DELL
 */
public class UserDAOTest {

    UserDAO instance = new UserDAO();

    public UserDAOTest() {
    }

//    @Before
//    public void setUp() throws Exception {
//    }
//
//    @After
//    public void tearDown() throws Exception {
//        instance.con.rollback();
//    }
    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testGetUserByUsername() {
        System.out.println("getUserByUsername");
        String username = "admin";
        String password = "admin";
        User result = instance.getUserByUsername(username, password);
        assertEquals("admin", result.getUsername());
        assertEquals("admin", result.getPassword());
    }

    @Test
    public void testGetUserByUsernameWithNull() {
        System.out.println("getUserByUsernameWithNull");
        String username = "";
        String password = "";
        User result = instance.getUserByUsername(username, password);
        assertEquals(null, result.getUsername());
        assertEquals(null, result.getPassword());
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Customer;
import java.util.ArrayList;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author DELL
 */
public class CustomerDAOTest {

    CustomerDAO instance = new CustomerDAO();

    public CustomerDAOTest() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testGetListCustomer() {
        System.out.println("getListCustomer");
        int expResult = 2;
        ArrayList<Customer> result = instance.getListCustomer();
        assertEquals(expResult, result.size());
    }

    @Test
    public void testGetCustomerById() {
        System.out.println("getCustomerById");
        int id = 1;
        Customer result = instance.getCustomerById(id);
        assertEquals("minh van", result.getName());
        assertEquals(23, result.getAge());
        assertEquals("Nam", result.getSex());
        assertEquals("ha noi", result.getAddress());
        assertEquals("038201010669", result.getCmt());
        assertEquals("1111", result.getTaxId());
        assertEquals("Có", result.getGtgcbt());
        assertEquals(23, result.getGtgcpt());
        assertEquals("Có", result.getGtbhbb());
    }

    @Test
    public void testUpdateCustomer() {
        System.out.println("updateCustomer");
        Customer customer = new Customer(2, "Phạm Văn Khoa", 25, "Nam",
                "Phường Văn Quán", "0123456785", "3588864289", "Có", 1, "Có");
        boolean expResult = true;
        boolean result = instance.updateCustomer(customer);
        Customer updatedCustomer = instance.getCustomerById(1);
        assertEquals(expResult, result);
        assertEquals("Phạm Văn Khoa", updatedCustomer.getName());
    }

    @Test
    public void testAddCustomer() {
        System.out.println("addCustomer");
        Customer customer = new Customer(10045, "Test Nguyen", 35, "Nữ",
                "Phường Yeen Nghĩa", "1122459999", "1113", "Có", 3, "Có");
        boolean expResult = true;
        boolean result = instance.addCustomer(customer);
        assertEquals(expResult, result);
    }

    @Test
    public void testDeleteCustomer() {
        // this case fail: foreign key error
        System.out.println("deleteCustomer");
        int id = 10001;
        boolean expResult = true;
        boolean result = instance.deleteCustomer(id);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testDeleteCustomer2() {
        // this case pass
        System.out.println("deleteCustomer");
        int id = 10047;
        boolean expResult = true;
        boolean result = instance.deleteCustomer(id);
        assertEquals(expResult, result);
    }

}

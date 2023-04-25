/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Customer;
import Model.Income;
import java.util.ArrayList;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author DELL
 */
public class IncomeDAOTest {

    IncomeDAO instance = new IncomeDAO();

    public IncomeDAOTest() {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
        // rollback database về trạng thái ban đầu sau mỗi hàm test
        instance.con.rollback();
    }

    @Test
    public void testGetAllIncome() {
        System.out.println("getAllIncome");
        int expLength = 16;
        int length = instance.getAllIncome().size();
        assertEquals(expLength, length);
    }

    @Test
    public void testGetIncomeById() {
        System.out.println("getIncomeById");
        int incomeId = 5001;
        Income income = instance.getIncomeById(incomeId);
        assertTrue(income.getCustomer().getId() == 10001);
        assertTrue(income.getYear() == 2020);
        assertTrue(income.getMonth() == 1);
        assertTrue(income.getSalary() == 20);
        assertTrue(income.getBonus() == 1);
    }

    @Test
    public void testGetIncomeById2() {
        System.out.println("getIncomeById2");
        int incomeId = 0; // id not exist
        Income income = instance.getIncomeById(incomeId);
        Customer customer = income.getCustomer();
        assertEquals(null, customer);
        assertTrue(income.getYear() == 0);
        assertTrue(income.getMonth() == 0);
        assertTrue(income.getSalary() == 0);
        assertTrue(income.getBonus() == 0);
    }

    @Test
    public void testGetIncomeByYear() {
        System.out.println("getIncomeByYear");
        int year = 2020;
        ArrayList<Income> listIncome = instance.getIncomeByYear(year);
        assertTrue(listIncome.size() == 16);
    }
    
    @Test
    public void testGetIncomeByYear2() {
        System.out.println("getIncomeByYear2");
        int year = 0;
        ArrayList<Income> listIncome = instance.getIncomeByYear(year);
        assertTrue(listIncome.isEmpty());
    }
    
    @Test
    public void testGetIncomeByYear3() {
        System.out.println("getIncomeByYear3");
        int year = -2020;
        ArrayList<Income> listIncome = instance.getIncomeByYear(year);
        assertTrue(listIncome.isEmpty());
    }
    
    @Test
    public void testGetIncomeByYear4() {
        System.out.println("getIncomeByYear4");
        int year = 2021;
        ArrayList<Income> listIncome = instance.getIncomeByYear(year);
        assertTrue(listIncome.isEmpty());
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Income;
import Model.TaxStatus;
import java.util.ArrayList;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author DELL
 */
public class TaxStatusDAOTest {

    TaxStatusDAO instance = new TaxStatusDAO();

    public TaxStatusDAOTest() {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
        instance.con.rollback();
    }

    @Test
    public void testGetTaxStatusByTime() {
        System.out.println("getTaxStatusByTime");
        int month = 5;
        int year = 2020;
        int expResult = 7;
        ArrayList<TaxStatus> result = instance.getTaxStatusByTime(month, year);
        assertEquals(expResult, result.size());
    }

    @Test
    public void testGetTaxStatusByTime2() {
        System.out.println("getTaxStatusByTime2");
        int month = 0;
        int year = 2020;
        int expResult = 0;
        ArrayList<TaxStatus> result = instance.getTaxStatusByTime(month, year);
        assertEquals(expResult, result.size());
    }

    @Test
    public void testGetTaxStatusById() {
        System.out.println("getTaxStatusById");
        int id = 6001;
        TaxStatus result = instance.getTaxStatusById(id);
        assertEquals(5001, result.getIncome().getId());
        assertEquals(0.159, result.getTaxAmount(), 0.0);
        assertEquals("Đã nộp", result.getStatus());
    }

    @Test
    public void testGetTaxStatusById2() {
        System.out.println("getTaxStatusById");
        int id = 1;
        TaxStatus result = instance.getTaxStatusById(id);
        assertEquals(null, result.getIncome());
        assertEquals(0.0, result.getTaxAmount(), 0.0);
        assertEquals(null, result.getStatus());
    }

    @Test
    public void testUpdateTaxStatus() {
        System.out.println("updateTaxStatus");
        TaxStatus taxStatus = new TaxStatus();
        Income income = new Income();
        income.setId(5002);
        taxStatus.setId(6001);
        taxStatus.setIncome(income);
        taxStatus.setTaxAmount(0.2);
        taxStatus.setStatus("Chưa nộp");
        boolean result = instance.updateTaxStatus(taxStatus);
        assertEquals(true, result);

        TaxStatus updatedTaxStatus = instance.getTaxStatusById(6001);
        assertEquals(5002, updatedTaxStatus.getIncome().getId());
        assertEquals(0.2, updatedTaxStatus.getTaxAmount(), 0.0);
        assertEquals("Chưa nộp", updatedTaxStatus.getStatus());
    }

}

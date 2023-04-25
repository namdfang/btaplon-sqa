/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.TaxRatio;
import java.util.ArrayList;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author DELL
 */
public class TaxRatioDAOTest {

    TaxRatioDAO instance = new TaxRatioDAO();

    public TaxRatioDAOTest() {
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
    public void testGetListTaxRatio() {
        System.out.println("getListTaxRatio");
        ArrayList<TaxRatio> listTaxRatio = instance.getListTaxRatio();
        assertTrue(listTaxRatio.size() == 7);
        //assertEquals(7, listTaxRatio.size());
    }

    @Test
    public void testGetTaxRatioById() {
        System.out.println("getTaxRatioById");
        int id = 105;
        TaxRatio taxRatio = instance.getTaxRatioById(id);
        assertTrue(taxRatio.getLevel() == 5);
        assertTrue(taxRatio.getMinIncome() == 32);
        assertTrue(taxRatio.getMaxIncome() == 52);
        assertTrue(taxRatio.getDescription().equals("Trên 32 tr.VNĐ đến 52 tr.VNĐ"));
        assertEquals(25, taxRatio.getRatio(), 0.0);
    }

    @Test
    public void testGetTaxRatioById2() {
        System.out.println("getTaxRatioById2");
        int id = 0; // id not exist
        TaxRatio taxRatio = instance.getTaxRatioById(id);
        assertTrue(taxRatio.getLevel() == 0);
        assertTrue(taxRatio.getMinIncome() == 0);
        assertTrue(taxRatio.getMaxIncome() == 0);
        assertEquals(null, taxRatio.getDescription());
        assertTrue(taxRatio.getRatio() == 0);
    }

    @Test
    public void testGetTaxRatioByDescription() {
        System.out.println("getTaxRatioByDescription");
        String des = "Trên 5 tr.VNĐ đến 10 tr.VNĐ";
        TaxRatio taxRatio = instance.getTaxRatioByDescription(des);
        assertTrue(taxRatio.getId() == 102);
        assertTrue(taxRatio.getLevel() == 2);
        assertTrue(taxRatio.getMinIncome() == 5);
        assertTrue(taxRatio.getMaxIncome() == 10);
        assertEquals("Trên 5 tr.VNĐ đến 10 tr.VNĐ", taxRatio.getDescription());
        assertTrue(taxRatio.getRatio() == 10);
    }
    
    @Test
    public void testGetTaxRatioByDescription2() {
        System.out.println("getTaxRatioByDescription2");
        String des = ""; // description is not exist
        TaxRatio taxRatio = instance.getTaxRatioByDescription(des);
        assertTrue(taxRatio.getId() == 0);
        assertTrue(taxRatio.getLevel() == 0);
        assertTrue(taxRatio.getMinIncome() == 0);
        assertTrue(taxRatio.getMaxIncome() == 0);
        assertEquals(null, taxRatio.getDescription());
        assertTrue(taxRatio.getRatio() == 0);
    }
    
    @Test
    public void testGetTaxRatioByDescription3() {
        System.out.println("getTaxRatioByDescription3");
        String des = "aaaaa"; // description is not exist
        TaxRatio taxRatio = instance.getTaxRatioByDescription(des);
        assertTrue(taxRatio.getId() == 0);
        assertTrue(taxRatio.getLevel() == 0);
        assertTrue(taxRatio.getMinIncome() == 0);
        assertTrue(taxRatio.getMaxIncome() == 0);
        assertEquals(null, taxRatio.getDescription());
        assertTrue(taxRatio.getRatio() == 0);
    }

    @Test
    public void testGetTaxRatioByLevel() {
        System.out.println("getTaxRatioByLevel");
        int level = 5;
        TaxRatio taxRatio = instance.getTaxRatioByLevel(level);
        assertTrue(taxRatio.getId() == 105);
        assertTrue(taxRatio.getMinIncome() == 32);
        assertTrue(taxRatio.getMaxIncome() == 52);
        assertTrue(taxRatio.getDescription().equals("Trên 32 tr.VNĐ đến 52 tr.VNĐ"));
        assertEquals(25, taxRatio.getRatio(), 0.0);
    }

    @Test
    public void testGetTaxRatioByLevel2() {
        System.out.println("getTaxRatioByLevel2");
        int level = 0; // level not exist
        TaxRatio taxRatio = instance.getTaxRatioByLevel(level);
        assertTrue(taxRatio.getMinIncome() == 0);
        assertTrue(taxRatio.getMaxIncome() == 0);
        assertEquals(null, taxRatio.getDescription());
        assertTrue(taxRatio.getRatio() == 0);
    }

    @Test
    public void testGetTaxRatioByTNTT() {
        System.out.println("getTaxRatioByTNTT");
        double TNTT = 40.35;
        TaxRatio taxRatio = instance.getTaxRatioByTNTT(TNTT);
        assertTrue(taxRatio.getId() == 105);
        assertTrue(taxRatio.getLevel() == 5);
        assertTrue(taxRatio.getMinIncome() == 32);
        assertTrue(taxRatio.getMaxIncome() == 52);
        assertTrue(taxRatio.getDescription().equals("Trên 32 tr.VNĐ đến 52 tr.VNĐ"));
        assertEquals(25, taxRatio.getRatio(), 0.0);
    }

    @Test
    public void testGetTaxRatioByTNTT2() {
        System.out.println("getTaxRatioByTNTT2");
        double TNTT = 0;
        TaxRatio taxRatio = instance.getTaxRatioByTNTT(TNTT);
        assertTrue(taxRatio.getId() == 0);
        assertTrue(taxRatio.getLevel() == 0);
        assertTrue(taxRatio.getMinIncome() == 0);
        assertTrue(taxRatio.getMaxIncome() == 0);
        assertEquals(null, taxRatio.getDescription());
        assertTrue(taxRatio.getRatio() == 0);
    }
    
    @Test
    public void testGetTaxRatioByTNTT3() {
        System.out.println("getTaxRatioByTNTT3");
        double TNTT = -20;
        TaxRatio taxRatio = instance.getTaxRatioByTNTT(TNTT);
        assertTrue(taxRatio.getId() == 0);
        assertTrue(taxRatio.getLevel() == 0);
        assertTrue(taxRatio.getMinIncome() == 0);
        assertTrue(taxRatio.getMaxIncome() == 0);
        assertEquals(null, taxRatio.getDescription());
        assertTrue(taxRatio.getRatio() == 0);
    }

    @Test
    public void testUpdateTaxRatio() {
        System.out.println("updateTaxRatio");
        TaxRatio taxRatio = new TaxRatio(105, 5, 32, 52,
                "Trên 32 tr.VNĐ đến 52 tr.VNĐ", 27);
        boolean result = instance.updateTaxRatio(taxRatio);
        assertEquals(true, result);
        
        // check if database updated or not
        TaxRatio updatedTaxRatio = instance.getTaxRatioById(105);
        assertTrue(updatedTaxRatio.getId() == 105);
        assertTrue(updatedTaxRatio.getLevel() == 5);
        assertTrue(updatedTaxRatio.getMinIncome() == 32);
        assertTrue(updatedTaxRatio.getMaxIncome() == 52);
        assertEquals("Trên 32 tr.VNĐ đến 52 tr.VNĐ", updatedTaxRatio.getDescription());
        assertTrue(updatedTaxRatio.getRatio() == 27);
    }

    @Test
    public void testAddTaxRatio() {
        System.out.println("addTaxRatio");
        TaxRatio taxRatio = new TaxRatio(108, 8, 100, 125,
                "Trên 100 tr.VNĐ đến 125 tr.VNĐ", 40);
        boolean result = instance.addTaxRatio(taxRatio);
        assertEquals(true, result);
        
        // check if database updated or not
        TaxRatio addedTaxRatio = instance.getTaxRatioByDescription(taxRatio.getDescription());
        assertTrue(addedTaxRatio.getLevel() == 8);
        assertTrue(addedTaxRatio.getMinIncome() == 100);
        assertTrue(addedTaxRatio.getMaxIncome() == 125);
        assertEquals("Trên 100 tr.VNĐ đến 125 tr.VNĐ", addedTaxRatio.getDescription());
        assertTrue(addedTaxRatio.getRatio() == 40);
    }

    @Test
    public void testDeleteTaxRatio() {
        System.out.println("deleteTaxRatio");
        int id = 103;
        boolean result = instance.deleteTaxRatio(id);
        assertEquals(true, result);
        
        // check if database updated or not
        TaxRatio taxRatio = instance.getTaxRatioById(103);
        assertTrue(taxRatio.getId() == 0);
        assertTrue(taxRatio.getLevel() == 0);
        assertTrue(taxRatio.getMinIncome() == 0);
        assertTrue(taxRatio.getMaxIncome() == 0);
        assertEquals(null, taxRatio.getDescription());
        assertTrue(taxRatio.getRatio() == 0);
    }
    
}

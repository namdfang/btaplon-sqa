/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Reduce;
import java.util.ArrayList;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author DELL
 */
public class ReduceDAOTest {

    ReduceDAO instance = new ReduceDAO();

    public ReduceDAOTest() {
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
    public void testGetListReduce() {
        System.out.println("getListReduce");
        ArrayList<Reduce> listReduce = instance.getListReduce();
        assertEquals(11, listReduce.size());
    }

    @Test
    public void testGetReduceAmountByKeyword() {
        System.out.println("getReduceAmountByKeyword");
        String keyword = "gtgcbt";
        double expResult = 9;
        double result = instance.getReduceAmountByKeyword(keyword);
        assertEquals(expResult, result, 0.0);
    }
    
    @Test
    public void testGetReduceAmountByKeyword2() {
        System.out.println("getReduceAmountByKeyword2");
        String keyword = "dummy";
        double expResult = 0;
        double result = instance.getReduceAmountByKeyword(keyword);
        assertEquals(expResult, result, 0.0);
    }

    @Test
    public void testGetReduceById() {
        System.out.println("getReduceById");
        int id = 201;
        Reduce reduce = instance.getReduceById(id);
        assertTrue(reduce.getName().equals("Giảm trừ gia cảnh: Bản thân"));
        assertTrue(reduce.getKeyword().equals("gtgcbt"));
        assertEquals(9, reduce.getAmount(), 0.0);
        assertTrue(reduce.getMeasure().equals("triệu VNĐ"));
    }
    
    @Test
    public void testGetReduceById2() {
        System.out.println("getReduceById2");
        int id = 0; // id not exist -> false
        Reduce reduce = instance.getReduceById(id);
        assertEquals(null, reduce.getName());
        assertEquals(null, reduce.getKeyword());
        assertEquals(null, reduce.getAmount());
        assertEquals(null, reduce.getMeasure());
    }
    
    @Test
    public void testGetReduceByKeyword() {
        System.out.println("getReduceByKeyword");
        String keyword = "gtgcbt";
        Reduce reduce = instance.getReduceByKeyword(keyword);
        assertTrue(reduce.getName().equals("Giảm trừ gia cảnh: Bản thân"));
        assertTrue(reduce.getKeyword().equals("gtgcbt"));
        assertEquals(9, reduce.getAmount(), 0.0);
        assertTrue(reduce.getMeasure().equals("triệu VNĐ"));
    }
    
    @Test
    public void testGetReduceByKeyword2() {
        System.out.println("getReduceByKeyword2");
        String keyword = "";
        Reduce reduce = instance.getReduceByKeyword(keyword);
        assertEquals(0, reduce.getId());
        assertEquals(null, reduce.getName());
        assertEquals(null, reduce.getKeyword());
        assertEquals(null, reduce.getAmount());
        assertEquals(null, reduce.getMeasure());
    }
    
    @Test
    public void testGetReduceByKeyword3() {
        System.out.println("getReduceByKeyword3");
        String keyword = "aaaa";
        Reduce reduce = instance.getReduceByKeyword(keyword);
        assertEquals(0, reduce.getId());
        assertEquals(null, reduce.getName());
        assertEquals(null, reduce.getKeyword());
        assertEquals(null, reduce.getAmount());
        assertEquals(null, reduce.getMeasure());
    }

    @Test
    public void testUpdateReduce() {
        System.out.println("updateReduce");
        Reduce reduce = new Reduce(201, "Giảm trừ gia cảnh: Bản thân",
                "gtgcbt", 11.0, "triệu VNĐ");
        boolean result = instance.updateReduce(reduce);
        assertEquals(true, result);
        
        // check if database updated or not
        Reduce updatedReduce = instance.getReduceById(201);
        assertEquals(updatedReduce.getName(), reduce.getName());
        assertEquals(updatedReduce.getKeyword(), reduce.getKeyword());
        assertEquals(updatedReduce.getMeasure(), reduce.getMeasure());
        assertEquals(updatedReduce.getAmount(), reduce.getAmount(), 0.0);
    }

    @Test
    public void testAddReduce() {
        System.out.println("addReduce");
        Reduce reduce = new Reduce();
        reduce.setName("Test Reduce");
        reduce.setKeyword("test");
        reduce.setAmount(5.5);
        reduce.setMeasure("triệu VNĐ");
        
        boolean result = instance.addReduce(reduce);
        assertEquals(true, result);
        
        // check if database updated or not
        Reduce addedReduce = instance.getReduceByKeyword(reduce.getKeyword());
        assertEquals(reduce.getName(), addedReduce.getName());
        assertEquals(reduce.getKeyword(), addedReduce.getKeyword());
        assertEquals(reduce.getAmount(), addedReduce.getAmount(), 0.0);
        assertEquals(reduce.getMeasure(), addedReduce.getMeasure());
    }

    @Test
    public void testDeleteReduce() {
        System.out.println("deleteReduce");
        int id = 205;
        boolean result = instance.deleteReduce(id);
        assertEquals(true, result);
        
        // check if database updated or not
        Reduce reduce = instance.getReduceById(205);
        assertEquals(null, reduce.getName());
        assertEquals(null, reduce.getKeyword());
        assertEquals(null, reduce.getAmount());
        assertEquals(null, reduce.getMeasure());
    }  
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilities;

import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class test {
    public static void main(String[] args) {
        Utility u = new Utility();
        
        ArrayList<Double> listTaxAmount = u.getListTaxAmountByLevels();
        
        for (int i = 0; i < listTaxAmount.size(); i++) {
            System.out.println(listTaxAmount.get(i));
        }
        
        System.out.println("-------CACULATE TAX------");
        System.out.println(u.caculateTax(250));
        System.out.println(u.caculateTax(4));
        
    }
   
}

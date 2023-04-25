/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author DELL
 */
public class Customer {

    private int id;
    private String name;
    private int age;
    private String sex; // nam, nữ, bd,...
    private String address;
    private String cmt; //chứng minh thư
    private String taxId; // mã số thuế
    private String email;
    private String sdt;
    private String gtgcbt; // giảm trừ gia cảnh: bản thân: true or false
    private int gtgcpt; // giảm trừ gia cảnh: số lượng người phụ thuộc
    private String gtbhbb; // giảm trừ bảo hiểm bắt buộc: true or false
    

    public Customer() {
    }

    public Customer(int id, String name, int age, String sex, String address, String cmt, String taxId, String email, String sdt, String gtgcbt, int gtgcpt, String gtbhbb) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.address = address;
        this.cmt = cmt;
        this.taxId = taxId;
        this.email = email;
        this.sdt = sdt;
        this.gtgcbt = gtgcbt;
        this.gtgcpt = gtgcpt;
        this.gtbhbb = gtbhbb;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCmt() {
        return cmt;
    }

    public void setCmt(String cmt) {
        this.cmt = cmt;
    }

    public String getTaxId() {
        return taxId;
    }

    public void setTaxId(String taxId) {
        this.taxId = taxId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getGtgcbt() {
        return gtgcbt;
    }

    public void setGtgcbt(String gtgcbt) {
        this.gtgcbt = gtgcbt;
    }

    public int getGtgcpt() {
        return gtgcpt;
    }

    public void setGtgcpt(int gtgcpt) {
        this.gtgcpt = gtgcpt;
    }

    public String getGtbhbb() {
        return gtbhbb;
    }

    public void setGtbhbb(String gtbhbb) {
        this.gtbhbb = gtbhbb;
    }



    
}

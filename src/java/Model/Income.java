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
public class Income {

    private int id;
    private Customer customer;
    private int month;
    private int year;
    private double salary;
    private double bonus;
    private double pcanuong; // phu cap an uong
    private double pcvpp; // phu cap van phong pham
    private double pcctp; // phu cap cong tac phi
    private double pctangca; // phu cap tang ca, lam them gio
    private double pcdochai; // phu cap lam viec trong mtrg doc hai
    private double pckcb; // phu cap kham chua benh hiem ngheo
    private double pcbhkbb; // phu cap bao hiem k bat buoc: bao hiem nhan tho,...
    private double tuthien; // cac khoan dong gop, tu thien.

    public Income() {
    }

    public Income(int id, Customer customer, int month, int year, double salary,
            double bonus, double pcanuong, double pcvpp, double pcctp, double pctangca,
            double pcdochai, double pckcb, double pcbhkbb, double tuthien) {
        this.id = id;
        this.customer = customer;
        this.month = month;
        this.year = year;
        this.salary = salary;
        this.bonus = bonus;
        this.pcanuong = pcanuong;
        this.pcvpp = pcvpp;
        this.pcctp = pcctp;
        this.pctangca = pctangca;
        this.pcdochai = pcdochai;
        this.pckcb = pckcb;
        this.pcbhkbb = pcbhkbb;
        this.tuthien = tuthien;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public double getPcanuong() {
        return pcanuong;
    }

    public void setPcanuong(double pcanuong) {
        this.pcanuong = pcanuong;
    }

    public double getPcvpp() {
        return pcvpp;
    }

    public void setPcvpp(double pcvpp) {
        this.pcvpp = pcvpp;
    }

    public double getPcctp() {
        return pcctp;
    }

    public void setPcctp(double pcctp) {
        this.pcctp = pcctp;
    }

    public double getPctangca() {
        return pctangca;
    }

    public void setPctangca(double pctangca) {
        this.pctangca = pctangca;
    }

    public double getPcdochai() {
        return pcdochai;
    }

    public void setPcdochai(double pcdochai) {
        this.pcdochai = pcdochai;
    }

    public double getPckcb() {
        return pckcb;
    }

    public void setPckcb(double pckcb) {
        this.pckcb = pckcb;
    }

    public double getPcbhkbb() {
        return pcbhkbb;
    }

    public void setPcbhkbb(double pcbhkbb) {
        this.pcbhkbb = pcbhkbb;
    }

    public double getTuthien() {
        return tuthien;
    }

    public void setTuthien(double tuthien) {
        this.tuthien = tuthien;
    }

}

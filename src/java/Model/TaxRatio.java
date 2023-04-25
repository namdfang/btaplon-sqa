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
public class TaxRatio {

    private int id;
    private int level;
    private double minIncome;
    private double maxIncome;
    private String description;
    private double ratio;

    public TaxRatio() {
    }

    public TaxRatio(int id, int level, double minIncome, double maxIncome, String description, double ratio) {
        this.id = id;
        this.level = level;
        this.minIncome = minIncome;
        this.maxIncome = maxIncome;
        this.description = description;
        this.ratio = ratio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public double getMinIncome() {
        return minIncome;
    }

    public void setMinIncome(double minIncome) {
        this.minIncome = minIncome;
    }

    public double getMaxIncome() {
        return maxIncome;
    }

    public void setMaxIncome(double maxIncome) {
        this.maxIncome = maxIncome;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getRatio() {
        return ratio;
    }

    public void setRatio(double ratio) {
        this.ratio = ratio;
    }
}

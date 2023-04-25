/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilities;

import DAO.IncomeDAO;
import DAO.ReduceDAO;
import DAO.TaxRatioDAO;
import Model.Income;
import Model.TaxRatio;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class Utility {

    TaxRatioDAO taxRatioDAO = new TaxRatioDAO();
    IncomeDAO incomeDAO = new IncomeDAO();
    ReduceDAO reduceDAO = new ReduceDAO();

    // get tổng thu nhập
    public double getTotalIncome(int incomeId) {
        double totalIncome = 0;
        Income income = incomeDAO.getIncomeById(incomeId);

        double salary = income.getSalary();
        double bonus = income.getBonus();
        double pcanuong = income.getPcanuong();
        double pcvpp = income.getPcvpp();
        double pcctp = income.getPcctp();
        double pctangca = income.getPctangca();
        double pcdochai = income.getPcdochai();
        double pckcb = income.getPckcb();
        double pcbhkbb = income.getPcbhkbb();
        double tuthien = income.getTuthien();
        totalIncome = salary + bonus + pcanuong + pcvpp
                + pcctp + pctangca + pcdochai + pckcb + pcbhkbb + tuthien;

        return (double) Math.round(totalIncome * 10000) / 10000;
    }

    // get level theo TNTT
    public int getTaxLevelByTNTT(double TNTT) {
        if (TNTT <= 0) {
            return 0;
        } else {
            TaxRatio taxRatio = taxRatioDAO.getTaxRatioByTNTT(TNTT);
            return taxRatio.getLevel();
        }
    }

    //get thuế suât theo level
    public double getTaxRatioByLevel(int level) {
        if (level <= 0) {
            return 0;
        } else {
            return taxRatioDAO.getTaxRatioByLevel(level).getRatio();
        }
    }

    // get chi tiết giảm trừ
    public ReduceDetail getReduceDetail(Income income) {
        // cac khoan giam tru 
        double gtgcbt = 0, gtgcpt = 0, gtbhbb = 0;

        gtgcbt = reduceDAO.getReduceAmountByKeyword("gtgcbt"); // gtgc ban than: 9tr (11tr)

        gtgcpt = income.getCustomer().getGtgcpt()
                * reduceDAO.getReduceAmountByKeyword("gtgcpt"); // vd: 2ng x 3.6 = 7.2tr

        double reduceBH = reduceDAO.getReduceAmountByKeyword("gtbhbb");
        gtbhbb = reduceBH / 100 * income.getSalary(); // gtbbb: 10.5% luong

        // cac khoan phu cap duoc giam tru
        double pcanuong = 0;// phu cap an uong: giảm max 0.73tr
        if (income.getPcanuong() <= reduceDAO.getReduceAmountByKeyword("pcanuong")) {
            pcanuong = income.getPcanuong();
        } else {
            pcanuong = reduceDAO.getReduceAmountByKeyword("pcanuong");
        }

        double pcvpp = 0; // phu cap van phong pham: giảm max 0.083333tr
        if (income.getPcvpp() <= reduceDAO.getReduceAmountByKeyword("pcvpp")) {
            pcvpp = income.getPcvpp();
        } else {
            pcvpp = reduceDAO.getReduceAmountByKeyword("pcvpp");
        }

        double pcctp = reduceDAO.getReduceAmountByKeyword("pcctp") / 100
                * income.getPcctp(); // phụ cấp công tác phí: giảm 100%
        double pctangca = reduceDAO.getReduceAmountByKeyword("pctangca") / 100
                * income.getPctangca(); // phụ cấp tăng ca: giảm 100%
        double pcdochai = reduceDAO.getReduceAmountByKeyword("pcdochai") / 100
                * income.getPcdochai(); // phụ cấp làm viec trong mt độc hại: giảm 100%
        double pckcb = reduceDAO.getReduceAmountByKeyword("pckcb") / 100
                * income.getPckcb(); // phụ cấp khám chữa bệnh: giảm 100%
        double pcbhkbb = reduceDAO.getReduceAmountByKeyword("pcbhkbb") / 100
                * income.getPcbhkbb(); // phụ cấp bảo hiểm ko bắt buộc: giảm 100%
        double tuthien = reduceDAO.getReduceAmountByKeyword("tuthien") / 100
                * income.getTuthien(); // phụ cấp từ thiện: giảm 100%

        ReduceDetail rd = new ReduceDetail(gtgcbt, gtgcpt, gtbhbb, pcanuong,
                pcvpp, pcctp, pctangca, pcdochai, pckcb, pcbhkbb, tuthien);
        return rd;
    }

    //get Tax Amount by level: get số tiền thuế phải nộp theo các level
    public ArrayList<Double> getListTaxAmountByLevels() {
        ArrayList<Double> listTaxAmount = new ArrayList<>();
        double taxAmount = 0;
        for (int i = 0; i < taxRatioDAO.getListTaxRatio().size() + 1; i++) {
            TaxRatio taxRatio = taxRatioDAO.getTaxRatioByLevel(i + 1);
            taxAmount = (taxRatio.getMaxIncome() - taxRatio.getMinIncome()) * taxRatio.getRatio() / 100;
            listTaxAmount.add(taxAmount);
        }
        return listTaxAmount;
    }

    // tính tổng thuế các level thấp hơn phải nộp
    public double caculateLowerLevelTaxAmount(int level) {
        double taxAmountLowerLevel = 0; // tính thuế của các level trc
        if (level <= 0) {
            return 0;
        } else {
            ArrayList<Double> listTaxAmount = getListTaxAmountByLevels();
            for (int i = 0; i < level - 1; i++) {
                taxAmountLowerLevel += listTaxAmount.get(i);
            }
            return taxAmountLowerLevel;
        }
    }

    // caculate Total Tax Amount
    public double caculateTax(double TNTT) {
        double result = 0;

        if (TNTT <= 0) {
            return 0;
        } else {
            int level = getTaxLevelByTNTT(TNTT);
            TaxRatio taxRatio = taxRatioDAO.getTaxRatioByLevel(level);
            if (level == 1) {
                result = taxRatio.getRatio() / 100 * TNTT;
            } else {
                double taxAmountLowerLevel = caculateLowerLevelTaxAmount(level);
                result = (TNTT - taxRatio.getMinIncome()) * (taxRatio.getRatio() / 100) + taxAmountLowerLevel;
            }
            return (double) Math.round(result * 10000) / 10000;
        }
    }

    public boolean checkOnlyDigitCharacter(String s) {
        return s.matches("[0-9]+") && s.length() > 2;
    }

}

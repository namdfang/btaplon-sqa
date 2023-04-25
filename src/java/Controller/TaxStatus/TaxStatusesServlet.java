/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.TaxStatus;

import DAO.TaxStatusDAO;
import Model.TaxStatus;
import Utilities.ReduceDetail;
import Utilities.Utility;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author DELL
 */
@WebServlet(name = "TaxStatusesServlet", urlPatterns = {"/taxStatuses"})
public class TaxStatusesServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int year = Integer.parseInt(request.getParameter("year"));
        int month = Integer.parseInt(request.getParameter("month"));

        String url = "/tax-statuses.jsp";
        TaxStatusDAO taxStatusDAO = new TaxStatusDAO();
        //TaxRatioDAO taxRatioDAO = new TaxRatioDAO();
        Utility utility = new Utility();

        ArrayList<TaxStatus> listTaxStatus = taxStatusDAO.getTaxStatusByTime(month, year);

        for (TaxStatus ts : listTaxStatus) {
            //TaxStatus taxStatus = taxStatusDAO.getTaxStatusById(ts.getId());      
            double totalIncome = (double) Math.round(utility.getTotalIncome(ts.getIncome().getId()) * 10000) / 10000;

            // tinh cac khoan giam tru
            ReduceDetail rd = utility.getReduceDetail(ts.getIncome());
            double reduces = rd.getGtgcbt() + rd.getGtgcpt() + rd.getGtbhbb()
                    + rd.getPcanuong() + rd.getPcvpp() + rd.getPcctp() + rd.getPctangca()
                    + rd.getPcdochai() + rd.getPckcb() + rd.getPcbhkbb() + rd.getTuthien();
            double totalReduce = (double) Math.round(reduces * 10000) / 10000; // lam tron 4 con so

            // Tinh so tien thue:
            double TNTT = totalIncome - totalReduce;
            double taxAmount = utility.caculateTax(TNTT);
            ts.setTaxAmount(taxAmount);
            
            // nếu chưa nộp thì mới update tiền thuế
            if (!ts.getStatus().equals("Đã nộp")) {
                taxStatusDAO.updateTaxStatus(ts);
            }
        }

        request.setAttribute("year", year);
        request.setAttribute("month", month);
        request.setAttribute("listTaxStatus", listTaxStatus);
        RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
        rd.forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}

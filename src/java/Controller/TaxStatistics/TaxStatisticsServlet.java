/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.TaxStatistics;

import DAO.TaxStatusDAO;
import Model.TaxStatus;
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
@WebServlet(name = "TaxStatisticServlet", urlPatterns = {"/taxStatistics"})
public class TaxStatisticsServlet extends HttpServlet {

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

        String url = "/tax-statistics.jsp";
        TaxStatusDAO taxStatusDAO = new TaxStatusDAO();
        ArrayList<TaxStatus> listTaxStatus = taxStatusDAO.getTaxStatusByTime(month, year);

        int numberPaid = 0, numberUnpaid = 0; // số người nộp & chưa nộp
        double totalTaxAmount = 0; // Tổng số tiền thuế phải thu
        double totalPaidAmount = 0, totalUnpaidAmount = 0; // tổng số tiền đã nộp & chưa nộp

        for (TaxStatus ts : listTaxStatus) {
            totalTaxAmount += ts.getTaxAmount();
            if (ts.getStatus().equals("Đã nộp")) {
                numberPaid++;
                totalPaidAmount += ts.getTaxAmount();
            } else if (ts.getStatus().equals("Chưa nộp")) {
                numberUnpaid++;
                totalUnpaidAmount += ts.getTaxAmount();
            }
        }

        request.setAttribute("year", year);
        request.setAttribute("month", month);
        request.setAttribute("numberPaid", numberPaid);
        request.setAttribute("numberUnpaid", numberUnpaid);
        request.setAttribute("totalTaxAmount", (double) Math.round(totalTaxAmount * 10000) / 10000); // lam tron 4 con so
        request.setAttribute("totalPaidAmount", (double) Math.round(totalPaidAmount * 10000) / 10000);
        request.setAttribute("totalUnpaidAmount", (double) Math.round(totalUnpaidAmount * 10000) / 10000);

        RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
        rd.forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}

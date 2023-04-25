/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.TaxStatus;

import DAO.TaxRatioDAO;
import DAO.TaxStatusDAO;
import Model.TaxStatus;
import Utilities.ReduceDetail;
import Utilities.Utility;
import java.io.IOException;
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
@WebServlet(name = "TaxStatusDetailServlet", urlPatterns = {"/taxStatusDetail"})
public class TaxStatusDetailServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));

        String url = "/tax-status-detail.jsp";

        TaxStatusDAO taxStatusDAO = new TaxStatusDAO();
        TaxRatioDAO taxRatioDAO = new TaxRatioDAO();
        TaxStatus taxStatus = taxStatusDAO.getTaxStatusById(id);

        Utility utility = new Utility();
        double totalIncome = (double) Math.round(utility.getTotalIncome(taxStatus.getIncome().getId()) * 10000) / 10000;
        
        // tinh cac khoan giam tru
        ReduceDetail rd = utility.getReduceDetail(taxStatus.getIncome());
        double reduces = rd.getGtgcbt() + rd.getGtgcpt() + rd.getGtbhbb()
                + rd.getPcanuong() + rd.getPcvpp() + rd.getPcctp() + rd.getPctangca()
                + rd.getPcdochai() + rd.getPckcb() + rd.getPcbhkbb() + rd.getTuthien();
        double totalReduce = (double) Math.round(reduces * 10000) / 10000; // lam tron 4 con so

        // Tinh so tien thue:
        double TNTT = totalIncome - totalReduce;
        // get level by TNTT
        int level = utility.getTaxLevelByTNTT(TNTT);
        
        // caculate tax
        double taxAmount = utility.caculateTax(TNTT);
        
        request.setAttribute("taxStatus", taxStatus);
        request.setAttribute("totalIncome", totalIncome);
        request.setAttribute("totalReduce", totalReduce);
        
        request.setAttribute("taxRatio", utility.getTaxRatioByLevel(level));
        request.setAttribute("totalLowerLevelTaxAmount", utility.caculateLowerLevelTaxAmount(level));
        request.setAttribute("minIncomeOfLevel", taxRatioDAO.getTaxRatioByLevel(level).getMinIncome());
        
        request.setAttribute("TNTT", (double) Math.round(TNTT * 10000) / 10000);
        request.setAttribute("level", level);
        request.setAttribute("taxAmount", taxAmount);

        request.setAttribute("gtgcbt", rd.getGtgcbt());
        request.setAttribute("gtgcpt", rd.getGtgcpt());
        request.setAttribute("gtbhbb", rd.getGtbhbb());

        request.setAttribute("pcanuong", rd.getPcanuong());
        request.setAttribute("pcvpp", rd.getPcvpp());
        request.setAttribute("pcctp", rd.getPcctp());
        request.setAttribute("pctangca", rd.getPctangca());
        request.setAttribute("pcdochai", rd.getPcdochai());
        request.setAttribute("pckcb", rd.getPckcb());
        request.setAttribute("pcbhkbb", rd.getPcbhkbb());
        request.setAttribute("tuthien", rd.getTuthien());

        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher(url);
        requestDispatcher.forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}

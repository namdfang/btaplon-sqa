/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.TaxRatio;

import DAO.TaxRatioDAO;
import Model.TaxRatio;
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
@WebServlet(name = "TaxRatiosServlet", urlPatterns = {"/taxRatios"})
public class TaxRatiosServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String url = "/tax-ratios.jsp";
        TaxRatioDAO taxRatioDAO = new TaxRatioDAO();
        ArrayList<TaxRatio> listTaxRatio = taxRatioDAO.getListTaxRatio();
        
        Utility utility = new Utility();
        
        //request.setAttribute("totalLowerLevelTaxAmount", utility.caculateLowerLevelTaxAmount(level));
        request.setAttribute("listTaxRatio", listTaxRatio);
        RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
        rd.forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}

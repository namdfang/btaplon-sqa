/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.TaxRatio;

import DAO.TaxRatioDAO;
import Model.TaxRatio;
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
@WebServlet(name = "AddTaxRatioServlet", urlPatterns = {"/addTaxRatio"})
public class AddTaxRatioServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        String LEVEL = request.getParameter("level");
        String MIN_INCOME = request.getParameter("minIncome");
        String MAX_INCOME = request.getParameter("maxIncome");
        String DESCRIPTION = request.getParameter("description");
        String RATIO = request.getParameter("ratio");

        String add = request.getParameter("add");
        String cancel = request.getParameter("cancel");

        String url = "";
        String error = "";

        TaxRatioDAO taxRatioDAO = new TaxRatioDAO();

        if (add != null) {
            if (LEVEL.equals("") || MIN_INCOME.equals("") || MAX_INCOME.equals("")
                    || DESCRIPTION.equals("") || RATIO.equals("")) {
                error = "PHẢI NHẬP ĐỦ CÁC TRƯỜNG!";
                url = "/add-tax-ratio.jsp";
                request.setAttribute("error", error);
                request.setAttribute("level", LEVEL);
                request.setAttribute("minIncome", MIN_INCOME);
                request.setAttribute("maxIncome", MAX_INCOME);
                request.setAttribute("description", DESCRIPTION);
                request.setAttribute("ratio", RATIO);
            } else {
                int level = Integer.parseInt(LEVEL);
                double minIncome = Double.parseDouble(MIN_INCOME);
                double maxIncome = Double.parseDouble(MAX_INCOME);
                double ratio = Double.parseDouble(RATIO);

                if (level <= 0 || minIncome <= 0 || maxIncome <= 0 || maxIncome <= minIncome || ratio <= 0) {
                    error = "MỘT SỐ GIÁ TRỊ KHÔNG HỢP LỆ!";
                    url = "/add-tax-ratio.jsp";
                    request.setAttribute("error", error);
                    request.setAttribute("level", LEVEL);
                    request.setAttribute("minIncome", MIN_INCOME);
                    request.setAttribute("maxIncome", MAX_INCOME);
                    request.setAttribute("description", DESCRIPTION);
                    request.setAttribute("ratio", RATIO);
                } else {
                    url = "/taxRatios";
                    TaxRatio taxRatio = new TaxRatio();
                    taxRatio.setLevel(level);
                    taxRatio.setMinIncome(minIncome);
                    taxRatio.setMaxIncome(maxIncome);
                    taxRatio.setDescription(DESCRIPTION);
                    taxRatio.setRatio(ratio);
                    taxRatioDAO.addTaxRatio(taxRatio);
                }

            }
        } else if (cancel != null) {
            url = "/taxRatios";
        }

        RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
        rd.forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}

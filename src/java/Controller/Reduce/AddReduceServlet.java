/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.Reduce;

import DAO.ReduceDAO;
import Model.Reduce;
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
@WebServlet(name = "AddReduceServlet", urlPatterns = {"/addReduce"})
public class AddReduceServlet extends HttpServlet {

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

        String name = request.getParameter("name");
        String amount = request.getParameter("amount"); // amount: double 
        String keyword = request.getParameter("keyword");
        String measure = request.getParameter("measure");

        String add = request.getParameter("add");
        String cancel = request.getParameter("cancel");

        String url = "";
        String error = "";

        ReduceDAO reduceDAO = new ReduceDAO();

        if (add != null) {
            if (amount.equals("") || name.equals("") || keyword.equals("") || measure.equals("")) {
                error = "PHẢI NHẬP ĐỦ CÁC TRƯỜNG!";
                url = "/add-reduce.jsp";
                request.setAttribute("error", error);
                request.setAttribute("name", name);
                request.setAttribute("amount", amount);
                request.setAttribute("keyword", keyword);
                request.setAttribute("measure", measure);
            } else {
                double AMOUNT = Double.parseDouble(amount);
                if (AMOUNT <= 0) {
                    error = "GIÁ TRỊ PHẢI LỚN HƠN 0!";
                    url = "/add-reduce.jsp";
                    request.setAttribute("error", error);
                    request.setAttribute("name", name);
                    request.setAttribute("amount", amount);
                    request.setAttribute("keyword", keyword);
                    request.setAttribute("measure", measure);
                } else {
                    url = "/reduces";
                    Reduce reduce = new Reduce();
                    reduce.setName(name);
                    reduce.setKeyword(keyword);
                    reduce.setAmount(AMOUNT);
                    reduce.setMeasure(measure);
                    reduceDAO.addReduce(reduce);
                }

            }
        } else if (cancel != null) {
            url = "/reduces";
        }

        RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
        rd.forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}

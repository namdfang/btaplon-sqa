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
@WebServlet(name = "EditReduceManagerServlet", urlPatterns = {"/editReduceManager"})
public class EditReduceManagerServlet extends HttpServlet {

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

        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String amount = request.getParameter("amount");
        String keyword = request.getParameter("keyword");
        String measure = request.getParameter("measure");

        String edit = request.getParameter("edit");
        String cancel = request.getParameter("cancel");

        String url = "";
        String error = "";

        ReduceDAO reduceDAO = new ReduceDAO();

        if (edit != null) {
            if (amount.equals("") || name.equals("") || keyword.equals("") || measure.equals("")) {
                error = "PHẢI NHẬP ĐỦ CÁC TRƯỜNG!";
                url = "/editReduce?id=" + id;
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
                    Reduce reduce = new Reduce(id, name, keyword, AMOUNT, measure);
                    reduceDAO.updateReduce(reduce);
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

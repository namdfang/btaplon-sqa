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
@WebServlet(name = "EditReduceServlet", urlPatterns = {"/editReduce"})
public class EditReduceServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String id = request.getParameter("id");
        
        ReduceDAO reduceDAO = new ReduceDAO();
        Reduce reduce = reduceDAO.getReduceById(Integer.parseInt(id));
        
        String url = "/edit-reduce.jsp";
        
        request.setAttribute("reduce", reduce);
        RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
        rd.forward(request, response);
    }
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }
}

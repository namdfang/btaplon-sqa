/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.UserDAO;
import Model.User;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author DELL
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        String url = "/";
        String error = "";
        
        System.out.println("username"+ username);
        System.out.println("password"+ password);
        
        UserDAO userDAO = new UserDAO();
        User user = userDAO.getUserByUsername(username, password);

        if (user.getId() == 0) {
            error = "Tên đăng nhập hoặc mật khẩu không đúng!";
            url = "/login.jsp";
            request.setAttribute("error", error);
            request.setAttribute("username", username);
            request.setAttribute("password", password);
            RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
            rd.forward(request, response);
        } else {
            error = "";
            Cookie loginCookie = new Cookie("username", user.getUsername());
            //setting cookie to expire after 12 hours.
            loginCookie.setMaxAge(60*60*12);
            response.addCookie(loginCookie);
            response.sendRedirect("/Tax-Management/index.jsp");          
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}

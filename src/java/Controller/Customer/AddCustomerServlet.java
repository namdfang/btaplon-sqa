/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.Customer;

import DAO.CustomerDAO;
import Model.Customer;
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
@WebServlet(name = "AddCustomerServlet", urlPatterns = {"/addCustomer"})
public class AddCustomerServlet extends HttpServlet {

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
        String age = request.getParameter("age"); // age: int
        String sex = request.getParameter("sex");
        String address = request.getParameter("address");
        String cmt = request.getParameter("cmt");
        String taxId = request.getParameter("taxId");
        String email = request.getParameter("email");
        String sdt = request.getParameter("sdt");
        String gtgcbt = request.getParameter("gtgcbt");
        String gtgcpt = request.getParameter("gtgcpt"); // gtgtpt: int
        String bhbb = request.getParameter("bhbb");

        String add = request.getParameter("add");
        String cancel = request.getParameter("cancel");

        String url = "";
        String error = "";

        CustomerDAO customerDAO = new CustomerDAO();
        Utility u = new Utility();

        if (add != null) {
            if (age.equals("") || name.equals("") || sex.equals("") || cmt.equals("")
                    || taxId.equals("")||email.equals("") || sdt.equals("") || gtgcbt.equals("") || gtgcpt.equals("") || bhbb.equals("")) {
                error = "PHẢI NHẬP ĐỦ CÁC TRƯỜNG!";
                url = "/add-customer.jsp";
                request.setAttribute("error", error);
                request.setAttribute("name", name);
                request.setAttribute("age", age);
                request.setAttribute("address", address);
                request.setAttribute("cmt", cmt);
                request.setAttribute("taxId", taxId);
                request.setAttribute("email", email);
                request.setAttribute("sdt", sdt);
                request.setAttribute("gtgcpt", gtgcbt);
            } else {
                int AGE = Integer.parseInt(age);
                int GTGCPT = Integer.parseInt(age);

                if (AGE< 18 || GTGCPT < 0 || !u.checkOnlyDigitCharacter(cmt)
                        || !u.checkOnlyDigitCharacter(taxId)) {
                    error = "MỘT SỐ GIÁ TRỊ KHÔNG HỢP LỆ!";
                    url = "/add-customer.jsp";
                    request.setAttribute("error", error);
                    request.setAttribute("name", name);
                    request.setAttribute("age", age);
                    request.setAttribute("address", address);
                    request.setAttribute("cmt", cmt);
                    request.setAttribute("taxId", taxId);
                    request.setAttribute("email", email);
                    request.setAttribute("sdt", sdt);
                    request.setAttribute("gtgcpt", gtgcpt);
                } else {
                    url = "/customers";
                    int TAXID = Integer.parseInt(taxId);
                    int TAXID2 = TAXID + 1;
                    int count = customerDAO.rowCount();
//                    String taxId2 = Integer.toString(TAXID2);
                    String taxId2 = Integer.toString(count+1111);
                    Customer customer = new Customer();
                    customer.setName(name);
                    customer.setAge(AGE);
                    customer.setSex(sex);
                    customer.setAddress(address);
                    customer.setCmt(cmt);
                    customer.setTaxId(taxId2);
                    customer.setGtgcbt(email);
                    customer.setGtgcbt(sdt);
                    customer.setGtgcbt(gtgcbt);
                    customer.setGtgcpt(GTGCPT);
                    customer.setGtbhbb(bhbb);
                    customerDAO.addCustomer(customer);
                }
            }
        } else if (cancel != null) {
            url = "/customers";
        }

        RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
        rd.forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}

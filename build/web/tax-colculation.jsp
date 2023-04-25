<%-- 
    Document   : tax-colculation
    Created on : Apr 24, 2023, 9:37:10 PM
    Author     : NVM-LT
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Trang chủ</title>
        <!-- Meta tags -->
        <meta name="viewport" content="width=device-width, initial-scale=1" />
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <!-- Meta tags -->
        <!-- font-awesome icons -->
        <link href="assets/libs/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css"/>
        <!--stylesheets-->
        <link href="assets/libs/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="assets/css/style.css" rel="stylesheet" type="text/css"/>
        <link href="assets/css/sb_admin_styles.css" rel="stylesheet" type="text/css"/>
        <link href="assets/css/custom.css" rel="stylesheet" type="text/css"/>
        <link href="assets/css/tinhthue.css" rel="stylesheet" type="text/css"/>
        <!--//style sheet end here-->
        <link href="//fonts.googleapis.com/css?family=Montserrat:300,400,500,600" rel="stylesheet">
        <link href="//fonts.googleapis.com/css?family=Open+Sans:400,600,700" rel="stylesheet">
        <!--js-->
        <link href="https://cdn.datatables.net/1.10.20/css/dataTables.bootstrap4.min.css" rel="stylesheet" crossorigin="anonymous" />
    </head>
    <body>
        <%

            //
            String username = null;
            Cookie[] cookies = request.getCookies();
            if (cookies != null) {
                for (Cookie cookie : cookies) {
                    if (cookie.getName().equals("username")) {
                        username = cookie.getValue();
                    }
                }
            }

            if (username != null) {
        %>
        <c:import url="/shared/navigation-top.jsp" />
        <div id="layoutSidenav">
            <c:import url="/shared/navigation-left.jsp" />
            <div id="layoutSidenav_content">
                <main>
                    <h3 style="margin: 20px; text-align: center;">TÍNH THUẾ THU NHẬP CÁ NHÂN</h3>
                    <div class="left-column">
                        <h4>Tính Thuế</h4>
                        <div class="container">
                            
                                <label for="income">Thu nhập hàng tháng (VNĐ):</label>
                                <input type="number" id="income">
<!--                                <label for="sub">Tổng các khoản giảm trừ (VNĐ):</label>
                                <input type="number" id="sub">-->
                                <label for="dependents">Số người phụ thuộc:</label>
                                <input type="number" id="dependents">
                                
                                <button type="button" onclick="calculate()">Tính thuế</button><br>
                                <label style="text-align: right">Thuế phải nộp:</label>
                                <label id="tax" style="text-align: right"></label>
                                <div style="text-align: right; display: flex; justify-content: right">
                                    <button id="income-tax-button" style="width: 150px;" disabled>
                                        <a href="/Tax-Management/income-tax.jsp" style="color: white">Đóng thuế</a>
                                    </button>
                                </div>
                               
                            
                        </div>
                        <script>
                            function calculate() {
                                let income = document.getElementById("income").value - 11000000 ;
                                let dependents = document.getElementById("dependents").value;
                                let tax = 0;
                                income -= dependents*4400000;
                                if (income <= 5000000) {
                                    tax = income * 0.05;
                                } else if (income > 5000000 && income <= 10000000) {
                                    tax = 250000 + (income - 5000000) * 0.1;
                                } else if (income > 10000000 && income <= 18000000) {
                                    tax = 750000 + (income - 10000000) * 0.15;
                                } else if (income > 18000000 && income <= 32000000) {
                                    tax = 1950000 + (income - 18000000) * 0.2;
                                } else if (income > 32000000 && income <= 52000000) {
                                    tax = 4750000 + (income - 32000000) * 0.25;
                                } else if (income > 52000000 && income <= 80000000) {
                                    tax = 9750000 + (income - 52000000) * 0.3;
                                } else {
                                    tax = 18150000 + (income - 80000000) * 0.35;
                                }
                                
                                tax = tax < 0 ? 0 : tax;
                                document.getElementById("tax").textContent = tax.toLocaleString();
                                document.getElementById("income-tax-button").disabled = true;
                            }
                        </script>
                    </div>
                    <div class="right-column">
                        <h4>Chú Thích</h4>
                        <label>Thuế TNCN phải nộp =  Thu nhập tính thuế X Thuế suất</label><br>
                        <label>Thu nhập tính thuế = Thu nhập chịu thuế - Các khoản giảm trừ</label><br>
                        <table>
                            <thead>
                                <tr>
                                    <th>Mức thu nhập</th>
                                    <th>Thuế suất</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <td>Dưới 5 triệu đồng</td>
                                    <td>5%</td>
                                </tr>
                                <tr>
                                    <td>Từ 5 triệu đến dưới 10 triệu đồng</td>
                                    <td>10%</td>
                                </tr>
                                <tr>
                                    <td>Từ 10 triệu đến dưới 18 triệu đồng</td>
                                    <td>15%</td>
                                </tr>
                                <tr>
                                    <td>Từ 18 triệu đến dưới 32 triệu đồng</td>
                                    <td>20%</td>
                                </tr>
                                <tr>
                                    <td>Từ 32 triệu đến dưới 52 triệu đồng</td>
                                    <td>25%</td>
                                </tr>
                                <tr>
                                    <td>Từ 52 triệu đến dưới 80 triệu đồng</td>
                                    <td>30%</td>
                                </tr>
                                <tr>
                                    <td>Trên 80 triệu đồng</td>
                                    <td>35%</td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                    <div class="clear"></div>
                </main>
                <c:import url="/shared/footer.jsp" />
            </div>
        </div>
        <%
        } else {
        %> 
        <c:import url="/login.jsp" />
        <% }%>

        <script src="assets/jquery/jquery.min.js" type="text/javascript"></script>
        <script src="assets/jquery/scripts.js" type="text/javascript"></script>
        <script src="assets/jquery/datatables-demo.js" type="text/javascript"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
        <script src="https://cdn.datatables.net/1.10.20/js/jquery.dataTables.min.js" crossorigin="anonymous"></script>
        <script src="https://cdn.datatables.net/1.10.20/js/dataTables.bootstrap4.min.js" crossorigin="anonymous"></script>
    </body>
</html>
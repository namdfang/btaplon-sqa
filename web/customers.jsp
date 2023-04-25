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
        <!--//style sheet end here-->
        <link href="//fonts.googleapis.com/css?family=Montserrat:300,400,500,600" rel="stylesheet">
        <link href="//fonts.googleapis.com/css?family=Open+Sans:400,600,700" rel="stylesheet">
        <!--js-->
        <link href="https://cdn.datatables.net/1.10.20/css/dataTables.bootstrap4.min.css" rel="stylesheet" crossorigin="anonymous" />
    </head>
    <body>
        <%
            int stt = 1;
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
                    <div class="card mb-4">
                        <div class="card-header"><i class="fa fa-table mr-1"></i>Thông tin người nộp thuế</div>
                        <div class="card-header">
                            <i>*Chú thích:<br />
                              -BT: Giảm trừ gia cảnh: Bản thân. <br />
                              -PT: Giảm trừ gia cảnh: Số người phụ thuộc. <br />
                              -BHBB: Bảo hiểm bắt buôc. </i>
                        </div>
                        <div class="card-body">
                            <a class="btn btn-primary"
                               href="/Tax-Management/add-customer.jsp"
                               style="margin-bottom: 20px"><i class="fa fa-plus"></i> Đăng ký mới</a>
                            <div class="table-responsive">
                                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                    <thead class="thead-light">
                                        <tr>
                                            <th>STT</th>
                                            <th>ID</th>
                                            <th>Tên</th>
                                            <th>Tuổi</th>
                                            <th>Giới tính</th>
                                            <th>Địa chỉ</th>
                                            <th>CMTND</th>
<!--                                            <th>Mã số thuế</th>-->
                                            <th>Mã số thuế</th>
                                            <th>Email</th>
                                            <th>SDT</th>
                                            <th>BT</th>
                                            <th>PT</th>
                                            <th>BHBB</th>
                                            <th>Chỉnh sửa</th>
                                            <th>Xóa</th>
                                        </tr>
                                    </thead>
                                    <tbody>                    
                                        <c:forEach items="${listCustomer}" var="customer">
                                            <tr>
                                                <td><%= stt++%></td>
                                                <td>${customer.id}</td>
                                                <td>${customer.name}</td>
                                                <td>${customer.age}</td>
                                                <td>${customer.sex}</td>
                                                <td>${customer.address}</td>
                                                <td>${customer.cmt}</td>
                                                <td>${customer.taxId}</td>  
                                                <td>${customer.email}</td> 
                                                <td>${customer.sdt}</td> 
                                                <td>${customer.gtgcbt}</td>
                                                <td>${customer.gtgcpt}</td>
                                                <td>${customer.gtbhbb}</td>
                                                <td><a class="btn btn-success" href="editCustomer?id=${customer.id}"><i class="fa fa-edit"></i> Chỉnh sửa</a></td>
                                                <td><a class="btn btn-danger" href="deleteCustomer?id=${customer.id}"><i class="fa fa-trash"></i> Xóa</a></td>
                                            </tr>
                                        </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
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


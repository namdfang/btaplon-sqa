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
            int [] months = {1,2,3,4,5,6,7,8,9,10,11,12};
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
                    <h3 style="margin: 20px; text-align: center;">XEM TÌNH HÌNH NỘP THUẾ</h3>
                    <form action="taxStatuses" method="post">            
                        <div class="form-group row" style="margin:10px 100px">
                            <label class="col-sm-3 col-form-label">Năm:</label>
                            <div class="col-sm-9">
                                <input type="number" min="2000" max="2020" name="year" value="2020" class="form-control">
                            </div>
                        </div>
                        <div class="form-group row" style="margin:10px 100px">
                            <label class="col-sm-3 col-form-label">Tháng:</label>
                            <div class="col-sm-9">
                                <select class="form-control" name="month">
                                    <c:forEach items="<%= months%>" var="month">
                                        <option value="${month}">${month}</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>

                        <div style="margin:20px 330px">
                            <input class="btn btn-primary" type="submit" value="Xem" name="edit">
<!--                            <input class="btn btn-danger" type="submit" value="Hủy" name="cancel">-->
                        </div>

                    </form>
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

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
                    <h3 style="margin: 20px; text-align: center;">ĐĂNG KÝ THÔNG TIN NGƯỜI NỘP THUẾ</h3>
                    <form action="addCustomer" method="post">
                        <div style="text-align: center; color: red">${error}</div>
                        <div class="form-group row" style="margin:50px 100px 10px 100px">
                            <label class="col-sm-3 col-form-label">Họ tên:</label>
                            <div class="col-sm-9">
                                <input type="text" name="name" value="${name}" class="form-control">
                            </div>
                        </div>
                        <div class="form-group row" style="margin:10px 100px">
                            <label class="col-sm-3 col-form-label">Tuổi:</label>
                            <div class="col-sm-9">
                                <input type="number" name="age" value="${age}" class="form-control">
                            </div>
                        </div>
                        <div class="form-group row" style="margin:10px 100px">
                            <label class="col-sm-3 col-form-label">Giới tính:</label>
                            <div class="col-sm-9">
                                <select class="form-control" name="sex">
                                    <option value="Nam">Nam</option>
                                    <option value="Nữ">Nữ</option>
                                    
                                </select>
                            </div>
                        </div>
                        <div class="form-group row" style="margin:10px 100px">
                            <label class="col-sm-3 col-form-label">Địa chỉ:</label>
                            <div class="col-sm-9">
                                <input type="text" name="address" value="${address}" class="form-control">
                            </div>
                        </div>
                        <div class="form-group row" style="margin:10px 100px">
                            <label class="col-sm-3 col-form-label">CCCD:</label>
                            <div class="col-sm-9">
                                <input type="text" name="cmt" value="${cmt}" class="form-control">
                            </div>
                        </div>
                        <div class="form-group row" style="margin:10px 100px">
                            <label class="col-sm-3 col-form-label">Nơi cấp:</label>
                            <div class="col-sm-9">
                                <input type="text" name="taxId" value="${taxId}" class="form-control">
                            </div>
                        </div>
                            <div class="form-group row" style="margin:10px 100px">
                            <label class="col-sm-3 col-form-label">Email:</label>
                            <div class="col-sm-9">
                                <input type="text" name="email" value="${Email}" class="form-control">
                            </div>
                        </div>
                            <div class="form-group row" style="margin:10px 100px">
                            <label class="col-sm-3 col-form-label">SDT:</label>
                            <div class="col-sm-9">
                                <input type="text" name="sdt" value="${SDT}" class="form-control">
                            </div>
                        </div>
                        <div class="form-group row" style="margin:10px 100px">
                            <label class="col-sm-3 col-form-label">GTGC-Bản thân:</label>
                            <div class="col-sm-9">
                                <select class="form-control" name="gtgcbt">
                                    <option value="Có">Có</option>
                                    <option value="Không">Không</option>
                                    <!--<option value="Không">Không</option>-->
                                </select>
                            </div>
                        </div>
                        <div class="form-group row" style="margin:10px 100px">
                            <label class="col-sm-3 col-form-label">Số lượng người phụ thuộc:</label>
                            <div class="col-sm-9">
                                <input type="number" name="gtgcpt" value="${gtgcpt}" class="form-control">
                            </div>
                        </div>
                        <div class="form-group row" style="margin:10px 100px">
                            <label class="col-sm-3 col-form-label">Bảo hiểm bắt buộc</label>
                            <div class="col-sm-9">
                                <select class="form-control" name="bhbb">
                                    <option name="Có">Có</option>
                                    <option name="Không">Không</option>
                                    <!--<option name="Không">Không</option>-->
                                </select>
                            </div>
                        </div>
                        <div class="form-group row" style="margin:10px 100px">
                            <label class="col-sm-3 col-form-label">Cách thức nhận:</label>
                            <div class="col-sm-9">
                                <select class="form-control" name="nhanTB">
                                    <option value="TT">Lấy trực tiếp</option>
                                    <option value="BD">Qua bưu điện</option>
                                    
                                </select>
                            </div>
                        </div>
                        <div style="margin:20px 330px">
                            <input class="btn btn-primary" type="submit" value="Thêm" name="add">
                            <input class="btn btn-danger" type="submit" value="Hủy" name="cancel">
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


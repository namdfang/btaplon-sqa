<%-- 
    Document   : income-tax
    Created on : Apr 24, 2023, 9:40:23 PM
    Author     : NVM-LT
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Đóng thuế</title>
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
                        <h3 style="margin: 20px; text-align: center;">ĐÓNG THUẾ THU NHẬP CÁ NHÂN</h3>
                        
                    <div style="width: 300px; margin: 0 auto;">
                        <div ><lable style="width: 100px; display: inline-block">Họ và tên:</lable> <span>Đặng Phương Nam</span></div>
                        <div ><lable style="width: 100px; display: inline-block">Địa chỉ:</lable> <span>Hà Đông, Hà Nội</span></div>
                        <div ><lable style="width: 100px; display: inline-block">Email:</lable> <span>namdang@gmail.com</span></div>
                        <div ><lable style="width: 100px; display: inline-block">Số điện thoại:</lable> <span>0123456789</span></div>
                        <div ><lable style="width: 100px; display: inline-block">Mã số thuế:</lable> <span>987654321</span></div>
                        <div ><lable style="width: 100px; display: inline-block">Số tiền thuế:</lable> <span>100.000.000 VNĐ</span></div>
                        <div style="margin-top: 20px">Chọn hình thức thanh toán:</div>
                        <form style="margin-top: 4px">
                            <input type="radio" name="gender" value="off" onclick="handleGenderChange(this)">
                            <label for="male">Thanh toán trực tiếp</label><br>
                            <input type="radio" name="gender" value="onl" onclick="handleGenderChange(this)">
                            <label for="female">Thanh toán online</label><br>
                         </form>
                        <!--<button style="margin-left: 108px; margin-top: 16px">Đóng thuế</button>-->
                        <div id="qrcode" style="margin-bottom: 16px; margin-top: 20px; font-weight: 600"></div>
                    </div>
                        
                </main>
                <%--<c:import url="/shared/footer.jsp" />--%>
            </div>
        </div>
        <%
        } else {
        %> 
            <c:import url="/login.jsp" />
        <% }%>
            <script src="https://cdnjs.cloudflare.com/ajax/libs/qrcodejs/1.0.0/qrcode.min.js"></script>
<!--            <script type="text/javascript">
            
          </script>-->
          
          
          <script>
            function handleGenderChange(radio) {
                var qrCode = document.getElementById("qrcode");
              if (radio.value === "off") {
                qrCode.innerText = "Vui lòng đến Chi cục Thuế gần nhất để thanh toán"
              } else if (radio.value === "onl") {
                  qrCode.innerText = "Vui lòng quét mã QR để thanh toán"
                var qrcode = new QRCode(qrCode, {
              text: "10.000.000 VNĐ",
              width: 256,
              height: 256,
              colorDark : "#000000",
              colorLight : "#ffffff",
              correctLevel : QRCode.CorrectLevel.H
            });
            qrcode.makeCode("10.000.000 VNĐ");
              }
            }
          </script>

        <script src="assets/jquery/jquery.min.js" type="text/javascript"></script>
        <script src="assets/jquery/scripts.js" type="text/javascript"></script>
        <script src="assets/jquery/datatables-demo.js" type="text/javascript"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
        <script src="https://cdn.datatables.net/1.10.20/js/jquery.dataTables.min.js" crossorigin="anonymous"></script>
        <script src="https://cdn.datatables.net/1.10.20/js/dataTables.bootstrap4.min.js" crossorigin="anonymous"></script>
    </body>
</html>

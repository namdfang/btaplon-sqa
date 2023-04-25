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
                        <div class="card-header"><i class="fa fa-table mr-1"></i>Thông tin chi tiết</div>
                        <div class="card-header">
                            <i class="fa fa-user-circle"></i><b>1. Thông tin người nộp thuế:</b> <br/>
                            <i><u>*Chú thích:</u><br />
                                -BT: Giảm trừ gia cảnh: Bản thân. <br />
                                -PT: Giảm trừ gia cảnh: Số người phụ thuộc. <br />
                                -BHBB: Bảo hiểm bắt buôc. <br />
                                -PCAU: Phụ cấp ăn uống. <br />
                                -PCVPP: Phụ cấp trang phục, văn phòng phẩm. <br />
                                -PCCTP: Phụ cấp công tác phí. <br />
                                -PCTC: Phụ cấp tăng ca/ làm thêm giờ. <br />
                                -PCĐH: Phụ cấp làm việc trong môi trường độc hại, nguy hiểm. <br />
                                -PCKCB: Phụ cấp khám chữa bệnh <br />
                                -PCBHKBB: Phụ cấp các loại bảo hiểm không bắt buộc: nhân thọ,...</i>
                        </div>
                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table table-bordered" width="100%" cellspacing="0">
                                    <thead class="thead-light">
                                        <tr>
                                            <th>ID</th>
                                            <th>Tên</th>
                                            <th>Tuổi</th>
                                            <th>Giới tính</th>
                                            <th>Địa chỉ</th>
                                            <th>CMTND</th>
                                            <th>Mã số thuế</th>
                                            <th>BT</th>
                                            <th>PT</th>
                                            <th>BHBB</th>
                                        </tr>
                                    </thead>
                                    <tbody>                    
                                        <tr>
                                            <td>${taxStatus.income.customer.id}</td>
                                            <td>${taxStatus.income.customer.name}</td>
                                            <td>${taxStatus.income.customer.age}</td>
                                            <td>${taxStatus.income.customer.sex}</td>
                                            <td>${taxStatus.income.customer.address}</td>
                                            <td>${taxStatus.income.customer.cmt}</td>
                                            <td>${taxStatus.income.customer.taxId}</td>    
                                            <td>${taxStatus.income.customer.gtgcbt}</td>
                                            <td>${taxStatus.income.customer.gtgcpt}</td>
                                            <td>${taxStatus.income.customer.gtbhbb}</td>
                                        </tr>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                        <div class="card-header">
                            <i class="fa fa-money"></i><b>2. Thông tin chi tiết thu nhập:</b> <br/>
                            <i>*Đơn vị: tr.VNĐ (triệu VNĐ)</i>
                        </div>
                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table table-bordered" width="100%" cellspacing="0">
                                    <thead class="thead-light">
                                        <tr>
                                            <th>ID</th>
                                            <th>Lương</th>
                                            <th>Thưởng</th>
                                            <th>PCAU</th>
                                            <th>PCVPP</th>
                                            <th>PCCTP</th>
                                            <th>PTTC</th>
                                            <th>PCDH</th>
                                            <th>PCKCB</th>
                                            <th>PCBHKBB</th>
                                            <th>Từ thiện</th>
                                        </tr>
                                    </thead>
                                    <tbody>                    
                                        <tr>
                                            <td>${taxStatus.income.id}</td>
                                            <td>${taxStatus.income.salary}</td>
                                            <td>${taxStatus.income.bonus}</td>
                                            <td>${taxStatus.income.pcanuong}</td>
                                            <td>${taxStatus.income.pcvpp}</td>
                                            <td>${taxStatus.income.pcctp}</td>
                                            <td>${taxStatus.income.pctangca}</td>
                                            <td>${taxStatus.income.pcdochai}</td>
                                            <td>${taxStatus.income.pckcb}</td>
                                            <td>${taxStatus.income.pcbhkbb}</td>
                                            <td>${taxStatus.income.tuthien}</td>
                                        </tr>
                                    </tbody>
                                </table>
                            </div>
                            <div style="float: right"><b>Tổng thu nhập:</b> ${totalIncome} <b>(tr.VNĐ)</b></div>
                        </div>
                        <div class="card-header">
                            <i class="fa fa-adjust"></i><b>3. Các khoản giảm trừ:</b> <br/>
                            <i>*Đơn vị: tr.VNĐ (triệu VNĐ)</i>
                        </div>
                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table table-bordered" width="100%" cellspacing="0">
                                    <thead class="thead-light">
                                        <tr>
                                            <th>BT</th>
                                            <th>PT</th>
                                            <th>BHBB</th>
                                            <th>PCAU</th>                       
                                            <th>PCVPP</th>
                                            <th>PCCTP</th>
                                            <th>PTTC</th>
                                            <th>PCDH</th>
                                            <th>PCKCB</th>
                                            <th>PCBHKBB</th>
                                            <th>Từ thiện</th>
                                        </tr>
                                    </thead>
                                    <tbody>                    
                                        <tr>
                                            <td>${gtgcbt}</td>
                                            <td>${gtgcpt}</td>
                                            <td>${gtbhbb}</td>
                                            <td>${pcanuong}</td>
                                            <td>${pcvpp}</td>
                                            <td>${pcctp}</td>
                                            <td>${pctangca}</td>
                                            <td>${pcdochai}</td>
                                            <td>${pckcb}</td>
                                            <td>${pcbhkbb}</td>
                                            <td>${tuthien}</td>
                                        </tr>
                                    </tbody>
                                </table>
                            </div>
                            <div style="float: right"><b>Tổng giảm trừ:</b> ${totalReduce} <b>(tr.VNĐ)</b></div>
                        </div>
                        <div style="text-align: center; font-size: 20px">
                            <i class="fa fa-money"></i>
                            <b> Thu nhập thực tế </b>= ${totalIncome} - ${totalReduce} = ${TNTT} <b>(tr.VNĐ)</b> ( Mức ${level})<br/>
                            <i class="fa fa-arrow-circle-o-right"></i>
                            <b> Tổng số tiền thuế các mức trước = </b> ${totalLowerLevelTaxAmount} <b>(tr.VNĐ)</b> <br/>
                            <i class="fa fa-arrow-circle-o-right"></i>
                            <b> Số tiền thuế = </b> ${taxRatio}% x ( <b>Thu nhập thực tế - </b> ${minIncomeOfLevel} ) + <b>Tổng số tiền thuế các mức trước</b> = ${taxAmount} <b>(tr.VNĐ)</b>
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


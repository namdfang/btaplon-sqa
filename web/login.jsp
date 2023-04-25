<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Đăng nhập hệ thống</title>
        <!-- Meta tags -->
        <meta name="viewport" content="width=device-width, initial-scale=1" />
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <meta name="keywords" content="Allied Login Form Responsive Widget, Audio and Video players, Login Form Web Template, Flat Pricing Tables, Flat Drop-Downs, Sign-Up Web Templates, Flat Web Templates, Login Sign-up Responsive Web Template, Smartphone Compatible Web Template, Free Web Designs for Nokia, Samsung, LG, Sony Ericsson, Motorola Web Design"
              />
        <script>
            addEventListener("load", function () {
                setTimeout(hideURLbar, 0);
            }, false);
            function hideURLbar() {
                window.scrollTo(0, 1);
            }
        </script>
        <!-- Meta tags -->
        <!-- font-awesome icons -->
        <link href="assets/libs/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css"/>
        <!--stylesheets-->
        <link href="assets/libs/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="assets/css/style.css" rel="stylesheet" type="text/css"/>
        <!--//style sheet end here-->
        <link href="//fonts.googleapis.com/css?family=Montserrat:300,400,500,600" rel="stylesheet">
        <link href="//fonts.googleapis.com/css?family=Open+Sans:400,600,700" rel="stylesheet">
        <!--js-->
        <script src="assets/libs/bootstrap/dist/js/bootstrap.min.js" type="text/javascript"></script>
    </head>

    <body>
        <h1 class="error">PHẦN MỀM QUẢN LÝ THUẾ THU NHẬP CÁ NHÂN</h1>
        <div class="w3layouts-two-grids">
            <div class="mid-class">
                <div class="txt-left-side">
                    <h2> Đăng nhập </h2>                   
                    <form action="login" method="post">
                        <div class="form-left-to-w3l">
                            <span class="fa fa-user-o" aria-hidden="true"></span>
                            <input type="text" name="username" value="${username}" placeholder="Tài khoản" required="">
                            <div class="clear"></div>
                        </div>
                        <div class="form-left-to-w3l">
                            <span class="fa fa-lock" aria-hidden="true"></span>
                            <input type="password" name="password" value="${password}" placeholder="Mật khẩu" required="">
                            <div class="clear"></div>
                        </div>
                        <div class="main-two-w3ls">
                            <div class="left-side-forget">
                                <input type="checkbox" class="checked">
                                <span class="remenber-me">Nhớ mật khẩu </span>
                            </div>
                            <div class="right-side-forget">
                                <a href="#" class="for">Quên mật khẩu...?</a>
                            </div>
                        </div>
                        <div class="btnn">
                            <button type="submit">Đăng nhập</button>
                        </div>
                        
                            <!-- comment <form action="signup" method="post" class="form-signup">
                                <h1 class="h3 mb-3 font-weight-normal" style="text-align: center">Đăng ký</h1>
                                <input name="username" type="text" id="user-name" class="form-control" placeholder="User name" reguired="" autofocus=""
                                <input name="password" type="password" id="user-pass" class="form-control" placeholder="Password" reguired="" autofocus=""
                                <input name="repass" type="password" id="user-repeatpass" class="form-control" placeholder="Repeat Password" reguired="" autofocus=""
                                
                                <button class="btn btn-primary btn-block" type="submit"><i class="fas fa-user-plus"></i>Đăng ký</button>
                            <a href="#" id="cancel_signup"><i class="fas fa-angle-left"></i>Back</a>
                            </form>-->
                            <a class="nav-link" href="/Tax-Management/signup.jsp"
                                ><div class="sb-nav-link-icon">
                                    <i class="fa fa-address-book"></i></div>
                                     Đăng ký tài khoản </a> 
                        
                    </form>
                    
                </div>
                <div class="img-right-side">
                    <img src="assets/images/thue-logo.png" alt="" />
                    <h3 style="color: purple; margin-top: 10px">Chi cục thuế quận Hà Đông</h3>
                </div>
            </div>
        </div>
        <footer class="copyrigh-wthree">
            <p>
                © 2020 Ha Dong District Personal Income Tax Management All Rights Reserved | SQA Group 5
            </p>
        </footer>
    </body>
</html>
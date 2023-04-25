<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<div id="layoutSidenav_nav">
    <nav class="sb-sidenav accordion sb-sidenav-dark" id="sidenavAccordion">
        <div class="sb-sidenav-menu">
            <div class="nav">
                <div class="sb-sidenav-menu-heading" style="font-size: 1em">
                    <i class="fa fa-circle"></i>
                    Quản lý thuế TNCN
                </div>

                <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseLayouts" aria-expanded="false" aria-controls="collapseLayouts"
                   ><div class="sb-nav-link-icon"><i class="fa fa-columns"></i></div>
                    Cấu hình thuế
                    <div class="sb-sidenav-collapse-arrow"><i class="fa fa-angle-down"></i></div
                    ></a>
                <div class="collapse" id="collapseLayouts" aria-labelledby="headingOne" data-parent="#sidenavAccordion">
                    <nav class="sb-sidenav-menu-nested nav">
                        <a class="nav-link" href="reduces">Các khoản giảm trừ</a>
                        <a class="nav-link" href="taxRatios">Thuế suất</a>
                    </nav>
                </div>
                <a class="nav-link" href="customers"
                   ><div class="sb-nav-link-icon">
                        <i class="fa fa-address-book"></i></div>
                    Đăng ký nộp thuế </a> 
                <a class="nav-link" href="/Tax-Management/tax-statuses-filter.jsp"
                   ><div class="sb-nav-link-icon">
                        <i class="fa fa-cube"></i></div>
                    Xem tình hình nộp thuế </a>    
                <a class="nav-link" href="/Tax-Management/tax-statistics-filter.jsp"
                   ><div class="sb-nav-link-icon">
                        <i class="fa fa-tachometer"></i></div>
                    Xem báo cáo thống kê thuế </a>
                <a class="nav-link" href="/Tax-Management/tax-colculation.jsp"
                   ><div class="sb-nav-link-icon">
                        <i class="fa fa-tachometer"></i></div>
                    Tính thuế thu nhập cá nhân </a>
            </div>
        </div>
    </nav>
</div>

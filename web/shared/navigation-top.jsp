<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

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
<nav class="sb-topnav navbar navbar-expand navbar-dark bg-dark">
    <a class="navbar-brand" href="index.jsp">Trang quản trị</a><i class="fas fa-bars"></i>
    <!-- Navbar Search-->
    <form class="d-none d-md-inline-block form-inline ml-auto mr-0 mr-md-3 my-2 my-md-0">
    </form>
    <!-- Navbar-->
    <ul class="navbar-nav ml-auto ml-md-0">
        <a class="nav-link active">
            <i class="fa fa-user-circle"></i> <%=username%></a>
        <a class="nav-link active" href="logout">
            <i class="fa fa-sign-out"></i>Đăng xuất</a>
    </ul>
</nav>
<%
} else {
%> 
    <c:import url="/shared/login.jsp" />
<% }%>    


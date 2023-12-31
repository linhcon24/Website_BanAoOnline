<%--
  Created by IntelliJ IDEA.
  User: adm
  Date: 9/25/2023
  Time: 10:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- Sidebar -->
<ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">

    <!-- Sidebar - Brand -->
    <a class="sidebar-brand d-flex align-items-center justify-content-center" href="/admin/dashboard">
        <div class="sidebar-brand-icon rotate-n-15">
            <i class="fas fa-laugh-wink"></i>
            <%--<i class="fa-solid fa-gauge"></i>--%>
        </div>
        <div class="sidebar-brand-text mx-3"> Trang Quản Trị <sup>2</sup></div>
    </a>

    <!-- Divider -->
    <hr class="sidebar-divider my-0">

    <!-- Nav Item - Dashboard -->
    <li class="nav-item active">
        <a class="nav-link" href="/admin/dashboard">
            <i class="fas fa-fw fa-tachometer-alt"></i>
            <span>Trang Chủ</span></a>
    </li>

    <!-- Divider -->
    <hr class="sidebar-divider">

    <!-- Heading -->
    <div class="sidebar-heading">
        Interface
    </div>

    <!-- Nav Item - Pages Collapse Menu -->
    <li class="nav-item">
        <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseTwo"
           aria-expanded="true" aria-controls="collapseTwo">
            <i class="fas fa-fw fa-cog"></i>
            <span>Quản Lý</span>
        </a>
        <div id="collapseTwo" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionSidebar">
            <div class="bg-white py-2 collapse-inner rounded">
                <h6 class="collapse-header">Custom Components:</h6>
                <a class="collapse-item" href="/admin/tai-khoan">Tài Khoản</a>
                <a class="collapse-item" href="/admin/chi-tiet-sp">Chi Tiết Sản Phẩm</a>
                <a class="collapse-item" href="/admin/sanpham">Sản Phẩm</a>
                <a class="collapse-item" href="/admin/thuong-hieu">Thương Hiệu</a>
                <a class="collapse-item" href="/admin/anhs">Ảnh</a>
                <a class="collapse-item" href="/admin/chat-lieu">Chất Liệu</a>
                <a class="collapse-item" href="/admin/kich-thuoc">Kích Thước</a>
                <a class="collapse-item" href="/admin/kieu-dang">Kiểu Dáng</a>
                <a class="collapse-item" href="/admin/nha-cung-cap">Nhà Cung Cấp</a>
                <a class="collapse-item" href="/admin/mau-sac">Màu Sắc</a>
                <a class="collapse-item" href="/admin/danh-sach-yeu-thich">Danh Sách Yêu Thích</a>
                <a class="collapse-item" href="/admin/danh-gia-san-pham">Đánh Giá Sản Phẩm</a>
                <a class="collapse-item" href="/admin/loai-khuyen-mai">Loại Khuyến Mãi</a>
                <a class="collapse-item" href="/admin/khuyen-mai">Khuyến Mãi</a>
                <a class="collapse-item" href="/admin/bai-dang">Bài Đăng</a>
            </div>
        </div>
    </li>

    <!-- Nav Item - Utilities Collapse Menu -->
    <li class="nav-item">
        <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseUtilities"
           aria-expanded="true" aria-controls="collapseUtilities">
            <i class="fas fa-fw fa-wrench"></i>
            <span>Utilities</span>
        </a>
        <div id="collapseUtilities" class="collapse" aria-labelledby="headingUtilities"
             data-parent="#accordionSidebar">
            <div class="bg-white py-2 collapse-inner rounded">
                <h6 class="collapse-header">Custom Utilities:</h6>
                <a class="collapse-item" href="utilities-color.html">Colors</a>
                <a class="collapse-item" href="utilities-border.html">Borders</a>
                <a class="collapse-item" href="utilities-animation.html">Animations</a>
                <a class="collapse-item" href="utilities-other.html">Other</a>
            </div>
        </div>
    </li>

    <!-- Divider -->
    <hr class="sidebar-divider">

    <!-- Heading -->
    <div class="sidebar-heading">
        Addons
    </div>

    <!-- Nav Item - Pages Collapse Menu -->
    <li class="nav-item">
        <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapsePages"
           aria-expanded="true" aria-controls="collapsePages">
            <i class="fas fa-fw fa-folder"></i>
            <span>Pages</span>
        </a>
        <div id="collapsePages" class="collapse" aria-labelledby="headingPages" data-parent="#accordionSidebar">
            <div class="bg-white py-2 collapse-inner rounded">
                <h6 class="collapse-header">Login Screens:</h6>
                <a class="collapse-item" href="/login">Login</a>
                <a class="collapse-item" href="/register">Register</a>
                <a class="collapse-item" href="/forget">Forgot Password</a>
                <div class="collapse-divider"></div>
                <h6 class="collapse-header">Other Pages:</h6>
                <a class="collapse-item" href="/403">403 Page</a>
                <a class="collapse-item" href="">Blank Page</a>
            </div>
        </div>
    </li>

    <!-- Nav Item - Charts -->
    <li class="nav-item">
        <a class="nav-link" href="/admin/hoa-don">
            <i class="fa-solid fa-file-invoice"></i>
            <span>Hóa đơn</span></a>
    </li>

    <!-- Nav Item - Tables -->
    <li class="nav-item">
        <a class="nav-link" href="/admin/thong-ke">
            <i class="fas fa-fw fa-chart-area"></i>
            <span>Thống kê</span></a>
    </li>

    <li class="nav-item">
        <a class="nav-link" href="/index">
            <i class="fa-solid fa-arrow-left"></i>
            <span>Quay lại trang chủ </span></a>
    </li>

    <!-- Nav Item - Tables -->
<%--    <li class="nav-item">--%>
<%--        <a class="nav-link" href="tables">--%>
<%--            <i class="fas fa-fw fa-table"></i>--%>
<%--            <span>Tables</span></a>--%>
<%--    </li>--%>

    <!-- Divider -->
    <hr class="sidebar-divider d-none d-md-block">

    <!-- Sidebar Toggler (Sidebar) -->
    <div class="text-center d-none d-md-inline">
        <button class="rounded-circle border-0" id="sidebarToggle"></button>
    </div>

    <%--   <!-- Sidebar Message -->
       <div class="sidebar-card d-none d-lg-flex">
           <img class="sidebar-card-illustration mb-2" src="../views/admin/img/undraw_rocket.svg" alt="...">
           <p class="text-center mb-2"><strong>SB Admin Pro</strong> is packed with premium features, components, and
               more!</p>
           <a class="btn btn-success btn-sm" href="https://startbootstrap.com/theme/sb-admin-pro">Upgrade to Pro!</a>
       </div>--%>

</ul>
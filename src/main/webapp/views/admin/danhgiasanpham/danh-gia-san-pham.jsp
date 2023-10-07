<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>


<br>
<%--<c:if test="${account.role == 0 }">--%>
<h1 style="text-align: center;"><i class="fa-solid fa-file-invoice"></i> Quản Lý Đánh Giá</h1>
<br>
<div class="btnThem">
    <button type="button" class="btn btn-info"><a href="${pageContext.request.contextPath }/admin/danh-gia-san-pham/add"><i
            class="fa-solid fa-circle-plus"></i> Thêm Đánh Giá</a></button>
</div>
<br>
<table class="table">
    <tr>
        <%--            <td>#</td>--%>
        <td>IdDanhGia</td>
        <td>MaDanhGia</td>
        <td>NoiDung</td>
        <td>NgayTao</td>
        <td>NgayCapNhat</td>
        <td>TrangThai</td>
        <td>IdSanPham</td>
        <td>IdTài Khoản</td>
        <td colspan="2">Action</td>

    </tr>

    <%--        <c:set value="0" var="i" scope="page"></c:set>--%>
    <c:forEach items="${listDGSP}" var="p">
        <%--            <c:set value="${i+1 }" var="i" scope="page" ></c:set>--%>
        <c:if test="${p.trangthai == 0 }">
            <tr>
                    <%--                    <td>${i }</td>--%>
                <td>${p.iddanhgia}</td>
                <td>${p.madanhgia}</td>
                <td>${p.noidung}</td>
                <td>${p.ngaytao}</td>
                <td>${p.ngaycapnhat}</td>
                <td>${p.trangthai}</td>
                <td>${p.sanPham.tensanpham}</td>
                <td>${p.taiKhoan.tentaikhoan}</td>
                <td>
                    <button type="button" class="btn btn-danger btnSua"><a
                            href="${pageContext.request.contextPath}/admin/danh-gia-san-pham/update/${p.iddanhgia }"><i
                            class="fa-solid fa-wrench"></i> Sửa</a></button>
                    <button type="button" class="btn btn-warning btnSua"><a
                            href="${pageContext.request.contextPath}/admin/danh-gia-san-pham/delete/${p.iddanhgia }"><i
                            class="fa-solid fa-trash"></i> Xóa</a></button>
                </td>
            </tr>
        </c:if>
    </c:forEach>
</table>
<div>
    <ul class="pagination">
        <c:forEach begin="1" end="${count}" var="i">
            <li class="page-item">
                <a href="${pageContext.request.contextPath}?pageNum=${i}" class="page-link">${i }</a>
            </li>
        </c:forEach>
    </ul>
</div>
<%--</c:if>--%>
<%--<c:if test="${account == null ||account.role == 1 }">--%>
<%--    <h1>Bạn không có quyền truy cập chức năng này !</h1>--%>
<%--</c:if>--%>


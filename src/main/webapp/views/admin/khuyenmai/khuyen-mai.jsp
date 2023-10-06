<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>





<br>
<%--<c:if test="${account.role == 0 }">--%>
<h1 style="text-align: center;"><i class="fa-solid fa-file-invoice"></i> Quản Lý Khuyến Mãi</h1>
<br>
<div class="btnThem">
    <button type="button" class="btn btn-info"><a href="${pageContext.request.contextPath }/admin/khuyen-mai/add"><i
            class="fa-solid fa-circle-plus"></i> Thêm Khuyến Mãi</a></button>
</div>
<br>
<table class="table">
    <tr>
        <%--            <td>#</td>--%>
        <td>idkhuyenmai</td>
        <td>makhuyenmai</td>
        <td>tenkhuyenmai</td>
        <td>mota</td>
        <td>chietkhau</td>
        <td>ngaybatdau</td>
        <td>ngayketthuc</td>
        <td>ngaytao</td>
        <td>ngaycapnhat</td>
        <td>trangthai</td>
        <td>loaiKhuyenMai</td>
        <td>Chức năng</td>
    </tr>

    <%--        <c:set value="0" var="i" scope="page"></c:set>--%>
    <c:forEach items="${listKM}" var="p">
        <%--            <c:set value="${i+1 }" var="i" scope="page" ></c:set>--%>
        <c:if test="${p.trangthai == 0 }">
            <tr>
                    <%--                    <td>${i }</td>--%>
                <td>${p.idkhuyenmai}</td>
                <td>${p.makhuyenmai}</td>
                <td>${p.tenkhuyenmai}</td>
                <td>${p.mota}</td>
                <td>${p.chietkhau}</td>
                <td>${p.ngaybatdau}</td>
                <td>${p.ngayketthuc}</td>
                <td>${p.ngaytao}</td>
                <td>${p.ngaycapnhat}</td>
                <td>${p.trangthai}</td>
                <td>${p.loaiKhuyenMai.idloaikhuyenmai}</td>
                <td>
                    <button type="button" class="btn btn-danger btnSua"><a
                            href="${pageContext.request.contextPath}/admin/khuyen-mai/update/${p.idkhuyenmai }"><i
                            class="fa-solid fa-wrench"></i> Sửa</a></button>
                    <button type="button" class="btn btn-warning btnSua"><a
                            href="${pageContext.request.contextPath}/admin/khuyen-mai/delete/${p.idkhuyenmai }"><i
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


<%--
  Created by IntelliJ IDEA.
  User: adm
  Date: 9/28/2023
  Time: 9:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<br>
<%--<c:if test="${account.role == 0 }">--%>
<h1 style="text-align: center;"><i class="fa-solid fa-file-invoice"></i> Quản Lý Loại Khuyến Mại  </h1>
<br>
    <%--            <c:set value="${i+1 }" var="i" scope="page" ></c:set>--%>
    <c:if test="${lkm.trangthai == 0 }">
            <p>ID: ${lkm.idloaikhuyenmai}</p>
            <p>Mã: ${lkm.maloaikhuyenmai}</p>
            <p>Tên: ${lkm.tenloaikhuyenmai}</p>
            <p>Ngày Tạo: ${lkm.ngaytao}</p>
            <p>Ngày Cập Nhật: ${lkm.ngaycapnhat}</p>
            <p>Người Cập Nhật: ${lkm.nguoicapnhat}</p>
            <p>Trạng Thái: ${lkm.trangthai}</p>
    </c:if>
<button type="button" class="btn btn-info"><i class="fa-solid fa-plus"></i><a href="/admin/loai-khuyen-mai/back">back</a></button>

<%--</c:if>--%>
<%--<c:if test="${account == null ||account.role == 1 }">--%>
<%--    <h1>Bạn không có quyền truy cập chức năng này !</h1>--%>
<%--</c:if>--%>


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
<h1 style="text-align: center;"><i class="fa-solid fa-file-invoice"></i> Quản Lý Màu Sắc  </h1>
<br>
<div class="btnThem">
    <button type="button" class="btn btn-info"><a href="${pageContext.request.contextPath }/admin/mau-sac/add"><i
            class="fa-solid fa-circle-plus"></i> Thêm màu sắc </a></button>
</div>
<br>
<table class="table">
    <tr>
        <%--            <td>#</td>--%>
        <td>ID</td>
        <td>Tên màu sắc </td>
        <td>Chức năng</td>
    </tr>

    <%--        <c:set value="0" var="i" scope="page"></c:set>--%>
    <c:forEach items="${list}" var="p">
        <%--            <c:set value="${i+1 }" var="i" scope="page" ></c:set>--%>
        <c:if test="${p.trangthai == 0 }">
            <tr>
                    <%--                    <td>${i }</td>--%>
                <td>${p.idmausac}</td>
                <td>${p.tenmausac}</td>
                <td>
                    <button type="button" class="btn btn-warning btnSua"><a
                            href="${pageContext.request.contextPath}/admin/mau-sac/update/${p.idmausac}"><i
                            class="fa-solid fa-wrench"></i> Sửa</a></button>
                    <button type="button" class="btn btn-danger btnSua"><a
                            href="${pageContext.request.contextPath}/admin/mau-sac/delete/${p.idmausac }"><i
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


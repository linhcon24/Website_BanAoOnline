<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>





<br>
<%--<c:if test="${account.role == 0 }">--%>
<h1 style="text-align: center;"><i class="fa-solid fa-file-invoice"></i> Quản Lý Ảnh</h1>
<br>
<div class="btnThem">
    <button type="button" class="btn btn-info"><a href="${pageContext.request.contextPath }/admin/anhs/add"><i
            class="fa-solid fa-circle-plus"></i> Thêm Ảnh</a></button>
</div>
<br>
<table class="table">
    <tr>
        <td>Tên Ảnh</td>
        <td>Ảnh 1</td>
        <td>Ảnh 2</td>
        <td>Ảnh 3</td>
        <td>Ảnh 4</td>
        <td>Chức năng</td>
    </tr>

    <c:forEach items="${listAnh}" var="p">
        <c:if test="${p.trangthai == 0}">
            <tr>
                <td>${p.tenimage}</td>
                <td><img src="${pageContext.request.contextPath}/views/uploads/${p.imageurl1}" alt="Ảnh 1" width="100" height="100" style="border-radius: 50%;"></td>
                <td><img src="${pageContext.request.contextPath}/views/uploads/${p.imageurl2}" alt="Ảnh 2" width="100" height="100" style="border-radius: 50%;"></td>
                <td><img src="${pageContext.request.contextPath}/views/uploads/${p.imageurl3}" alt="Ảnh 3" width="100" height="100" style="border-radius: 50%;"></td>
                <td><img src="${pageContext.request.contextPath}/views/uploads/${p.imageurl4}" alt="Ảnh 4" width="100" height="100" style="border-radius: 50%;"></td>
                <td>
                    <button type="button" class="btn btn-danger btnSua"><a
                            href="${pageContext.request.contextPath}/admin/anhs/update/${p.idimage }"><i
                            class="fa-solid fa-wrench"></i> Sửa</a></button>
                    <button type="button" class="btn btn-warning btnSua"><a
                            href="${pageContext.request.contextPath}/admin/anhs/delete/${p.idimage }"><i
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


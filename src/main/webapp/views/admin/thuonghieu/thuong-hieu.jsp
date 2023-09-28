<%--
  Created by IntelliJ IDEA.
  User: adm
  Date: 9/28/2023
  Time: 9:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>


<head>
    <link rel="Website Icon" type="png" href="../../views/img/logotitle.png">
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Admin Page</title>

    <script src="https://kit.fontawesome.com/999051c9de.js"
            crossorigin="anonymous"></script>

    <!-- Custom fonts for this template-->
    <link href="${pageContext.request.contextPath}/views/admin/vendor/fontawesome-free/css/all.min.css" rel="stylesheet"
          type="text/css">
    <link
            href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
            rel="stylesheet">

    <!-- Custom styles for this template-->
    <link href="${pageContext.request.contextPath}/views/admin/css/sb-admin-2.min.css" rel="stylesheet">
    <link rel="stylesheet"
          href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
          crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
            integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
            crossorigin="anonymous"></script>
    <script
            src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js"
            integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
            crossorigin="anonymous"></script>
    <script
            src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js"
            integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
    <script src="https://kit.fontawesome.com/999051c9de.js"
            crossorigin="anonymous"></script>

    <link rel="stylesheet" href="${pageContext.request.contextPath}/views/css/style.css">
</head>


<br>
<%--<c:if test="${account.role == 0 }">--%>
    <h1 style="text-align: center;"> <i class="fa-solid fa-file-invoice"></i> Quản Lý Thương Hiệu</h1>
    <br>
    <div class="btnThem"><button type="button" class="btn btn-secondary"><a href="${pageContext.request.contextPath }/thuong-hieu/add"><i class="fa-solid fa-circle-plus"></i> Thêm Thương Hiệu</a></button></div>
    <br>
    <table class="table">
        <tr>
            <td>#</td>
            <td>ID</td>
            <td>Tên Thương Hiệu</td>
            <td>Chức năng</td>
        </tr>

        <c:set value="0" var="i" scope="page"></c:set>
        <c:forEach items="${list}" var="p">
            <c:set value="${i+1 }" var="i" scope="page" ></c:set>
            <c:if test="${p.trangthai == 0 }">
                <tr>
                    <td>${i }</td>
                    <td>${p.idthuonghieu}</td>
                    <td>${p.tenthuonghieu}</td>
                    <td>
                        <button type="button" class="btn btn-danger btnSua"> <a href="${pageContext.request.contextPath}/thuong-hieu/update/${p.idthuonghieu }"><i class="fa-solid fa-wrench"></i> Sửa</a></button>
                        <button type="button" class="btn btn-warning btnSua" ><a href="${pageContext.request.contextPath}/thuong-hieu/delete/${p.idthuonghieu }"><i class="fa-solid fa-trash"></i> Xóa</a></button>
                    </td>
                </tr>
            </c:if>
        </c:forEach>
    </table>
    <div>
        <ul class="pagination">
            <c:forEach begin="1" end="${count}" var="i">
                <li class="page-item">
                    <a  href="${pageContext.request.contextPath}?pageNum=${i}" class="page-link">${i }</a>
                </li>
            </c:forEach>
        </ul>
    </div>
<%--</c:if>--%>
<%--<c:if test="${account == null ||account.role == 1 }">--%>
<%--    <h1>Bạn không có quyền truy cập chức năng này !</h1>--%>
<%--</c:if>--%>


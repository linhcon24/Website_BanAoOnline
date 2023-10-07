<%--
  Created by IntelliJ IDEA.
  User: adm
  Date: 9/28/2023
  Time: 11:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title><tiles:getAsString name="title-admin"></tiles:getAsString></title>
    <link rel="Website Icon" type="png" href="../../views/img/logotitle.png">
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

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

<%--    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">--%>
<%--    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>--%>
<%--    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>--%>
<%--    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>--%>
    <link rel="stylesheet" href="${pageContext.request.contextPath }/views/css/style.css">
    <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
    <script src="https://kit.fontawesome.com/999051c9de.js" crossorigin="anonymous"></script>
</head>
<body id="page-top">
<div id="wrapper">
    <c:if test="${not empty message}">
        <input type="hidden" id="message" value="${message }">
        <input type="hidden" id="type" value="${type }">
    </c:if>
<tiles:insertAttribute name="sidebar-admin"/>
<div id="content-wrapper" class="d-flex flex-column">
    <div id="content">
        <div class="container-fluid">
            <tiles:insertAttribute name="header-admin"/>
            <tiles:insertAttribute name="body-admin"/>
        </div>

    </div>

    <tiles:insertAttribute name="footer-admin"/>
</div>

</div>

<script type="text/javascript">
    var message = document.getElementById("message").value;
    var type = document.getElementById("type").value;
    console.log(message);

    if(message != ""){
        console.log("ggk");
        Swal.fire(message, '', type);
    }

</script>


<!-- Bootstrap core JavaScript-->
<script src="${pageContext.request.contextPath}/views/admin/vendor/jquery/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/views/admin/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

<!-- Core plugin JavaScript-->
<script src="${pageContext.request.contextPath}/views/admin/vendor/jquery-easing/jquery.easing.min.js"></script>

<!-- Custom scripts for all pages-->
<script src="${pageContext.request.contextPath}/views/admin/js/sb-admin-2.min.js"></script>

<!-- Page level plugins -->
<script src="${pageContext.request.contextPath}/views/admin/vendor/chart.js/Chart.min.js"></script>

<!-- Page level custom scripts -->
<script src="${pageContext.request.contextPath}/views/admin/js/demo/chart-area-demo.js"></script>
<script src="${pageContext.request.contextPath}/views/admin/js/demo/chart-pie-demo.js"></script>

<%--<script>--%>

<%--    function xoa(){--%>
<%--        Swal.fire({--%>
<%--            title: 'Bạn có muốn xóa?',--%>
<%--            text: "You won't be able to revert this!",--%>
<%--            icon: 'warning',--%>
<%--            showCancelButton: true,--%>
<%--            confirmButtonColor: '#3085d6',--%>
<%--            cancelButtonColor: '#d33',--%>
<%--            confirmButtonText: 'OK!'--%>
<%--        }).then((result) => {--%>
<%--            if (result.isConfirmed) {--%>
<%--                Swal.fire('Xóa thành công !', '', 'success');--%>
<%--            }--%>
<%--        })--%>
<%--    }--%>
<%--</script>--%>
</body>

</html>

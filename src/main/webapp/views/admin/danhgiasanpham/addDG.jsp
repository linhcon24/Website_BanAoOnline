<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!doctype html>
<html lang="en">
<head>
    <title>Title</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
    <div class="container">
        <h1> Thêm Đánh Giá</h1>
        <p style="color: red">${message }</p>
        <%--@elvariable id="kt" type=""--%>
        <f:form modelAttribute="kt" action="${pageContext.request.contextPath}/admin/danh-gia-san-pham/add" method="POST"
                enctype="multipart/form-data">

            <label for="exampleInputEmail1"> Mã Đánh Giá <span style="color:red">*</span> :</label>
            <f:input type="text" class="form-control" id="exampleInputEmail1" name="madanhgia" path="madanhgia"/>
            <f:errors style="color:red" path="madanhgia" element="div"></f:errors>
            <br>
            <label for="exampleInputEmail2"> Nội Dung <span style="color:red">*</span> :</label>
            <f:input type="text" class="form-control" id="exampleInputEmail2" name="noidung" path="noidung"/>
            <f:errors style="color:red" path="noidung" element="div"></f:errors>
            <br>
            <label> Id Sản Phẩm:  <span style="color:red">*</span> :</label>
            <f:select class="form-control" path="sanPham">
                <c:forEach items="${listSP}" var="sp">
                    <f:option value="${sp.idsanpham}">${sp.masanpham}</f:option>
                </c:forEach>
            </f:select> <br>
            <label> Id Tài Khoản:  <span style="color:red">*</span> :</label>
            <f:select class="form-control" path="taiKhoan">
                <c:forEach items="${listtk}" var="sp">
                    <f:option value="${sp.idtaikhoan}">${sp.username}</f:option>
                </c:forEach>
            </f:select> <br>
            <button type="submit" class="btn btn-danger"><i class="fa-solid fa-plus"></i> Thêm</button>

        </f:form>
    </div>
    <br>
<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>
</body>
</html>
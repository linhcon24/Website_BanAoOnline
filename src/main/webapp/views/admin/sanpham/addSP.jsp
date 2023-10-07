<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<div class="container">
    <h1> Thêm Sản Phẩm</h1>
    <p style="color: red">${message }</p>
    <%--@elvariable id="sp" type=""--%>
    <f:form modelAttribute="sp" action="${pageContext.request.contextPath}/admin/sanpham/add" method="POST"
            enctype="multipart/form-data">

        <label for="exampleInputEmail1"> Tên <span style="color:red">*</span> :</label>
        <f:input type="text" class="form-control" id="exampleInputEmail1" name="tensanpham" path="tensanpham"/>
        <f:errors style="color:red" path="tensanpham" element="div"></f:errors>
        <br>
        <button type="submit" class="btn btn-danger"><i class="fa-solid fa-plus"></i> Thêm</button>
    <a href="/admin/sanpham"><button type="submit" class="btn btn-secondary" ><i class="fa-solid fa-rotate-right"></i> Back</button>

    </f:form>
</div>
<br>

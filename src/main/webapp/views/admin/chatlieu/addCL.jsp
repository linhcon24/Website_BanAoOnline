<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<div class="container">
    <h1> Thêm Chất Liệu</h1>
    <p style="color: red">${message }</p>
    <%--@elvariable id="cl" type=""--%>
    <f:form modelAttribute="cl" action="${pageContext.request.contextPath}/admin/chat-lieu/add" method="POST"
            enctype="multipart/form-data">

        <label for="exampleInputEmail1"> Tên <span style="color:red">*</span> :</label>
        <f:input type="text" class="form-control" id="exampleInputEmail1" name="tenchatlieu" path="tenchatlieu"/>
        <f:errors style="color:red" path="tenchatlieu" element="div"></f:errors>
        <br>
        <button type="submit" class="btn btn-danger"><i class="fa-solid fa-plus"></i> Thêm</button>

    </f:form>
</div>
<br>
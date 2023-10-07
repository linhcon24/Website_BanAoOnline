<%--
  Created by IntelliJ IDEA.
  User: adm
  Date: 9/28/2023
  Time: 9:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<div class="container">
    <h1> Thêm Thương Hiệu</h1>
    <p style="color: red">${message }</p>
    <%--@elvariable id="th" type=""--%>
    <f:form modelAttribute="th" action="${pageContext.request.contextPath}/admin/thuong-hieu/add" method="POST"
            enctype="multipart/form-data">

        <label for="exampleInputEmail1"> Tên <span style="color:red">*</span> :</label>
        <f:input type="text" class="form-control" id="exampleInputEmail1" name="tenthuonghieu" path="tenthuonghieu"/>
        <f:errors style="color:red" path="tenthuonghieu" element="div"></f:errors>
        <br>
        <button type="submit" class="btn btn-info"><i class="fa-solid fa-plus"></i> Thêm</button>
        <a href="/admin/thuong-hieu"><button type="submit" class="btn btn-secondary" ><i class="fa-solid fa-rotate-right"></i> Back</button>
        </a>


    </f:form>
</div>
<br>

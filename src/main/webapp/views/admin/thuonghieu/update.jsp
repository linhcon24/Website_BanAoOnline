<%--
  Created by IntelliJ IDEA.
  User: adm
  Date: 9/28/2023
  Time: 9:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<div class="container">
    <h1> Sửa Thương Hiệu</h1>
    <f:form action="${pageContext.request.contextPath}/category/update" method="post" modelAttribute="th">
        <f:input type="hidden" class="form-control"  id="exampleInputEmail1" name="ten" value="${cate.id }" path="id"/>
        <label for="exampleInputEmail1"> Tên <span style="color:red">*</span> :</label>
        <f:input type="text" class="form-control"  id="exampleInputEmail1" name="ten" value="${cate.ten }" path="ten"/>
        <f:errors style="color:red" path="ten" element="div"></f:errors>
        <br>
        <button type="submit" class="btn btn-danger"><i class="fa-solid fa-plus"></i>  Sửa</button>

    </f:form>
</div>
<br>

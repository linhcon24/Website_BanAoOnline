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
    <h1> Sửa Màu Sắc</h1>
    <%--@elvariable id="ms" type=""--%>
    <f:form action="${pageContext.request.contextPath}/admin/mau-sac/update" method="POST" modelAttribute="ms">
        <f:input type="hidden" class="form-control" id="exampleInputEmail1" name="idmausac"
                 value="${ms1.idmausac }" path="idmausac"/>
        <label for="exampleInputEmail1"> Tên <span style="color:red">*</span> :</label>
        <f:input type="text" class="form-control" id="exampleInputEmail1" name="tenmausac"
                 value="${ms1.tenmausac}" path="tenmausac"/>
        <f:errors style="color:red" path="tenmausac" element="div"></f:errors>
        <br>
        <button type="submit" class="btn btn-warning"><i class="fa-solid fa-plus"></i> Sửa</button>
    <a href="/admin/mau-sac"><button type="submit" class="btn btn-secondary" ><i class="fa-solid fa-rotate-right"></i> Back</button>

    </f:form>
</div>
<br>

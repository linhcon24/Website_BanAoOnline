<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<div class="container">
    <h1> Sửa Chất Liệu</h1>
    <%--@elvariable id="cl" type=""--%>
    <f:form action="${pageContext.request.contextPath}/admin/chat-lieu/update" method="POST" modelAttribute="cl">
        <f:input type="hidden" class="form-control" id="exampleInputEmail1" name="idchatlieu"
                 value="${cl1.idchatlieu }" path="idchatlieu"/>
        <label for="exampleInputEmail1"> Tên <span style="color:red">*</span> :</label>
        <f:input type="text" class="form-control" id="exampleInputEmail1" name="tenchatlieu"
                 value="${cl1.tenchatlieu }" path="tenchatlieu"/>
        <f:errors style="color:red" path="tenchatlieu" element="div"></f:errors>
        <br>
        <button type="submit" class="btn btn-danger"><i class="fa-solid fa-plus"></i> Sửa</button>

    </f:form>
</div>
<br>

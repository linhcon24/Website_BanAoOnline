<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<div class="container">
    <h1> Sửa Kích Thước</h1>
    <%--@elvariable id="kt" type=""--%>
    <f:form action="${pageContext.request.contextPath}/admin/kich-thuoc/update" method="POST" modelAttribute="kt">
        <f:input type="hidden" class="form-control" id="exampleInputEmail1" name="idkichthuoc"
                 value="${kt1.idkichthuoc }" path="idkichthuoc"/>
        <label for="exampleInputEmail1"> Tên <span style="color:red">*</span> :</label>
        <f:input type="text" class="form-control" id="exampleInputEmail1" name="tenkichthuoc"
                 value="${kt1.tenkichthuoc }" path="tenkichthuoc"/>
        <f:errors style="color:red" path="tenkichthuoc" element="div"></f:errors>
        <br>
        <button type="submit" class="btn btn-danger"><i class="fa-solid fa-plus"></i> Sửa</button>
    <a href="/admin/kich-thuoc"><button type="submit" class="btn btn-secondary" ><i class="fa-solid fa-rotate-right"></i> Back</button>

    </f:form>
</div>
<br>

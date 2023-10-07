<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<div class="container">
    <h1> Sửa Sản Phẩm</h1>
    <%--@elvariable id="sp" type=""--%>
    <f:form action="${pageContext.request.contextPath}/admin/sanpham/update" method="POST" modelAttribute="sp">
        <f:input type="hidden" class="form-control" id="exampleInputEmail1" name="idsanpham"
                 value="${sp1.idsanpham }" path="idsanpham"/>
        <f:input type="hidden" class="form-control" id="exampleInputEmail1" name="masanpham"
                 value="${sp1.masanpham }" path="masanpham"/>
        <label for="exampleInputEmail1"> Tên <span style="color:red">*</span> :</label>
        <f:input type="text" class="form-control" id="exampleInputEmail1" name="tensanpham"
                 value="${sp1.tensanpham }" path="tensanpham"/>
        <f:errors style="color:red" path="tensanpham" element="div"></f:errors>
        <br>
        <button type="submit" class="btn btn-danger"><i class="fa-solid fa-plus"></i> Sửa</button>

    </f:form>
</div>
<br>

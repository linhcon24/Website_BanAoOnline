<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<div class="container">
    <h1> Thêm Ảnh</h1>
    <p style="color: red">${message }</p>
    <%--@elvariable id="anh" type=""--%>
    <f:form modelAttribute="anh" action="${pageContext.request.contextPath}/admin/anhs/add" method="POST"
            enctype="multipart/form-data">

        <label for="exampleInputEmail1"> Tên <span style="color:red">*</span> :</label>
        <f:input type="text" class="form-control" id="exampleInputEmail1" name="tenimage" path="tenimage"/>
        <f:errors style="color:red" path="tenimage" element="div"></f:errors>

        <label for="exampleInputImage1"> Ảnh 1 <span style="color:red">*</span> :</label>
        <input type="file" class="form-control" id="exampleInputImage1" name="imageFile" accept=".png, .jpg, .jpeg, .gif, .svg"/>
        <f:errors style="color:red" path="imageurl1" element="div"></f:errors>

        <label for="exampleInputImage1"> Ảnh 2 <span style="color:red">*</span> :</label>
        <input type="file" class="form-control" id="exampleInputImage1" name="imageFile" accept=".png, .jpg, .jpeg, .gif, .svg/">
        <f:errors style="color:red" path="imageurl2" element="div"></f:errors>

        <label for="exampleInputImage1"> Ảnh 3 <span style="color:red">*</span> :</label>
        <input type="file" class="form-control" id="exampleInputImage1" name="imageFile" accept=".png, .jpg, .jpeg, .gif, .svg"/>
        <f:errors style="color:red" path="imageurl3" element="div"></f:errors>

        <label for="exampleInputImage1"> Ảnh 4 <span style="color:red">*</span> :</label>
        <input type="file" class="form-control" id="exampleInputImage1" name="imageFile" accept=".png, .jpg, .jpeg, .gif, .svg"/>
        <f:errors style="color:red" path="imageurl4" element="div"></f:errors>
        <br>
        <button type="submit" class="btn btn-danger"><i class="fa-solid fa-plus"></i> Thêm</button>

    </f:form>
</div>
<br>

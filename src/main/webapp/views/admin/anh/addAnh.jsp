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
    <f:form modelAttribute="anh" action="${pageContext.request.contextPath}/admin/anh/add" method="POST"
            enctype="multipart/form-data">

        <label for="exampleInputEmail1"> Tên <span style="color:red">*</span> :</label>
        <f:input type="text" class="form-control" id="exampleInputEmail1" name="tenimage" path="tenimage"/>
        <f:errors style="color:red" path="tenimage" element="div"></f:errors>

        <label for="exampleInputEmail1"> Đường dẫn 1 <span style="color:red">*</span> :</label>
        <f:input type="text" class="form-control" id="exampleInputEmail1" name="imageurl1" path="imageurl1"/>
        <f:errors style="color:red" path="imageurl1" element="div"></f:errors>
        <br>

        <label for="exampleInputEmail1"> Đường dẫn 2 <span style="color:red">*</span> :</label>
        <f:input type="text" class="form-control" id="exampleInputEmail1" name="imageurl2" path="imageurl2"/>
        <f:errors style="color:red" path="imageurl2" element="div"></f:errors>

        <label for="exampleInputEmail1"> Đường dẫn 3 <span style="color:red">*</span> :</label>
        <f:input type="text" class="form-control" id="exampleInputEmail1" name="imageurl3" path="imageurl3"/>
        <f:errors style="color:red" path="imageurl3" element="div"></f:errors>

        <label for="exampleInputEmail1"> Đường dẫn 4 <span style="color:red">*</span> :</label>
        <f:input type="text" class="form-control" id="exampleInputEmail1" name="imageurl4" path="imageurl4"/>
        <f:errors style="color:red" path="imageurl4" element="div"></f:errors>
        <button type="submit" class="btn btn-danger"><i class="fa-solid fa-plus"></i> Thêm</button>

    </f:form>
</div>
<br>

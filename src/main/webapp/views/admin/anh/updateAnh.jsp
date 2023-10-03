<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<div class="container">
    <h1> Sửa Ảnh</h1>
    <%--@elvariable id="anh" type=""--%>
    <f:form action="${pageContext.request.contextPath}/admin/anh/update" method="POST" modelAttribute="anh">
        <f:input type="hidden" class="form-control" id="exampleInputEmail1" name="idimage"
                 value="${anh1.idimage }" path="idimage"/>
        <label for="exampleInputEmail1"> Tên <span style="color:red">*</span> :</label>
        <f:input type="text" class="form-control" id="exampleInputEmail1" name="tenimage"
                 value="${anh1.tenimage }" path="tenimage"/>
        <f:errors style="color:red" path="tenimage" element="div"></f:errors>

        <label for="exampleInputEmail1"> Đường dẫn 1 <span style="color:red">*</span> :</label>
        <f:input type="text" class="form-control" id="exampleInputEmail1" name="imageurl1"
                 value="${anh1.imageurl1 }" path="imageurl1"/>
        <f:errors style="color:red" path="imageurl1" element="div"></f:errors>

        <label for="exampleInputEmail1"> Đường dẫn 2 <span style="color:red">*</span> :</label>
        <f:input type="text" class="form-control" id="exampleInputEmail1" name="imageurl2"
                 value="${anh1.imageurl2 }" path="imageurl2"/>
        <f:errors style="color:red" path="imageurl2" element="div"></f:errors>

        <label for="exampleInputEmail1"> Đường dẫn 3 <span style="color:red">*</span> :</label>
        <f:input type="text" class="form-control" id="exampleInputEmail1" name="imageurl3"
                 value="${anh1.imageurl3 }" path="imageurl3"/>
        <f:errors style="color:red" path="imageurl3" element="div"></f:errors>

        <label for="exampleInputEmail1"> Đường dẫn 4 <span style="color:red">*</span> :</label>
        <f:input type="text" class="form-control" id="exampleInputEmail1" name="imageurl4"
                 value="${anh1.imageurl4 }" path="imageurl4"/>
        <f:errors style="color:red" path="imageurl4" element="div"></f:errors>
        <br>
        <button type="submit" class="btn btn-danger"><i class="fa-solid fa-plus"></i> Sửa</button>

    </f:form>
</div>
<br>

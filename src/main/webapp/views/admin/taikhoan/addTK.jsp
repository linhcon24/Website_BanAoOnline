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
    <h1> Thêm Tài Khoản</h1>
    <p style="color: red">${message }</p>
    <%--@elvariable id="tk" type=""--%>
    <f:form modelAttribute="tk" action="${pageContext.request.contextPath}/admin/tai-khoan/add" method="POST"
            enctype="multipart/form-data">

        <div class="form-group">
            <%--@declare id="exampleformcontrolfile1"--%><label for="exampleFormControlFile1"> Image <span style="color:red">*</span> :</label> <input
                type="file" class="form-control-file" id="fileUpload" name="file" />
        </div>
        <label for="exampleInputEmail1"> Username <span style="color:red">*</span> :</label>
        <f:input type="text" class="form-control" id="exampleInputEmail1" name="username" path="username"/>
        <f:errors style="color:red" path="username" element="div"></f:errors>

        <label for="exampleInputEmail1"> Password <span style="color:red">*</span> :</label>
        <f:input type="password" class="form-control" id="exampleInputEmail1"  name="password" path="password"/>
        <f:errors style="color:red" path="password" element="div"></f:errors>

        <label for="exampleInputEmail1"> Email <span style="color:red">*</span> :</label>
        <f:input type="email" class="form-control" id="exampleInputEmail1" name="email" path="email"/>
        <f:errors style="color:red" path="email" element="div"></f:errors>

        <label for="exampleInputEmail1"> Sdt <span style="color:red">*</span> :</label>
        <f:input type="text" class="form-control" id="exampleInputEmail1" name="sdt" path="sdt"/>
        <f:errors style="color:red" path="sdt" element="div"></f:errors>

        <br>
        <label for="exampleInputEmail1"> Giới Tính <span style="color:red">*</span> :</label>
        <input type="radio"  name="gioitinh" path="gioitinh" value="true" checked="checked"/>Nam
        <input type="radio"  name="gioitinh" path="gioitinh" value="false" />Nữ

        <f:errors style="color:red" path="sdt" element="gioitinh"></f:errors>
        <br>
        <br>
        <label> Vai trò<span style="color:red">*</span> :</label>
        <f:select class="form-control" id="exampleFormControlSelect1"
                  name="vaitro" path="vaitro">
            <option value="0">Admin</option>
            <option value="1">Thành viên</option>
        </f:select>
        <br>
        <button type="submit" class="btn btn-info"><i class="fa-solid fa-plus"></i> Thêm</button>
    <a href="/admin/tai-khoan"><button type="submit" class="btn btn-secondary" ><i class="fa-solid fa-rotate-right"></i> Back</button>


    </f:form>
</div>
<br>

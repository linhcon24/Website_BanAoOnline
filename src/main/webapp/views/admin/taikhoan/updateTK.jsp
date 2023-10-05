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
    <h1> Sửa Thương Hiệu</h1>
    <%--@elvariable id="tk" type=""--%>
    <f:form action="${pageContext.request.contextPath}/admin/tai-khoan/update" method="POST" modelAttribute="tk">

        <f:input type="hidden" class="form-control" id="exampleInputEmail1" name="idtaikhoan"
                 value="${account.idtaikhoan }" path="idtaikhoan"/>
        <div class="form-group">
            <%--@declare id="exampleformcontrolfile1"--%>
                <label for="exampleFormControlFile1"> Image *:</label> <input
                type="file" class="form-control-file" id="fileUpload" name="file" />
        </div>
        <label for="exampleInputEmail1"> Username <span style="color:red">*</span> :</label>
        <f:input type="text" class="form-control" id="exampleInputEmail1" name="username" value="${account.username }" readonly="true" path="username"/>
        <f:errors style="color:red" path="username" element="div"></f:errors>

        <label for="exampleInputEmail1"> Password <span style="color:red">*</span> :</label>
        <f:input type="password" class="form-control" id="exampleInputEmail1"  name="password" value="${account.password }" path="password"/>
        <f:errors style="color:red" path="password" element="div"></f:errors>

        <label for="exampleInputEmail1"> Email <span style="color:red">*</span> :</label>
        <f:input type="email" class="form-control" id="exampleInputEmail1" name="email" value="${account.email }" path="email"/>
        <f:errors style="color:red" path="email" element="div"></f:errors>

        <label for="exampleInputEmail1"> Sdt <span style="color:red">*</span> :</label>
        <f:input type="text" class="form-control" id="exampleInputEmail1" name="sdt" value="${account.sdt}" path="sdt"/>
        <f:errors style="color:red" path="sdt" element="div"></f:errors>

        <br>
        <label for="exampleInputEmail1"> Giới Tính <span style="color:red">*</span>:</label>
        <input type="radio" name="gioitinh" path="gioitinh" value="true" checked="checked"/>Nam
        <input type="radio" name="gioitinh" path="gioitinh" value="false"/>Nữ

        <f:errors style="color:red" path="sdt" element="gioitinh"></f:errors>
        <br>
        <label> Vai trò<span style="color:red">*</span> :</label>
        <f:select class="form-control" id="exampleFormControlSelect1"
                  name="vaitro" path="vaitro">
            <option ${account.vaitro == 0 ? "selected" : ""} value="0">Admin</option>
            <option ${account.vaitro == 1 ? "selected" : ""} value="1">Thành viên</option>
        </f:select>
        <br>
        <button type="submit" class="btn btn-warning"><i class="fa-solid fa-plus"></i> Sửa</button>

    </f:form>
</div>
<br>

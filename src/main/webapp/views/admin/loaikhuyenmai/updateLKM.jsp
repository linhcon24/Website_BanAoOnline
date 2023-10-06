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
    <h1> Sửa Loại Khuyến Mại</h1>
    <%--@elvariable id="ms" type=""--%>
    <f:form action="${pageContext.request.contextPath}/admin/loai-khuyen-mai/update" method="POST" modelAttribute="lkm">

        <label for="exampleInputEmail1"> Mã <span style="color:red">*</span> :</label>
        <f:input type="text" class="form-control" value="${lkm1.idloaikhuyenmai }" id="exampleInputEmail1" name="idloaikhuyenmai" path="idloaikhuyenmai" readonly="true"/>
        <f:errors style="color:red"  path="maloaikhuyenmai" element="div"></f:errors>
        <br>

        <label for="exampleInputEmail1"> Mã <span style="color:red">*</span> :</label>
        <f:input type="text" class="form-control" value="${lkm1.maloaikhuyenmai }" id="exampleInputEmail1" name="maloaikhuyenmai" path="maloaikhuyenmai"/>
        <f:errors style="color:red"  path="maloaikhuyenmai" element="div"></f:errors>
        <br>

        <label for="exampleInputEmail1"> Tên <span style="color:red">*</span> :</label>
        <f:input type="text" class="form-control" value="${lkm1.tenloaikhuyenmai }" id="exampleInputEmail1" name="tenloaikhuyenmai" path="tenloaikhuyenmai"/>
        <f:errors style="color:red" path="tenloaikhuyenmai" element="div"></f:errors>
        <br>

        <label for="exampleInputEmail1"> Ngày Tạo <span style="color:red">*</span> :</label>
        <f:input type="date" class="form-control" value="${lkm1.ngaytao }" id="exampleInputEmail1" name="ngaytao" path="ngaytao"/>
        <br>

        <label for="exampleInputEmail1"> Ngày Cập Nhật <span style="color:red">*</span> :</label>
        <f:input type="date" class="form-control" value="${lkm1.ngaycapnhat }" id="exampleInputEmail1" name="ngaycapnhat" path="ngaycapnhat"/>
        <br>

        <label for="exampleInputEmail1"> Người Cập Nhật <span style="color:red">*</span> :</label>
        <f:input type="text" class="form-control" value="${lkm1.nguoicapnhat }" id="exampleInputEmail1" name="nguoicapnhat" path="nguoicapnhat"/>
        <f:errors style="color:red" path="nguoicapnhat" element="div"></f:errors>
        <br>

        <label for="exampleInputEmail1"> Trang Thái <span style="color:red">*</span> :</label>
        <f:input type="text" class="form-control" value="${lkm1.trangthai }" id="exampleInputEmail1" name="trangthai" path="trangthai"/>
        <f:errors style="color:red" path="trangthai" element="div"></f:errors>
        <br>
        <br>
        <button type="submit" class="btn btn-warning"><i class="fa-solid fa-plus"></i> Sửa</button>

    </f:form>
</div>
<br>

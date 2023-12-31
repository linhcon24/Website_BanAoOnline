<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<div class="container">
    <h1> Thêm Bài Đăng</h1>
    <p style="color: red">${message }</p>
    <%--@elvariable id="bd" type=""--%>
    <f:form modelAttribute="bd" action="${pageContext.request.contextPath}/admin/bai-dang/add" method="POST"
            enctype="multipart/form-data">

        <label for="exampleInputEmail1"> Mã <span style="color:red">*</span> :</label>
        <f:input type="text" class="form-control" id="exampleInputEmail1" name="mabaidang" path="mabaidang"/>
        <f:errors style="color:red" path="mabaidang" element="div"></f:errors>
        <br>

        <label for="exampleInputEmail1"> Tên <span style="color:red">*</span> :</label>
        <f:input type="text" class="form-control" id="exampleInputEmail1" name="tenbaidang" path="tenbaidang"/>
        <f:errors style="color:red" path="tenbaidang" element="div"></f:errors>
        <br>

        <label for="exampleInputEmail1"> Nội Dung<span style="color:red">*</span> :</label>
        <f:input type="text" class="form-control" id="exampleInputEmail1" name="noidung" path="noidung"/>
        <f:errors style="color:red" path="noidung" element="div"></f:errors>
        <br>

        <label for="exampleInputEmail1"> Ngày Tạo <span style="color:red">*</span> :</label>
        <f:input type="date" class="form-control" id="exampleInputEmail1" name="ngaytao" path="ngaytao"/>
        <br>

        <label for="exampleInputEmail1"> Ngày Cập Nhật <span style="color:red">*</span> :</label>
        <f:input type="date" class="form-control" id="exampleInputEmail1" name="ngaycapnhat" path="ngaycapnhat"/>
        <br>

        <label for="exampleInputEmail1"> Người Cập Nhật <span style="color:red">*</span> :</label>
        <f:input type="text" class="form-control" id="exampleInputEmail1" name="nguoicapnhat" path="nguoicapnhat"/>
        <f:errors style="color:red" path="nguoicapnhat" element="div"></f:errors>
        <br>

        <label for="exampleInputEmail1"> Trạng Thái <span style="color:red">*</span> :</label>
        <f:input type="text" class="form-control" id="exampleInputEmail1" name="trangthai" path="trangthai"/>
        <f:errors style="color:red" path="trangthai" element="div"></f:errors>
        <br>

        <label> Tài Khoản:  <span style="color:red">*</span> :</label>
        <f:select class="form-control" path="taiKhoan">
            <c:forEach items="${listtk}" var="sp">
                <f:option value="${sp.idtaikhoan}">${sp.username}</f:option>
            </c:forEach>
        </f:select> <br>
        <button type="submit" class="btn btn-danger"><i class="fa-solid fa-plus"></i> Thêm</button>
    <a href="/admin/bai-dang"><button type="submit" class="btn btn-secondary" ><i class="fa-solid fa-rotate-right"></i> Back</button>

    </f:form>
</div>
<br>

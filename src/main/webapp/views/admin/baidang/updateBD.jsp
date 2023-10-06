<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<div class="container">
    <h1> Sửa Bài Đăng</h1>
    <%--@elvariable id="kt" type=""--%>
    <f:form action="${pageContext.request.contextPath}/admin/bai-dang/update" method="POST" modelAttribute="bd">

        <label for="exampleInputEmail1"> ID <span style="color:red">*</span> :</label>
        <f:input type="text" class="form-control" value="${bd1.idbaidang }" id="exampleInputEmail4" name="idbaidang" path="idbaidang" readonly="true"/>
        <br>

        <label for="exampleInputEmail1"> Mã <span style="color:red">*</span> :</label>
        <f:input type="text" class="form-control" value="${bd1.mabaidang }" id="exampleInputEmail1" name="mabaidang" path="mabaidang"/>
        <f:errors style="color:red" path="mabaidang" element="div"></f:errors>
        <br>

        <label for="exampleInputEmail1"> Tên <span style="color:red">*</span> :</label>
        <f:input type="text" class="form-control" value="${bd1.tenbaidang }" id="exampleInputEmail1" name="tenbaidang" path="tenbaidang"/>
        <f:errors style="color:red" path="tenbaidang" element="div"></f:errors>
        <br>

        <label for="exampleInputEmail1"> Nội Dung<span style="color:red">*</span> :</label>
        <f:input type="text" class="form-control" value="${bd1.noidung }" id="exampleInputEmail1" name="noidung" path="noidung"/>
        <f:errors style="color:red" path="noidung" element="div"></f:errors>
        <br>

        <label for="exampleInputEmail1"> Ngày Tạo <span style="color:red">*</span> :</label>
        <f:input type="date" class="form-control" value="${bd1.ngaytao }" id="exampleInputEmail1" name="ngaytao" path="ngaytao"/>
        <br>

        <label for="exampleInputEmail1"> Ngày Cập Nhật <span style="color:red">*</span> :</label>
        <f:input type="date" class="form-control" value="${bd1.ngaycapnhat }" id="exampleInputEmail1" name="ngaycapnhat" path="ngaycapnhat"/>
        <br>

        <label for="exampleInputEmail1"> Người Cập Nhật <span style="color:red">*</span> :</label>
        <f:input type="text" class="form-control" value="${bd1.nguoicapnhat }" id="exampleInputEmail1" name="nguoicapnhat" path="nguoicapnhat"/>
        <f:errors style="color:red" path="nguoicapnhat" element="div"></f:errors>
        <br>

        <label for="exampleInputEmail1"> Trạng Thái <span style="color:red">*</span> :</label>
        <f:input type="text" class="form-control" value="${bd1.trangthai }" id="exampleInputEmail1" name="trangthai" path="trangthai"/>
        <f:errors style="color:red" path="trangthai" element="div"></f:errors>
        <br>

        <label> Tài Khoản:  <span style="color:red">*</span> :</label>
        <f:select class="form-control" path="taiKhoan">
            <c:forEach items="${listtk}" var="sp">
                <f:option value="${sp.idtaikhoan}" selected="${sp.idtaikhoan==bd1.taiKhoan.idtaikhoan?'true':''}">${sp.username}</f:option>
            </c:forEach>
        </f:select> <br>
        <button type="submit" class="btn btn-danger"><i class="fa-solid fa-plus"></i> Sửa</button>

    </f:form>
</div>
<br>

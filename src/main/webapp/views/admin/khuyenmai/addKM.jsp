<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<div class="container">
    <h1> Thêm Khuyến Mãi</h1>
    <p style="color: red">${message }</p>
    <%--@elvariable id="kt" type=""--%>
    <f:form modelAttribute="kt" action="${pageContext.request.contextPath}/admin/khuyen-mai/add" method="POST"
            enctype="multipart/form-data">

        <label for="exampleInputEmail1"> Mã KM <span style="color:red">*</span> :</label>
        <f:input type="text" class="form-control" id="exampleInputEmail1" name="makhuyenmai" path="makhuyenmai"/>
        <f:errors style="color:red" path="makhuyenmai" element="div"></f:errors>
        <br>

        <label for="exampleInputEmail1"> Tên KM <span style="color:red">*</span> :</label>
        <f:input type="text" class="form-control" id="exampleInputEmail1" name="tenkhuyenmai" path="tenkhuyenmai"/>
        <f:errors style="color:red" path="tenkhuyenmai" element="div"></f:errors>
        <br>

        <label for="exampleInputEmail1"> Mô Tả <span style="color:red">*</span> :</label>
        <f:input type="text" class="form-control" id="exampleInputEmail1" name="mota" path="mota"/>
        <f:errors style="color:red" path="mota" element="div"></f:errors>
        <br>

        <label for="exampleInputEmail1"> Chiết Khấu <span style="color:red">*</span> :</label>
        <f:input type="text" class="form-control" id="exampleInputEmail1" name="chietkhau" path="chietkhau"/>
        <f:errors style="color:red" path="chietkhau" element="div"></f:errors>
        <br>

        <label for="exampleInputEmail1"> Ngày Bắt Đầu <span style="color:red">*</span> :</label>
        <f:input type="date" class="form-control" id="exampleInputEmail1" name="ngaybatdau" path="ngaybatdau"/>
        <br>

        <label for="exampleInputEmail1"> Ngày Kết Thúc <span style="color:red">*</span> :</label>
        <f:input type="date" class="form-control" id="exampleInputEmail1" name="ngayketthuc" path="ngayketthuc"/>
        <br>

<%--        <label for="exampleInputEmail1"> Ngày Tạo <span style="color:red">*</span> :</label>--%>
<%--        <f:input type="date" class="form-control" id="exampleInputEmail1" name="ngaytao" path="ngaytao"/>--%>
<%--        <br>--%>

<%--        <label for="exampleInputEmail1"> Ngày Cập Nhật <span style="color:red">*</span> :</label>--%>
<%--        <f:input type="date" class="form-control" id="exampleInputEmail1" name="ngaycapnhat" path="ngaycapnhat"/>--%>
        <br>
    <label for="exampleInputEmail1"> Trạng Thái <span style="color:red">*</span> :</label>
    <f:select class="form-control" id="exampleFormControlSelect1"
    name="trangthai" path="trangthai">
        <option value="0">Đang khuyến mãi</option>
        <option value="1">Dừng khuyến mãi</option>
    </f:select>

<%--        <label for="exampleInputEmail1"> Trạng Thái <span style="color:red">*</span> :</label>--%>
<%--        <f:input type="text" class="form-control" id="exampleInputEmail1" name="trangthai" path="trangthai"/>--%>
<%--        <f:errors style="color:red" path="trangthai" element="div"></f:errors>--%>
        <br>

        <label> Loại Khuyến Mãi:  <span style="color:red">*</span> :</label>
        <f:select class="form-control" path="loaiKhuyenMai">
            <c:forEach items="${listKM}" var="sp">
                <f:option value="${sp.idloaikhuyenmai}">${sp.idloaikhuyenmai}</f:option>
            </c:forEach>
        </f:select> <br>

        <button type="submit" class="btn btn-danger"><i class="fa-solid fa-plus"></i> Thêm</button>
    <a href="/admin/khuyen-mai"><button type="submit" class="btn btn-secondary" ><i class="fa-solid fa-rotate-right"></i> Back</button>

    </f:form>
</div>
<br>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<div class="container">
    <h1> Sửa Đánh Giá</h1>
    <%--@elvariable id="kt" type=""--%>
    <f:form action="${pageContext.request.contextPath}/admin/danh-gia-san-pham/update" method="POST"
            modelAttribute="kt">

        <label for="exampleInputEmail1"> ID Đánh Giá <span style="color:red">*</span> :</label>
        <f:input type="text" class="form-control" value="${kt1.iddanhgia }" id="exampleInputEmail4" name="iddanhgia" path="iddanhgia" readonly="true"/>
        <br>
        <label for="exampleInputEmail1"> Mã Đánh Giá <span style="color:red">*</span> :</label>
        <f:input type="text" class="form-control" value="${kt1.madanhgia }" id="exampleInputEmail1" name="madanhgia" path="madanhgia"/>
        <f:errors style="color:red" path="madanhgia" element="div"></f:errors>
        <br>
        <label for="exampleInputEmail2"> Nội Dung <span style="color:red">*</span> :</label>
        <f:input type="text" class="form-control"  value="${kt1.noidung }" id="exampleInputEmail2" name="noidung" path="noidung"/>
        <f:errors style="color:red" path="noidung" element="div"></f:errors>
        <br>
        <label> Id Sản Phẩm:  <span style="color:red">*</span> :</label>
        <f:select class="form-control" path="sanPham">
            <c:forEach items="${listSP}" var="sp">
                <f:option value="${sp.idsanpham}" selected="${sp.idsanpham==kt1.sanPham.idsanpham?'true':''}">${sp.masanpham}</f:option>
            </c:forEach>
        </f:select>
        <br>
        <button type="submit" class="btn btn-danger"><i class="fa-solid fa-plus"></i> Sửa</button>
    <a href="/admin/danh-gia-san-pham"><button type="submit" class="btn btn-secondary" ><i class="fa-solid fa-rotate-right"></i> Back</button>

    </f:form>


</div>
<br>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<div class="container">
    <h1> Sửa Khuyến Mãi</h1>
    <%--@elvariable id="ctsp" type=""--%>
    <f:form action="${pageContext.request.contextPath}/admin/chi-tiet-sp/update" method="POST" modelAttribute="ctsp">
        <f:input type="hidden" class="form-control" value="${ctsp1.idctsp }" id="exampleInputEmail4" name="idctsp" path="idctsp" readonly="true"/>
        <br>

        <label for="exampleInputEmail1"> Giá Nhập <span style="color:red">*</span> :</label>
        <f:input type="number" class="form-control" value="${ctsp1.gianhap}" id="exampleInputEmail1" name="gianhap" path="gianhap"/>
        <f:errors style="color:red" path="gianhap" element="div"></f:errors>
        <br>

        <label for="exampleInputEmail1"> Giá Bán <span style="color:red">*</span> :</label>
        <f:input type="number" class="form-control" value="${ctsp1.giaban}" id="exampleInputEmail1" name="giaban" path="giaban"/>
        <f:errors style="color:red" path="giaban" element="div"></f:errors>
        <br>

        <label for="exampleInputEmail1"> Mô Tả <span style="color:red">*</span> :</label>
        <f:input type="text" class="form-control" value="${ctsp1.mota}" id="exampleInputEmail1" name="mota" path="mota"/>
        <f:errors style="color:red" path="mota" element="div"></f:errors>
        <br>

        <label for="exampleInputEmail1"> Số Lượng <span style="color:red">*</span> :</label>
        <f:input type="number" class="form-control" value="${ctsp1.soluong}" id="exampleInputEmail1" name="soluong" path="soluong"/>
        <f:errors style="color:red" path="soluong" element="div"></f:errors>
        <br>

        <label for="exampleInputEmail1"> Giảm Giá <span style="color:red">*</span> :</label>
        <f:input type="number" class="form-control" value="${ctsp1.giamgia}" id="exampleInputEmail1" name="giamgia" path="giamgia"/>
        <f:errors style="color:red" path="giamgia" element="div"></f:errors>
        <br>

        <label> Chọn Sản Phẩm:  <span style="color:red">*</span> :</label>
        <f:select class="form-control" path="sanPham">
            <c:forEach items="${listSP}" var="sp">
                <f:option value="${sp.idsanpham}" selected="${sp.idsanpham==ctsp1.sanPham.idsanpham?'true':''}">${sp.tensanpham}</f:option>
            </c:forEach>
        </f:select> <br>

        <label> Chọn Kiểu Dáng:  <span style="color:red">*</span> :</label>
        <f:select class="form-control" path="kieuDang">
            <c:forEach items="${listKD}" var="kd">
                <f:option value="${kd.idkieudang}" selected="${kd.idkieudang==ctsp1.kieuDang.idkieudang?'true':''}">${kd.tenkieudang}</f:option>
            </c:forEach>
        </f:select> <br>

        <label> Chọn Kích Thước:  <span style="color:red">*</span> :</label>
        <f:select class="form-control" path="kichThuoc">
            <c:forEach items="${listKT}" var="kt">
                <f:option value="${kt.idkichthuoc}" selected="${kt.idkichthuoc==ctsp1.kichThuoc.idkichthuoc?'true':''}">${kt.tenkichthuoc}</f:option>
            </c:forEach>
        </f:select> <br>

        <label> Chọn Chất Liệu:  <span style="color:red">*</span> :</label>
        <f:select class="form-control" path="chatLieu">
            <c:forEach items="${listCL}" var="cl">
                <f:option value="${cl.idchatlieu}" selected="${cl.idchatlieu==ctsp1.chatLieu.idchatlieu?'true':''}">${cl.tenchatlieu}</f:option>
            </c:forEach>
        </f:select> <br>

        <label> Chọn Màu Sắc:  <span style="color:red">*</span> :</label>
        <f:select class="form-control" path="mauSac">
            <c:forEach items="${listMS}" var="ms">
                <f:option value="${ms.idmausac}" selected="${ms.idmausac==ctsp1.mauSac.idmausac?'true':''}">${ms.tenmausac}</f:option>
            </c:forEach>
        </f:select> <br>

        <label> Chọn Khuyến Mãi:  <span style="color:red">*</span> :</label>
        <f:select class="form-control" path="khuyenMai">
            <c:forEach items="${listKM}" var="km">
                <f:option value="${km.idkhuyenmai}" selected="${km.idkhuyenmai==ctsp1.khuyenMai.idkhuyenmai?'true':''}">${km.tenkhuyenmai}</f:option>
            </c:forEach>
        </f:select> <br>

        <label> Chọn Ảnh:  <span style="color:red">*</span> :</label>
        <f:select class="form-control" path="anh">
            <c:forEach items="${listAnh}" var="anh">
                <f:option value="${anh.idimage}" selected="${anh.idimage==ctsp1.anh.idimage?'true':''}">${anh.tenimage}</f:option>
            </c:forEach>
        </f:select> <br>

        <label> Chọn Thương Hiệu:  <span style="color:red">*</span> :</label>
        <f:select class="form-control" path="thuongHieu">
            <c:forEach items="${listTH}" var="th">
                <f:option value="${th.idthuonghieu}" selected="${th.idthuonghieu==ctsp1.thuongHieu.idthuonghieu?'true':''}">${th.tenthuonghieu}</f:option>
            </c:forEach>
        </f:select> <br>
        <button type="submit" class="btn btn-danger"><i class="fa-solid fa-plus"></i> Sửa</button>

    </f:form>
</div>
<br>

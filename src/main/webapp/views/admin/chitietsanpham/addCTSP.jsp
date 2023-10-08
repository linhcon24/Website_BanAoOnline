<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<div class="container">
    <h1> Thêm Chi Tiết Sản Phẩm</h1>
    <p style="color: red">${message }</p>
    <%--@elvariable id="ctspForm" type=""--%>
    <f:form modelAttribute="ctspForm" action="${pageContext.request.contextPath}/admin/chi-tiet-sp/add" method="POST"
            enctype="multipart/form-data">

        <label for="exampleInputEmail1"> Giá Nhập <span style="color:red">*</span> :</label>
        <f:input type="number" class="form-control" id="exampleInputEmail1" name="gianhap" path="gianhap"/>
        <f:errors style="color:red" path="gianhap" element="div"></f:errors>

        <label for="exampleInputEmail1"> Giá Bán <span style="color:red">*</span> :</label>
        <f:input type="number" class="form-control" id="exampleInputEmail1" name="giaban" path="giaban"/>
        <f:errors style="color:red" path="giaban" element="div"></f:errors>

        <label for="exampleInputEmail1"> Mô Tả <span style="color:red">*</span> :</label>
        <f:input type="text" class="form-control" id="exampleInputEmail1" name="mota" path="mota"/>
        <f:errors style="color:red" path="mota" element="div"></f:errors>

        <label for="exampleInputEmail1"> Số Lượng <span style="color:red">*</span> :</label>
        <f:input type="number" class="form-control" id="exampleInputEmail1" name="soluong" path="soluong"/>
        <f:errors style="color:red" path="soluong" element="div"></f:errors>

        <label for="exampleInputEmail1"> Giảm Giá <span style="color:red">*</span> :</label>
        <f:input type="number" class="form-control" id="exampleInputEmail1" name="giamgia" path="giamgia"/>
        <f:errors style="color:red" path="giamgia" element="div"></f:errors>

        <label for="sanPham">Chọn Sản Phẩm:</label>
        <select class="form-control" id="sanPham" name="sanPham.idsanpham">
            <option value="">-- Chọn Sản Phẩm --</option>
            <c:forEach items="${sanPhamList}" var="sanPham">
                <option value="${sanPham.idsanpham}">${sanPham.tensanpham}</option>
            </c:forEach>
        </select>

        <label for="kieuDang">Chọn Kiểu Dáng:</label>
        <select class="form-control" id="kieuDang" name="kieuDang.idkieudang">
            <option value="">-- Chọn Kiểu Dáng --</option>
            <c:forEach items="${kieuDangList}" var="kieuDang">
                <option value="${kieuDang.idkieudang}">${kieuDang.tenkieudang}</option>
            </c:forEach>
        </select>

        <label for="kichThuoc">Chọn Kích Thước:</label>
        <select class="form-control" id="kichThuoc" name="kichThuoc.idkichthuoc">
            <option value="">-- Chọn Kích Thước --</option>
            <c:forEach items="${kichThuocList}" var="kichThuoc">
                <option value="${kichThuoc.idkichthuoc}">${kichThuoc.tenkichthuoc}</option>
            </c:forEach>
        </select>

        <label for="chatLieu">Chọn Chất Liệu:</label>
        <select class="form-control" id="chatLieu" name="chatLieu.idchatlieu">
            <option value="">-- Chọn Chất Liệu --</option>
            <c:forEach items="${chatLieuList}" var="chatLieu">
                <option value="${chatLieu.idchatlieu}">${chatLieu.tenchatlieu}</option>
            </c:forEach>
        </select>

        <label for="mauSac">Chọn Màu Sắc:</label>
        <select class="form-control" id="mauSac" name="mauSac.idmausac">
            <option value="">-- Chọn Màu Sắc --</option>
            <c:forEach items="${mauSacList}" var="mauSac">
                <option value="${mauSac.idmausac}">${mauSac.tenmausac}</option>
            </c:forEach>
        </select>

        <label for="khuyenMai">Chọn Khuyến Mãi:</label>
        <select class="form-control" id="khuyenMai" name="khuyenMai.idkhuyenmai">
            <option value="">-- Chọn Khuyến Mãi --</option>
            <c:forEach items="${khuyenMaiList}" var="khuyenMai">
                <option value="${khuyenMai.idkhuyenmai}">${khuyenMai.tenkhuyenmai}</option>
            </c:forEach>
        </select>

        <label for="anh">Chọn Ảnh:</label>
        <select class="form-control" id="anh" name="anh.idimage">
            <option value="">-- Chọn Ảnh --</option>
            <c:forEach items="${anhList}" var="anh">
                <option value="${anh.idimage}">${anh.tenimage}</option>
            </c:forEach>
        </select>

        <label for="thuongHieu">Chọn Thương Hiệu:</label>
        <select class="form-control" id="thuongHieu" name="thuongHieu.idthuonghieu">
            <option value="">-- Chọn Thương Hiệu --</option>
            <c:forEach items="${thuongHieuList}" var="thuongHieu">
                <option value="${thuongHieu.idthuonghieu}">${thuongHieu.tenthuonghieu}</option>
            </c:forEach>
        </select>

        <label for="nhaCungCap">Chọn Nhà Cung Cấp:</label>
        <select class="form-control" id="nhaCungCap" name="nhaCungCap.idnhacungcap">
            <option value="">-- Chọn Nhà Cung Cấp --</option>
            <c:forEach items="${nhaCungCapList}" var="nhaCungCap">
                <option value="${nhaCungCap.idnhacungcap}">${nhaCungCap.tennhacungcap}</option>
            </c:forEach>
        </select>

        <br>
        <button type="submit" class="btn btn-danger"><i class="fa-solid fa-plus"></i> Thêm</button>

    </f:form>
</div>
<br>

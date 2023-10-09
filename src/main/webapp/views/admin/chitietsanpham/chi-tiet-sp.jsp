<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>



<br>
<%--<c:if test="${account.role == 0 }">--%>
<h1 style="text-align: center;"><i class="fa-solid fa-file-invoice"></i> Quản Lý Chi Tiết Sản Phẩm</h1>
<br>
<div class="btnThem">
    <button type="button" class="btn btn-info"><a href="${pageContext.request.contextPath }/admin/chi-tiet-sp/add"><i
            class="fa-solid fa-circle-plus"></i> Thêm Chi Tiết Sản Phẩm</a></button>
</div>
<br>
<table class="table">
    <tr>
        <%--            <td>#</td>--%>
        <td>ID</td>
        <td>Giá Nhập</td>
        <td>Giá Bán</td>
        <td>Mô Tả</td>
        <td>Số Lượng</td>
        <td>Giảm Giá</td>
        <td>Tên Sản Phẩm</td>
        <td>Tên Thương Hiệu</td>
        <td>Tên Nhà Cung Cấp</td>
        <td>Tên Kiểu Dáng</td>
        <td>Tên Kích Thước</td>
        <td>Tên Chất Liệu</td>
        <td>Tên Màu Sắc</td>
        <td>Khuyến Mãi</td>
        <td>Tên Ảnh</td>
        <td>Chức Năng</td>
    </tr>

    <%--        <c:set value="0" var="i" scope="page"></c:set>--%>
    <c:forEach items="${listCTSP}" var="p">
        <%--            <c:set value="${i+1 }" var="i" scope="page" ></c:set>--%>
        <c:if test="${p.trangthai == 0 }">
            <tr>
                    <%--                    <td>${i }</td>--%>
                <td>${p.idctsp}</td>
                <td>${p.gianhap}</td>
                <td>${p.giaban}</td>
                <td>${p.mota}</td>
                <td>${p.soluong}</td>
                <td>${p.giamgia}</td>
                <td>${p.sanPham.tensanpham}</td>
                <td>${p.thuongHieu.tenthuonghieu}</td>
                <td>${p.nhaCungCap.tennhacungcap}</td>
                <td>${p.kieuDang.tenkieudang}</td>
                <td>${p.kichThuoc.tenkichthuoc}</td>
                <td>${p.chatLieu.tenchatlieu}</td>
                <td>${p.mauSac.tenmausac}</td>
                <td>${p.khuyenMai.tenkhuyenmai}</td>
                <td>${p.anh.tenimage}</td>
<%--                <td><img src="${pageContext.request.contextPath}/views/uploads/${p.anh.imageurl1}" alt="Ảnh 1" width="100" height="100" style="border-radius: 50%;"></td>--%>
                <td>
                    <button type="button" class="btn btn-danger btnSua"><a
                            href="${pageContext.request.contextPath}/admin/chi-tiet-sp/update/${p.idctsp }"><i
                            class="fa-solid fa-wrench"></i> Sửa</a></button>
                    <button type="button" class="btn btn-warning btnSua"><a
                            href="${pageContext.request.contextPath}/admin/chi-tiet-sp/delete/${p.idctsp }"><i
                            class="fa-solid fa-trash"></i> Xóa</a></button>
                </td>
            </tr>
        </c:if>
    </c:forEach>
</table>
<div>
    <ul class="pagination">
        <c:forEach begin="1" end="${count}" var="i">
            <li class="page-item">
                <a href="${pageContext.request.contextPath}?pageNum=${i}" class="page-link">${i }</a>
            </li>
        </c:forEach>
    </ul>
</div>
<%--</c:if>--%>
<%--<c:if test="${account == null ||account.role == 1 }">--%>
<%--    <h1>Bạn không có quyền truy cập chức năng này !</h1>--%>
<%--</c:if>--%>


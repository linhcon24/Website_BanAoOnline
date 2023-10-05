<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<br>
<%--<c:if test="${taikhoan.vaitro == 0 }">--%>
    <h1 style="text-align: center;"><i class="fa-solid fa-users-line"></i> Quản Lý Tài Khoản</h1>
    <br>
    <div class="btnThem"><button type="button" class="btn btn-secondary"><a href="${pageContext.request.contextPath }/admin/tai-khoan/add"><i class="fa-solid fa-circle-plus"></i> Thêm Tài Khoản</a></button></div>
    <br>
    <table class="table">
        <tr>
            <td>Id</td>
            <td>Image</td>
            <td>Username</td>
            <td>Password</td>
            <td>Email</td>
            <td>Sdt</td>
            <td>Giới tính</td>
            <td>Vai trò</td>
            <td>Chức năng</td>
        </tr>
        <c:forEach items="${listAccount }" var="p">
            <c:if test="${p.vaitro != 2}">
                <tr>
                    <td>${p.idtaikhoan }</td>
                    <td><img
                            src="${pageContext.request.contextPath }/views/img/${p.image}"
                            height="60" width="70"></td>
                    <td>${p.username}</td>
                    <td>${p.password}</td>
                    <td>${p.email}</td>
                    <td>${p.sdt}</td>
                    <td>${p.gioitinh == true ? 'Nam' : 'Nữ'}</td>
                    <td>${p.vaitro == 0 ? 'Admin' : 'Thành Viên'}</td>
<%--                    <td><c:if test="${p.vaitro == 0 }">Admin</c:if><c:if test="${p.vaitro == 1 }">Thành viên</c:if></td>--%>
                    <td>
                        <button type="button" class="btn btn-success btnSua"> <a href="${pageContext.request.contextPath}/admin/tai-khoan/update/${p.idtaikhoan }"><i class="fa-solid fa-wrench"></i> Sửa</a></button>
                        <button type="button" class="btn btn-warning btnSua"><a href="${pageContext.request.contextPath}/admin/tai-khoan/delete/${p.idtaikhoan }"><i class="fa-solid fa-trash"></i> Xóa</a></button>
                    </td>
                </tr>
            </c:if>
        </c:forEach>
    </table>
    <br>
    <%-- <div class="aa">

               <nav aria-label="Page navigation example">
               <ul class="pagination">
                   <li class="page-item"><a class="page-link" href="users">1</a></li>
                   <c:forEach begin="2" end="${count }" var="i">
                       <li class="page-item"><a class="page-link" href="?page=${i}">${i}</a></li>
                   </c:forEach>
                   </ul>
                   </nav>

    </div> --%>
    <div>
        <ul class="pagination">
            <c:forEach begin="1" end="${count}" var="i">
                <li class="page-item">
                    <a  href="${pageContext.request.contextPath}?pageNum=${i}" class="page-link">${i }</a>
                </li>
            </c:forEach>
        </ul>
    </div>


<%--</c:if>--%>

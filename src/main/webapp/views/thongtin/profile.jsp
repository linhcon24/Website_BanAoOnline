<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<c:if test="${account != null}">

    <section style="background-color: #eee;" modelAttribute="pro">
        <div class="container py-5">
            <div class="row">
                <div class="col">

                </div>
            </div>
            <c:if test="${account.trangthai == 0}">

            <div class="row">
                <div class="col-lg-4">
                    <div class="card mb-4">
                        <div class="card-body text-center">
                            <img src="${pageContext.request.contextPath}/views/img/${account.image}"
                                 alt=""
                                 class="rounded-circle img-fluid" style="width: 150px;">
                            <h5 class="my-3"></h5>
                            <p class="text-muted mb-1">${fn:toUpperCase(account.username)}</p>
                            <p class="text-muted mb-4">Bay Area, San Francisco, CA</p>
                            <div class="d-flex justify-content-center mb-2">
                                <button  style="margin-right: 20px" type="submit" class="btn btn-success btnSua"> <a href="${pageContext.request.contextPath}/profile/edit/${account.idtaikhoan }"><i class="fa-solid fa-wrench"></i> Sửa</a></button>
                                <a href="/index"><button type="submit" class="btn btn-secondary" ><i class="fa-solid fa-rotate-right"></i>Quay lại trang chủ</button></a>

                            </div>
                        </div>
                    </div>
                        <%--    --%>
                </div>
                <div class="col-lg-8">
                    <div class="card mb-4">
                        <div class="card-body">
                            <div class="row">
                                <div class="col-sm-3">
                                    <p class="mb-0">Full Name</p>
                                </div>
                                <div class="col-sm-9">
                                    <p class="text-muted mb-0">${account.username}</p>
                                </div>
                            </div>
                            <hr>
                            <div class="row">
                                <div class="col-sm-3">
                                    <p class="mb-0">Password</p>
                                </div>
                                <div class="col-sm-9">
                                    <p class="text-muted mb-0">${account.password}</p>
                                </div>
                            </div>
                            <hr>
                            <div class="row">
                                <div class="col-sm-3">
                                    <p class="mb-0">Email</p>
                                </div>
                                <div class="col-sm-9">
                                    <p class="text-muted mb-0">${account.email}</p>
                                </div>
                            </div>
                            <hr>
                            <div class="row">
                                <div class="col-sm-3">
                                    <p class="mb-0">Phone</p>
                                </div>
                                <div class="col-sm-9">
                                    <p class="text-muted mb-0">${account.sdt}</p>
                                </div>
                            </div>
                            <hr>
                            <div class="row">
                                <div class="col-sm-3">
                                    <p class="mb-0">Role</p>
                                </div>
                                <div class="col-sm-9">
                                    <p class="text-muted mb-0">${account.vaitro == 1 ? 'Thành Viên' : 'Admin'}</p>
                                </div>
                            </div>
                            <hr>
                        </div>
                    </div>

                </div>
            </div>
        </div>
        </c:if>
    </section>
</c:if>


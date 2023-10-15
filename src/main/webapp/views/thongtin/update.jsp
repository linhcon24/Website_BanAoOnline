<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<c:if test="${account != null}">

    <section style="background-color: #eee;">
        <div class="container py-5">
            <div class="row">
                <div class="col">

                </div>
            </div>
            <%--@elvariable id="edit" type="java"--%>
            <f:form modelAttribute="edit" action="${pageContext.request.contextPath}/profile/edit" enctype="multipart/form-data" method="post">
            <c:if test="${account.trangthai == 0}">
            <f:input type="hidden" class="form-control" id="exampleInputEmail1" name="idtaikhoan"
                     value="${account.idtaikhoan }" path="idtaikhoan"/>
            <div class="row">
                <div class="col-lg-4">
                    <div class="card mb-4">
                        <div class="card-body text-center">

                            <%--@declare id="exampleformcontrolfile1"--%>
                                <label for="exampleFormControlFile1"> Image *:</label> <input
                                type="file" class="form-control-file" id="fileUpload" name="file" />
                            <h5 class="my-3"></h5>

                                <hr>
                            <div class="d-flex justify-content-center mb-2">
                                <button style="margin-right: 20px" type="submit" class="btn btn-primary">Sửa</button>

                                <a href="${pageContext.request.contextPath}/profile/${account.idtaikhoan}"><button type="submit" class="btn btn-secondary" ><i class="fa-solid fa-rotate-right"></i> Back</button></a>

                            </div>
                        </div>
                    </div>

                </div>
                <div class="col-lg-8">
                    <div class="card mb-4">
                        <div class="card-body">
                            <div class="row">
                                <div class="col-sm-3">
                                    <p class="mb-0"> <label for="exampleInputEmail1"> Full Name<span style="color:red">*</span> :</label></p>
                                </div>
                                <div class="col-sm-9">

                                    <f:input type="text" class="form-control" id="exampleInputEmail1"  name="username" value="${account.username }" path="username"/>
                                    <f:errors style="color:red" path="username" element="div"></f:errors>

                                </div>
                            </div>
                            <hr>
                            <div class="row">
                                <div class="col-sm-3">
                                    <p class="mb-0"><label for="exampleInputEmail1"> Password <span style="color:red">*</span> :</label></p>
                                </div>
                                <div class="col-sm-9">
                                    <f:input type="password" class="form-control" id="exampleInputEmail1"  name="password" value="${account.password }" path="password"/>
                                    <f:errors style="color:red" path="password" element="div"></f:errors>
                                </div>
                            </div>
                            <hr>
                            <div class="row">
                                <div class="col-sm-3">
                                    <p class="mb-0"> <label for="exampleInputEmail1"> Email<span style="color:red">*</span> :</label></p>

                                </div>
                                <div class="col-sm-9">
                                    <f:input type="email" id="form2Example37" class="form-control form-control-lg"
                                             name="email" path="email" value="${account.email }"/>
                                    <f:errors style="color:red" path="email" element="div"></f:errors>
                                </div>
                            </div>

                            <hr>
                            <div class="row">
                                <div class="col-sm-3">
                                    <p class="mb-0">Phone</p>
                                </div>
                                <div class="col-sm-9">
                                    <f:input type="number" id="form2Example37" class="form-control form-control-lg"
                                             name="sdt" path="sdt" value="${account.sdt }"/>
                                    <f:errors style="color:red" path="sdt" element="div"></f:errors>
                                </div>
                            </div>
                            <hr>
                            <div class="row">
                                <div class="col-sm-3">
                                    <p class="mb-0">Role</p>
                                </div>
                                <div class="col-sm-9">
                                    <p class="text-muted mb-0" readonly="true">${account.vaitro == 1 ? 'Thành Viên' : 'Admin'}</p>
                                </div>
                            </div>
                            <hr>
                        </div>
                    </div>

                </div>
            </div>
        </div>
        </c:if>
        </f:form>
    </section>
</c:if>


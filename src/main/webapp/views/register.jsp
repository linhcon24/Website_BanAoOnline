<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<link rel="stylesheet"
      href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css"
      integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
      crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script
        src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
<script
        src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
<script src="https://kit.fontawesome.com/999051c9de.js"
        crossorigin="anonymous"></script>

<link rel="stylesheet" href="${pageContext.request.contextPath}/views/css/style.css">

<c:if test="${account == null }">
<section class="vh-100 register" style="background-color: #fff;">
    <div class="container py-5 h-100">
        <div class="row d-flex justify-content-center align-items-center h-100">
            <div class="col col-xl-10">
                <div class="card" style="border-radius: 1rem;">
                    <div class="row g-0">
                        <div class="col-md-6 col-lg-5 d-none d-md-block login">
                            <img src="./views/img/signup1.gif"
                                 alt="login form" class="img-fluid resize"  style="border-radius: 1rem 0 0 1rem;"/>
                        </div>
                        <div class="col-md-6 col-lg-7 d-flex align-items-center">
                            <div class="card-body p-4 p-lg-5 text-black">

                                <form action="register" method="post" modelAttribute="data"
                                      enctype="multipart/form-data">

                                    <div class="d-flex align-items-center mb-3 pb-1">
                                        <span class="h1 fw-bold mb-0"> <h1 class="giua"><i
                                                class="fa-solid fa-square-plus"></i> Đăng ký </h1></span>
                                    </div>
                                    <div class="form-outline mb-4">
                                        <label class="form-label" for="form2Example17"><i class="fa-solid fa-user"></i>
                                            Tài khoản</label>
                                        <input type="text" id="form2Example17" class="form-control form-control-lg"
                                               name="username" path="username"/>
                                        <errors style="color:red" path="username" element="div"></errors>
                                    </div>

                                    <div class="form-outline mb-4">
                                        <label class="form-label" for="form2Example27"><i class="fa-solid fa-lock"></i>
                                            Mật khẩu</label>
                                        <input type="password" id="form2Example27" class="form-control form-control-lg"
                                               name="password" path="password"/>
                                        <errors style="color:red" path="password" element="div"></errors>
                                    </div>
                                    <div class="form-outline mb-4">
                                        <label class="form-label" for="form2Example27"><i class="fa-solid fa-lock"></i>
                                            Nhập lại mật khẩu</label>
                                        <input type="password" id="form2Example47" class="form-control form-control-lg"
                                               name="rePassword" path="rePassword"/>
                                        <errors style="color:red" path="rePassword" element="div"></errors>
                                    </div>
                                    <div class="form-outline mb-4">
                                        <label class="form-label" for="form2Example17"><i
                                                class="fa-solid fa-envelope"></i> Email</label>
                                        <input type="text" id="form2Example37" class="form-control form-control-lg"
                                               name="email" path="email"/>
                                        <errors style="color:red" path="email" element="div"></errors>
                                    </div>
                                    <div class="form-outline mb-4">
                                        <input type="checkbox" name="checkbox"/> Tôi đồng ý với các điều khoản trên!
                                    </div>
                                    <div class="pt-1 mb-4">
                                        <button class="btn btn-dark btn-lg btn-block" type="submit"><i
                                                class="fa-solid fa-square-plus"></i> Đăng ký
                                        </button>
                                    </div>
                                    <p class="mb-5 pb-lg-2 l" style="color: #121216;">
                                        Bạn đã có tài khoản? <a href="login"
                                                                style="color: blue;">Đăng nhập.</a>
                                    </p>
                                </form>

                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
</c:if>
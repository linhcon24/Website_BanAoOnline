
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
    <style>
        @media (max-width: 767.98px) { .border-sm-start-none { border-left: none !important; } }
    </style>
</head>
<body>
<section style="background-color: #eee;">
    <div class="container py-5">
        <c:forEach items="${list.content}"  var="sanPham">
            <div class="row justify-content-center mb-3">
            <div class="col-md-12 col-xl-10">
                <div class="card shadow-0 border rounded-3">
                    <div class="card-body">
                        <div class="row">
                            <div class="col-md-12 col-lg-3 col-xl-3 mb-4 mb-lg-0">
                                <div class="bg-image hover-zoom ripple rounded ripple-surface">
                                    <img src="https://mdbcdn.b-cdn.net/img/Photos/Horizontal/E-commerce/Products/img%20(4).webp"
                                         class="w-100" />
                                    <a href="#!">
                                        <div class="hover-overlay">
                                            <div class="mask" style="background-color: rgba(253, 253, 253, 0.15);"></div>
                                        </div>
                                    </a>
                                </div>
                            </div>
                            <div class="col-md-6 col-lg-6 col-xl-6">
                                <h5>${sanPham.tensanpham}</h5>
                                <div class="d-flex flex-row">
                                    <div class="text-danger mb-1 me-2">
                                        <i class="fa fa-star"></i>
                                        <i class="fa fa-star"></i>
                                        <i class="fa fa-star"></i>
                                        <i class="fa fa-star"></i>
                                    </div>
                                    <span>310</span>
                                </div>
                                <div class="mt-1 mb-0 text-muted small">
                                    <span>100% cotton</span>
                                    <span class="text-primary"> • </span>
                                    <span>Light weight</span>
                                    <span class="text-primary"> • </span>
                                    <span>Best finish<br /></span>
                                </div>
                                <div class="mb-2 text-muted small">
                                    <span>Unique design</span>
                                    <span class="text-primary"> • </span>
                                    <span>For men</span>
                                    <span class="text-primary"> • </span>
                                    <span>Casual<br /></span>
                                </div>
                                <p class="text-truncate mb-4 mb-md-0">
                                    There are many variations of passages of Lorem Ipsum available, but the
                                    majority have suffered alteration in some form, by injected humour, or
                                    randomised words which don't look even slightly believable.
                                </p>
                            </div>
                            <div class="col-md-6 col-lg-3 col-xl-3 border-sm-start-none border-start">
                                <div class="d-flex flex-row align-items-center mb-1">
                                    <h4 class="mb-1 me-1">$13.99</h4>
                                    <span class="text-danger"><s>$20.99</s></span>
                                </div>
                                <h6 class="text-success">Free shipping</h6>
                                <div class="d-flex flex-column mt-4">
                                    <a href="${pageContext.request.contextPath }/product/detail?id=${sanPham.idsanpham}" class="btn btn-primary btn-sm" type="submit">Details</a>
<%--                                    <form action="${pageContext.request.contextPath }/product/add-to-cart" method="post">--%>
<%--                                        <button class="btn btn-outline-primary btn-sm mt-2" type="submit" >--%>
<%--                                            Add to wishlist--%>
<%--                                        </button>--%>
<%--                                    </form>--%>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        </c:forEach>
    </div>
</section>
</body>
</html>
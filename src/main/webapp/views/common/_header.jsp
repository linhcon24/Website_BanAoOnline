<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<div class="input-group">
    <div class="form-outline">
        <input id="search-input" type="search" id="form1" class="form-control " placeholder="Tìm kiếm..."/>
    </div>
    <button id="search-button" type="button" class="btn btn-primary">
        <i class="fas fa-search"></i>
    </button>
</div>
<header>
    <nav class="navbar navbar-expand-lg navbar-light nav">
        <a class="navbar-brand" href="index"><img class="logo"
                                                  src="${pageContext.request.contextPath}/views/img/logotitle.png"></a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item menu">
                        <a class="chu-m" href="${pageContext.request.contextPath}/index"><i class="fa-solid fa-house"></i>
                            Trang chủ<span class="sr-only">(current)</span></a>
                    </li>
                    <li class="nav-item menu">
                        <a class="chu-m" href="${pageContext.request.contextPath}/product"><i
                                class="fa-brands fa-shopify"></i> Sản Phẩm</a>
                    </li>
                    <li class="nav-item menu">
                        <a class="chu-m" href="${pageContext.request.contextPath}/info"><i
                                class="fa-solid fa-circle-info"></i> Giới thiệu</a>
                    </li>
                    <li class="nav-item menu">
                        <a class="chu-m" href="${pageContext.request.contextPath}/contact"><i class="fa-solid fa-phone"></i>
                            Liên hệ</a>
                    </li>


                    <c:if test="${account.vaitro ==0 }">
                        <li class="nav-item menu">
                            <a class="chu-m" href="${pageContext.request.contextPath}/admin/dashboard"><i
                                    class="fa-solid fa-gears"></i> Quản Trị</a>
                        </li>
                    </c:if>


                </ul>

                <div class="button-cangiua">
                    <!--  <button class="nut"><a class="nav-link menu" href="#"><i class="fa-solid fa-magnifying-glass"></i></a></button>https://s2.o7planning.com/templates/o7planning/resources/images/languages/vi.png -->
                    <div style="margin-left: 65px"><a style="color: white" href="?language=vi"><img style="width: 20px"
                                                                                                    src="${pageContext.request.contextPath }/views/img/co-viet-nam.png"></a>
                        | <a style="color: white" href="?language=en"> <img style="width: 20px" alt=""
                                                                            src="https://s2.o7planning.com/templates/o7planning/resources/images/languages/en.png">
                        </a></div>
                    <button class="nut"><a class="nav-link menu" href="${pageContext.request.contextPath }/cart"><i
                            class="fa-solid fa-cart-plus"></i>
                        <p class="soluong"></p><sup style="color: yellow">${totalProduct}</sup></a>

                    </button>
                    <button class="nuthan dropdown show">
                        <a class="dropdown-toggle" href="#" role="button" id="dropdownMenuLink" data-toggle="dropdown"
                           aria-haspopup="true" aria-expanded="false">
                            <i class="fa-solid fa-user"></i> Hi,<!--  , --><c:if
                                test="${account != null }"> ${account.username}</c:if>
                            <c:if test="${account == null }">khách</c:if>
                        </a>
                        <c:choose>
                            <c:when test="${account != null }">
                                <div class="dropdown-menu drop" aria-labelledby="dropdownMenuLink">
                                    <div class="nutdrop">
                                        <a class="dropdown-item"
                                           href="${pageContext.request.contextPath}/profile/${account.idtaikhoan}">Profile</a>
                                        <a class="dropdown-item" href="${pageContext.request.contextPath}/change">Đổi mật
                                            khẩu</a>
                                        <a class="dropdown-item" href="#" onclick="dangXuat()">Logout</a>
                                    </div>
                                </div>
                            </c:when>
                            <c:otherwise>
                                <div class="dropdown-menu drop" aria-labelledby="dropdownMenuLink">
                                    <div class="nutdrop">
                                        <a class="dropdown-item" href="${pageContext.request.contextPath}/login">Login</a>
                                        <a class="dropdown-item"
                                           href="${pageContext.request.contextPath}/register">Register</a>
                                        <a class="dropdown-item" href="${pageContext.request.contextPath}/forget">Forget</a>
                                    </div>
                                </div>
                            </c:otherwise>
                        </c:choose>

                    </button>

                </div>

            </div>

        </div>

    </nav>
</header>
    <script>
    	function dangXuat() {
    		Swal.fire({
    			  title: 'Bạn chắc chắn muốn đăng xuất?',
    			  showCancelButton: true,
    			  confirmButtonText: 'Đăng xuất',
    			}).then((result) => {
    			  /* Read more about isConfirmed, isDenied below */
    			  if (result.isConfirmed) {
    				  Swal.fire('Đăng xuất thành công !', '', 'success');
    				  setTimeout(() => {
    					  location.href = "${pageContext.request.contextPath}/logout";
					}, 2000);


    			  } else if (result.isDenied) {

    			  }
    			})
		}
    </script>
    <script>
        const searchButton = document.getElementById('search-button');
        const searchInput = document.getElementById('search-input');
        searchButton.addEventListener('click', () => {
        const inputValue = searchInput.value;
        alert(inputValue);
        });
    </script>
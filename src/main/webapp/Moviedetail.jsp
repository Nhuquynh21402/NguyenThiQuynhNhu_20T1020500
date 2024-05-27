<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@page import="com.fpt.ojtstem.model.Account"%>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Chi tiết phim</title>

  <!-- 
    - favicon
  -->
  <link rel="shortcut icon" href="./favicon.svg" type="image/svg+xml">

  <!-- 
    - custom css link
  -->
  <link rel="stylesheet" href="./assets/css/style.css">
  <link rel="stylesheet" href="./assets/css/movie.css">

  <!-- 
    - google font link
  -->
  <link rel="preconnect" href="https://fonts.googleapis.com">
  <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
  <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;500;600;700&display=swap" rel="stylesheet">
</head>

<body id="top">

  <!-- 
    - #HEADER
  -->

  <header class="header" data-header>
    <div class="container">

      <div class="overlay" data-overlay></div>

      <a href="./page.jsp" class="logo">
        <img src="./assets/img/logo.jpg" alt="Filmlane logo"  style="height: 80px;  width: 200px;  border-radius: 50px;">
      </a>

      <div class="header-actions">

        <button class="search-btn">
          <ion-icon name="search-outline"></ion-icon>
        </button>

      <% Account acc = (Account) session.getAttribute("user");
       if(acc!= null){%>
       <a href="inforAcc" class="navbar-link"><%=acc.getUserName()%></a>
       <a href="LogoutAction" class="navbar-link">Đăng xuất </a>
       <%}else {%>
       <a href="login" class="navbar-link">Đăng nhập</a>
       <a href="signup" class="navbar-link">Đăng kí </a>
       <%}%>

      </div>

      <button class="menu-open-btn" data-menu-open-btn>
        <ion-icon name="reorder-two"></ion-icon>
      </button>

      <nav class="navbar" data-navbar>

        <div class="navbar-top">

          <a href="./index.html" class="logo">
            <img src="./assets/images/logo.svg" alt="Filmlane logo">
          </a>

          <button class="menu-close-btn" data-menu-close-btn>
            <ion-icon name="close-outline"></ion-icon>
          </button>

        </div>

        <ul class="navbar-list">

          <li>
            <a href="page" class="navbar-link">Trang chủ</a>
          </li>

          <li>
            <a href="#" class="navbar-link">Phim</a>
          </li>

          <li>
            <a href="#" class="navbar-link">Lịch chiếu</a>
          </li>

      

        </ul>

        <ul class="navbar-social-list">

          <li>
            <a href="#" class="navbar-social-link">
              <ion-icon name="logo-twitter"></ion-icon>
            </a>
          </li>

          <li>
            <a href="#" class="navbar-social-link">
              <ion-icon name="logo-facebook"></ion-icon>
            </a>
          </li>

          <li>
            <a href="#" class="navbar-social-link">
              <ion-icon name="logo-pinterest"></ion-icon>
            </a>
          </li>

          <li>
            <a href="#" class="navbar-social-link">
              <ion-icon name="logo-instagram"></ion-icon>
            </a>
          </li>

          <li>
            <a href="#" class="navbar-social-link">
              <ion-icon name="logo-youtube"></ion-icon>
            </a>
          </li>

        </ul>

      </nav>

    </div>
  </header>





  <main>
    <article>

 <section class="product-container">
        <!-- left side -->
        <div class="img-card">
           <img src="img/<s:property value='movie.image' />">
            <!-- small img -->
            <div class="small-Card">
            		<button type="button"
											class="btn btn-primary m-t-15 waves-effect"
											onclick="onBack('<s:property value="movie.movieId" />')" style="width: 100%;">Đặt Vé</button>
                   
            </div>
           
        </div>
        <!-- Right side -->
        <div class="product-info">
            <h3 style="color: white;"><s:property value='movie.movieName' /></h3>
            <h5 style="color: white;">Thể loại: <s:property value='movie.typeName' /></h5>
            <h5 style="color: white;">Đạo diễn: <s:property value='movie.direction' /></h5>
            <h5 style="color: white;">Diễn viên: <s:property value='movie.actor' /></h5>
            <h5 style="color: white;">Thời gian: <s:property value='movie.duration' /> phút</h5>
            <h5 style="color: white;">Nội dung: </h5>
            <p style="color: white;"><s:property value='movie.content' /></p>
          
       </div>
    </section>

 </article>
  </main>




  <!-- 
    - custom js link
  -->
  <script src="./assets/js/script.js"></script>
<script type="text/javascript"> 
function onBack(movieId) {
			window.location.href = "<s:url action='booking'/>?id="+movieId;
		}
</script>
  <!-- 
    - ionicon link
  -->
  <script type="module" src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>
  <script nomodule src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js"></script>
  <style>
.movie-card .card-banner img {
width: 250px;
}
  </style>

</body>

</html>
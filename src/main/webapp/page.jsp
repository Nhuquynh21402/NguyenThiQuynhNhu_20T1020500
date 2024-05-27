<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.fpt.ojtstem.model.Account"%>


<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Filmlane - Best movie collections</title>

  <!-- 
    - favicon
  -->
  <link rel="shortcut icon" href="./favicon.svg" type="image/svg+xml">

  <!-- 
    - custom css link
  -->
  <link rel="stylesheet" href="./assets/css/style.css">

  <!-- 
    - google font link
  -->
  <link rel="preconnect" href="https://fonts.googleapis.com">
  <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
  <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;500;600;700&display=swap" rel="stylesheet">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css"  />
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

      </nav>

    </div>
  </header>





  <main>
    <article>
      <section class="top-rated">
        <div class="container">

            <div class="title-wrapper">
              <p class="section-subtitle"></p>

              <h2 class="h2 section-title">Phim chiếu trong tuần</h2>
            </div>
        

          <ul class="movies-list">

             <s:iterator value="listTop" var="movie">

            <li>
              <div class="movie-card">

              <a href="detail?id=<s:property value='#movie.movieId' />">
                  <figure class="card-banner">
                    <img src="img/<s:property value="#movie.image" />" alt="The Northman movie poster">
                  </figure>
                </a>

                <div class="title-wrapper">
                  <a href="./movie-details.html">
                    <h3 class="card-title"><s:property value="#movie.movieName" /></h3>
                  </a>

                </div>
              </div>
            </li>
        </s:iterator>
          </ul>

        </div>
      </section>







    

    </article>
  </main>













  <!-- 
    - custom js link
  -->
  <script src="./assets/js/script.js"></script>

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
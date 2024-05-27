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
  <link rel="stylesheet" type="text/css" href="style/print/print.min.css" />
<link rel="stylesheet" type="text/css" href="style/css/styleTicket.css" />

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

      <!-- 
        - #HERO
      -->





      <!-- 
        - #UPCOMING
      -->
      <section class="top-rated">
        <div class="container">
        <form method="post" action="#" id="printJS-form">
											<s:iterator value="listInvoice" var="invoice">
												<div class="ticket created-by-anniedotexe">
													<div class="left">
														<div class="image">
															<div class="ticket-number">
																<img src="img/<s:property value="movie.image" />"
																	style="width: 95%; padding-left: 10px; height: 90%;">
															</div>
														</div>
														<div class="ticket-info">
															<div class="show-name">
																<h1>
																	<s:property value="movie.movieName" />
																</h1>
																<h2>
																	<s:property value="movie.actor" />
																</h2>
															</div>
															<div class="time">
																<p>
																	<s:property value="showTime.fromTime" />
																	<span> TO</span>
																	<s:property value="showTime.toTime" />
																</p>
																<p>
																	<s:property value="room.roomName" />
																	<span>@</span> Chỗ ngồi:
																	<s:property value="#invoice.seatId" />
																</p>
															</div>
															<p class="location">
																<span>Như Cinemal</span> <span class="separator"><i
																	class="far fa-smile"></i></span> <span>11/131 Trần Phú,
																	Phước Vĩnh, Huế</span>
															</p>
														</div>
													</div>
													<div class="right">
														<div class="right-info-container">
															<div class="show-name">
																<h1>Như Cinemal</h1>
															</div>
															<div class="time">
																<p>
																	<s:property value="showTime.fromTime" />
																	<span> TO</span>
																	<s:property value="showTime.toTime" />
																</p>
																<p>
																	<s:property value="room.roomName" />
																	<span> @ </span> Chỗ ngồi:
																	<s:property value="#invoice.seatId" />
																</p>
															</div>
															<p class="ticket-number">
																#
																<s:property value="#invoice.invoiceID" />
															</p>
														</div>
													</div>
												</div>
												<br />
											</s:iterator>
										</form>
        

								<button type="button" class="btn btn-dark m-t-15 waves-effect"
									onclick="printJS('printJS-form', 'html')">In</button>
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
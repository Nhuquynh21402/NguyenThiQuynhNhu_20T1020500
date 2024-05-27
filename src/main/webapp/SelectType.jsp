<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@page import="org.hibernate.type.ListType"%>
<%@page import="com.fpt.ojtstem.model.TicketType"%>
<%@page import="com.fpt.ojtstem.model.Account"%>

<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Chi tiết phim</title>
  <link rel="stylesheet" href="./assets/css/style.css">
  <link rel="stylesheet" href="./assets/css/movie.css">
  <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
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
           
        </div>
        <!-- Right side -->
        <div class="product-info">
        <s:form action="buyTicket" method="post">
            <h3 style="color: white;"><s:property value='movie.movieName' /></h3>
            <h5 style="color: white;">Tên phòng : <s:property value='room.roomName' /></h5>
            <h5 style="color: white;">Ngày chiếu: <s:property value='bookingDate' /></h5>
            <h5 style="color: white;">Giờ chiếu : <s:property value='showTime.fromTime' />- <s:property value='showTime.toTime' /></h5>
            <h5 style="color: white;">Ghế       : <s:property value='#session.listSeatId' /></h5>
            <div class="col-sm-6">
												<h5 style="color: white;">Chọn loại vé :</h5>
												 <select
													class="form-control show-tick" name="selectedTicketType"
													id="selectedTicketType">
													<option value="" style="text-align: center;">--
														Chọn loại vé--</option>
													<%
													List<TicketType> listTicket = (List<TicketType>) session.getAttribute("listTicket");
													if (listTicket != null) {
														for (TicketType ticket : listTicket) {
													%>
													<option value="<%=ticket.getTicketTypeName()%>"
														style="text-align: center;"><%=ticket.getTicketTypeName()%></option>
													<%
													}
													}
													%>
												</select>
											</div>
											<br>
											
												<button type="submit"
													class="btn btn-primary m-t-15 waves-effect"
													style="float: right;">Thanh toán</button>
													<button type="button"
											class="btn btn-primary m-t-15 waves-effect"
											onclick="onBack()" style="float: left;">Quay lại</button>
											</div>
										</s:form>
       </div>
         <h5 style="color: white;">Tổng tiền  : <s:property value='total' /></h5>
    </section>

 </article>
  </main>





<script type="text/javascript"> 

function onBack(movieId) {
			window.location.href = "<s:url action='booking'/>?id="+movieId;
		}

	 $(document).ready(function() {
        $("#selectedTicketType").on("change", function() {
            var selectedTicketType = $(this).val();
            window.location.href = "selectedTicketTypeAction?selectedTicketType=" + selectedTicketType;
        });
    });
		function methodPayment() {
			const TicketType = document.getElementById('selectedTicketType').value;
			const MethodPayment = document
					.getElementById('selectedMethodPayment').value;
			console.log(TicketType);
			if (TicketType === "") {
				alert('Bạn chưa chọn lọai vé!!');
			}  else {

				window.location.href = "Payment?selectedTicketType="
						+ TicketType;
			}
		}


</script>
  <script type="module" src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>
  <script nomodule src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js"></script>
  
  
<style>
.movie-card .card-banner img {
width: 250px;
}
</style>
</body>

</html>
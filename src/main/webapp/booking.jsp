<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@page import="com.fpt.ojtstem.dao.MovieDao"%>
<%@page import="com.fpt.ojtstem.model.Schedule"%>
<%@page import="com.fpt.ojtstem.model.ShowTime"%>
<%@page import="com.fpt.ojtstem.model.Room"%>
<%@page import="com.fpt.ojtstem.model.Movie"%>
<%@page import="com.fpt.ojtstem.model.Account"%>

<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Chi tiết phim</title>
<jsp:include page="menu/libUser.jsp" />
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
    </div>
    <!-- Right side -->
<div class="product-info">
    <s:actionerror />
    <form action="Seat" method="post">
        <!-- Chọn ngày chiếu -->
        <div class="col-sm-4">
            <label style="text-align: center;">Chọn ngày chiếu:</label>
            <select class="form-control show-tick" name="bookingDate" id="bookingDate">
                <option value="" style="text-align: center;">-- Chọn ngày --</option>
                <%
                    List<String> showdates = (List<String>) session.getAttribute("showdates");
                    if (showdates != null) {
                        for (String date : showdates) {
                %>
                <option value="<%= date %>" style="text-align: center;"><%= date %></option>
                <%
                        }
                    }
                %>
            </select>
        </div>
        
        <!-- Chọn phòng -->
        <div class="col-sm-3">
            <label style="text-align: center;">Chọn phòng:</label>
            <select class="form-control show-tick" name="selectedRoom" id="selectedRoom">
                <%
                    String selectedRoom = (String) session.getAttribute("selectedRoom");
                    if (selectedRoom != null) {
                        Room room = (Room) session.getAttribute("room");
                %>
                <option value="<%= selectedRoom %>" style="text-align: center;"><%= room.getRoomName() %></option>
                <%
                    } else {
                %>
                <option value="" style="text-align: center;">-- Chọn phòng --</option>
                <%
                    }
                    List<Room> listRoom = (List<Room>) session.getAttribute("listRoom");
                    if (listRoom != null) {
                        for (Room room : listRoom) {
                %>
                <option value="<%= room.getRoomId() %>" style="text-align: center;"><%= room.getRoomName() %></option>
                <%
                        }
                    }
                %>
            </select>
        </div>
        
        <!-- Chọn giờ chiếu -->
        <div class="col-sm-3">
            <label style="text-align: center;">Chọn giờ chiếu:</label>
            <select class="form-control show-tick" name="selectedShowTime" id="selectedShowtime">
                <option value="" style="text-align: center;">-- Chọn giờ chiếu --</option>
                <%
                    List<ShowTime> listShowtime = (List<ShowTime>) session.getAttribute("listShowtime");
                    if (listShowtime != null) {
                        for (ShowTime showTime : listShowtime) {
                %>
                <option value="<%= showTime.getShowTimeID() %>" style="text-align: center;"><%= showTime.getFromTime() %></option>
                <%
                        }
                    }
                %>
            </select>
        </div>
        
        <!-- Nút tìm kiếm -->
        <button type="submit" style="float: right; width: 80px; height: 50px; float: right;">
            Tìm kiếm
        </button>
    </form>
</div>
</section>
<section style="    padding-bottom: 100px;" >
							<br>
							<h2 style="color:#fff">SƠ ĐỒ CHỖ NGỒI</h2>

										<form action="ConfirmTicket" method="post">
											<div class="card" style="background-color: #000;">

												<div class="screen"></div>
												<s:if test="isSchedule">
													<div class="card"
														style="padding-left: 90px; border: 3px solid; padding-right: 30px; background-color: #000;">


														<div class="row">
															<s:if test="seatIdList.contains('A1')">
																<div class="col col-lg-1 place mx-auto  seat occupied"
																	id="A1">A1</div>
															</s:if>
															<s:else>
																<div class="col col-lg-1 place mx-auto  seat unbooked"
																	id="A1">A1</div>
															</s:else>

															<s:if test="seatIdList.contains('A2')">
																<div class="col col-lg-1 place mx-auto occupied seat"
																	id="A2">A2</div>
															</s:if>
															<s:else>
																<div class="col col-lg-1 place mx-auto unbooked seat"
																	id="A2">A2</div>
															</s:else>

															<s:if test="seatIdList.contains('A3')">
																<div class="col col-lg-1 place mx-auto  seat occupied"
																	id="A3">A3</div>
															</s:if>
															<s:else>
																<div class="col col-lg-1 place mx-auto  seat unbooked"
																	id="A3">A3</div>
															</s:else>


															<s:if test="seatIdList.contains('A4')">
																<div class="col col-lg-1 place mx-auto  seat occupied"
																	id="A4">A4</div>
															</s:if>
															<s:else>
																<div class="col col-lg-1 place mx-auto  seat unbooked"
																	id="A4">A4</div>
															</s:else>

															<s:if test="seatIdList.contains('A5')">
																<div class="col col-lg-1 place mx-auto  seat occupied"
																	id="A5">A5</div>
															</s:if>
															<s:else>
																<div class="col col-lg-1 place mx-auto  seat unbooked"
																	id="A5">A5</div>
															</s:else>



															<s:if test="seatIdList.contains('A6')">
																<div class="col col-lg-1 place mx-auto  seat occupied"
																	id="A6">A6</div>
															</s:if>
															<s:else>
																<div class="col col-lg-1 place mx-auto  seat unbooked"
																	id="A6">A6</div>
															</s:else>
															<s:if test="seatIdList.contains('A7')">
																<div class="col col-lg-1 place mx-auto  seat occupied"
																	id="A7">A7</div>
															</s:if>
															<s:else>
																<div class="col col-lg-1 place mx-auto  seat unbooked"
																	id="A7">A7</div>
															</s:else>


															<s:if test="seatIdList.contains('A8')">
																<div class="col col-lg-1 place mx-auto  seat occupied"
																	id="A8">A8</div>
															</s:if>
															<s:else>
																<div class="col col-lg-1 place mx-auto  seat unbooked"
																	id="A8">A8</div>
															</s:else>

															<s:if test="seatIdList.contains('A9')">
																<div class="col col-lg-1 place mx-auto  seat occupied"
																	id="A9">A9</div>
															</s:if>
															<s:else>
																<div class="col col-lg-1 place mx-auto  seat unbooked"
																	id="A9">A9</div>
															</s:else>

															<s:if test="seatIdList.contains('A10')">
																<div class="col col-lg-1 place mx-auto  seat occupied"
																	id="A10">A10</div>
															</s:if>
															<s:else>
																<div class="col col-lg-1 place mx-auto  seat unbooked"
																	id="A10">A10</div>
															</s:else>

														</div>
														<div class="row">
															<s:if test="seatIdList.contains('B1')">
																<div class="col col-lg-1 place mx-auto  seat occupied"
																	id="B1">B1</div>
															</s:if>
															<s:else>
																<div class="col col-lg-1 place mx-auto  seat unbooked"
																	id="B1">B1</div>
															</s:else>

															<s:if test="seatIdList.contains('B2')">
																<div class="col col-lg-1 place mx-auto occupied seat"
																	id="B2">B2</div>
															</s:if>
															<s:else>
																<div class="col col-lg-1 place mx-auto unbooked seat"
																	id="B2">B2</div>
															</s:else>

															<s:if test="seatIdList.contains('B3')">
																<div class="col col-lg-1 place mx-auto  seat occupied"
																	id="B3">B3</div>
															</s:if>
															<s:else>
																<div class="col col-lg-1 place mx-auto  seat unbooked"
																	id="B3">B3</div>
															</s:else>


															<s:if test="seatIdList.contains('B4')">
																<div class="col col-lg-1 place mx-auto  seat occupied"
																	id="B4">B4</div>
															</s:if>
															<s:else>
																<div class="col col-lg-1 place mx-auto  seat unbooked"
																	id="B4">B4</div>
															</s:else>

															<s:if test="seatIdList.contains('B5')">
																<div class="col col-lg-1 place mx-auto  seat occupied"
																	id="B5">B5</div>
															</s:if>
															<s:else>
																<div class="col col-lg-1 place mx-auto  seat unbooked"
																	id="B5">B5</div>
															</s:else>



															<s:if test="seatIdList.contains('B6')">
																<div class="col col-lg-1 place mx-auto  seat occupied"
																	id="A6">B6</div>
															</s:if>
															<s:else>
																<div class="col col-lg-1 place mx-auto  seat unbooked"
																	id="B6">B6</div>
															</s:else>
															<s:if test="seatIdList.contains('B7')">
																<div class="col col-lg-1 place mx-auto  seat occupied"
																	id="B7">B7</div>
															</s:if>
															<s:else>
																<div class="col col-lg-1 place mx-auto  seat unbooked"
																	id="B7">B7</div>
															</s:else>


															<s:if test="seatIdList.contains('B8')">
																<div class="col col-lg-1 place mx-auto  seat occupied"
																	id="B8">B8</div>
															</s:if>
															<s:else>
																<div class="col col-lg-1 place mx-auto  seat unbooked"
																	id="B8">B8</div>
															</s:else>

															<s:if test="seatIdList.contains('B9')">
																<div class="col col-lg-1 place mx-auto  seat occupied"
																	id="B9">B9</div>
															</s:if>
															<s:else>
																<div class="col col-lg-1 place mx-auto  seat unbooked"
																	id="B9">B9</div>
															</s:else>

															<s:if test="seatIdList.contains('B10')">
																<div class="col col-lg-1 place mx-auto  seat occupied"
																	id="B10">B10</div>
															</s:if>
															<s:else>
																<div class="col col-lg-1 place mx-auto  seat unbooked"
																	id="B10">B10</div>
															</s:else>

														</div>
														<div class="row">
															<s:if test="seatIdList.contains('C1')">
																<div class="col col-lg-1 place mx-auto  seat occupied"
																	id="C1">C1</div>
															</s:if>
															<s:else>
																<div class="col col-lg-1 place mx-auto  seat unbooked"
																	id="C1">C1</div>
															</s:else>

															<s:if test="seatIdList.contains('C2')">
																<div class="col col-lg-1 place mx-auto occupied seat"
																	id="C2">C2</div>
															</s:if>
															<s:else>
																<div class="col col-lg-1 place mx-auto unbooked seat"
																	id="C2">C2</div>
															</s:else>

															<s:if test="seatIdList.contains('C3')">
																<div class="col col-lg-1 place mx-auto  seat occupied"
																	id="C3">C3</div>
															</s:if>
															<s:else>
																<div class="col col-lg-1 place mx-auto  seat unbooked"
																	id="C3">C3</div>
															</s:else>


															<s:if test="seatIdList.contains('C4')">
																<div class="col col-lg-1 place mx-auto  seat occupied"
																	id="C4">C4</div>
															</s:if>
															<s:else>
																<div class="col col-lg-1 place mx-auto  seat unbooked"
																	id="C4">C4</div>
															</s:else>

															<s:if test="seatIdList.contains('C5')">
																<div class="col col-lg-1 place mx-auto  seat occupied"
																	id="C5">C5</div>
															</s:if>
															<s:else>
																<div class="col col-lg-1 place mx-auto  seat unbooked"
																	id="C5">C5</div>
															</s:else>



															<s:if test="seatIdList.contains('C6')">
																<div class="col col-lg-1 place mx-auto  seat occupied"
																	id="C6">C6</div>
															</s:if>
															<s:else>
																<div class="col col-lg-1 place mx-auto  seat unbooked"
																	id="C6">C6</div>
															</s:else>
															<s:if test="seatIdList.contains('C7')">
																<div class="col col-lg-1 place mx-auto  seat occupied"
																	id="C7">C7</div>
															</s:if>
															<s:else>
																<div class="col col-lg-1 place mx-auto  seat unbooked"
																	id="C7">C7</div>
															</s:else>


															<s:if test="seatIdList.contains('C8')">
																<div class="col col-lg-1 place mx-auto  seat occupied"
																	id="C8">C8</div>
															</s:if>
															<s:else>
																<div class="col col-lg-1 place mx-auto  seat unbooked"
																	id="C8">C8</div>
															</s:else>

															<s:if test="seatIdList.contains('C9')">
																<div class="col col-lg-1 place mx-auto  seat occupied"
																	id="C9">C9</div>
															</s:if>
															<s:else>
																<div class="col col-lg-1 place mx-auto  seat unbooked"
																	id="C9">C9</div>
															</s:else>

															<s:if test="seatIdList.contains('C10')">
																<div class="col col-lg-1 place mx-auto  seat occupied"
																	id="C10">C10</div>
															</s:if>
															<s:else>
																<div class="col col-lg-1 place mx-auto  seat unbooked"
																	id="C10">C10</div>
															</s:else>
														</div>
														
																<div class="row">
															<s:if test="seatIdList.contains('D1')">
																<div class="col col-lg-1 place mx-auto  seat occupied"
																	id="D1">D1</div>
															</s:if>
															<s:else>
																<div class="col col-lg-1 place mx-auto  seat unbooked"
																	id="D1">D1</div>
															</s:else>

															<s:if test="seatIdList.contains('D2')">
																<div class="col col-lg-1 place mx-auto occupied seat"
																	id="D2">D2</div>
															</s:if>
															<s:else>
																<div class="col col-lg-1 place mx-auto unbooked seat"
																	id="D2">D2</div>
															</s:else>

															<s:if test="seatIdList.contains('D3')">
																<div class="col col-lg-1 place mx-auto  seat occupied"
																	id="D3">D3</div>
															</s:if>
															<s:else>
																<div class="col col-lg-1 place mx-auto  seat unbooked"
																	id="D3">D3</div>
															</s:else>


															<s:if test="seatIdList.contains('D4')">
																<div class="col col-lg-1 place mx-auto  seat occupied"
																	id="D4">D4</div>
															</s:if>
															<s:else>
																<div class="col col-lg-1 place mx-auto  seat unbooked"
																	id="D4">D4</div>
															</s:else>

															<s:if test="seatIdList.contains('D5')">
																<div class="col col-lg-1 place mx-auto  seat occupied"
																	id="D5">D5</div>
															</s:if>
															<s:else>
																<div class="col col-lg-1 place mx-auto  seat unbooked"
																	id="D5">D5</div>
															</s:else>



															<s:if test="seatIdList.contains('D6')">
																<div class="col col-lg-1 place mx-auto  seat occupied"
																	id="D6">D6</div>
															</s:if>
															<s:else>
																<div class="col col-lg-1 place mx-auto  seat unbooked"
																	id="D6">D6</div>
															</s:else>
															<s:if test="seatIdList.contains('D7')">
																<div class="col col-lg-1 place mx-auto  seat occupied"
																	id="D7">D7</div>
															</s:if>
															<s:else>
																<div class="col col-lg-1 place mx-auto  seat unbooked"
																	id="D7">D7</div>
															</s:else>


															<s:if test="seatIdList.contains('D8')">
																<div class="col col-lg-1 place mx-auto  seat occupied"
																	id="D8">D8</div>
															</s:if>
															<s:else>
																<div class="col col-lg-1 place mx-auto  seat unbooked"
																	id="D8">D8</div>
															</s:else>

															<s:if test="seatIdList.contains('D9')">
																<div class="col col-lg-1 place mx-auto  seat occupied"
																	id="D9">D9</div>
															</s:if>
															<s:else>
																<div class="col col-lg-1 place mx-auto  seat unbooked"
																	id="D9">D9</div>
															</s:else>

															<s:if test="seatIdList.contains('D10')">
																<div class="col col-lg-1 place mx-auto  seat occupied"
																	id="D10">D10</div>
															</s:if>
															<s:else>
																<div class="col col-lg-1 place mx-auto  seat unbooked"
																	id="D10">D10</div>
															</s:else>
														</div>
														
														
																<div class="row">
															<s:if test="seatIdList.contains('I1')">
																<div class="col col-lg-1 place mx-auto  seat occupied"
																	id="I1">I1</div>
															</s:if>
															<s:else>
																<div class="col col-lg-1 place mx-auto  seat unbooked"
																	id="I1">I1</div>
															</s:else>

															<s:if test="seatIdList.contains('I2')">
																<div class="col col-lg-1 place mx-auto occupied seat"
																	id="I2">I2</div>
															</s:if>
															<s:else>
																<div class="col col-lg-1 place mx-auto unbooked seat"
																		id="I2">I2</div>
															</s:else>

															<s:if test="seatIdList.contains('I3')">
																<div class="col col-lg-1 place mx-auto  seat occupied"
																	id="I3">I3</div>
															</s:if>
															<s:else>
																<div class="col col-lg-1 place mx-auto  seat unbooked"
																	id="I3">I3</div>
															</s:else>


															<s:if test="seatIdList.contains('I4')">
																<div class="col col-lg-1 place mx-auto  seat occupied"
																	id="I4">I4</div>
															</s:if>
															<s:else>
																<div class="col col-lg-1 place mx-auto  seat unbooked"
																	id="I4">I4</div>
															</s:else>

															<s:if test="seatIdList.contains('I5')">
																<div class="col col-lg-1 place mx-auto  seat occupied"
																	id="I5">I5</div>
															</s:if>
															<s:else>
																<div class="col col-lg-1 place mx-auto  seat unbooked"
																	id="I5">I5</div>
															</s:else>



															<s:if test="seatIdList.contains('I6')">
																<div class="col col-lg-1 place mx-auto  seat occupied"
																	id="I6">I6</div>
															</s:if>
															<s:else>
																<div class="col col-lg-1 place mx-auto  seat unbooked"
																	id="I6">I6</div>
															</s:else>
															<s:if test="seatIdList.contains('I7')">
																<div class="col col-lg-1 place mx-auto  seat occupied"
																	id="I7">I7</div>
															</s:if>
															<s:else>
																<div class="col col-lg-1 place mx-auto  seat unbooked"
																	id="I7">I7</div>
															</s:else>


															<s:if test="seatIdList.contains('I8')">
																<div class="col col-lg-1 place mx-auto  seat occupied"
																	id="I8">I8</div>
															</s:if>
															<s:else>
																<div class="col col-lg-1 place mx-auto  seat unbooked"
																	id="I8">I8</div>
															</s:else>

															<s:if test="seatIdList.contains('I9')">
																<div class="col col-lg-1 place mx-auto  seat occupied"
																	id="I9">I9</div>
															</s:if>
															<s:else>
																<div class="col col-lg-1 place mx-auto  seat unbooked"
																	id="I9">I9</div>
															</s:else>

															<s:if test="seatIdList.contains('I10')">
																<div class="col col-lg-1 place mx-auto  seat occupied"
																	id="I10">I10</div>
															</s:if>
															<s:else>
																<div class="col col-lg-1 place mx-auto  seat unbooked"
																	id="I10">I10</div>
															</s:else>
														</div>
													</div>

													<div class="card">
														<ul class="showcase">
															<li>
																<div class="seat"></div> <small>Ghế trống</small>
															</li>
															<li>
																<div class="seat selected"></div> <small>Ghế
																	đang chọn</small>
															</li>
															<li>
																<div class="seat occupied"></div> <small>Ghế đã
																	chọn</small>
															</li>
														</ul>
													</div>
												</s:if>
												<s:else>
													<h2>Không có lịch chiếu cho kết quả tìm kiếm này!!!!</h2>
												</s:else>
												<button type="button"
													class="btn btn-primary m-t-15 waves-effect"
													style="float: right;" onclick=ConfirmTicket()>Tiếp
													theo</button>
											</div>

										</form>
								</section>


 </article>
  </main>


<jsp:include page="menu/lib.jsp" />

  <!-- 
    - custom js link
  -->
  <script src="./assets/js/script.js"></script>
<script type="text/javascript"> 
function onBack(movieId) {
			window.location.href = "<s:url action='booking'/>?id="+movieId;
		}
		
	$("#bookingDate").on("change", function() {
	    var bookingDate = $(this).val();
	    window.location.href = "dateAction?bookingDate=" + bookingDate;
	});
	$('#selectedRoom').change(
		function(){
			var selectedRoom = $(this).val();
			window.location.href = "roomAction?selectedRoom=" + selectedRoom;
		}
		)	
		function ConfirmTicket() {
		    var selectedSeats = document.querySelectorAll('.place.selected');
		    var seatIds = [];
		    selectedSeats.forEach(function(seat) {
		        seatIds.push(seat.textContent);
		    });
		    console.log(seatIds);
		    if (seatIds.length === 0) {
		        alert('Bạn chưa chọn ghế!!');
		    } else {
		        var seatIdsParam = seatIds.join(",");
		        window.location.href = "Ticket?listSeatId=" + seatIdsParam;
		    }
		}
		
		
		            $(function () {
		            	  $(".place").click(function () {
		            	    $(this).toggleClass("active");
		            	  });
		            	  $(".unbooked").attr("title","Unbooked");
		            	  $(".taken").attr("title","Taken");
		            	});

		            	$("#submit").click(function () {
		            	  $(".place").each(function () {
		            	    if ($(this).hasClass("active")) {
		            	      $(this).addClass("taken");
		            	      $(this).removeClass("unbooked");
		            	      $(this).attr("title","Taken");
		            	      $(this).addClass("occupied");
		            	    }
		            	  });
		            	});

		            	const container = document.querySelector('.container')
		            	const seats = document.querySelectorAll('.row .seat:not(.occupied)')
		            	const count = document.getElementById('count')

		          
                        document.addEventListener('click', function (e) {
                         console.log(e.target);
                            if (e.target.classList.contains('seat') && !e.target.classList.contains('occupied')) {
                          console.log(e.target);
                    e.target.classList.toggle('selected');
                       updateSelectedCount();
                      }
                       });

		            	function updateSelectedCount() {
		            	  const selectedSeats = document.querySelectorAll('.row .seat.selected')
		            	  const selectedSeatsCount = selectedSeats.length
		            	  count.innerText = selectedSeatsCount
		            	}
		            	
		            	document.getElementById("selectedRoom").addEventListener('change',function() {
		        		    var selectedValue = $(this).val();
		        		    let data = [];
		        			console.log("ngay : ", selectedValue);
		        		    <%for (Room room : listRoom) {%>
		        		            data.push('<%=room.getRoomId()%>');
		        	<%}%>
		            	})
		
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
.form-control {
    background-color: hsl(225, 25%, 9%);
}
  </style>

</body>

</html>
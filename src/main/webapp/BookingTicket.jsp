
<%@page import="com.fpt.ojtstem.dao.MovieDao"%>
<%@page import="com.fpt.ojtstem.model.Schedule"%>
<%@page import="com.fpt.ojtstem.model.ShowTime"%>
<%@page import="com.fpt.ojtstem.model.Room"%>
<%@page import="com.fpt.ojtstem.model.Movie"%>
<%@page import="java.util.List"%>
<%@page import="com.fpt.ojtstem.model.Account"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<%@ page import="java.util.Calendar"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="java.util.Date"%>
<%@ page import="java.util.Locale"%>
<%@ page import="java.text.DateFormatSymbols"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Admin_Quản lý bán vé</title>
<head>
<jsp:include page="menu/lib_Head.jsp" />
<link href="style/css/styleSeat.css" rel="stylesheet">
</head>
<body class="theme-red">
	<jsp:include page="menu/nav_nv.jsp" />
	<section class="content">
		<div class="row clearfix">
			<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
				<div class="card">

					<div class="header">
						<h1 style="text-align: center;">CHỌN CHỖ NGỒI</h1>
					</div>
					<div class="body">
						<br>
						<s:actionerror />

						<div class="row clearfix">
							<div class="col-sm-12">
								<form action="showSeat" method="post">
									<div class="col-sm-3">
										<label style="text-align: center;">Chọn phim:</label> <select
											class="form-control show-tick" name="selectedMovie"
											id="selectedMovie">
											<%
											String selectedMovie = (String) session.getAttribute("selectedMovie");
											if (selectedMovie != null) {
												MovieDao movieDao = new MovieDao();
												Movie movie = movieDao.getOneMovie(selectedMovie);
											%>

											<option value="<%=selectedMovie%>"
												style="text-align: center;">--
												<%=movie.getMovieName()%> --
											</option>
											<%
											} else {
											%>
											<option value="" style="text-align: center;">-- Chọn
												phim --</option>
											<%
											}
											List<Movie> listMovie = (List<Movie>) session.getAttribute("movies");
											if (listMovie != null) {
											for (Movie movie : listMovie) {
											%>
											<option value="<%=movie.getMovieId()%>"
												style="text-align: center;"><%=movie.getMovieName()%></option>
											<%
											}
											}
											%>
										</select>
									</div>


									<div class="col-sm-3">
										<label style="text-align: center;">Chọn phòng:</label> <select
											class="form-control show-tick" name="selectedRoom"
											id="selectedRoom">
											<%
											String selectedRoom = (String) session.getAttribute("selectedRoom");
											if (selectedRoom != null) {
												Room room = (Room) session.getAttribute("room");
											%>
											<option value="<%=selectedRoom%>" style="text-align: center;"><%=room.getRoomName()%></option>
											<%
											} else {
											%>
											<option value="" style="text-align: center;">-- Chọn
												phòng --</option>

											<%
											}
											List<Room> listRoom = (List<Room>) session.getAttribute("listRoom");
											if (listRoom != null) {
											for (Room room : listRoom) {
											%>
											<option value="<%=room.getRoomId()%>"
												style="text-align: center;"><%=room.getRoomName()%></option>
											<%
											}
											}
											%>
										</select>

									</div>


									<div class="col-xs-3">
										<label style="text-align: center;">Chọn ngày chiếu:</label>
										<%
										List<String> showdates = (List<String>) session.getAttribute("showdates");
										if (showdates != null && !showdates.isEmpty()) {
										%>
										<select class="form-control show-tick" name="bookingDate"
											id="bookingDate">
											<%
											String bookingDate = (String) session.getAttribute("bookingDate");
											if (bookingDate != null) {
											%>

											<option value="<%=bookingDate%>" style="text-align: center;"><%=bookingDate%></option>
											<%
											} else {
											%>

											<option value="" style="text-align: center;">-- Chọn
												ngày --</option>
											<%
											}
											%>
											<%
											for (String date : showdates) {
											%>
											<option value="<%=date%>" style="text-align: center;"><%=date%></option>
											<%
											}
											}
											%>
										</select>
										<%
										if (showdates == null || showdates.isEmpty()) {
										%>
										<div class="input-group date"
											id="bs_datepicker_component_container">
											<div class="form-line">
												<input type="text" class="form-control"
													placeholder="----chọn ngày-----" id="bookingDate"
													name="bookingDate">
											</div>
											<span class="input-group-addon"><i
												class="material-icons">date_range</i></span>
										</div>
										<%
										}
										%>

									</div>

									<div class="col-sm-2">
										<label style="text-align: center;">Chọn giờ chiếu:</label> <select
											class="form-control show-tick" name="selectedShowTime"
											id="selectedShowtime">
											<option value="" style="text-align: center;">-- Chọn giờ chiếu --</option>
											<%
											List<ShowTime> listShowtime = (List<ShowTime>) session.getAttribute("listShowtime");
											if (listShowtime != null) {
												for (ShowTime showTime : listShowtime) {
											%>
											<option value="<%=showTime.getShowTimeID()%>"
												style="text-align: center;"><%=showTime.getFromTime()%></option>
											<%
											}
											}
											%>
										</select>
									</div>
									<button type="submit" onclick()
										style="float: right; width: 80px; height: 50px; float: right;">
										Tìm kiếm</button>

								</form>
							</div>
							<br>
						</div>
					<!-- 	<ul>
							<li class="header" style="background-color: #A9A9A9"></li>
						</ul> -->


					<div class="row clearfix">
							<div class="col-sm-12">
							<br>
							<h2>SƠ ĐỒ CHỖ NGỒI</h2>

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
									</div>
								</div>
							</div>

						</div>
					</div>
				</div>
	</section>
    <style>
    label{
    color: #000;
    }
    </style>
	<jsp:include page="menu/lib.jsp" />

	<script>
	 $("#bookingDate").on("change", function() {
	    var bookingDateString = $(this).val();
	    const bookingDate = new Date(bookingDateString);
	    console.log("ngay dat ve: ", bookingDate);
	    const currentDate = new Date();
	    console.log("ngay hien tai: ", currentDate);

	    if (bookingDate.getFullYear() < currentDate.getFullYear() ||
	        (bookingDate.getFullYear() === currentDate.getFullYear() && bookingDate.getMonth() < currentDate.getMonth()) ||
	        (bookingDate.getFullYear() === currentDate.getFullYear() && bookingDate.getMonth() === currentDate.getMonth() && bookingDate.getDate() < currentDate.getDate())) {
	        $(this).val(null);
	        alert('Ngày được chọn không hợp lệ!!');
	    }
	});

	$("#bookingDate").on("change", function() {
	    var bookingDate = $(this).val();
	    window.location.href = "bookingDateAction?bookingDate=" + bookingDate;
	});

	$("#selectedMovie").change(
			function(){
				var selectedMovie = $(this).val();
				window.location.href = "bookingTicketAction?selectedMovie=" +selectedMovie;
				
			}
			)
$('#selectedRoom').change(
		function(){
			var selectedRoom = $(this).val();
			window.location.href = "selectedRoomAction?selectedRoom=" + selectedRoom;
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
		        window.location.href = "ConfirmTicket?listSeatId=" + seatIdsParam;
		    }
		}
	
    <%--  document.getElementById("selectedMovie").addEventListener('change',function() {
		    var selectedValue = $(this).val();
		    let data = [];
			console.log("ngay : ", selectedValue);
		    <%for (Movie movie : listMovie) {%>
		            data.push('<%=movie.getMovieId()%>');
	<%}%>
		console.log("ngay hien tai: ", data);
		 if (selectedValue !== null && selectedValue !== "") {
		        if (!data.includes(selectedValue)) {
		            alert("Giá trị không hợp lệ.");
		            $(this).val("");
		        }
		    } else {
		        alert("Vui lòng chọn một phim.");
		    }
     }); --%>
     document.getElementById("selectedMovie").addEventListener('change', function() {
    	    var selectedValue = $(this).val();
    	    let data = [];
    	    console.log("Ngày: ", selectedValue);
    	    <%for (Movie movie : listMovie) {%>
    	        data.push('<%=movie.getMovieId()%>');
    	    <%}%>
    	    console.log("Danh sách phim: ", data);
    	    if (selectedValue === null || selectedValue === "") {
    	        alert("Vui lòng chọn một phim.");
    	        return;
    	    }
    	    if (!data.includes(selectedValue)) {
    	        alert("Giá trị không hợp lệ.");
    	        $(this).val("");
    	    }
    	});
     document.getElementById("selectedRoom").addEventListener('change',function() {
		    var selectedValue = $(this).val();
		    let data = [];
			console.log("ngay : ", selectedValue);
		    <%for (Room room : listRoom) {%>
		            data.push('<%=room.getRoomId()%>');
	<%}%>
		console.log("ngay hien tai: ", data);
					if (!data.includes(selectedValue)) {
						alert("Giá trị không hợp lệ.");
						$(this).val("");
					}
				}); 
     document.getElementById("selectedShowtime").addEventListener('change',function() {
		    var selectedValue = $(this).val();
		    let data = [];
			console.log("ngay : ", selectedValue);
		    <%for (ShowTime showtime : listShowtime) {%>
		            data.push('<%=showtime.getShowTimeID()%>');
	<%}%>
		console.log("ngay hien tai: ", data);
					if (!data.includes(selectedValue)) {
						alert("Giá trị không hợp lệ.");
						$(this).val("");
					}
				}); 
  
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
		            	var today = new Date();

        
        var formattedDate = ('0' + (today.getMonth() + 1)).slice(-2) + '/' + ('0' + today.getDate()).slice(-2) + '/' + today.getFullYear();
        document.getElementById('bookingDate').value = formattedDate;
		            	
	</script>
	
	
	 <%
        String errorMessage = (String) request.getAttribute("errorMessage");
        if (errorMessage != null && !errorMessage.isEmpty()) {
    %>
            <script>
            console.log("Lỗi: ");
                alert("<%= errorMessage %>");
            </script>
    <%
        }
    %> 

</body>

</html>



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
	<jsp:include page="menu/Navigation.jsp" />
	<section class="content">
		<div class="row clearfix">
			<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
				<div class="card">

					<div class="header">
						<h1 style="text-align: center;">Thêm lịch chiếu</h1>
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
									<label>Chọn Phòng chiếu</label>
										<div class="form-group">
											<div class="form-line">
												<div class="demo-checkbox">
													<%
													List<Room> listRoom = (List<Room>) session.getAttribute("listRoom");
													if (listRoom != null) {
														for (Room room : listRoom) {
													%>
                                                     
													<input type="checkbox" id="<%=room.getRoomId()%>"
														class="filled-in chk-col-red" name="schedule.roomId"
														value="<%=room.getRoomId()%>" /> <label
														for="<%=room.getRoomId()%>"><%=room.getRoomName()%></label>
                                                     

							
													<%
													}
													}
													%>
												</div>
											</div>
										</div>
										<label>Chọn giờ chiếu</label>
										<div class="form-group">
											<div class="form-line">
												<div class="demo-checkbox">
													<%
													List<ShowTime> listShowTime = (List<ShowTime>) session.getAttribute("listShowTime");
													if (TypeName != null) {
														for (ShowTime showtime : listShowTime) {
													%>


													<input type="checkbox" id="<%=showtime.getFromTime()%>"
														class="filled-in chk-col-red" name="schedule.showTimeId"
														value="<%=showtime.getShowTimeID()%>" /> <label
														for="<%=showtime.getFromTime()%>"><%=showtime.getFromTime()%></label>

													<%
													}
													}
													%>
												</div>
											</div>
										</div>


									<br>
										<label>Chọn ngày lên lịch</label>
										<div class="form-group">
											<div class="col-xs-6">
												<h2 class="card-inside-title">Từ ngày</h2>
												<div class="input-group date"
													id="bs_datepicker_component_container">
													<div class="form-line">
														<input type="text" class="form-control"
															placeholder="----chọn ngày-----" id="fromBookingDate"
															name="fromBookingDate">
													</div>
													<span class="input-group-addon"><i
														class="material-icons">date_range</i></span>
												</div>
											</div>
											<div class="col-xs-6">
												<h2 class="card-inside-title">Đến</h2>
												<div class="form-group">
													<div class="form-line" id="bs_datepicker_container">
														<input type="text" class="form-control" id="toBookingDate"
															name="toBookingDate"
															placeholder="Đến ngày ...">
													</div>
												</div>
											</div>
										</div>
										<br>
										<button type="submit"
											class="btn btn-primary m-t-15 waves-effect"
											style="float: right;">Thêm</button>

								</form>
							</div>
							<br>
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


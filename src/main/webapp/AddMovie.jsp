<%@page import="com.fpt.ojtstem.model.Room"%>
<%@page import="com.fpt.ojtstem.model.ShowTime"%>
<%@page import="java.util.List"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta charset="UTF-8">
<meta
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"
	name="viewport">
<title>Input Information Movie</title>
<!-- -----UFT-8------ -->
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />



<jsp:include page="menu/lib_Head.jsp" />
</head>
<body class="theme-red">
	<jsp:include page="menu/Navigation.jsp" />
	<section class="content">
		<div class="container-fluid">

			<!-- Input -->
			<div class="row clearfix">
				<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
					<div class="card">

						<div class="body">
							<div class="header">
								<h2 style="text-align: center;">BẢNG ĐIỀN THÔNG TIN PHIM</h2>
							</div>
							<div class="row clearfix">
								<div class="col-sm-12">
									<s:actionerror />
									<s:form action="UpdateImg" enctype="multipart/form-data"
										method="post">


										<label>Tên phim</label>
										<div class="form-group">
											<div class="form-line">
												<input type="text" id="movieName" name="movie.movieName"
													class="form-control" placeholder="Điền vào tên phim">
											</div>
										</div>
										<label>Đạo diễn</label>
										<div class="form-group">
											<div class="form-line">
												<input type="text" id="direction" name="movie.direction"
													class="form-control" placeholder="Điền vào tên đạo diễn">
											</div>
										</div>
										<label>Diễn viên</label>
										<div class="row clearfix">
											<div class="col-sm-12">
												<div class="form-group">
													<div class="form-line">
														<textarea rows="4" class="form-control no-resize"
															placeholder="Hãy điền tên các diễn viên chính vào đây"
															name="movie.actor"></textarea>
													</div>
												</div>
											</div>
										</div>
										<div class="row clearfix">
											<div class="col-sm-4">

												<div class="form-group">
													<label>Năm sản xuất</label>
													<div class="form-line">
														<input type="text" class="form-control"
															placeholder="Nhập vào năm sản xuất"
															name="movie.yearOfProduction">
													</div>
												</div>
											</div>
											<div class="col-sm-4">
												<div class="form-group">
													<label>Nhà sản xuất</label>
													<div class="form-line">
														<input type="text" class="form-control"
															placeholder="Nhập vào nhà sản xuất"
															name="movie.producter" />
													</div>
												</div>
											</div>
											<div class="col-sm-4">
												<div class="form-group">
													<label>Thời lượng phim</label>
													<div class="form-line">
														<input type="text" class="form-control"
															placeholder="Nhập vào thời lượng phim"
															name="movie.duration" />
													</div>
												</div>
											</div>
										</div>


										<div class="form-group">
											<label>Nội dung</label>
											<div class="row clearfix">
												<div class="col-sm-12">
													<div class="form-group">
														<div class="form-line">
															<textarea rows="4" class="form-control no-resize"
																placeholder="Hãy điền mô tả vế phim vào đây"
																name="movie.content"></textarea>
														</div>
													</div>
												</div>
											</div>
										</div>
										<div class="form-group">
											<label>Chọn ảnh</label>
											<div class="row clearfix">
												<div class="col-sm-12">
													<div class="form-group">
														<div class="form-line">
															<input type="file" id="imgFile" name="imgFile">
														</div>
													</div>
												</div>
											</div>
										</div>




										<label>Thể loại</label>
										<div class="form-group">
											<div class="form-line">
												<div class="demo-checkbox">
													<%
													List<String> TypeName = (List<String>) session.getAttribute("TypeName");
													if (TypeName != null) {
														for (String name : TypeName) {
													%>


													<input type="checkbox" id="<%=name%>"
														class="filled-in chk-col-red" name="movie.typeName"
														value="<%=name%>" /> <label for="<%=name%>"><%=name%></label>

													<%
													}
													}
													%>
												</div>
											</div>
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
									</s:form>

								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<!-- #END# Vertical Layout -->
		</div>
	</section>

	<jsp:include page="menu/lib.jsp" />
	<style>
	label{
	color:#000;
	}
	<style>
	<script>
		$("#fromBookingDate")
				.on(
						"change",
						function() {
							var bookingDateString = this.value;
							const bookingDate = new Date(bookingDateString);
							console.log("ngay dat ve: ", bookingDate);
							const currentDate = new Date();
							console.log("ngay hien tai: ", currentDate);
							if (bookingDate.getFullYear() < currentDate
									.getFullYear()
									|| (bookingDate.getFullYear() === currentDate
											.getFullYear() && bookingDate
											.getMonth() < currentDate
											.getMonth())
									|| (bookingDate.getFullYear() === currentDate
											.getFullYear()
											&& bookingDate.getMonth() === currentDate
													.getMonth() && bookingDate
											.getDate() < currentDate.getDate())) {
								this.value = null;
								alert('Ngày được chọn không hợp lệ!!');
							}

						});

		$("#toBookingDate")
				.on(
						"change",
						function() {
							var bookingDateString = this.value;
							const bookingDate = new Date(bookingDateString);
							console.log("ngay dat ve: ", bookingDate);
							const currentDate = new Date();
							console.log("ngay hien tai: ", currentDate);
							if (bookingDate.getFullYear() < currentDate
									.getFullYear()
									|| (bookingDate.getFullYear() === currentDate
											.getFullYear() && bookingDate
											.getMonth() < currentDate
											.getMonth())
									|| (bookingDate.getFullYear() === currentDate
											.getFullYear()
											&& bookingDate.getMonth() === currentDate
													.getMonth() && bookingDate
											.getDate() < currentDate.getDate())) {
								this.value = null;
								alert('Ngày được chọn không hợp lệ!!');
							}

						});
		$("#fromBookingDate, #toBookingDate").on("change", function() {
			var fromDate = new Date($("#fromBookingDate").val());
			var toDate = new Date($("#toBookingDate").val());

			if (fromDate > toDate) {
				alert("Ngày nhập không hợp lệ!");
				$("#fromBookingDate").val("");
				$("#toBookingDate").val("");
			}
		});
		window.onload = function() {
		    var submitButton = document.querySelector('.btn.btn-primary');
		    var fromBookingDateInput = document.getElementById('fromBookingDate');
		    
		    if (submitButton) {
		        submitButton.addEventListener('click', function(event) {
		            var checkedBoxes = document.querySelectorAll('input[type="checkbox"][name="schedule.roomId"]:checked');
		            var checkedShowTime = document.querySelectorAll('input[type="checkbox"][name="schedule.showTimeId"]:checked');
		            var checkedTypeName = document.querySelectorAll('input[type="checkbox"][name="movie.typeName"]:checked');
		            
		            if (checkedBoxes.length === 0) {
		                alert('Bạn chưa chọn phòng.');
		                event.preventDefault(); 
		            }
		            if (checkedShowTime.length === 0) {
		                alert('Bạn chưa chọn giờ chiếu.');
		                event.preventDefault(); 
		            }
		            if (checkedTypeName.length === 0) {
		                alert('Bạn chưa chọn thể loại phim.');
		                event.preventDefault(); 
		            }
		            
		            if (fromBookingDateInput) {
		                if (fromBookingDateInput.value.trim() === '') {
		                    alert('Vui lòng chọn ngày');
		                    event.preventDefault();
		                }
		            } else {
		                console.error('fromBookingDateInput không tồn tại trong DOM');
		            }
		        });
		    } else {
		        console.error('submitButton không tồn tại trong DOM');
		    }
		}

	</script>
</body>
</html>
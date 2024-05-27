<!DOCTYPE html>
<%@page import="com.fpt.ojtstem.model.TicketType"%>
<%@page import="java.util.List"%>
<%@page import="com.fpt.ojtstem.model.Account"%>
<html>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Admin_Quản lý thể loai</title>
<head>
<jsp:include page="menu/lib_Head.jsp" />
</head>
<body class="theme-red">
	<jsp:include page="menu/nav_nv.jsp" />
	<section class="content">
		<div class="container-fluid">

			<!-- Input -->
			<div class="row clearfix">
				<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
					<div class="card">

						<div class="body">
							<div class="header">
								<h2 style="text-align: center;">THÔNG TIN VÉ ĐÃ ĐẶT</h2>
							</div>
							<div class="body">
								<div class="row clearfix">
									<div class="col-sm-12">
										<s:form action="buy" method="post">
											<div class="container-fluid"
												style="position: absolute; width: 70%; height: 100%; float: left;">
												<img src="img/<s:property value="movie.image" />"
													style="width: 50%; height: 80%;">
											</div>
											<div class="container-fluid"
												style="width: 50%; height: 100%; float: right; margin-right: 20px; padding: 20px;">
												<label for="id_theloai">Tên phim</label>
												<div class="form-group">
													<div class="form-line">
														<input type="text" id="movieName" name="selectedMovie"
															class="form-control"
															value="<s:property value='movie.movieName' />"
															readonly="readonly">
													</div>
												</div>

												<label for="ten_theloai">Tên phòng</label>
												<div class="form-group">
													<div class="form-line">
														<input type="text" id="ten_theloai" name="selectedRoom"
															class="form-control"
															value="<s:property value='room.roomName' />"
															readonly="readonly">
													</div>
												</div>

												<label for="ten_theloai">Ngày chiếu </label>
												<div class="form-group">
													<div class="form-line">

														<input type="text" id="ten_theloai" name="bookingDate"
															class="form-control"
															value="<s:property value='bookingDate' />"
															readonly="readonly">

													</div>
												</div>


												<label for="ten_theloai">Giờ chiếu</label>
												<div class="form-group">
													<div class="form-line">
														<input type="text" id="ten_theloai"
															name="selectedShowTime" class="form-control"
															value="<s:property value='showTime.fromTime' />- <s:property value='showTime.toTime' /> "
															readonly="readonly">
													</div>
												</div>

												<label for="ten_theloai">Ghế</label>
												<div class="form-group">
													<div class="form-line">
														<%
														String id = (String) session.getAttribute("listSeatId");
														%>
														<input type="text" id="ten_theloai" name="idSeat"
															class="form-control" value="<%=id%>" readonly="readonly">
													</div>
												</div>
												<label style="text-align: center;">Loại vé :</label>
												<div class="form-group">
													<div class="form-line">
														<input type="text" id="ten_theloai"
															name="selectedTicketType" class="form-control"
															value="<s:property value='selectedTicketType'/>"
															readonly="readonly">
													</div>
												</div>
												<label style="text-align: center;">Phương thức thanh
													toán :</label>
												<div class="form-group">
													<div class="form-line">
														<input type="text" id="ten_theloai"
															name="selectedMethodPayment" class="form-control"
															value="<s:property value='selectedMethodPayment'/>"
															readonly="readonly">
													</div>

												</div>


												<label style="text-align: center;">Tổng tiền:</label>
												<div class="form-group">
													<div class="form-line">
														<input type="text" id="ten_theloai" name="total"
															class="form-control" value="<s:property value='total'/>"
															readonly="readonly">
													</div>

												</div>
												<button type="submit"
													class="btn btn-primary m-t-15 waves-effect"
													style="float: right;">Thanh toán</button>
													<button type="button"
											class="btn btn-primary m-t-15 waves-effect"
											onclick="onBack()" style="float: left;">Quay lại</button>
											</div>
										</s:form>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>

			</div>
		</div>
	</section>
<script >
function onBack() {
	window.location.href = "<s:url action='ConfirmTicket'/>";
}
		document.getElementById("movieName").addEventListener('input',function(event) {
			event.preventDefault()
		    var selectedValue = $(this).val();
			console.log("ngay : ", selectedValue);
	        var data= "<s:property value='movie.movieName' />";
	    	console.log("ngay hien tai: ", data);
					if (selectedValue !== data) {
						alert("Giá trị không hợp lệ.");
				
					}
				}); 
  
</script>
	<jsp:include page="menu/lib.jsp" />
	<%
	String errorMessage = (String) request.getAttribute("errorMessage");
	if (errorMessage != null && !errorMessage.isEmpty()) {
	%>
	<script>
                alert("<%=errorMessage%>");
	</script>
	<%
	}
	%>
<style>
	label{
	color:#000;
	}
	<style>
</body>
</html>
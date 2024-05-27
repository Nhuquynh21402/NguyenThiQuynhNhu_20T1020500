<!DOCTYPE html>
<%@page import="com.fpt.ojtstem.model.Account"%>
<html>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Admin_Quản lý phòng chiếu</title>
<head>
<jsp:include page="menu/lib_Head.jsp" />
</head>
<body class="theme-red">
	<jsp:include page="menu/Navigation.jsp" />
	<section class="content">
		<div class="container-fluid">
			<!-- Vertical Layout -->
			<div class="row clearfix">
				<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
					<div class="card">
						<div class="header">
							<h2>CHỈNH SỬA THÔNG TIN PHÒNG CHIẾU</h2>
						</div>


						<div class="body">
							<div class="row clearfix">
								<div class="col-sm-12">

									<s:actionerror />
									<s:form action="" method="post" id="UpdateRooom">
										<div class="form-group">
											<div class="form-line">
												<%
												String id = (String) session.getAttribute("session");
												if (id == null) {
												%>
												<label for="ten_theloai">ID phòng chiếu</label> <input
													type="text" name="roomId" class="form-control"
													value="<s:property value='room.roomId' />"
													readonly="readonly" />
												<%
												} else {
												%>
												<label for="ten_theloai">ID phòng chiếu</label> <input
													type="text" name="idPhong" class="form-control"
													value="<%=id%>" readonly="readonly" />
												<%
												}
												%>
											</div>
											<div id="roomId_error" style="color: red;"></div>
										</div>
										<label for="ten_theloai">Tên phòng chiếu</label>
										<div class="form-group">
											<div class="form-line">
												<input type="text" id="roomName" name="tenPhong"
													class="form-control"
													value="<s:property value='room.roomName' />">
											</div>
											<div id="roomName_error" style="color: red;"></div>
										</div>
										<label for="ten_theloai">Số lượng ghế</label>
										<div class="form-group">
											<div class="form-line">
												<input type="text" id="seatQuantity" name="soLuongGhe"
													class="form-control"
													value="<s:property value='room.seatQuantity' />">
											</div>
											<div id="seatQuantity_error" style="color: red;"></div>
										</div>
										<br>
										<button class="btn btn-primary m-t-15 waves-effect"
											onclick="UpdateRoom(this,'<s:property value="room.roomId" />')">Lưu</button>
										<button type="button"
											class="btn btn-primary m-t-15 waves-effect"
											onclick="onBack()" style="float: right;">Quay lại</button>
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

	<script>
		function UpdateRoom(form, RoomId) {
			var a = document.getElementById('UpdateRooom');
			a.action = "EditRoomAction?id=" + RoomId;
			a.submit();

		}
		function UpdateRoom1(form, RoomId) {
			form.action = "EditRoomAction?id=" + RoomId;
			form.submit();

		}

		function onBack() {
			window.location.href = "<s:url action='Room'/>";
		}

		$(document)
				.ready(
						function() {
							$("#roomId")
									.on(
											'input',
											function() {
												var roomId = $(this).val();
												var errorElement = $("#roomId_error");

												if (roomId === "") {
													errorElement
															.text("Id phòng không được để trống.");
													return false;
												}
												if (roomId.length > 5) {
													errorElement
															.text("Id phòng không được dài hơn 5 ký tự.");
													return false;
												}

												var pattern = /^[\p{L}0-9\\s]+$/u;

												if (!pattern.test(roomId)) {
													errorElement
															.text("Id chỉ được chứa các ký tự chữ cái, số.");
													return false;
												}
												var textId = /^\D+$/u;
												errorElement.text("");
												return true;
											});
						});
		$(document)
				.ready(
						function() {
							$("#roomName")
									.on(
											'input',
											function() {
												var roomName = $(this).val();
												var errorElement = $("#roomName_error");

												if (roomName === "") {
													errorElement
															.text("Tên phòng không được để trống.");
													return false;
												}
												if (roomName.length > 10) {
													errorElement
															.text("Tên phòng phim không được dài hơn 50 ký tự.");
													return false;
												}

												var pattern = /^[\p{L}0-9]+$/u;
												if (!pattern.test(roomName)) {
													errorElement
															.text("Tên phòng chỉ được chứa các ký tự chữ cái, số ");
													return false;
												}
												/*   var textId = /^\D+$/u;
													      if(!textId.test(roomName)){
													        	  errorElement.text("Tên phòng không được chứa toàn số.");
														            return false;
													        } */

												errorElement.text("");
												return true;
											});
						});

		$("#seatQuantity").on('input', function() {
			var seatQuantity = $(this).val();
			var errorElement = $("#seatQuantity_error");

			if (seatQuantity === "") {
				errorElement.text("Số lượng ghế không được để trống.");
				return false;
			}
			if (seatQuantity.length > 3) {
				errorElement.text("Số lượng ghế không được quá 100.");
				return false;
			}

			var pattern = /^\d+$/u;
			if (!pattern.test(seatQuantity)) {
				errorElement.text("Số lượng ghế phải là số ");
				return false;
			}

			errorElement.text("");
			return true;
		});

		<%-- <%
		String errorMessage = (String) session.getAttribute("errorMessage");
		session.removeAttribute("errorMessage"); 
		%>
	    var errorMessage = "<%=errorMessage%>";
	    if (errorMessage) {
	        alert(errorMessage); 
	    }
 --%>
	
	</script>
	<style>
	label{
	color:#000;
	}
	<style>

</body>
</html>
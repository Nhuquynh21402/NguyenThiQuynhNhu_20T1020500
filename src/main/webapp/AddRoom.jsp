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

			<!-- Input -->
			<div class="row clearfix">
				<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
					<div class="card">

						<div class="body">
							<div class="header">
								<h2 style="text-align: center;">ĐIỂN THÔNG TIN PHÒNG CHIẾU</h2>
							</div>
							<div class="row clearfix">
								<div class="col-sm-12">

									<s:form action="AddRoomAction" method="post">
										<s:actionerror />
										
										<label for="ten_theloai">Tên phòng chiếu</label>
										<div class="form-group">
											<div class="form-line">
												<input type="text" id="roomName" name="room.roomName"
													class="form-control">

											</div>
											<div id="roomName_error" style="color: red;"></div>
										</div>

										<label for="ten_theloai">Số lượng ghế</label>
										<div class="form-group">
											<div class="form-line">
												<input type="text" id="seatQuantity"
													name="room.seatQuantity" class="form-control">

											</div>
											<div id="seatQuantity_error" style="color: red;"></div>
										</div>
										<br>
										<button type="submit"
											class="btn btn-primary m-t-15 waves-effect">Save</button>
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
	<style>
	label{
	color:#000;
	}
	<style>
	<script type="text/javascript">
		function onBack() {
			window.location.href = "<s:url action='Room'/>";
		}
	

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
												if (roomName.length > 20) {
													errorElement
															.text("Tên phòng phim không được dài hơn 20 ký tự.");
													return false;
												}

												var pattern = /^[\p{L}0-9]+$/u;
												if (!pattern.test(roomName)) {
													errorElement
															.text("Tên phòng chỉ được chứa các ký tự chữ cái, số ");
													return false;
												}
												var textId = /^[+-]?[\\d]*[.]?[\\d]*$/;
												if (textId.test(roomName)) {
													errorElement
															.text("Tên phòng không được chứa toàn số.");
													return false;
												}

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
			if (seatQuantity.length > 2) {
				errorElement.text("Số lượng ghế không được quá 100.");
				return false;
			}

			var pattern = /^[+-]?[\\d]*[.]?[\\d]*$/;
			if (pattern.test(seatQuantity)) {
				errorElement.text("Số lượng ghế phải là số ");
				return false;
			}

			errorElement.text("");
			return true;
		});
		 function validateForm() {
		        var roomId = document.getElementById('roomId').value.trim();
		        var roomName = document.getElementById('roomName').value.trim();
		        var seatQuantity = document.getElementById('seatQuantity').value.trim();

		        if (roomId === "") {
		            alert('Id phòng không được để trống.');
		            return false;
		        }

		        if (roomName === "") {
		            alert('Tên phòng không được để trống.');
		            return false;
		        }

		        if (seatQuantity === "") {
		            alert('Số lượng ghế không được để trống.');
		            return false;
		        }

		        return true;
		    }
	</script>
</body>
</html>
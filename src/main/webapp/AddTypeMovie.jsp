<!DOCTYPE html>
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
	<jsp:include page="menu/Navigation.jsp" />
	<section class="content">
		<div class="container-fluid">

			<!-- Input -->
			<div class="row clearfix">
				<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
					<div class="card">

						<div class="body">
							<div class="header">
								<h2 style="text-align: center;">BẢNG ĐIỀN THÔNG TIN THỂ
									LOẠI PHIM</h2>
							</div>
							<div class="row clearfix">
								<div class="col-sm-12">

									<s:form action="AddTypeMovieAction" method="post">
										<s:actionerror />
										<label for="idtheloai">ID Thể loại phim</label>
										<div class="form-group">
											<div class="form-line">
												<input type="text" id="typeMovieID" name="typeMovieID"
													class="form-control"
													placeholder="Nhập vào ID thể loại phim">
											</div>
											<div id="id_theloai_error" style="color: red;"></div>
										</div>
										<label for="ten_theloai">Tên thể loại phim</label>
										<div class="form-group">
											<div class="form-line">
												<input type="text" id="typeMovieName" name="typeMovieName"
													class="form-control"
													placeholder="Nhập vào tên thể loại phim">
											</div>
											<div id="ten_theloai_error" style="color: red;"></div>

										</div>
										<br>

										<button type="button"
											class="btn btn-dark m-t-15 waves-effect text-white"
											onclick="onBack()" >Quay lại</button>
											
										<button type="submit" onclick="Confirm()"
											class="btn btn-dark m-t-15 waves-effect text-white" style="float: right ;">Xác
											nhận</button>

									</s:form>

								</div>
							</div>
						</div>
					</div>
				</div>
			</div>


		</div>
	</section>
	<style>
	label{
	color:#000;
	}
	<style>

	<jsp:include page="menu/lib.jsp" />
	<script>
		function onBack() {
			window.location.href = "<s:url action='TypeMovie'/>";
		}

		function Confirm() {
			var id = document.getElementById("typeMovieID").value;
			console.log(id);

			var name = document.getElementById("typeMovieName").value;
			console.log(name);

			if (confirm('Bạn có chắc chắn muốn thêm vé có ID: ' + id
					+ ' và tên: ' + name + ' này không?')) {
				window.location.href = "<s:url action='AddTypeMovieAction'/>";
			}
		}

		$(document)
				.ready(
						function() {
							$("#typeMovieName")
									.on(
											'input',
											function() {
												var tenTheLoai = $(this).val();
												var errorElement = $("#ten_theloai_error");

												if (tenTheLoai === "") {
													errorElement
															.text("Tên thể loại phim không được để trống.");
													return false;
												}
												if (tenTheLoai.length > 50) {
													errorElement
															.text("Tên thể loại phim không được dài hơn 50 ký tự.");
													return false;
												}

												var pattern = /^[\p{L}\s]+$/u;
												if (!pattern.test(tenTheLoai)) {
													errorElement
															.text("Tên thể loại phim chỉ được chứa các ký tự chữ cái và khoảng trắng.");
													return false;
												}

												errorElement.text("");
												return true;
											});
						});
		$(document)
				.ready(
						function() {
							$("#typeMovieID")
									.on(
											'input',
											function() {
												var idTheLoai = $(this).val();
												var errorElement = $("#id_theloai_error");

												if (idTheLoai === "") {
													errorElement
															.text("Id thể loại phim không được để trống.");
													return false;
												}
												if (idTheLoai.length > 20) {
													errorElement
															.text("Id thể loại phim không được dài hơn 20 ký tự.");
													return false;
												}

												var pattern = /^[\p{L}]+$/u;
												if (!pattern.test(idTheLoai)) {
													errorElement
															.text("Id thể loại phim chỉ được chứa các ký tự chữ cái");
													return false;
												}

												errorElement.text("");
												return true;
											});
						});
	</script>



</body>
</html>

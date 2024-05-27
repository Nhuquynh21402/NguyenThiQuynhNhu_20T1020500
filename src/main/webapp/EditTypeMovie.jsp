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
			<!-- Vertical Layout -->
			<div class="row clearfix">
				<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
					<div class="card">
						<div class="header">
							<h2 >CHỈNH SỬA THÔNG TIN THỂ LOẠI
								PHIM</h2>
						</div>


						<div class="body">
						<s:actionerror />
							<s:form action="Edit" method="post">
								<label for="id_theloai">ID Thể loại phim</label>
								<div class="form-group">
									<div class="form-line">
									<% String typeMovie = (String) session.getAttribute("typeMovie");
										
									if(typeMovie !=null){ %>
										<input type="text" id="typeMovieID" name="idTheloai"
											class="form-control"
											value="<%=typeMovie %>" readonly="readonly">
											<%}else{ %>
												<input type="text" id="typeMovieID" name="idTheloai"
											class="form-control"
											value="<s:property value='type.typeMovieID' />" readonly="readonly">
											<%} %>
											
									</div>
										<div id="id_theloai_error" style="color: red;"></div>
								</div>
						
						<label for="ten_theloai">Tên thể loại phim</label>
						<div class="form-group">
							<div class="form-line">
								<input type="text" id="typeMovieName" name="tenTheloai"
									class="form-control"
									value="<s:property value='type.typeMovieName' />">
							</div>
								<div id="ten_theloai_error" style="color: red;"></div>
						</div>
						<br>
						<button type="submit" class="btn btn-primary m-t-15 waves-effect" style="float: right;"
							>Lưu</button>
							<button type="button"
									class="btn btn-primary m-t-15 waves-effect" onclick="onBack()"
									>Quay lại</button>
					
						</s:form>
						</div>
</div>
					</div>
				</div>
			</div>
		
	</section>

	<jsp:include page="menu/lib.jsp" />
	<script >
	function onBack() {
		window.location.href = "<s:url action='TypeMovie'/>";
	}

	$(document).ready(function() {
	    $("#typeMovieName").on('input', function() {
	        var tenTheLoai = $(this).val();
	        var errorElement = $("#ten_theloai_error");
	        
	        if (tenTheLoai === "") {
	            errorElement.text("Tên thể loại phim không được để trống.");
	            return false;
	        }
	        if (tenTheLoai.length > 50) {
	            errorElement.text("Tên thể loại phim không được dài hơn 50 ký tự.");
	            return false;
	        }

	        var pattern = /^[\p{L}\s]+$/u;
	        if (!pattern.test(tenTheLoai)) {
	            errorElement.text("Tên thể loại phim chỉ được chứa các ký tự chữ cái, số và khoảng trắng.");
	            return false;
	        }

	        errorElement.text("");
	        return true;
	    });
	});
	 	$(document).ready(function() {
		    $("#typeMovieID").on('input', function() {
		        var idTheLoai = $(this).val();
		        var errorElement = $("#id_theloai_error");
		        
		        if (idTheLoai === "") {
		            errorElement.text("Id thể loại phim không được để trống.");
		            return false;
		        }
		        if (idTheLoai.length > 20) {
		            errorElement.text("Id thể loại phim không được dài hơn 20 ký tự.");
		            return false;
		        }

		        var pattern = /^[a-zA-Z0-9]+$/;
		        if (!pattern.test(idTheLoai)) {
		            errorElement.text("Id thể loại phim chỉ được chứa các ký tự chữ cái, số và khoảng trắng.");
		            return false;
		        }

		        errorElement.text("");
		        return true;
		    }); 
	 	 }); 
		    
	 	
	 
	</script>
	<style>
	label{
	color:#000;
	}
	<style>
	
</body>
</html>
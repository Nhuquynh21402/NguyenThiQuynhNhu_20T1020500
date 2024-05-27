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
		<div class="container">
			<!-- Vertical Layout -->
			<div class="row">
				<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
					<div class="card">
						<div class="header">
							<h2>BẢNG ĐIỀN THÔNG TIN PHIM VÉ</h2>
						</div>
						<div class="body">
							<s:actionerror />
							<s:form action="EditMovieAction" enctype="multipart/form-data"
								method="post">

								<label>ID phim</label>
								<div class="form-group">
									<div class="form-line">
										<input type="text" name="movie.movieId"
											class="form-control"
											value="<s:property value='movie.movieId'  />"
											readonly="readonly">
									</div>
								</div>


								<label>Tên phim</label>
								<div class="form-group">
									<div class="form-line">
										<input type="text" name="movie.movieName"
											class="form-control"
											value="<s:property value='movie.movieName' />">
									</div>
								</div>
								<label>Đạo diễn</label>
								<div class="form-group">
									<div class="form-line">
										<input type="text" id="direction" name="movie.direction"
											class="form-control"
											value="<s:property value='movie.direction' />">
									</div>
								</div>
								<label>Diễn viên</label>
								<div class="row clearfix">
									<div class="col-sm-12">
										<div class="form-group">
											<div class="form-line">
												<input type="text" id="direction" name="movie.actor"
													class="form-control"
													value="<s:property value='movie.actor' />">

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
													value="<s:property value='movie.yearOfProduction' />"
													name="movie.yearOfProduction">
											</div>
										</div>
									</div>
									<div class="col-sm-4">
										<div class="form-group">
											<label>Nhà sản xuất</label>
											<div class="form-line">
												<input type="text" class="form-control"
													value="<s:property value='movie.producter' />"
													name="movie.producter" />
											</div>
										</div>
									</div>
									<div class="col-sm-4">
										<div class="form-group">
											<label>Thời lượng phim</label>
											<div class="form-line">
												<input type="text" class="form-control"
													value="<s:property value='movie.duration' />"
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
													<input type="text" class="form-control"
														value="<s:property value='movie.content' />"
														name="movie.content" />

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
													<input type="file" id="imgFile" name="imgFile"
														value="<s:property value='movie.image' />"
														name="oneMovie.image">
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
											String[] types = (String[]) session.getAttribute("type");
											if (TypeName != null && types != null) {
												for (String name : TypeName) {
													boolean checked = false;
													for (String type : types) {
												if (name.equals(type)) {
													checked = true;
													break;
												}
													}
											%>
											<input type="checkbox" id="<%=name%>"
												class="filled-in chk-col-red" name="movie.typeName"
												value="<%=name%>" <%=checked ? "checked" : ""%> /> <label
												for="<%=name%>"><%=name%></label>
											<%
											}
											}
											%>
										</div>
									</div>
								</div>



								<br>
								<button type="submit">Cập nhật</button>
							</s:form>

						</div>
					</div>
				</div>
			</div>
			<!-- #END# Vertical Layout -->
		</div>
	</section>
	<style>
	label{
	color:#000;
	}
	<style>

	<jsp:include page="menu/lib.jsp" />
</body>
</html>
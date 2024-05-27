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
								<h2>BẢNG ĐIỀN THÔNG TIN PHIM VÉ</h2>
							</div>
							<div class="body">
								<s:actionerror />
								<label>ID phim</label>
								<div class="form-group">
									<div class="form-line">
										<p>
											<s:property value='movie.movieId' />
										</p>
									</div>
								</div>


								<label>Tên phim</label>
								<div class="form-group">
									<div class="form-line">
										<p>
											<s:property value='movie.movieName' />
										</p>

									</div>
								</div>
								<label>Đạo diễn</label>
								<div class="form-group">
									<div class="form-line">
										<p>
											<s:property value='movie.direction' />
										</p>

									</div>
								</div>
								<label>Diễn viên</label>
								<div class="row clearfix">
									<div class="col-sm-12">
										<div class="form-group">
											<div class="form-line">
												<p>
													<s:property value='movie.actor' />
												</p>


											</div>
										</div>
									</div>
								</div>
								<div class="row clearfix">
									<div class="col-sm-4">

										<div class="form-group">
											<label>Năm sản xuất</label>
											<div class="form-line">
												<p>
													<s:property value='movie.yearOfProduction' />
												</p>


											</div>
										</div>
									</div>
									<div class="col-sm-4">
										<div class="form-group">
											<label>Nhà sản xuất</label>
											<div class="form-line">
												<p>
													<s:property value='movie.producter' />
												</p>

											</div>
										</div>
									</div>
									<div class="col-sm-4">
										<div class="form-group">
											<label>Thời lượng phim</label>
											<div class="form-line">
												<p>
													<s:property value='movie.duration' />
												</p>

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
													<p>
														<s:property value='movie.content' />
													</p>


												</div>
											</div>
										</div>
									</div>

								</div>
								<div class="form-group">
									<label>Hình ảnh</label>
									<div class="row clearfix">
										<div class="col-sm-12">
											<div class="form-group">
													<img src="img/<s:property value='movie.image' />">

												
											</div>
										</div>
									</div>
								</div>
						<label>Thể loại</label>
								<div class="form-group">
										<div class="demo-checkbox">
				                          <p><s:property value='movie.typeName' /></p>
										</div>
								</div>
						<label>Lịch chiếu</label>
							<div class="form-group">
							<s:iterator value="list" var="schedule">
								   <p><s:property value=""/></p>
							</s:iterator>
						
							</div>
								<br>
							</div>
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
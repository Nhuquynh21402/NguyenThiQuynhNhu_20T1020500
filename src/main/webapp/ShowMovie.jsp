<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Admin_Quản lý phim</title>
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
						<div class="header">
							<button id="add"
								class="btn btn-dark m-t-15 waves-effect text-white"
								onclick="addMovie()" style="float: left:;">Thêm phim
								mới</button>
							<h2>DANH SÁCH PHIM</h2>
						</div>

						<div class="body">
							<div class="table-responsive">
								<table
									class="table table-bordered table-striped table-hover js-basic-example dataTable">
									<thead>
										<tr>
											<th style="text-align: center;">Tên phim</th>
											<th style="text-align: center;">Đạo diễn</th>
											<th style="text-align: center;">Diễn viên</th>
											<th style="text-align: center;">Ảnh</th>
											<th style="text-align: center;">Chi tiết</th>
											<th style="text-align: center;">Quản lý</th>
										</tr>
									</thead>
									<tbody>
										<s:iterator value="movies" var="movie">
											<tr>
												<td><s:property value="#movie.movieName" /></td>
												<td><s:property value="#movie.direction" /></td>
												<td><s:property value="#movie.actor" /></td>
												<td><img src="img/<s:property value="#movie.image" />"
													style="width: 100px; height: 100px;"></td>
												<td style="text-align: center;"><a
													href="detailMovie?id=<s:property value='#movie.movieId' />"><i
														class="material-icons">visibility</i></a></td>
												<td style="text-align: center; padding-right: 10px"><a
													class="btn btn-dark m-t-15 waves-effect"
													href="EditMovie?id=<s:property value='#movie.movieId' />"><i
														class="material-icons">edit</i></a>

													<div style="width: 10px; display: inline;"></div>
													<button class="btn btn-dark m-t-15 waves-effect"
														onclick="Delete('<s:property value="#movie.movieId" />','<s:property value="#movie.movieName" />')">
														<i class="material-icons">delete</i>
													</button></td>
											</tr>

										</s:iterator>

									</tbody>
								</table>
							</div>
						</div>

					</div>
				</div>
			</div>
		</div>
	</section>
	<jsp:include page="menu/lib.jsp" />
	<script>
		function addMovie() {
			window.location.href = "<s:url action='AddMovie'/>";

		}
		function Delete(moveiId, movieName) {

			if (confirm('Bạn có chắc chắn muốn xóa phim "' + movieName
					+ '"  này không?')) {
				window.location.href = "<s:url action='DeleteMovie'/>?id="
						+ moveiId;
			}
		}
	</script>
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

</body>
<style>
#add {
	position: absolute;
	top: 15px;
	right: 20px;
}
</style>
</html>






























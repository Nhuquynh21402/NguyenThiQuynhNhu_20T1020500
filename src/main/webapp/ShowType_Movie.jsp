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
<jsp:include page="menu/Navigation.jsp" />
<body class="theme-red">
<section class="content">
	<div class="container-fluid">
		<div class="row clearfix">
			<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">

				<div class="card">
					<div class="body">
						<div class="header" style="text-align: center;">
							<button onclick="addTypeMovie()" style="float: right;"
								class="btn btn-dark m-t-15 waves-effect text-white">Thêm
								thể loại phim mới</button>

							<h2>DANH SÁCH THỂ LOẠI PHIM</h2>


						</div>
						<div class="row clearfix">
							<div class="col-sm-12">

								<div class="table-responsive">
									<table
										class="table table-bordered table-striped table-hover js-basic-example dataTable">
										<thead>
											<tr>
												<th style="text-align: center;">ID Thể loại phim</th>
												<th style="text-align: center;">Tên thể loại phim</th>
												<th style="text-align: center;">Quản lý</th>
											</tr>
										</thead>
										<tbody>
											<s:iterator value="listType" var="type">
												<tr>
													<td><s:property value="#type.typeMovieID" /></td>
													<td><s:property value="#type.typeMovieName" /></td>
													<td style="text-align: center; padding-right: 10px"><a
														class="btn btn-dark m-t-15 waves-effect text-white"
														href="EditTypeMovie?id=<s:property value='#type.typeMovieID' />"><i
															class="material-icons">edit</i></a>
														<div style="width: 10px; display: inline;"></div>
														<button
															class="btn btn-dark m-t-15 waves-effect text-white"
															onclick="Delete('<s:property value="#type.typeMovieID" />','<s:property value="#type.typeMovieName" />')">
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
		</div>

	</div>
</section>
<body>
<jsp:include page="menu/lib.jsp" />
<script>
	function addTypeMovie() {
		window.location.href = "<s:url action='AddTypeMovie'/>";

	}
</script>

<script>
	function Delete(typeId, typeName) {
		if (confirm('Bạn có chắc chắn muốn xóa thể loại phim "' + typeName
				+ '" này không?')) {
			window.location.href = "<s:url action='Delete'/>?typeId=" + typeId;
		}
	}
</script>
</body>
</html>
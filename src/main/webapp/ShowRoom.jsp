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
			<div class="row clearfix">
				<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">

					<div class="card">
						<div class="body">
							<div class="header">
								<button class="btn btn-dark m-t-15 waves-effect"
									onclick="addRoom()" style="float: right;">Thêm phòng
									mới</button>
								<h2>DANH SÁCH PHÒNG CHIẾU</h2>
							</div>


							<s:actionerror />
							<div class="row clearfix">
								<div class="col-sm-12">
									<div class="table-responsive">
										<table class="table table-bordered table-striped table-hover js-basic-example dataTable">
											<thead>
												<tr>
												
													<th style="text-align: center;">TÊN PHÒNG</th>
													<th style="text-align: center;">SỐ LƯỢNG GHẾ</th>
													<th style="text-align: center;">QUẢN LÝ</th>
												</tr>
											</thead>
											<tbody>
												<s:iterator value="ListRoom" var="room">
													<tr>
													
														<td><s:property value="#room.roomName" /></td>
														<td><s:property value="#room.seatQuantity" /></td>
														<td style="text-align: center;"><a
															class="btn btn-dark m-t-15 waves-effect"
															href="EditRoom?id=<s:property value='#room.roomId' />"><i
																class="material-icons">edit</i></a>
															<div style="width: 10px; display: inline;"></div>
															<button class="btn btn-dark m-t-15 waves-effect"
																onclick="Delete('<s:property value="#room.roomId" />','<s:property value="#room.roomName" />')">
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
			<!-- #END# Basic Examples -->
		</div>
	</section>

	<jsp:include page="menu/lib.jsp" />
	<script>
		function addRoom() {
			window.location.href = "<s:url action='AddRoom'/>";

		}
	</script>
	<script>
		function Delete(RoomId, RoomName) {

			if (confirm('Bạn có chắc chắn muốn xóa phòng chiếu phim "'
					+ RoomName + '"  này không?')) {
				window.location.href = "<s:url action='DeleteRoom'/>?roomId="
						+ RoomId;
			}
		}
	</script>
</body>
</body>
</html>
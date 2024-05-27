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
									onclick="addTypeTicket()" style="float: right;">Thêm
									loại vé mới</button>
								<h2>DANH SÁCH THỂ LOẠI VÉ</h2>
							</div>
							<div class="row clearfix">
								<div class="col-sm-12">

									<div class="table-responsive">
										<table
											class="table table-bordered table-striped table-hover js-basic-example dataTable">
											<thead>
												<tr>
													<th style="text-align: center;">ID Thể loại vé</th>
													<th style="text-align: center;">Tên thể loại vé</th>
													<th style="text-align: center;">Giá vé</th>
													<th style="text-align: center;">Quản lý</th>
												</tr>
											</thead>
											<tbody>
												<s:iterator value="ListTicket" var="ticket">
													<tr>
														<td><s:property value="#ticket.ticketTypeID" /></td>
														<td><s:property value="#ticket.ticketTypeName" /></td>
														<td><s:property value="#ticket.price" /></td>
														<td
															style="text-align: center; padding-right: 10px; margin-left: 20px;">
															<a class="btn btn-dark m-t-15 waves-effect"
															href="EditTypeTicket?id=<s:property value='#ticket.ticketTypeID' />"><i
																class="material-icons">edit</i></a>

															<div style="width: 10px; display: inline;"></div>
															<button class="btn btn-dark m-t-15 waves-effect"
																onclick="Delete('<s:property value="#ticket.ticketTypeID" />','<s:property value="#ticket.ticketTypeID" />')">
																<i class="material-icons">delete</i>
															</button>
														</td>
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

	<jsp:include page="menu/lib.jsp" />
	<script>
		function addTypeTicket() {
			window.location.href = "<s:url action='AddTicket'/>";

		}
	</script>

	<script>
		function Delete(typeId, typeName) {
			if (confirm('Bạn có chắc chắn muốn xóa loại vé "' + typeName
					+ '" này không?')) {
				window.location.href = "<s:url action='DeleteTypeTicket'/>?ticketId="
						+ typeId;
			}
		}
	</script>
</body>
</html>
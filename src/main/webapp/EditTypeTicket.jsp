<!DOCTYPE html>
<%@page import="com.fpt.ojtstem.model.Account"%>
<html>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Admin_Quản lý thể loai vé</title>
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
								<h2>CHỈNH SỬA THÔNG TIN THỂ LOẠI VÉ</h2>
							</div>

							<div class="row clearfix">
								<div class="col-sm-12">
									<s:actionerror />
									<s:form action="" method="post" id="EditTypeTicketAction">


										<div class="form-group">
											<div class="form-line">
												<label for="ten_theloai">Id loại vé</label>
												<%
												String id = (String) session.getAttribute("ticket");
												if (id == null) {
												%>

												<input type="text" id="ticketTypeID" name="ticketTypeID"
													class="form-control"
													value="<s:property value='ticket.ticketTypeID' />"
													readonly="readonly">
												<%
												} else {
												%>
												<input type="text" id="ticketTypeID" name="ticketTypeID"
													class="form-control" value="<%=id%>" readonly="readonly">
												<%
												}
												%>
											</div>

										</div>
										<label for="ten_theloai">Tên loại vé</label>
										<div class="form-group">
											<div class="form-line">
												<input type="text" id="ticketTypeID" name="ticketTypeName"
													class="form-control"
													value="<s:property value='ticket.ticketTypeName' />">
											</div>
										</div>
										<label for="ten_theloai">Giá vé</label>
										<div class="form-group">
											<div class="form-line">
												<input type="text" id="Price" name="price"
													class="form-control"
													value="<s:property value='ticket.Price' />">
											</div>
										</div>
										<br>
										<button class="btn btn-primary m-t-15 waves-effect"
											onclick="EditTypeTicket(this,'<s:property value="ticket.ticketTypeID" />')">Lưu thông tin</button>

										<button type="button"
											class="btn btn-primary m-t-15 waves-effect"
											onclick="onBack()" style="float: right; margin: 20px;">Quay
											lại</button>
										<br>
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

	<script>
		function EditTypeTicket(form, ticketId) {
			var a = document.getElementById('EditTypeTicketAction');
			a.action = "EditTypeTicketAction?ticketId=" + ticketId;
			a.submit();
		}
		function onBack() {
			window.location.href = "<s:url action='TypeTicket'/>";
		}
	</script>

<style>
	label{
	color:#000;
	}
	<style>
	<jsp:include page="menu/lib.jsp" />
</body>
</html>
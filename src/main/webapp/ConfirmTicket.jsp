<!DOCTYPE html>
<%@page import="org.hibernate.type.ListType"%>
<%@page import="com.fpt.ojtstem.model.TicketType"%>
<%@page import="java.util.List"%>
<%@page import="com.fpt.ojtstem.model.Account"%>
<html>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<title>Admin_Quản lý bán vé</title>

<jsp:include page="menu/lib_Head.jsp" />

<body class="theme-red">
	<jsp:include page="menu/nav_nv.jsp" />
	<section class="content">
		<div class="row clearfix">
			<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
				<div class="card">
					<div class="body">
						<div class="header">
							<h2>CHỌN LOẠI VÉ VÀ PHƯƠNG THỨC THANH TOÁN</h2>
							<br>
						</div>
						<div class="row clearfix">
							<div class="col-sm-12">
								<div class="container-fluid" id="img" style="padding-left: 30%;">
									<img src="img/<s:property value="movie.image" />"
										style="width: 50%;">
								</div>
								<br>

								<s:actionerror />
								<s:form action="Payment" method="post">
									<div class="body">
										<div class="row ">

											<div class="col-sm-6">
												<label style="text-align: center;">Chọn loại vé :</label> <select
													class="form-control show-tick" name="selectedTicketType"
													id="selectedTicketType">
													<option value="" style="text-align: center;">--
														Chọn loại vé--</option>
													<%
													List<TicketType> listTicket = (List<TicketType>) session.getAttribute("listTicket");
													if (listTicket != null) {
														for (TicketType ticket : listTicket) {
													%>
													<option value="<%=ticket.getTicketTypeName()%>"
														style="text-align: center;"><%=ticket.getTicketTypeName()%></option>
													<%
													}
													}
													%>
												</select>
											</div>
											<div class="col-sm-6">
												<label style="text-align: center;">Chọn phương thức
													thanh toán :</label> <select class="form-control show-tick"
													name="selectedMethodPayment" id="selectedMethodPayment">
													<option value="" style="text-align: center;">--
														Chọn phương thức thanh toán--</option>

													<option value="Tiền mặt" style="text-align: center;">Tiền
														mặt</option>
													<option value="Chuyển khoản" style="text-align: center;">Chuyển
														khoản</option>

												</select>
											</div>

										</div>
										<button type="button" onclick=methodPayment()
											class="btn btn-primary m-t-15 waves-effect"
											style="float: right;">Xác nhận</button>
										<button type="button"
											class="btn btn-primary m-t-15 waves-effect"
											onclick="onBack()" style="float: left;">Quay lại</button>
									</div>
								</s:form>
							</div>
						</div>




					</div>
				</div>
			</div>
		</div>
	</section>
	<jsp:include page="menu/lib.jsp" />
	<script>
	document.getElementById("selectedTicketType").addEventListener('change',function() {	
		<%List<TicketType> listTicket = (List<TicketType>) session.getAttribute("listTicket"); %>
	    var selectedValue = $(this).val();
	    let data = [];
		console.log("ngay : ", selectedValue);
		<%for (TicketType ticket : listTicket) {%>
        data.push('<%=ticket.getTicketTypeName()%>');
<%}%>
	console.log("ngay hien tai: ", data);
				if (!data.includes(selectedValue)) {
					alert("Loại vé không hợp lệ.");
					$(this).val("");
				}
			}); 
	document.getElementById("selectedMethodPayment").addEventListener('change',function() {	

	    var selectedValue = $(this).val();
	    let data = [];
		console.log("ngay : ", selectedValue);
        data.push('Tiền mặt');
        data.push('Chuyển khoản');
	console.log("ngay hien tai: ", data);
				if (!data.includes(selectedValue)) {
					alert("Phương thức thanh toán không hợp lệ.");
					$(this).val("");
				}
			}); 
		function onBack() {
			window.location.href = "<s:url action='bookingTicketAction'/>";
		}

		function methodPayment(){
			const TicketType = document.getElementById('selectedTicketType').value;
			const MethodPayment = document
					.getElementById('selectedMethodPayment').value;
			console.log(TicketType);
			if (TicketType === "") {
				alert('Bạn chưa chọn lọai vé!!');
			} else if (MethodPayment === "") {
				alert('Bạn chưa chọn phương thức thanh toán!!');
			} else {

				window.location.href = "Payment?selectedTicketType="
						+ TicketType + "&&selectedMethodPayment="
						+ MethodPayment;
			}
		}
	</script>
	<style>
	label{
	color:#000;
	}
	<style>
</body>
<style>
</html>

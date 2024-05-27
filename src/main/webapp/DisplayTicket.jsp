<!DOCTYPE html>
<%@page import="com.fpt.ojtstem.model.Account"%>
<html>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" />
<link rel="stylesheet" type="text/css" href="style/print/print.min.css" />
<link rel="stylesheet" type="text/css" href="style/css/styleTicket.css" />
<title>Admin_Quản lý thể loai</title>
<head>
<jsp:include page="menu/lib_Head.jsp" />
</head>
<body class="theme-red">
	<jsp:include page="menu/nav_nv.jsp" />
	<section class="content">
		<div class="container-fluid">

			<!-- Input -->
			<div class="row clearfix">
				<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
					<div class="card">

						<div class="body">
							<div class="header">
								<h2 style="text-align: center;">THÔNG TIN VÉ ĐÃ ĐẶT</h2>
							</div>
							<div class="body">
								<div class="row clearfix">
									<div class="col-sm-12">
										<form method="post" action="#" id="printJS-form">
											<s:iterator value="listInvoice" var="invoice">
												<div class="ticket created-by-anniedotexe">
													<div class="left">
														<div class="image">
															<div class="ticket-number">
																<img src="img/<s:property value="movie.image" />"
																	style="width: 95%; padding-left: 10px; height: 90%;">
															</div>
														</div>
														<div class="ticket-info">
															<div class="show-name">
																<h1>
																	<s:property value="movie.movieName" />
																</h1>
																<h2>
																	<s:property value="movie.actor" />
																</h2>
															</div>
															<div class="time">
																<p>
																	<s:property value="showTime.fromTime" />
																	<span> TO</span>
																	<s:property value="showTime.toTime" />
																</p>
																<p>
																	<s:property value="room.roomName" />
																	<span>@</span> Chỗ ngồi:
																	<s:property value="#invoice.seatId" />
																</p>
															</div>
															<p class="location">
																<span>Như Cinemal</span> <span class="separator"><i
																	class="far fa-smile"></i></span> <span>11/131 Trần Phú,
																	Phước Vĩnh, Huế</span>
															</p>
														</div>
													</div>
													<div class="right">
														<div class="right-info-container">
															<div class="show-name">
																<h1>Như Cinemal</h1>
															</div>
															<div class="time">
																<p>
																	<s:property value="showTime.fromTime" />
																	<span> TO</span>
																	<s:property value="showTime.toTime" />
																</p>
																<p>
																	<s:property value="room.roomName" />
																	<span> @ </span> Chỗ ngồi:
																	<s:property value="#invoice.seatId" />
																</p>
															</div>
															<p class="ticket-number">
																#
																<s:property value="#invoice.invoiceID" />
															</p>
														</div>
													</div>
												</div>
												<br />
											</s:iterator>
										</form>

									</div>
								</div>

								<button type="button" class="btn btn-dark m-t-15 waves-effect"
									onclick="printJS('printJS-form', 'html')">In</button>

							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<jsp:include page="menu/lib.jsp" />
	</section>
	<style>
	label{
	color:#000;
	}
	<style>
	<script src="style/print/print.min.js"></script>

</body>

</html>
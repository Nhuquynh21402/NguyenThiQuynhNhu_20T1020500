
<!DOCTYPE html>
<%@page import="com.fpt.ojtstem.model.Statistic"%>
<%@page import="java.util.List"%>
<%@page import="com.fpt.ojtstem.model.Account"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html lang="en">
<head>
<title>ADMIN_NHU-CINEMA</title>
<meta charset="UTF-8">
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>

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
							<h2 class="card-inside-title">Doanh thu</h2>
							<div class="row clearfix" >
								<div class="col-sm-12">
									<div class="row clearfix">
										<div class="col-lg-3 col-md-3 col-sm-6 col-xs-12">
											<div class="info-box bg-pink hover-expand-effect">
												<div class="icon">
													<i class="material-icons">shopping_cart</i>
												</div>
												<div class="content">
													<div class="text">Số lượng vé bán được</div>
												<s:if test="%{selectedTime.equals('week')}">
														<div class="number count-to" data-from="0" data-to="125"
															data-speed="15" data-fresh-interval="20">
															<s:property value="all.quantity" />
																</div>
												</s:if>
												<s:elseif test="%{selectedTime.equals('month')}">
														<div class="number count-to" data-from="0" data-to="125"
															data-speed="15" data-fresh-interval="20">
															<s:property value="all.quantity" />
																</div>
												</s:elseif>
												<s:else>
														<div class="number count-to" data-from="0" data-to="125"
															data-speed="15" data-fresh-interval="20">
															<s:property value="#session['all'].quantity" />
														</div>
													</s:else>
													
												</div>
											</div>
										</div>
										<div class="col-lg-3 col-md-3 col-sm-6 col-xs-12">
											<div class="info-box bg-cyan hover-expand-effect">
												<div class="icon">
													<i class="material-icons">attach_money</i>
												</div>
												<div class="content">
													<div class="text">Doanh thu</div>
													<s:if test="%{selectedTime.equals('week')}">
													<div class="number count-to" data-from="0" data-to="257"
															data-speed="1000" data-fresh-interval="20">
															<s:property value="all.income" />
														</div>
													</s:if>
													<s:elseif test="%{selectedTime.equals('month')}">
														<div class="number count-to" data-from="0" data-to="257"
															data-speed="1000" data-fresh-interval="20">
															<s:property value="all.income" />
															</div>
													</s:elseif>
													<s:else>
													<div class="number count-to" data-from="0" data-to="257"
														data-speed="1000" data-fresh-interval="20">
														<s:property value="#session['all'].income" />
													</div>
													</s:else>
													
												</div>
											</div>
										</div>
										
									<s:if test="%{selectedTime.equals('week')}">
									<div class="col-xs-12 col-sm-12 col-md-4 col-lg-3" style="float: right;">
											<div class="card">
												<div class="header">
													<h2>SƠ ĐỒ DOANH THU TRONG TUẦN</h2>
													
												</div>
												<div class="body">
												<canvas id="dashboardChart"></canvas>
												</div>
											</div>
										</div>
									</s:if>
									<s:elseif test="%{(selectedCriteria.equals('income')&& selectedTime.equals('week')) || (selectedCriteria == null && selectedTime.equals('week'))}">
									<div class="col-xs-12 col-sm-12 col-md-4 col-lg-3" style="float: right;">
											<div class="card">
												<div class="header">
													<h2>SƠ ĐỒ DOANH THU TRONG TUẦN</h2>
													
												</div>
												<div class="body">
												<canvas id="dashboardChart"></canvas>
												</div>
											</div>
										</div>
									</s:elseif>
									<s:elseif test="%{(selectedCriteria.equals('income')&& selectedTime.equals('month')}) || (selectedCriteria == null && selectedTime.equals('month')})">
									<div class="col-xs-12 col-sm-12 col-md-4 col-lg-3" style="float: right;">
											<div class="card">
												<div class="header">
													<h2>SƠ ĐỒ DOANH THU TRONG THÁNG</h2>
													
												</div>
												<div class="body">
												<canvas id="dashboardChart"></canvas>
												</div>
											</div>
										</div>
									</s:elseif>
									<s:elseif test="%{selectedCriteria.equals('quantity')&& selectedTime.equals('month')}">
									<div class="col-xs-12 col-sm-12 col-md-4 col-lg-3" style="float: right;">
											<div class="card">
												<div class="header">
													<h2>SƠ ĐỒ SỐ LƯỢNG VÉ BÁN RA TRONG THÁNG</h2>
													
												</div>
												<div class="body">
												<canvas id="dashboardChart"></canvas>
												</div>
											</div>
										</div>
									</s:elseif>
									<s:elseif test="%{selectedCriteria.equals('quantity')&& selectedTime.equals('month')}">
									<div class="col-xs-12 col-sm-12 col-md-4 col-lg-3" style="float: right;">
											<div class="card">
												<div class="header">
													<h2>SƠ ĐỒ SỐ LƯỢNG VÉ BÁN RA TRONG TUẦN</h2>
													
												</div>
												<div class="body">
												<canvas id="dashboardChart"></canvas>
												</div>
											</div>
										</div>
									</s:elseif>
									<s:else>
										<div class="col-xs-12 col-sm-12 col-md-4 col-lg-3" style="float: right;">
											<div class="card">
												<div class="header">
													<h2>SƠ ĐỒ DOANH THU TRONG NGÀY</h2>
													
												</div>
												<div class="body">
												<canvas id="dashboardChart"></canvas>
												</div>
											</div>
										</div>
									</s:else>

										<!-- #END# Browser Usage -->
										<div class="col-xs-12 col-sm-12 col-md-4 col-lg-3"
											style="border: 1px solid; background-color: #8BC34A; color: #fff; box-shadow: 2px 2px 2px 2px #EEEEEE;">
											<div class="header">
												<h2 style=" color: #fff;">BẢNG CHỌN</h2>
											</div>
											<br> <label style="text-align: center;">Chọn
												tiêu chí:</label> <select class="form-control show-tick"
												name="selectedCriteria" id="selectedCriteria">
												<s:if test="%{selectedCriteria != null}">
											     	<s:if test="%{selectedCriteria.equals('quantity')}" >
											     	<option value="quantity" style="text-align: center;">Số
													lượng</option>
												    </s:if>
													<s:else>
														<option value="income" style="text-align: center;">Doanh
													thu</option>
													</s:else>
												</s:if>
												<s:else>
													<option value="" style="text-align: center;">Chọn
														tiêu chí</option>
												</s:else>
												<option value="quantity" style="text-align: center;">Số
													lượng</option>
												<option value="income" style="text-align: center;">Doanh
													thu</option>
											</select>
											<div style="height: 20px;"></div>
											<div style="height: 20px;"></div>
											<div style="height: 20px;"></div>
											<br> <label style="text-align: center;">Chọn
												thời gian:</label> <select class="form-control show-tick"
												name="selectedTime" id="selectedTime">
												<s:if test="%{selectedTime != null}">
												   <s:if test="%{selectedTime .equals('day')}">
													<option value="day" style="text-align: center;">Theo ngày</option>
													</s:if>
													  <s:elseif test="%{selectedTime .equals('week')}">
													  	<option value="week" style="text-align: center;">Theo tuần</option>
													</s:elseif>
													<s:else>
													<option value="month" style="text-align: center;">Theo tháng</option>
											        </s:else>
												</s:if>
												<s:else>
													<option value="" style="text-align: center;">Chọn
														thời gian thống kê</option>
												</s:else>

												<option value="day" style="text-align: center;">Theo
													ngày</option>
												<option value="week" style="text-align: center;">Theo
													tuần</option>
												<option value="month" style="text-align: center;">Theo
													tháng</option>

											</select>
											<div style="height: 60px;"></div>

									
											<div style="height: 55px;"></div>
                                             </div>
										</div>
                               <div class="body">
										<div class="row clearfix">
										<div class="col-sm-12">
											<div class="table-responsive">
												<h2 style="text-align: center;">BẢNG THỐNG KÊ DOANH THU</h2>
									            	 <table class="table table-bordered">
													<s:if test="%{selectedCriteria.equals('quantity')}">
														<thead style="background-color: #ce1126; color: #fff;">
															<tr>
																<th style="text-align: center;">TÊN PHIM</th>
																<th style="text-align: center;">SỐ LƯỢNG VÉ</th>
															</tr>
														</thead>
														<tbody>
															<s:iterator value="movies" var="movie">
																<tr>
																	<td  style="text-align: center;"><s:property value="#movie.movieName" /></td>
																	<td  style="text-align: center;"><s:property value="#movie.quantity" /></td>

																</tr>
															</s:iterator>
														</tbody>
													</s:if>
													<s:elseif test="%{selectedCriteria.equals('income')}">
														<thead style="background-color: #00c300; color: #fff;">
															<tr>
																<th style="text-align: center;">TÊN PHIM</th>
																<th style="text-align: center;">DOANH THU</th>
															</tr>
														</thead>
														<tbody>
															<s:iterator value="movies" var="movie">
																<tr>
																	<td style="text-align: center;"><s:property value="#movie.movieName" /></td>
																	<td style="text-align: center;"><s:property value="#movie.income" /></td>
																</tr>
															</s:iterator>
														</tbody>
													</s:elseif>
													<s:elseif
														test="%{selectedCriteria.equals('income')&& selectedTime!=null}">
														<thead style="background-color: #780062; color: #fff;">
															<tr>
																<th style="text-align: center;">TÊN PHIM</th>
																<th style="text-align: center;">DOANH THU</th>
															</tr>
														</thead>
														<tbody>
															<s:iterator value="movies" var="movie">
																<tr>
																	<td style="text-align: center;"><s:property value="#movie.movieName" /></td>
																	<td style="text-align: center;"><s:property value="#movie.income" /></td>
																</tr>
															</s:iterator>
														</tbody>
													</s:elseif>
													<s:elseif
														test="%{selectedCriteria.equals('quantity')}&& selectedTime!=null}">
														<thead style="background-color: #F9F400; color: #fff;">
															<tr>
																<th style="text-align: center;">TÊN PHIM</th>
																<th style="text-align: center;">SỐ LƯỢNG VÉ</th>
															</tr>
														</thead>
														<tbody>
															<s:iterator value="movies" var="movie">
																<tr style="text-align: center;">
																	<td style="text-align: center;"><s:property value="#movie.movieName" /></td>
																	<td style="text-align: center;"><s:property value="#movie.quantity" /></td>

																</tr>
															</s:iterator>
														</tbody>
													</s:elseif>
													<s:else>
														<thead style="background-color: #1769ff; color: #fff;" >
															<tr >
																<th style="text-align: center;">TÊN PHIM</th>
																<th style="text-align: center;">SỐ LƯỢNG VÉ</th>
																<th style="text-align: center;">DOANH THU</th>
															</tr>
														</thead>
														<tbody>
															<s:iterator value="movies" var="movie">
																<tr style="text-align: center;">
																	<td style="text-align: center;"><s:property value="#movie.movieName" /></td>
																	<td style="text-align: center;"><s:property value="#movie.quantity" /></td>
																	<td style="text-align: center;"><s:property value="#movie.income" /></td>
																</tr>
															</s:iterator>
														</tbody>
													</s:else>

												</table>
											</div>
										</div>

									</div>
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
	$("#selectedCriteria")
			.on(
					"change",
					function() {
						var selectedCriteria = $(this).val();
						window.location.href = "selectedCriteriaAction?selectedCriteria="
								+ selectedCriteria;
					});

	$("#selectedTime")
			.on(
					"change",
					function() {
						var selectedTime = $(this).val();
						console.log(selectedTime);
						var selectElement = document
								.getElementById('selectedCriteria');
						var selectedCriteria = selectElement.value;
						window.location.href = "selectedTimeAction?selectedTime="
								+ selectedTime
								+ "&selectedCriteria="
								+ selectedCriteria;
					});
	var selectedCriteria = document.getElementById('selectedCriteria');
	var selectedTime = document.getElementById('selectedTime');


</script> 
<script>

var selectElement = document.getElementById('selectedCriteria');
var selectedCriteria = selectElement.value;
var selectElement = document.getElementById('selectedTime');
var selectedTime = selectElement.value;
var movieNames = [];
var incomes = []; 
function decodeHtmlEntities(str) {
    return str.replace(/&[^\s]*;/g, function (entity) {
        var char = {
            '&aacute;': 'á',
            '&ugrave;': 'ù',
            '&agrave;': 'à',
        }[entity];
        return char || entity;
    });
}
if (selectedTime === "week" || selectedTime === "month") {

    <s:iterator value="movies" var="movie">
      var movieName = '<s:property value="#movie.movieName" />';
      var income = '<s:property value="#movie.income" />';
      movieNames.push(decodeHtmlEntities(movieName));
      incomes.push(decodeURI(income));
	  </s:iterator> 
	  console.log("Danh sách tên phim: ", movieNames);
}
else {
		var button = document.getElementById('myButton');
<% List<Statistic> allIncome = (List<Statistic>) session.getAttribute("allIncome");%>
	    <%for (Statistic statistic : allIncome) {%>
	    movieNames.push('<%=statistic.getMovieName()%>');
	    <%}%>
	    <%for (Statistic statistic : allIncome) {%>
	    incomes.push('<%=statistic.getIncome()%>');
	    <%}%>
	
	    console.log("Danh sách tên phim: ", movieNames); 
}
var ctx = document.getElementById('dashboardChart').getContext('2d');
var myChart = new Chart(ctx, {
    type: 'doughnut',
    data: {
        labels: movieNames,
        datasets: [{
            label: 'Tổng tiền: ',
            data: incomes ,
            backgroundColor: [
            	'#E91E63',
                'rgba(54, 162, 235, 0.2)',
                'rgba(255, 206, 86, 0.2)',
                'rgb(255, 152, 0)'
            ],
            borderColor: [
                'rgba(255, 99, 132, 1)',
                'rgba(54, 162, 235, 1)',
                'rgba(255, 206, 86, 1)'
            ],
            borderWidth: 1
        }]
    },
    options: {
    }
});

</script>


</html>
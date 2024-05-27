
<!DOCTYPE html>
<%@page import="com.fpt.ojtstem.model.Account"%>
<html lang="en">
<head>
<title>ADMIN_NHU-CINEMA</title>
<meta charset="utf-8">
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<%@ taglib prefix="s" uri="/struts-tags"%>
<jsp:include page="menu/lib_Head.jsp" />
</head>
<body class="theme-red">
	<jsp:include page="menu/nav_nv.jsp" />
	<section class="content">
		<div class="container-fluid">
			<div class="row clearfix">
				<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
					<div class="card">

						<div class="body">
							<h2 class="card-inside-title">
								CHÀO MỪNG ĐẾN VỚI CA LÀM VIỆC CỦA BẠN:
								
							</h2>
							<div class="row clearfix">
							<!-- 	<div class="image-container">
									<img src="img/Nhu.png" alt="Animated Image">
								</div> -->
							</div> 
							<audio controls>
								<source src="style/audio/jessie_j_price_tag_ft_b_o_b_Ik1R83IByoK-gucZWmzr.mp3" type="audio/mpeg">
							</audio>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>

	<jsp:include page="menu/lib.jsp" />

</body>
<style>
/* Định dạng container của hình ảnh */
.image-container {
	width: 300px; /* Định kích thước của container */
	height: 300px;
	overflow: hidden; /* Ẩn phần vượt ra ngoài của hình ảnh */
	position: relative;
	/* Để có thể định vị tuyệt đối cho hình ảnh bên trong */
}

/* Định dạng hình ảnh */
.image-container img {
	width: 100%; /* Đảm bảo hình ảnh điền đầy container */
	height: auto; /* Tự động tính toán chiều cao dựa trên chiều rộng */
	display: block; /* Đảm bảo hình ảnh hiển thị là một block element */
	position: absolute; /* Định vị tuyệt đối để điều khiển vị trí */
	top: 0;
	left: 0;
	animation: shake 0.5s infinite; /* Áp dụng animation cho hình ảnh */
}

/* Định nghĩa keyframes cho animation */
@
keyframes shake { 0% {
	transform: translateX(0);
} /* Khoảng thời gian ban đầu */
25
%
{
transform
:
translateX(
-5px
);
} /* Di chuyển sang trái */
50
%
{
transform
:
translateX(
5px
);
} /* Di chuyển sang phải */
75
%
{
transform
:
translateX(
-5px
);
} /* Di chuyển sang trái */
100
%
{
transform
:
translateX(
0
);
} /* Trở lại vị trí ban đầu */
}
</style>
</html>
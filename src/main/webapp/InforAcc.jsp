
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
	<link rel="stylesheet" href="./assets/css/style.css">
<%@ taglib prefix="s" uri="/struts-tags"%>
<jsp:include page="menu/lib_Head.jsp" />
</head>
<body class="theme">
	<nav class="navbar" style="border: 2px solid white; background-color: #000;">
	<div class="container">

      <div class="header-actions" style="float: right;">

          <% Account acc = (Account) session.getAttribute("user");
       if(acc!= null){%>
       <a href="inforAcc" class="navbar-link"><%=acc.getUserName()%></a>
       <a href="LogoutAction" class="navbar-link">Đăng xuất </a>
       <%}else {%>
       <a href="login" class="navbar-link">Đăng nhập</a>
       <a href="signup" class="navbar-link">Đăng kí </a>
       <%}%>

      </div>

      <button class="menu-open-btn" data-menu-open-btn>
        <ion-icon name="reorder-two"></ion-icon>
      </button>

      <nav class="navbar" data-navbar>

        <ul class="navbar-list">

          <li>
            <a href="page" class="navbar-link">Trang chủ</a>
          </li>

          <li>
            <a href="#" class="navbar-link">Phim</a>
          </li>

          <li>
            <a href="#" class="navbar-link">Lịch chiếu</a>
          </li>

      

        </ul>

        <ul class="navbar-social-list">

          <li>
            <a href="#" class="navbar-social-link">
              <ion-icon name="logo-twitter"></ion-icon>
            </a>
          </li>

          <li>
            <a href="#" class="navbar-social-link">
              <ion-icon name="logo-facebook"></ion-icon>
            </a>
          </li>

          <li>
            <a href="#" class="navbar-social-link">
              <ion-icon name="logo-pinterest"></ion-icon>
            </a>
          </li>

          <li>
            <a href="#" class="navbar-social-link">
              <ion-icon name="logo-instagram"></ion-icon>
            </a>
          </li>

          <li>
            <a href="#" class="navbar-social-link">
              <ion-icon name="logo-youtube"></ion-icon>
            </a>
          </li>

        </ul>

      </nav>

    </div>
	</nav>
	<!-- #Top Bar -->
	<section >
		<!-- Left Sidebar -->
		<aside id="leftsidebar" class="sidebar" style="border: 2px solid white;">
			<%Account account = (Account) session.getAttribute("user"); %>
		<h2><%=account.getUserName() %></h2>
			<!-- User Info -->
			<div class="user-info" style="background-color: black;">
				<div class="iNhmage">
					<img src="img/img.jpg" width="200" height="100" alt="User"  style="margin-left: 30px; border: 3px solid white;  border-radius: 300px; box-shadow: 5px #FFFFFF;" />
				
				</div>
				
			</div>
			<!-- #User Info -->
			<!-- Menu -->
			<div class="menu" style="background-color: black; ">
				<ul class="list">
					<li class="header" style="background-color: white;"></li>
					<li><a href="InforAcc" style="color: white;"> <i class="material-icons">person</i> <span style="color: white;">THÔNG TIN TÀI KHOẢN</span>
					</a></li>
					<li><a href="showInvoice"> <i class="material-icons" style="color: white;">movie</i>
							<span style="color: white;">QUẢN LÝ BÁN VÉ</span>
					</a></li>
					<li style="color: white;"><a  onclick="logout()"> <i
							class="material-icons col-red" style="color: white;">donut_large</i> <span style="color: white;">Đăng
								xuất</span>
					</a></li>
			
				</ul>
			</div>
			<!-- #Menu -->
			<!-- Footer -->
			<div class="legal" style="background-color: black;">
				<div class="copyright" style="color: white;">
					&copy; Của như <a href="javascript:void(0);">Rạp chiếu của Như</a>.
				</div>
				<div class="version" style="color: white;">
					<b>Version: </b> 29/02/2024
				</div>
			</div>
			<!-- #Footer -->
		</aside>
		<!-- #END# Left Sidebar -->
	</section>
	<section class="content">
		<div class="container-fluid">
			<div class="row clearfix">
				<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
					<div class="card">

						<div class="body">
							<div class="header">
								<h2>THÔNG TIN TÀI KHOẢN</h2>
							</div>
							<div class="body">
								<s:actionerror />
								<label>Tên tài khoản</label>
								<div class="form-group">
									<div class="form-line">
										<p>
											<%=acc.getUserName()%>
										</p>
									</div>
								</div>


								<label>Họ tên</label>
								<div class="form-group">
									<div class="form-line">
										<p>
											<%=acc.getFullName()%>
										</p>

									</div>
								</div>
								<label>Số điện thoại</label>
								<div class="form-group">
									<div class="form-line">
										<p>
											<%=acc.getSDT()%>
										</p>

									</div>
								</div>
								<label>Email</label>
								<div class="row clearfix">
									<div class="col-sm-12">
										<div class="form-group">
											<div class="form-line">
												<p>
													<%=acc.getEmail()%>
												</p>


											</div>
										</div>
									</div>
								</div>
								<button class="btn btn-primary m-t-15 waves-effect"
											onclick="UpdateRoom(this,'<s:property value="room.roomId" />')">Chỉnh sửa tài khoản</button>
										<button type="button"
											class="btn btn-primary m-t-15 waves-effect"
											onclick="onBack()" style="float: right;">Đổi mật khẩu</button>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>

	<jsp:include page="menu/lib.jsp" />

</body>
<style>
label{
color: #000;
}
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
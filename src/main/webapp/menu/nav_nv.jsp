	<%@page import="com.fpt.ojtstem.model.Account"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

	<nav class="navbar" style="border: 2px solid white;">
		<div class="container-fluid" style="background-color: #000000;">
			<div class="navbar-header"  style="float: right;">
					<img src="img/movie.jpg"  width="150" height="50" border="3px solid black" style="border-radius: 50px;"  />	  
			</div>
				<div class="navbar-header" >
			<a class="navbar-brand" href="../../index.html">NHƯ_CHỦ RẠP CHIẾU</a>
			</div>
			
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
					<img src="./assets/img/logo.jpg" width="200" height="100" alt="User"  style="margin-left: 30px; border: 3px solid white;  border-radius: 300px; box-shadow: 5px #FFFFFF;" />
				
				</div>
				
			</div>
			<!-- #User Info -->
			<!-- Menu -->
			<div class="menu" style="background-color: black; ">
				<ul class="list">
					<li class="header" style="background-color: white;"></li>
					<li><a href="index" style="color: white;"> <i class="material-icons">person</i> <span style="color: white;">Trang chủ</span>
					</a></li>
					<li><a href="BookingTicket"> <i class="material-icons" style="color: white;">movie</i>
							<span style="color: white;">QUẢN LÝ BÁN VÉ</span>
					</a></li>
					<li><a href=""> <i class="material-icons" style="color: white;">text_fields</i>
							<span style="color: white;">QUẢN LÝ TÀI KHOẢN</span>
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
<script >
function logout() {
	if (confirm('Bạn có chắc chắn muốn đăng xuất khỏi hệ thống ?')){
		window.location.href = 'LogoutAction';
	}

}
</script>
	
	

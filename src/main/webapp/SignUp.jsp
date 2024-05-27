
<!DOCTYPE html>
<html>
<%@ taglib prefix="s" uri="/struts-tags"%>
<head>
    <meta charset="UTF-8">
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
      <%@page contentType="text/html" pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>HỆ THỐNG QUẢN LÝ RẠP CHIẾU PHIM</title>
    <!-- Favicon-->
    <link rel="icon" href="../../favicon.ico" type="image/x-icon">

    <!-- Google Fonts -->
    <link href="https://fonts.googleapis.com/css?family=Roboto:400,700&subset=latin,cyrillic-ext" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet" type="text/css">

    <!-- Bootstrap Core Css -->
    <link href="style/plugins/bootstrap/css/bootstrap.css" rel="stylesheet">

    <!-- Waves Effect Css -->
    <link href="style/plugins/node-waves/waves.css" rel="stylesheet" />

    <!-- Animation Css -->
    <link href="style/plugins/animate-css/animate.css" rel="stylesheet" />

    <!-- Custom Css -->
    <link href="style/css/style.css" rel="stylesheet">
</head>

<body class="login-page">
    <div class="login-box">
        <div class="logo">
            <br/>
        </div>
        <div class="card">
            <div class="body">
            
                <form id="sign_in" method="POST" action="signuppro">
                	<s:actionerror />
                    <div class="msg"><h1>Đăng kí</h1></div>
                    <div class="input-group">
                        <span class="input-group-addon">
                            <i class="material-icons">person</i>
                        </span>
                        <div class="form-line">
                            <input type="text" class="form-control" name="account.userName" placeholder="Tên tài khoản" required autofocus>
                        </div>
                    </div>
                    <div class="input-group">
                        <span class="input-group-addon">
                            <i class="material-icons">lock</i>
                        </span>
                        <div class="form-line">
                            <input type="password" class="form-control" name="account.passWord" placeholder="Mật khẩu" required>
                        </div>
                    </div>
                      <div class="input-group">
                        <span class="input-group-addon">
                            <i class="material-icons">lock</i>
                        </span>
                        <div class="form-line">
                            <input type="password" class="form-control" name="prePassWord" placeholder="Nhập lại mật khẩu" required>
                        </div>
                    </div>
                     <div class="input-group">
                        <span class="input-group-addon">
                            <i class="material-icons">person</i>
                        </span>
                        <div class="form-line">
                            <input type="text" class="form-control" name="account.fullName" placeholder="Họ tên" required autofocus>
                        </div>
                    </div>
                     <div class="input-group">
                        <span class="input-group-addon">
                            <i class="material-icons">phone</i>
                        </span>
                        <div class="form-line">
                            <input type="text" class="form-control" name="account.SDT" placeholder="Số điện thoại" required autofocus>
                        </div>
                    </div>
                      <div class="input-group">
                        <span class="input-group-addon">
                            <i class="material-icons">email</i>
                        </span>
                        <div class="form-line">
                            <input type="text" class="form-control" name="account.email" placeholder="Email" required autofocus>
                        </div>
                    </div>
                    <div class="row">
                            <button class="btn btn-block bg-pink waves-effect" type="submit" style="margin-right: 15px;">ĐĂNG NHẬP</button>
                  
                    </div>
                   
                </form>
            </div>
        </div>
    </div>

   </body>
<style>
.btn-block {
    float: right;
    width: 100px;
}
</style>

</html>
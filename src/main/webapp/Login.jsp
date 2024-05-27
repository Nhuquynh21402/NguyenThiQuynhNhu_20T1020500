
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
            
                <form id="sign_in" method="POST" action="loginprocess">
                	<s:actionerror />
                    <div class="msg"><h1>Đăng nhập</h1></div>
                    <div class="input-group">
                        <span class="input-group-addon">
                            <i class="material-icons">person</i>
                        </span>
                        <div class="form-line">
                            <input type="text" class="form-control" name="username" placeholder="Tên tài khoản" required autofocus>
                        </div>
                    </div>
                    <div class="input-group">
                        <span class="input-group-addon">
                            <i class="material-icons">lock</i>
                        </span>
                        <div class="form-line">
                            <input type="password" class="form-control" name="password" placeholder="Mật khẩu" required>
                        </div>
                    </div>
                    <div class="row">
                            <button class="btn btn-block bg-pink waves-effect" type="submit" style="margin-right: 15px;">ĐĂNG NHẬP</button>
                  
                    </div>
                   
                </form>
            </div>
        </div>
    </div>

    <!-- Jquery Core Js -->
    <script src="style/plugins/jquery/jquery.min.js"></script>

    <!-- Bootstrap Core Js -->
    <script src="style/plugins/bootstrap/js/bootstrap.js"></script>

    <!-- Waves Effect Plugin Js -->
    <script src="style/plugins/node-waves/waves.js"></script>

    <!-- Validation Plugin Js -->
    <script src="style/plugins/jquery-validation/jquery.validate.js"></script>

    <!-- Custom Js -->
    <script src="style/js/admin.js"></script>
    <script src="style/js/pages/examples/sign-in.js"></script>
</body>
<style>
.btn-block {
    float: right;
    width: 100px;
}
</style>

</html>
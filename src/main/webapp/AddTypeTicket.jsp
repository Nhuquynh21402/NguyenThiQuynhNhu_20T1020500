<%@ page import="com.fpt.ojtstem.model.Account" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>Admin_Quản lý thể loại vé</title>
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
                            <h2 style="text-align: center;">BẢNG ĐIỀN THÔNG TIN THỂ
                                LOẠI VÉ</h2>
                        </div>
                        <div class="row clearfix">
                            <div class="col-sm-12">
                                <s:actionerror />
                                <s:form action="AddTypeTicketAction" method="post">
                                    <label for="ticketTypeName">Tên thể loại vé</label>
                                    <div class="form-group">
                                        <div class="form-line">
                                            <input type="text" id="ticketTypeName"
                                                   name="ticket.ticketTypeName" class="form-control"
                                                   placeholder="Nhập vào tên thể loại vé">
                                        </div>
                                        <div id="ticketTypeName_error" style="color: red;"></div>
                                    </div>
                                    <label for="price">Giá vé</label>
                                    <div class="form-group">
                                        <div class="form-line">
                                            <input type="text" id="price" name="ticket.price"
                                                   class="form-control" placeholder="Nhập vào giá vé">
                                        </div>
                                        <div id="price_error" style="color: red;"></div>
                                    </div>
                                    <br>
                                  	<button type="submit"
											class="btn btn-primary m-t-15 waves-effect">Save</button>
                                    </button>
                                    <button type="button"
                                            class="btn btn-dark m-t-15 waves-effect text-white"
                                            onclick="onBack()" style="float: right;">Quay lại
                                    </button>
                                </s:form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<style>
	label{
	color:#000;
	}
	<style>
<jsp:include page="menu/lib.jsp" />
<script>
    function onBack() {
        window.location.href = "<s:url action='TypeTicket'/>";
    }

    $(document).ready(function () {
        $("#ticketTypeName").on('input', function () {
            var ticketTypeName = $(this).val();
            var errorElement = $("#ticketTypeName_error");

            if (ticketTypeName === "") {
                errorElement.text("Tên loại vé không được để trống.");
                return false;
            }
            if (ticketTypeName.length > 50) {
                errorElement.text("Tên loại vé không được dài hơn 50 ký tự.");
                return false;
            }

            var pattern = /^[\p{L}\s]+$/u;
            if (!pattern.test(ticketTypeName)) {
                errorElement.text("Tên thể loại vé chỉ được chứa các ký tự chữ cái");
                return false;
            }

            errorElement.text("");
            return true;
        });

        $("#price").on('input', function () {
            var price = $(this).val();
            var errorElement = $("#price_error");

            if (price === "") {
                errorElement.text("Giá vé không được để trống.");
                return false;
            }
            if (price.length > 6) {
                errorElement.text("Giá vé không được quá 100.000 !!");
                return false;
            }

            var pattern = /^\d+$/u;
            if (!pattern.test(price)) {
                errorElement.text("Giá vé phải là số ");
                return false;
            }

            errorElement.text("");
            return true;
        });
    });
</script>
</body>
</html>

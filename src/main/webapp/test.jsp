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
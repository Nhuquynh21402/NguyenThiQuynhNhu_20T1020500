
// Kiểm tra độ dài chuỗi nhập vào 
function limitByteLength(element, maxLength) {
	// var str = "こんにちはこんにちはこんにちはこ";
    const inputValue = element.value;
    let byteCount = 0;
    
    for (let i = 0; i < inputValue.length; i++) {
        const charCode = inputValue.charCodeAt(i);
        // Kiểm tra ký tự có mã Unicode mở rộng hay không
        if (charCode <= 0x7f) {
            // Ký tự ASCII, chiếm 1 byte
            byteCount += 1;
        } else if (charCode <= 0x7ff) {
            // Ký tự có mã Unicode từ 0x80 đến 0x7ff, chiếm 2 byte
            byteCount += 2;
        } else if (charCode <= 0xffff) {
            // Ký tự có mã Unicode từ 0x800 đến 0xffff, chiếm 3 byte
            byteCount += 3;
        } else {
            // Ký tự có mã Unicode từ 0x10000 trở lên, chiếm 4 byte
            byteCount += 4;
        }
        console.log("Độ dài chuỗi: ", byteCount, " byte")
        // Kiểm tra xem tổng số byte đã vượt quá giới hạn cho trước không
        if (byteCount >= maxLength) {
            // Nếu vượt quá, cắt chuỗi nhập để đảm bảo không vượt quá giới hạn byte
            element.value = inputValue.substring(0, i);
            break;
        }
    }
}

// Kiểm tra select list 
document.getElementById('statusSelect').addEventListener('change', function() {
    var selectedValue = this.value;
    var validValues = ["Đang hoạt động", "Đang bảo trì", "Đang sửa chữa", "Đóng cửa", "Đang sử dụng cho mục đích đặc biệt", "Khẩn cấp"];

    if (!validValues.includes(selectedValue)) {
        alert("Trạng thái phòng không hợp lệ. Vui lòng chọn một giá trị từ danh sách.");
        this.value = validValues[0];
    }
});

// Kiểm tra sau khi submit form
document.getElementById('newRoomForm').addEventListener('submit', function(event) {
    var selectedValue = document.getElementById('statusSelect').value;
    var validValues = ["Đang hoạt động", "Đang bảo trì", "Đang sửa chữa", "Đóng cửa", "Đang sử dụng cho mục đích đặc biệt", "Khẩn cấp"];

    if (!validValues.includes(selectedValue)) {
        alert("Trạng thái phòng không hợp lệ. Vui lòng chọn một giá trị từ danh sách.");
        this.value = validValues[0];
        event.preventDefault();
    }
});
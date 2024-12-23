function addJobToCartAjax(event, jobId) {
    event.preventDefault();

    fetch(`addJob?jid=` + jobId, {
        method: 'GET'
    })
        .then(response => {
            if (response.ok) {

                // Thay đổi biểu tượng trái tim sau khi lưu
                const heartIcon = event.target.closest('a').querySelector('i');
                heartIcon.classList.remove('fa-regular');
                heartIcon.classList.add('fa-solid');

            }
            else {
                alert('Có lỗi xảy ra!');
            }
        })
        .catch(error => {
            console.error('Error:', error);
            alert('Có lỗi xảy ra!');
        });

    return false; // Ngừng hành động mặc định (tránh thay đổi trang)
}
//  function change status button save job
function handleSaveButton(button) {
    // Kiểm tra trạng thái hiện tại
    const isSaved = button.classList.contains('isSaved');

    if (!isSaved) {
        button.classList.add('isSaved');
        button.textContent = 'Đã lưu';
        button.innerHTML = '<i class="fa-regular fa-heart"></i>Đã lưu'
    } else {
        // Reset về trạng thái ban đầu
        button.classList.remove('isSaved');
        button.className = 'save-button';
        button.innerHTML = '<i class="fa-regular fa-heart"></i>Lưu'
    }

}

// Lấy nút và thêm sự kiện click

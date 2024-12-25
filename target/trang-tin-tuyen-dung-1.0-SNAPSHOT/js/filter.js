    document.getElementById('show-all').addEventListener('click', function (e) {
    e.preventDefault();
    const hiddenLocations = document.querySelectorAll('.hidden-location');
    hiddenLocations.forEach(location => location.style.display = 'list-item');
});

    // Lắng nghe sự kiện change trên tất cả checkbox
    const checkboxes = document.querySelectorAll('input[name="location"]');
    checkboxes.forEach(checkbox => {
    checkbox.addEventListener('change', function () {
        const selectedLocations = Array.from(checkboxes)
            .filter(cb => cb.checked)
            .map(cb => cb.value);

        // Gửi AJAX request
        const xhr = new XMLHttpRequest();
        xhr.open('POST', 'filter-company', true);
        xhr.setRequestHeader('Content-Type', 'application/json; charset=UTF-8');

        xhr.onreadystatechange = function () {
            if (xhr.readyState === 4 && xhr.status === 200) {
                const response = JSON.parse(xhr.responseText);
                const companyListDiv = document.querySelector('.grid__company');
                companyListDiv.innerHTML = '';  // Xóa kết quả hiện tại

                // Cập nhật danh sách công ty
                response.forEach(company => {
                    console.log(company.img)
                    const companyCardHTML = `
        <div class="company-card">
            <a href="/html/job.html" class="company-card__link">
                <img src="${company.img}" class="picture" alt="Company Logo">
                <h3>${company.companyName}</h3>
                <p>0 việc đang tuyển</p>
                <p>${company.city}</p>
            </a>
        </div>
    `;

                    // Append the HTML to the container
                    const companyListDiv = document.querySelector('.grid__company');
                    companyListDiv.innerHTML += companyCardHTML;  // Cộng thêm HTML mới vào
                });
            }
        };

        // Gửi dữ liệu (danh sách địa điểm đã chọn)
        xhr.send(JSON.stringify({ locations: selectedLocations }));
    });
});

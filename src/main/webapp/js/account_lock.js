    function saveToCache(key, value) {
    localStorage.setItem(key, JSON.stringify(value));
}

    function getFromCache(key) {
    const value = localStorage.getItem(key);
    return value ? JSON.parse(value) : null;
}

    function removeFromCache(key) {
    localStorage.removeItem(key);
}

    function checkLockStatus() {
    fetch('check-lock-status')
        .then(response => response.json())
        .then(data => {
            if (data.locked) {
                saveToCache("accountLocked", true);
                alert("Tài khoản của bạn đã bị khóa. Bạn sẽ được đăng xuất.");
                window.location.href = "login.jsp";
            }
        });
}

    // Kiểm tra nếu localStorage đã bị khóa
    document.addEventListener("DOMContentLoaded", function () {
    var locked = getFromCache("accountLocked");
    if (locked) {
    removeFromCache("accountLocked");
    window.location.href = "login.jsp";
}
});

    // Chỉ gọi kiểm tra khi có tương tác người dùng
    let debounce = false;

    function handleUserInteraction() {
    if (!debounce) {
    debounce = true;
    checkLockStatus();
    setTimeout(() => debounce = false, 2000); // Chỉ check 1 lần mỗi 5 giây
}
}

    // Lắng nghe các tương tác chính
    window.addEventListener("click", handleUserInteraction);
    window.addEventListener("keydown", handleUserInteraction);
    window.addEventListener("mousemove", handleUserInteraction);

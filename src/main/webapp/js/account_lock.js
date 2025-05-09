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
function showLockPopup() {
    const popup = document.getElementById("lockPopup");
    if (popup) popup.style.display = "flex";
}
function checkLockStatus() {
    fetch(CONTEXT_PATH+`/check-lock-status`)
        .then(response => response.json())
        .then(data => {
            if (data.locked) {
                saveToCache("accountLocked", true);
                showLockPopup()
            }
        });
}

setInterval(checkLockStatus, 2500);

function redirectToLogin() {
    removeFromCache("accountLocked");
    window.location.href = "login.jsp";
}

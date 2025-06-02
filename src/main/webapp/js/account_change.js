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
function showChangePopup() {
    const popup = document.getElementById("changePopup");
    if (popup) popup.style.display = "flex";
}
function checkChangeStatus() {
    fetch(CONTEXT_PATH+`/check-change-status`)
        .then(response => response.json())
        .then(data => {
            if (data.changed) {
                saveToCache("accountChanged", true);
                showChangePopup()
            }
        });
}

setInterval(checkChangeStatus, 2500);

function redirectToLogin() {
    removeFromCache("accountChanged");
    window.location.href = "login.jsp";
}

document.addEventListener("DOMContentLoaded", function () {
    const searchInput = document.getElementById("searchInput");
    const menuItems = document.querySelectorAll("ul li");

    searchInput.addEventListener("input", function () {
        const query = searchInput.value.toLowerCase();

        for (let i = 0; i < menuItems.length; i++) {
            const item = menuItems[i];
            const text = item.textContent.toLowerCase();

            if (text.includes(query)) {
                item.style.display = "";
            } else {
                item.style.display = "none";
            }
        }
    });
});

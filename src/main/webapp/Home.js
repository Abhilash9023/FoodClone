let allRestaurantLinks = [];

window.onload = function () {
    const restaurantGrid = document.getElementById('restaurantGrid');
    allRestaurantLinks = Array.from(restaurantGrid.querySelectorAll('.card-link'));
};

function filterRestaurants() {
    const searchInput = document.getElementById('searchInput').value.toLowerCase();
    const restaurantGrid = document.getElementById('restaurantGrid');
    restaurantGrid.innerHTML = '';

    const matchingLinks = allRestaurantLinks.filter(link => {
        const restaurantName = link.getAttribute('data-name').toLowerCase();
        return restaurantName.includes(searchInput);
    });

    const linksToShow = (searchInput === '') ? allRestaurantLinks : matchingLinks;

    linksToShow.forEach(link => {
        restaurantGrid.appendChild(link);
    });
}

function sortRestaurants() {
    const sortBy = document.getElementById('sortSelect').value;
    const restaurantGrid = document.getElementById('restaurantGrid');
    const visibleLinks = Array.from(restaurantGrid.querySelectorAll('.card-link'));

    visibleLinks.sort((a, b) => {
        const aValue = a.getAttribute(`data-${sortBy}`);
        const bValue = b.getAttribute(`data-${sortBy}`);

        if (sortBy === 'rating') {
            return parseFloat(bValue) - parseFloat(aValue);
        } else if (sortBy === 'delivery') {
            return parseInt(aValue) - parseInt(bValue);
        } else {
            return aValue.localeCompare(bValue);
        }
    });

    restaurantGrid.innerHTML = '';
    visibleLinks.forEach(link => {
        restaurantGrid.appendChild(link);
    });
}

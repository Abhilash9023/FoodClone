// This will hold the original list of all card-link elements
let allRestaurantLinks = [];

window.onload = function () {
    const restaurantGrid = document.getElementById('restaurantGrid');
    allRestaurantLinks = Array.from(restaurantGrid.querySelectorAll('.card-link'));
};

// Function to filter restaurants based on search input
function filterRestaurants() {
    const searchInput = document.getElementById('searchInput').value.toLowerCase();
    const restaurantGrid = document.getElementById('restaurantGrid');

    // Clear the current grid
    restaurantGrid.innerHTML = '';

    // Filter matching card-links from the original list
    const matchingLinks = allRestaurantLinks.filter(link => {
        const restaurantName = link.getAttribute('data-name').toLowerCase();
        return restaurantName.includes(searchInput);
    });

    // Decide what to show: all or matching
    const linksToShow = (searchInput === '') ? allRestaurantLinks : matchingLinks;

    // Append only matching links back to the grid
    linksToShow.forEach(link => {
        restaurantGrid.appendChild(link);
    });
}

// Function to sort currently visible restaurants
function sortRestaurants() {
    const sortBy = document.getElementById('sortSelect').value;
    const restaurantGrid = document.getElementById('restaurantGrid');

    // Get only the currently visible cards in the grid
    const visibleLinks = Array.from(restaurantGrid.querySelectorAll('.card-link'));

    // Sort logic
    visibleLinks.sort((a, b) => {
        const aValue = a.getAttribute(`data-${sortBy}`);
        const bValue = b.getAttribute(`data-${sortBy}`);

        if (sortBy === 'rating') {
            return parseFloat(bValue) - parseFloat(aValue); // descending
        } else if (sortBy === 'delivery') {
            return parseInt(aValue) - parseInt(bValue); // ascending
        } else {
            return aValue.localeCompare(bValue); // name: alphabetically
        }
    });

    // Clear and re-append sorted cards
    restaurantGrid.innerHTML = '';
    visibleLinks.forEach(link => {
        restaurantGrid.appendChild(link);
    });
}

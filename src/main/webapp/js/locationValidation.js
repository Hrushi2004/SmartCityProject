function validateLocationForm() {
    let isValid = true;

    const name = document.getElementById('name').value.trim();
    const latitude = parseFloat(document.getElementById('latitude').value.trim());
    const longitude = parseFloat(document.getElementById('longitude').value.trim());

    // Clear previous errors
    document.getElementById('nameError').textContent = '';
    document.getElementById('latitudeError').textContent = '';
    document.getElementById('longitudeError').textContent = '';

    // Validate name
    if (name === '') {
        document.getElementById('nameError').textContent = 'Business Name is required.';
        isValid = false;
    }

    // Validate latitude
    if (isNaN(latitude) || latitude < -90 || latitude > 90) {
        document.getElementById('latitudeError').textContent = 'Latitude must be between -90 and 90.';
        isValid = false;
    }

    // Validate longitude
    if (isNaN(longitude) || longitude < -180 || longitude > 180) {
        document.getElementById('longitudeError').textContent = 'Longitude must be between -180 and 180.';
        isValid = false;
    }

    return isValid;
}

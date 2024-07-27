<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>City Map</title>
    <!-- Leaflet CSS -->
    <link rel="stylesheet" href="https://unpkg.com/leaflet/dist/leaflet.css" />
    <!-- Leaflet JS -->
    <script src="https://unpkg.com/leaflet/dist/leaflet.js"></script>
    <style>
        #map {
            height: 500px;
            width: 50%;
            margin: 0 auto;
            display: block;
        }
    </style>
    <script>
        function initMap() {
            var cityCenter = [16.515099, 80.632095]; // Center of the city

            var map = L.map('map').setView(cityCenter, 12); // Zoom level

            L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
                attribution: '&copy; <a href="https://www.openstreetmap.org/copyright">OpenStreetMap</a> contributors'
            }).addTo(map);

            L.marker(cityCenter).addTo(map)
                .bindPopup('Vijayawada')
                .openPopup();

            // Fetch and display business locations
            fetch('/get-locations')
                .then(response => response.json())
                .then(locations => {
                    locations.forEach(location => {
                        L.marker([location.latitude, location.longitude]).addTo(map)
                            .bindPopup(location.name);
                    });
                });
        }
        window.onload = initMap;
    </script>
</head>
<body>
    <h1>City Map</h1>
    <div id="map"></div>
</body>
</html>

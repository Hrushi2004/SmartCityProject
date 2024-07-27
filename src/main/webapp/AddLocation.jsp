<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Store Business Location</title>
<link rel="stylesheet" href="css/register.css" />
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css" />
<style>
    /* Additional CSS styles can be added here if needed */
    .form-container {
        max-width: 600px;
        margin: auto;
        padding: 20px;
        border: 1px solid #ddd;
        border-radius: 10px;
        background-color: #f9f9f9;
    }
    .form-container h1 {
        text-align: center;
        margin-bottom: 20px;
    }
    .form-container fieldset {
        border: none;
        margin: 0;
        padding: 0;
    }
    .form-container label {
        display: block;
        margin: 10px 0 5px;
    }
    .form-container input[type="text"],
    .form-container input[type="number"] {
        width: 100%;
        padding: 8px;
        margin-bottom: 10px;
        border: 1px solid #ccc;
        border-radius: 4px;
    }
    .form-container button {
        background-color: #0f0f0f;
        color: white;
        border: none;
        border-radius: 5px;
        padding: 10px 20px;
        font-size: 16px;
        cursor: pointer;
        transition: background-color 0.3s ease;
        margin-top: 20px;
    }
    .form-container button:hover {
        background-color: #333;
    }
</style>
</head>
<body>
    <div class="form-container">
        <h1>Store Business Location</h1>
        <form action="./add-location" method="POST" id="locationForm" onsubmit="return validateLocationForm()">
            <fieldset>
                <legend>Business Location Information</legend>
                
                <label for="name">*Business Name:</label>
                <input type="text" id="name" name="name" required />
                <span id="nameError" style="color: red"></span>

                <label for="latitude">*Latitude:</label>
                <input type="number" step="any" id="latitude" name="latitude" required />
                <span id="latitudeError" style="color: red"></span>

                <label for="longitude">*Longitude:</label>
                <input type="number" step="any" id="longitude" name="longitude" required />
                <span id="longitudeError" style="color: red"></span>
                
                <button type="submit">Save Location</button>
            </fieldset>
        </form>
    </div>
    <script src="js/locationValidation.js"></script>
</body>
</html>

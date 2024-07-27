<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Smart City Login</title>
<link rel="stylesheet" href="css/register.css" />
<link rel="stylesheet"
    href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css" />
<style>
    /* Additional CSS styles can be added here if needed */
</style>
</head>
<body>
    <div class="container">
        <h1>Smart City Login</h1>
        <form action="./Login" method="POST" id="loginForm" onsubmit="return validateLoginForm()">
            <div class="flex-container">
                <!-- Login Information -->
                <fieldset>
                    <legend>Login Information</legend>
                    <label for="username">*Username:</label>
                    <input type="text" id="username" name="username" required />
                    <span id="usernameError" style="color: red"></span>

                    <label for="password">*Password:</label>
                    <div class="password-container">
                        <input type="password" id="password" name="password" required placeholder="Enter your password" />
                        <span class="toggle-password" onclick="togglePassword('password', this)">
                            <i class="fas fa-lock"></i>
                        </span>
                    </div>
                    <span id="passwordError" style="color: red"></span>
               

                <button type="submit"
                    style="background-color: #0f0f0f; color: white; border: none; border-radius: 5px; padding: 10px 20px; font-size: 16px; cursor: pointer; transition: background-color 0.3s ease; margin-top: 20px;">
                    Login
                </button>
                 </fieldset>
            </div>
        </form>
    </div>
    <script src="js/loginValidation.js"></script>
</body>
</html>

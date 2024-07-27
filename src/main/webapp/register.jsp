<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Smart City Registration</title>
<link rel="stylesheet" href="css/register.css" />
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css" />
<style>
	
</style>
</head>
<body>
	<div class="container">
		<h1>Smart City Registration</h1>
		<p style="color: red">* indicates required field</p>
		<form action="./Register" method="POST" id="registrationForm" onsubmit="return validateForm()">
			<div class="flex-container">
				<!-- Personal Information -->
				<fieldset>
					<legend>Personal Information</legend>
					<label for="fullName">*Full Name:</label> <input type="text"
						id="fullName" name="fullName" required /> <span
						id="fullNameError" style="color: red"></span> <label for="dob">*Date
						of Birth:</label> <input type="date" id="dob" name="dob" required /> <span
						id="dobError" style="color: red"></span> <label for="gender">*Gender:</label>
					<select id="gender" name="gender" required>
						<option value="">Select Gender</option>
						<option value="male">Male</option>
						<option value="female">Female</option>
						<option value="other">Other</option>
						<option value="prefer_not_to_say">Prefer not to say</option>
					</select> <span id="genderError" style="color: red"></span> <label
						for="email">*Email:</label> <input type="email" id="email"
						name="email" required placeholder="example@gmail.com" /> <span
						id="emailError" style="color: red"></span> <label for="phone">Phone
						Number:</label> <input type="text" id="phone" name="phone" required
						placeholder="please enter 10 digits" pattern="\d{10}"
						title="Phone number should be 10 digits" /> <span id="phoneError"
						style="color: red"></span>
				</fieldset>

				<!-- Security Information -->
				<fieldset>
					<legend>Security Information</legend>
					<label for="username">*Username:</label> <input type="text"
						id="username" name="username" required /> <span
						id="usernameError" style="color: red"></span> <label
						for="password">*Password:</label>
					<div class="password-container">
						<input type="password" id="password" name="password" required
							placeholder="Enter your password" /> <span
							class="toggle-password"
							onclick="togglePassword('password', this)"><i
							class="fas fa-lock"></i></span>
					</div>
					<span id="passwordError" style="color: red"></span> <label
						for="confirmPassword">*Confirm Password:</label>
					<div class="password-container">
						<input type="password" id="confirmPassword" name="confirmPassword"
							required placeholder="Confirm your password" /> <span
							class="toggle-password"
							onclick="togglePassword('confirmPassword', this)"><i
							class="fas fa-lock"></i></span>
					</div>
					<span id="confirmPasswordError" style="color: red"></span>
				</fieldset>
			</div>

		<button type="submit"
    style="background-color: #0f0f0f; color: white; border: none; border-radius: 5px; padding: 10px 20px; font-size: 16px; cursor: pointer; transition: background-color 0.3s ease; margin-top: 20px;">
    Register
</button>

		</form>
	</div>
	<script src="js/Validation.js"></script>
</body>
</html>

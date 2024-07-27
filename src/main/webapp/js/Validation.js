function validateForm() {
    // Get form elements
    var fullName = document.getElementById('fullName');
    var dob = document.getElementById('dob');
    var gender = document.getElementById('gender');
    var email = document.getElementById('email');
    var phone = document.getElementById('phone');
    var username = document.getElementById('username');
    var password = document.getElementById('password');
    var confirmPassword = document.getElementById('confirmPassword');

    // Clear previous error messages
    clearErrors();

    var isValid = true;

    // Validate Full Name
    if (fullName.value.trim() === '') {
        showError('fullNameError', 'Full Name is required');
        isValid = false;
    }

    // Validate Date of Birth
	

    // Validate Gender
    if (gender.value === '') {
        showError('genderError', 'Gender is required');
        isValid = false;
    }

    // Validate Email
    var emailPattern = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    if (!emailPattern.test(email.value.trim())) {
        showError('emailError', 'Invalid email address');
        isValid = false;
    }

    // Validate Phone Number
    var phonePattern = /^\d{10}$/;
    if (!phonePattern.test(phone.value.trim())) {
        showError('phoneError', 'Phone number must be 10 digits');
        isValid = false;
    }

    // Validate Username
    var usernamePattern = /^(?=.*\d).{5,}$/;
    if (!usernamePattern.test(username.value.trim())) {
        showError('usernameError', 'Username must be at least 5 characters long and include at least one number');
        isValid = false;
    }

    // Validate Password
    if (password.value.trim().length < 5) {
        showError('passwordError', 'Password must be at least 5 characters long');
        isValid = false;
    }

    // Validate Confirm Password
    if (confirmPassword.value.trim() !== password.value.trim()) {
        showError('confirmPasswordError', 'Passwords do not match');
        isValid = false;
    }

    return isValid;
}

function showError(id, message) {
    var errorElement = document.getElementById(id);
    if (errorElement) {
        errorElement.textContent = message;
    }
}

function clearErrors() {
    var errorElements = document.querySelectorAll('span[id$="Error"]');
    errorElements.forEach(function(errorElement) {
        errorElement.textContent = '';
    });
}

function togglePassword(id, element) {
    var passwordField = document.getElementById(id);
    if (passwordField.type === 'password') {
        passwordField.type = 'text';
        element.querySelector('i').className = 'fas fa-unlock'; // Show password icon
    } else {
        passwordField.type = 'password';
        element.querySelector('i').className = 'fas fa-lock'; // Hide password icon
    }
}

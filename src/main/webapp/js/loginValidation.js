// Validation.js

function validateLoginForm() {
    var username = document.getElementById('username').value;
    var password = document.getElementById('password').value;
    var valid = true;

    // Clear previous errors
    document.getElementById('usernameError').textContent = '';
    document.getElementById('passwordError').textContent = '';

    // Basic validation example
    if (username === '') {
        document.getElementById('usernameError').textContent = 'Username is required.';
        valid = false;
    }
    if (password === '') {
        document.getElementById('passwordError').textContent = 'Password is required.';
        valid = false;
    }

    return valid;
}

function togglePassword(id, element) {
    var passwordField = document.getElementById(id);
    var type = passwordField.type === 'password' ? 'text' : 'password';
    passwordField.type = type;
    element.innerHTML = type === 'password' ? '<i class="fas fa-lock"></i>' : '<i class="fas fa-unlock"></i>';
}


function validateForm() {
    var username = document.registerForm.username.value;
    var password = document.registerForm.password.value;
    var cpassword = document.registerForm.cpassword.value;
    var email = document.registerForm.email.value;
    var address = document.registerForm.address.value;

    if (username === "" || password === "" || cpassword === "" || email === "" || address === "") {
        alert("All fields are mandatory. Please fill in all fields.");
        return false; 
    }

    if (password !== cpassword) {
        alert("Passwords do not match. Please try again.");
        return false; 
    }

    return true; 
}

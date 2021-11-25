<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login - Redstore</title>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600;700&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta2/css/all.min.css">
    <style><%@include file="../style.css"%></style>
</head>

<body>
    <div class="container">
        <jsp:include page="../partial/navbar.jsp"></jsp:include>
    </div>

    <!-- ---------- account-page--------- -->
    <div class="register-form">
        <div class="register-container">
            <div class="regis-title">Customer Information</div>
            <div class="content">
                <form action="${pageContext.request.contextPath}/register" method="post">
                    <div class="user-details">
                        <div class="input-box">
                            <span class="details">First Name</span>
                            <input type="text" placeholder="Enter your first name" required name="firstname">
                        </div>
                        <div class="input-box">
                            <span class="details">Last Name</span>
                            <input type="text" placeholder="Enter your last name" required name="lastname">
                        </div>
                        <div class="input-box">
                            <span class="details">Date Of Birth</span>
                            <input type="text" placeholder="Enter your email" required name="dob">
                        </div>
                        <div class="input-box">
                            <span class="details">Phone Number</span>
                            <input type="text" placeholder="Enter your number" required name="tel">
                        </div>
                        <div class="input-box">
                            <span class="details">HomeNo</span>
                            <input type="text" placeholder="Enter your home number" required name="homeNo">
                        </div>
                        <div class="input-box">
                            <span class="details">Street</span>
                            <input type="text" placeholder="Confirm your street" required name="street">
                        </div>
                        <div class="input-box">
                            <span class="details">City</span>
                            <input type="text" placeholder="Enter your city" required name="city">
                        </div>
                        <div class="input-box">
                            <span class="details">District</span>
                            <input type="text" placeholder="Confirm your district" required name="district">
                        </div>
                    </div>
                    <div class="gender-details">
                        <input type="radio" name="gender" id="dot-1" value="male">
                        <input type="radio" name="gender" id="dot-2" value="female">
                        <input type="radio" name="gender" id="dot-3" value="prefer not to say">
                        <span class="gender-title">Gender</span>
                        <div class="category">
                            <label for="dot-1">
			                    <span class="dot one"></span>
			                    <span class="gender">Male</span>
                  			</label>
                            <label for="dot-2">
			                    <span class="dot two"></span>
			                    <span class="gender">Female</span>
			                </label>
                            <label for="dot-3">
			                    <span class="dot three"></span>
			                    <span class="gender">Prefer not to say</span>
                    		</label>
                        </div>
                    </div>
                    <div class="button">
                        <input type="submit" value="Register">
                    </div>
                </form>
            </div>
        </div>
    </div>
    <!-- -----footer----- -->
    <jsp:include page="../partial/footer.jsp"></jsp:include>


    <script>
        var MenuItems = document.getElementById("MenuItems ");
        MenuItems.style.maxHeight = "0px ";

        function menutoggle() {
            if (MenuItems.style.maxHeight == "0px ") {
                MenuItems.style.maxHeight = "200px ";
            } else {
                MenuItems.style.maxHeight = "0px ";
            }
        }
    </script>

    <script>
        var LoginForm = document.getElementById("LoginForm");
        var RegForm = document.getElementById("RegForm");
        var Indicator = document.getElementById("Indicator");

        function register() {
            RegForm.style.transform = "translateX(0px)";
            LoginForm.style.transform = "translateX(0px)"
            Indicator.style.transform = "translateX(100px)"

        }

        function login() {
            RegForm.style.transform = "translateX(400px)";
            LoginForm.style.transform = "translateX(400px)"
            Indicator.style.transform = "translateX(0px)"
        }
    </script>


</body>

</html>
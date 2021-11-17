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
    <style><%@include file="main.css"%></style>
</head>

<body>
    <div class="container">
        <jsp:include page="../partial/navbar.jsp"></jsp:include>
    </div>

    <!-- ---------- account-page--------- -->
    <div class="container-account">
        <input type="checkbox" id="flip">
        <div class="cover">
            <div class="front">
                <img src="${pageContext.request.contextPath}/views/main/ImagesAccount/frontImg.jpg" alt="">
                <div class="text">
                    <span class="text-1">Every new friend is a <br> new adventure</span>
                    <span class="text-2">Let's get connected</span>
                </div>
            </div>
            <div class="back">
                <img class="backImg" src="${pageContext.request.contextPath}/views/main/ImagesAccount/backImg.jpg" alt="">
                <div class="text">
                    <span class="text-1">Complete miles of journey <br> with one step</span>
                    <span class="text-2">Let's get started</span>
                </div>
            </div>
        </div>
        <div class="forms">
            <div class="form-content">
                <div class="login-form">
                    <div class="title">Login</div>
                    <form action="${pageContext.request.contextPath}/login" method="post">
                        <div class="input-boxes">
                            <div class="input-box">
                                <i class="fas fa-envelope"></i>
                                <input type="text" placeholder="Enter your username" required name="username">
                            </div>
                            <div class="input-box">
                                <i class="fas fa-lock"></i>
                                <input type="password" placeholder="Enter your password" required name="password">
                            </div>
                            <div class="text"><a href="#">Forgot password?</a></div>
                            <div class="button input-box">
                                <input type="submit" value="Sumbit">
                            </div>
                            <div class="text sign-up-text">Don't have an account? <label for="flip">Sigup now</label></div>
                        </div>
                    </form>
                </div>
                <div class="signup-form">
                    <div class="title">Signup</div>
                    <form action="#">
                        <div class="input-boxes">
                            <div class="input-box">
                                <i class="fas fa-user"></i>
                                <input type="text" placeholder="Enter your name" required>
                            </div>
                            <div class="input-box">
                                <i class="fas fa-envelope"></i>
                                <input type="text" placeholder="Enter your email" required>
                            </div>
                            <div class="input-box">
                                <i class="fas fa-lock"></i>
                                <input type="password" placeholder="Enter your password" required>
                            </div>
                            <div class="button input-box">
                                <input type="submit" value="Sumbit">
                            </div>
                            <div class="text sign-up-text">Already have an account? <label for="flip">Login now</label></div>
                        </div>
                    </form>
                </div>
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
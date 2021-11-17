<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Red Store</title>
	<link rel="preconnect" href="https://fonts.googleapis.com">
	<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
	<link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600;700&display=swap" rel="stylesheet">
	<link rel="stylesheet"	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta2/css/all.min.css">
	<style><%@include file="../style.css"%></style>
</head>

<body>
	<div class="header">
		<div class="container">
			<jsp:include page="../partial/navbar.jsp"></jsp:include>
			<div class="row">
				<div class="col-2">
					<h1>
						Give Your Workout <br> A New Style!
					</h1>
					<p>
						Success isn't always about greatness. It's about consistency.
						Consistent <br> hard work gain success. Greatness will come
					</p>
					<a href="" class="btn">Explore now &#8594;</a>
				</div>
				<div class="col-2 img-banner">
					<img src="${pageContext.request.contextPath}/views/images/banner.png" alt="">
				</div>
			</div>
		</div>
	</div>

	<!-- --------- features categories-------------------- -->
	<div class="categories">
		<div class="small-container">
			<div class="row">
				<div class="col-3">
					<img src="${pageContext.request.contextPath}/views/images/clothes/clothes_49/gallery_01.webp" alt="">
				</div>
				<div class="col-3">
					<img src="${pageContext.request.contextPath}/views/images/clothes/clothes_33/gallery_02.webp" alt="">
				</div>
				<div class="col-3">
					<img src="${pageContext.request.contextPath}/views/images/clothes/clothes_36/gallery_02.webp" alt="">
				</div>
			</div>
		</div>
	</div>

	<!-- --------- features product-------------------- -->

	<div class="small-container">
		<h2 class="title">Featured Products</h2>
		<div class="row">
			<div class="col-4">
				<img src="${pageContext.request.contextPath}/views/images/clothes/clothes_13/gallery_01.webp" alt=""> <a
					href="product-detail?id=13">

					<h4>KERMIT THE FROG © DISNEY T-SHIRT</h4>
					<p>$50.00</p>
				</a>
			</div>
			<div class="col-4">
				<img src="${pageContext.request.contextPath}/views/images/clothes/clothes_14/gallery_01.webp" alt=""> <a
					href="../product-detail?id=14">

					<h4>GRAPHIC PRINT T-SHIRT</h4>
					<p>$50.00</p>
				</a>
			</div>
			<div class="col-4">
				<img src="${pageContext.request.contextPath}/views/images/clothes/clothes_15/gallery_01.webp" alt=""> <a
					href="product-detail?id=15">
					<h4>T-SHIRT WITH EMBROIDERED BAND</h4>

					<p>$50.00</p>
				</a>
			</div>
			<div class="col-4">
				<img src="${pageContext.request.contextPath}/views/images/clothes/clothes_16/gallery_01.webp" alt=""> <a
					href="product-detail?id=16">
					<h4>BOB MARLEY © ZION ROOTSWEAR PRINT T-SHIRT</h4>

					<p>$50.00</p>
				</a>
			</div>
		</div>

		<h2 class="title">Lastest Products</h2>
		<div class="row">
			<div class="col-4">
				<img src="${pageContext.request.contextPath}/views/images/clothes/clothes_26/gallery_01.webp" alt=""> <a
					href="product-detail?id=26">
					<h4>OVERSIZE PLEATED TROUSERS</h4>

					<p>$50.00</p>
				</a>
			</div>
			<div class="col-4">
				<img src="${pageContext.request.contextPath}/views/images/clothes/clothes_27/gallery_01.webp" alt=""> <a
					href="product-detail?id=27">
					<h4>LIMITED EDITION TROUSERS WITH CONTRAST TURN-UP</h4>

					<p>$50.00</p>
				</a>
			</div>
			<div class="col-4">
				<img src="${pageContext.request.contextPath}/views/images/clothes/clothes_28/gallery_01.webp" alt=""> <a
					href="product-detail?id=28">
					<h4>LIMITED EDITION STRIPED SUIT TROUSERS</h4>

					<p>$50.00</p>
				</a>
			</div>
			<div class="col-4">
				<img src="${pageContext.request.contextPath}/views/images/clothes/clothes_29/gallery_01.webp" alt=""> <a
					href="product-detail?id=29"><h4>LIMITED EDITION WOOL
						TROUSERS</h4>

					<p>$50.00</p></a>
			</div>
		</div>
	</div>

	<!-- ----- offer ----- -->

	<div class="offer">
		<div class="small-container">
			<div class="row">
				<div class="col-2">
					<img src="${pageContext.request.contextPath}/views/images/exclusive.png" alt="" class="offer-img" />
				</div>
				<div class="col-2">
					<p>Exclusive Available on Redstore</p>
					<h1>Smart Brand 4</h1>
					<p>
						<small> The Mi Smart Band 4 features a 39.9% lagger (than
							Mi Band 3) AMOLED color full-touch display with adjustable
							brightness, so everything is clear as can be. </small>
					</p>
					<a href="" class="btn">Buy Now &#8594;</a>
				</div>
			</div>
		</div>
	</div>

	<!-- ----------brands--------------- -->
	<div class="brands">
		<div class="small-container">
			<div class="row">
				<div class="col-5">
					<img src="${pageContext.request.contextPath}/views/images/logo-godrej.png" alt="">
				</div>
				<div class="col-5">
					<img src="${pageContext.request.contextPath}/views/images/logo-oppo.png" alt="">
				</div>
				<div class="col-5">
					<img src="${pageContext.request.contextPath}/views/images/logo-coca-cola.png" alt="">
				</div>
				<div class="col-5">
					<img src="${pageContext.request.contextPath}/views/images/logo-paypal.png" alt="">
				</div>
				<div class="col-5">
					<img src="${pageContext.request.contextPath}/views/images/logo-philips.png" alt="">
				</div>
			</div>
		</div>
	</div>

	<!-- -----footer----- -->
	<jsp:include page="../partial/footer.jsp"></jsp:include>


	<script>
		var MenuItems = document.getElementById("MenuItems");
		MenuItems.style.maxHeight = "0px";

		function menutoggle() {
			if (MenuItems.style.maxHeight == "0px") {
				MenuItems.style.maxHeight = "200px";
			} else {
				MenuItems.style.maxHeight = "0px";
			}
		}
	</script>
	<script>
		document.getElementById("search-txt").addEventListener("keyup",
				function(event) {
					if (event.keyCode === 13) {
						document.getElementById("myFormID").submit();
						return false;
					}
				});
	</script>
</body>

</html>
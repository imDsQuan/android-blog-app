<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>${shoe.name}</title>
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

	<!-- ----------single product details ---------- -->

	<div class="small-container single-product">
		<div class="row">
			<div class="col-2">
					<img src="${pageContext.request.contextPath}/views/${shoe.image[0]}" alt="" width="100%" id="productImg">
				<div class="small-img-row">
					<div class="small-img-col">
						<img src="${pageContext.request.contextPath}/views/${shoe.image[0]}" width="100%" class="small-img">
					</div>
					<div class="small-img-col">
						<img src="${pageContext.request.contextPath}/views/${shoe.image[1]}" width="100%" class="small-img">
					</div>
					<div class="small-img-col">
						<img src="${pageContext.request.contextPath}/views/${shoe.image[2]}" width="100%" class="small-img">
					</div>
					<div class="small-img-col">
						<img src="${pageContext.request.contextPath}/views/${shoe.image[3]}" width="100%" class="small-img">
					</div>
				</div>
			</div>
			<div class="col-2 product-info">
				<p>
					<a href="${pageContext.request.contextPath}/">Home</a> / <a href="${pageContext.request.contextPath}/shoe/typeshoe?type=${shoe.typeShoe}"> ${shoe.typeShoe} </a> 
				</p>
				<h1>
					<c:out value='${shoe.name}' />
				</h1>
				<h4>
					<c:out value='${shoe.price}'/>0 $
				</h4>
				<form action="${pageContext.request.contextPath}/add-to-cart" id="my_form" method="post">
				<select name="size" id="sizeChoosed">
					<option value="">Select Size</option>
					<option value="37">37</option>
					<option value="38">38</option>
					<option value="39">39</option>
					<option value="40">40</option>
				</select> <input type="number" value="1" id="amountInput" name="amount"> 
				<input type="text" value="${shoe.id}" name="id" style="display:none">
				<input type="text" value="<c:out value='${shoe.getClass().getName()}'/>" name="type" style="display:none"> 
					<button type="submit" class="btn">Add To Cart</button>
				</form>
				<h3>
					Product Detail <i class="fas fa-indent"></i>
				</h3>
				<br>
				<p>
					Material: <c:out value='${shoe.material}' /> <br>
					Brand: <c:out value='${shoe.brand}' /> <br><br>
					<c:out value='${shoe.description}' />
				</p>
			</div>
		</div>
	</div>
	
	<script type="text/javascript">
		function addToCart(){
			var sizeChoosed = document.getElementById("sizeChoosed").value;
			var amountInput = documnet.getElementById("amountInput").value;
			
		}
	</script>

	<!-- title -->
	<div class="small-container">
		<div class="row row-2">
			<h2>Related Product</h2>
			<p><a href="${pageContext.request.contextPath}/shoe/typeshoe?type=${shoe.typeShoe}"> View More </a></p>
		</div>
	</div>

	<!-- products -->
	<div class="small-container">
		<div class="row">
			<c:forEach var="shoe" items="${list}">
            	<div class="col-4">
	                <img src="${pageContext.request.contextPath}/views/${shoe.image[0]}" alt="">
	                <a  href="shoe-detail?id=${shoe.id}"><h4><c:out value="${shoe.name}"/></h4></a>
	                
	                <p>$<c:out value="${shoe.price}"/>0</p>
            	</div>
            </c:forEach>
			

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

	<!-- ----js for product galery----- -->

	<script>
        var productImg = document.getElementById("productImg");
        var smallImgs = document.getElementsByClassName("small-img");
        var smallImgCols = document.getElementsByClassName("small-img-col");
        smallImgCols[0].onclick = function() {
        	
            productImg.src = smallImgs[0].src;
        }
        smallImgCols[1].onclick = function() {
            productImg.src = smallImgs[1].src;
        }
        smallImgCols[2].onclick = function() {
            productImg.src = smallImgs[2].src;
        }
        smallImgCols[3].onclick = function() {
            productImg.src = smallImgs[3].src;
        }
    </script>
	
	<script>
		document.getElementById("search-txt").addEventListener("keyup", function(event) {
		    if (event.keyCode === 13) {
		    	document.getElementById("myFormID").submit();
				return false;
		    }
		});
	</script>
		
	
		
</body>

</html>
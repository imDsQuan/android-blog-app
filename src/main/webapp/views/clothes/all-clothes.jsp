<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>All Product</title>
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

	 <div class="small-view">
        <div class="category">
            <h2>Category</h2>
            <ul>
                <li><a href="${pageContext.request.contextPath}/clothes/typeclothes?type=t-shirt">T-shirt</a></li>
                <li><a href="${pageContext.request.contextPath}/clothes/typeclothes?type=shirt">Shirt</a></li>
                <li><a href="${pageContext.request.contextPath}/clothes/typeclothes?type=hoodie">Hoodie</a></li>
                <li><a href="${pageContext.request.contextPath}/clothes/typeclothes?type=sweater">Sweater</a></li>
                <li><a href="${pageContext.request.contextPath}/clothes/typeclothes?type=jeans">Jeans</a></li>
                <li><a href="${pageContext.request.contextPath}/clothes/typeclothes?type=trouser">Trouser</a></li>
                <li><a href="${pageContext.request.contextPath}/clothes/typeclothes?type=jacket">Jacket</a></li>
                <li><a href="${pageContext.request.contextPath}/clothes/typeclothes?type=coat">Coat</a></li>

            </ul>
        </div>
        <div class="separate"> </div>
        <div class="small-container">
        <div class="row row-2">
            <h2>All Products</h2>
            <form action="${pageContext.request.contextPath}/clothes" method="post">
            <select name="search-option" id="" onchange="javascript:this.form.submit()">
                <option value="">Default Sorting</option>
                <option value="1">Sort by descending price</option>
                <option value="2">Sort by ascending price </option>
                <option value="3">Sort by rating name</option>
            </select>
            </form>
        </div>
        <div class="row">
			<c:forEach var="clothes" items="${clothesList}">
            	<div class="col-4">
	                <img src="${pageContext.request.contextPath}/views/${clothes.image[0]}" alt="">
	                <a  href="clothes-detail?id=${clothes.id}"> <h4><c:out value="${clothes.name}"/></h4></a>
	                
	                <p>$<c:out value="${clothes.price}"/>0</p>
            	</div>
            </c:forEach>
     
        </div>
     </div>
	
	</div>
    
        
        
        
        <div class="page-btn">
        	
        
            <c:forEach begin="1" end="${totalPage}" var="i">
                <c:choose>
                    <c:when test="${currentPage eq i}">
                        <span style="background: #ff523b;color: #fff;">${i}</span>
                    </c:when>
                    <c:otherwise>
                        <span><a href="clothes?page=${i}">${i}</a></span>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
       		
    
     
    
        
        
            
        
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
		document.getElementById("search-txt").addEventListener("keyup", function(event) {
		    if (event.keyCode === 13) {
		    	document.getElementById("myFormID").submit();
				return false;
		    }
		});
	</script>
</body>

</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Shopping Cart - Redstore</title>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600;700&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta2/css/all.min.css">
    <link rel="stylesheet" href="style.css">	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
     <style><%@include file="../style.css"%></style>
</head>

<body>
    <div class="container">
        <jsp:include page="../partial/navbar.jsp"></jsp:include>
    </div>

    <!-- ----- cart items details--------- -->
    <div class="small-container cart-page">

        <table>
            <tr>
                <th>Product</th>
                <th>Quantity</th>
                <th>Subtotal</th>
            </tr>
			<c:forEach var="clothes" items="${listClothes}">
            <tr>
                <td>
                    <div class="cart-info">
                        <a href="clothes-detail?id=${clothes.id}"><img src="${pageContext.request.contextPath}/views/${clothes.image[0]}" alt=""></a>
                        <div>
                            <a href="clothes-detail?id=${clothes.id}">
                            	<p>${clothes.name}</p>
                            </a>
                            <small>Price: $${clothes.price}0</small>
                            <br>
                            <small>Size: ${clothes.size}</small>
                            <br>
                            <a href="${pageContext.request.contextPath}/cart?action=delete&id=${clothes.id}&type=${clothes.getClass().getName()}">Remove</a>
                        </div>
                    </div>  
                </td>
                <td>
	                	<div class="quantity">
					      <form action="">
					      		<a href="${pageContext.request.contextPath}/cart?id=${clothes.id}&action=add&type=${clothes.getClass().getName()}">
						      		<button class="plus-btn" type="button" name="button">
						      			<img src="https://designmodo.com/demo/shopping-cart/plus.svg" alt="" width="30px"  />
						      		</button>
					      		</a>
					      		<input type="text" name="name" value="${clothes.amount}">
						      	<a href="${pageContext.request.contextPath}/cart?id=${clothes.id}&action=sub&type=${clothes.getClass().getName()}">
							      	<button class="minus-btn" type="button" name="button">
							        	<img src="https://designmodo.com/demo/shopping-cart/minus.svg" alt="" width="30px"  />
							      	</button>
					      		</a>
					      </form>
	    				</div>
                </td>
                <td>$${clothes.amount*clothes.price}0</td>
            </tr>
            </c:forEach>
            
        </table>

        <div class="total-price">
            <table>
                <tr>
                    <td>Subtotal</td>
                    <td>$${subtotal}0</td>
                </tr>
                <tr>
                    <td>Tax</td>
                    <td>$${tax}0</td>
                </tr>
                <tr>
                    <td>Total</td>
                    <td>$${total}0</td>
                </tr>
            </table>
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
        let deductBtnArr = document.getElementsByClassName('plus-btn');
        let addButtonArr = document.getElementsByClassName('minus-btn');
        let inputQuantity = document.getElementsByClassName('')
        console.log(deductBtnArr);
        console.log(addButtonArr);

        for (let deductBtn of deductBtnArr) {
            deductBtn.onclick = function() {
                let currentInputBox = deductBtn.nextElementSibling;
                currentInputBox.value = parseInt(currentInputBox.value) + 1;
            }
        }

        for (let addButton of addButtonArr) {
            addButton.onclick = () => {
                let currentInputBox = addButton.previousElementSibling;
                if (currentInputBox.value == 0) {
                    currentInputBox.value = 0;
                } else currentInputBox.value = parseInt(currentInputBox.value) - 1;
            }
        }
    </script>



</body>

</html>
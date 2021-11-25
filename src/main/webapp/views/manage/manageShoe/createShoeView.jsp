<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" />
	<style><%@include file="../meta.css"%></style>    
    <title>Add New Shoe</title>
</head>

<body>
    <div class="d-flex" id="wrapper">
        <!-- Sidebar -->
        <div class="bg-white" id="sidebar-wrapper">
            <div class="sidebar-heading text-center py-4 primary-text fs-4 fw-bold text-uppercase border-bottom"><i class="fas fa-user-secret me-2"></i>Red Store</div>
            <div class="list-group list-group-flush my-3">
                <a href="${pageContext.request.contextPath}/manage" class="list-group-item list-group-item-action bg-transparent second-text fw-bold">
                    <i class="fas fa-tachometer-alt me-2"></i>Dashboard</a>
                <a href="#" class="list-group-item list-group-item-action bg-transparent second-text fw-bold">
                    <i class="fas fa-project-diagram me-2"></i>Customers</a>
                <a href="#" class="list-group-item list-group-item-action bg-transparent second-text fw-bold">
                    <i class="fab fa-shopify me-2"></i>Orders</a>
                <a href="#" class="list-group-item list-group-item-action bg-transparent second-text fw-bold">
                    <i class="fas fa-book me-2"></i>Books</a>
                <a href="#" class="list-group-item list-group-item-action bg-transparent second-text fw-bold">
                    <i class="fas fa-microscope me-2"></i>Electronic</a>
                <a href="${pageContext.request.contextPath}/manage/clothes" class="list-group-item list-group-item-action bg-transparent second-text fw-bold">
                    <i class="fas fa-tshirt me-2"></i>Clothes</a>
                <a href="${pageContext.request.contextPath}/manage/shoe" class="list-group-item list-group-item-action bg-transparent second-text active">
                    <i class="fas fa-socks me-2"></i>Shoes</a>
                <a href="#" class="list-group-item list-group-item-action bg-transparent text-danger fw-bold">
                	<i class="fas fa-power-off me-2"></i>Logout</a>
            </div>
        </div>
        <!-- /#sidebar-wrapper -->

        <!-- Page Content -->
        <div id="page-content-wrapper">
            <nav class="navbar navbar-expand-lg navbar-light bg-transparent py-4 px-4">
                <div class="d-flex align-items-center">
                    <i class="fas fa-align-left primary-text fs-4 me-3" id="menu-toggle"></i>
                    <h2 class="fs-2 m-0">Dashboard</h2>
                </div>

                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>


            </nav>

            <div class="container-fluid px-4">
                <div class="container">
                 	<c:if test="${shoe != null}" >
                 		<div class="title">Edit Shoe</div>
                 	</c:if>
                 	<c:if test="${shoe == null}" >
                 		<div class="title">Add Shoe</div>
                 	</c:if>
                    <div class="content">
                    	<c:if test="${shoe != null}">
                            <form action="manage/shoe/update" method="post">
                        </c:if>
                        <c:if test="${shoe == null}">
                            <form action="manage/shoe/insert" method="post" enctype="multipart/form-data">
                        </c:if>
                        
                        	<c:if test="${shoe != null}">
                            	<input type="hidden" name="id" value="<c:out value='${shoe.id}' />" />
                        	</c:if>
                            <div class="user-details">
                                <div class="input-box">
                                    <span class="details">Shoe Name</span>
                                    <input type="text" placeholder="Enter the name" required name="name" value="<c:out value='${shoe.name}'/>"/>
                                </div>
                                <div class="input-box">
                                    <span class="details">Description</span>
                                    <input type="text" placeholder="Enter the description" required name="description" value="<c:out value='${shoe.description}'/>"/>
                                </div>
                                <div class="input-box">
                                    <span class="details">Brand</span>
                                    <input type="text" placeholder="Enter the brand" required name="brand" value="<c:out value='${shoe.brand}'/>"/>
                                </div>
                                <div class="input-seperate">
                                    <div style="width:40%">
                                        <div class="input-box ">
                                            <span class="details">Material</span>
                                            <input type="text" placeholder="Enter the material" required name="material" value="<c:out value='${shoe.material}'/>"/>
                                        </div>
                                        <div class="input-box ">
                                            <span class="details">Price</span>
                                            <input type="text" placeholder="Enter the price" required name="price" value="<c:out value='${shoe.price}'/>"/>
                                        </div>
                                        <div class="input-box ">
                                            <span class="details">Discount</span>
                                            <input type="text" placeholder="Enter the discount" required name="discount" value="<c:out value='${shoe.discount}'/>"/>
                                        </div>
                                        <div class="input-box ">
                                            <span class="details">Warrantlyperiod</span>
                                            <input type="text" placeholder="Enter the warrantlyperiod" required name="warrantlyperiod" value="<c:out value='${shoe.warrantlyperiod}'/>"/>
                                        </div>
                                    </div>
                                    <div class="input-img">
                                        <span class="details">Product Images</span>
                                        <input type="file" name="image1" id="">
                                        <input type="file" name="image2" id="">
                                        <input type="file" name="image3" id="">
                                        <input type="file" name="image4" id="">
                                    </div>
                                </div>

                            </div>
                            <div class="type-details">
                                <input type="radio" name="type" id="dot-1" value="Sneaker">
                                <input type="radio" name="type" id="dot-2" value="Boot">
                                <input type="radio" name="type" id="dot-3" value="Oxford">
                                <input type="radio" name="type" id="dot-4" value="Nike">
                                <input type="radio" name="type" id="dot-5" value="Adidas">
                               
                                <span class="type-title">Shoe Type</span>
                                <div class="category">
                                    <label for="dot-1">
                                        <span class="dot one"></span>
                                        <span class="type">Sneaker</span>
                                    </label>
                                    <label for="dot-2">
                                        <span class="dot two"></span>
                                        <span class="type">Boot</span>
                                    </label>
                                    <label for="dot-3">
                                        <span class="dot three"></span>
                                        <span class="type">Oxford</span>
                                    </label>
                                    <label for="dot-4">
                                        <span class="dot four"></span>
                                        <span class="type">Nike</span>
                                    </label>
                                    <label for="dot-5">
                                        <span class="dot five"></span>
                                        <span class="type">Adidas</span>
                                    </label>
                                    
                                </div>
                            </div>
                            
                            <c:if test="${shoe != null}" >
		                 		<div class="button">
                                	<input type="submit" value="Update product">
                            	</div>
		                 	</c:if>
		                 	<c:if test="${shoe == null}" >
		                 		<div class="button">
                                	<input type="submit" value="Add product">
                            	</div>
		                 	</c:if>
                            
                            
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <!-- /#page-content-wrapper -->
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js"></script>
    <script>
        var el = document.getElementById("wrapper");
        var toggleButton = document.getElementById("menu-toggle");

        toggleButton.onclick = function() {
            el.classList.toggle("toggled");
        };
    </script>
</body>

</html>
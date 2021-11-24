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
	<title>Manage Shoe</title>
</head>

<body>
    <div class="d-flex" id="wrapper">
        <!-- Sidebar -->
        <div class="bg-white" id="sidebar-wrapper">
            <div class="sidebar-heading text-center py-4 primary-text fs-4 fw-bold text-uppercase border-bottom"><i class="fas fa-user-secret me-2"></i>Red Store</div>
            <div class="list-group list-group-flush my-3">
                <a href="#" class="list-group-item list-group-item-action bg-transparent second-text fw-bold">
                    <i class="fas fa-tachometer-alt me-2"></i>Dashboard</a>
                <a href="#" class="list-group-item list-group-item-action bg-transparent second-text fw-bold">
                    <i class="fas fa-project-diagram me-2"></i>Customers</a>
                <a href="#" class="list-group-item list-group-item-action bg-transparent second-text fw-bold">
                    <i class="fab fa-shopify me-2"></i>Orders</a>
                <a href="#" class="list-group-item list-group-item-action bg-transparent second-text fw-bold">
                    <i class="fas fa-book me-2"></i>Books</a>
                <a href="#" class="list-group-item list-group-item-action bg-transparent second-text fw-bold">
                    <i class="fas fa-microscope me-2"></i>Electronic</a>
                <a href="${pageContext.request.contextPath}/manage/clothes" class="list-group-item list-group-item-action bg-transparent second-text active">
                    <i class="fas fa-tshirt me-2"></i>Clothes</a>
                <a href="#" class="list-group-item list-group-item-action bg-transparent second-text fw-bold">
                    <i class="fas fa-socks me-2"></i>Shoes</a>
            </div>
        </div>
        <!-- /#sidebar-wrapper -->

        <!-- Page Content -->
        <div id="page-content-wrapper">
            <nav class="navbar navbar-expand-lg navbar-light bg-transparent py-4 px-4">
                <div class="d-flex align-items-center">
                    <i class="fas fa-align-left text-light fs-4 me-3" id="menu-toggle"></i>
                    <h2 class="fs-2 m-0 text-light">Manage Shoe</h2>
                </div>

                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>


            </nav>

            <div class="container-fluid px-4">



                <div class="row my-5">
                    <h3 class="fs-4 mb-3 text-light">Shoe List
                        <a href="${pageContext.request.contextPath}/manage/shoe/create" type="button" class="btn btn-light btn-rounded btn-l" style="float: right">
                            Add New Product
                        </a>
                    </h3>

                    <div class="col table-wrapper-scroll-y my-custom-scrollbar">
                        <table class="table bg-white  shadow-sm table-hover table-bordered rounded">
                            <thead class="thead-light">
                                <tr>
                                    <th class="text-center" scope="col" width="50">#</th>
                                    <th class="text-center" scope="col">Name</th>
                                    <th class="text-center" scope="col">Description</th>
                                    <th class="text-center" scope="col">Material</th>
                                    <th class="text-center" scope="col">Discount</th>
                                    <th class="text-center" scope="col">Price</th>
                                    <th class="text-center" scope="col">Brands</th>
                                    <th class="text-center" scope="col">Type</th>
                                    <th class="text-center" scope="col">Warrantlyperiod</th>
                                    <th></th>
                                </tr>
                            </thead>
                            <tbody>
                            <c:forEach var="shoe" items="${list}">
                                <tr>
                                    <th scope="row">${shoe.id}</th>
                                    <td class="text-wrap" style="width:300px">
                                        <div class="product-name">
                                            <img src="${pageContext.request.contextPath}/views/${shoe.image[0]}" alt="" height="100px">
                                            <h5>${shoe.name}</h5>
                                        </div>
                                    </td>
                                    <td class="text-wrap align-middle" style="width:35rem;">${shoe.description}</td>
                                    <td class="text-center align-middle">${shoe.material}</td>
                                    <td class="text-center align-middle">${shoe.discount}</td>
                                    <td class="text-center align-middle">$${shoe.price}0</td>
                                    <td class="text-center align-middle">${shoe.brand}</td>
                                    <td class="text-center align-middle">${shoe.typeShoe}</td>
                                    <td class="text-center align-middle">${shoe.warrantlyperiod}</td>
                                    <td class="text-center align-middle">
                                        <a href="${pageContext.request.contextPath}/manage/shoe/edit?id=${shoe.id}" type="button" class="btn btn-secondary btn-rounded btn-sm" style="margin: 16px;">
                                        Edit
                                      </a>
                                        <a href="${pageContext.request.contextPath}/manage/shoe/delete?id=${shoe.id}" type="button" class="btn btn-danger btn-rounded btn-sm">
                                        Remove
                                      </a>
                                    </td>

                                </tr>
                               	</c:forEach>


                            </tbody>
                        </table>
                    </div>
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
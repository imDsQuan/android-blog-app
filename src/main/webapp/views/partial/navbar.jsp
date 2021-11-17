<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<div class="navbar">
            <div class="logo">
		    	<a href="${pageContext.request.contextPath}/"><img src="${pageContext.request.contextPath}/views/images/logo.png" alt="Logo Store" width=125px></a>
            </div>
            <nav>
                <ul id="MenuItems"> <li>
                        <div class="search-box">
                            <form id="myFormID" action="${pageContext.request.contextPath}/search" method="get">
								<input type="text" id="search-txt" name="keyword"  placeholder="Type to search"> 
								<input type="submit" value="Submit" style="display:none">
								<i id="search-btn" class="fas fa-search"></i>
							</form>
                        </div>
                        <li>
                    <li><a href="${pageContext.request.contextPath}/">Home</a></li>
					<li><a href="${pageContext.request.contextPath}/book">Book</a></li>
					<li><a href="${pageContext.request.contextPath}/shoe">Shoe</a></li>
					<li><a href="${pageContext.request.contextPath}/electronic">Electronic</a></li>
					<li><a href="${pageContext.request.contextPath}/clothes">Clothes</a></li>
					<li><a href="${pageContext.request.contextPath}/account">Account</a></li>
                </ul>
            </nav>
            <a href="${pageContext.request.contextPath}/cart?action=view"><img src="${pageContext.request.contextPath}/views/images/cart.png" alt="" width="30px" height="30px"></a>
            <img src="${pageContext.request.contextPath}/views/images/menu.png" class="menu-icon" onclick="menutoggle()">
        </div>
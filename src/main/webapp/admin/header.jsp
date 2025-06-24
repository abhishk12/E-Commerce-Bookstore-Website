<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><%= request.getAttribute("pageTitle") %> - Administrator</title>
<link rel="icon" href="<%= request.getContextPath() %>/images/reading-book.png">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Spicy+Rice&display=swap" rel="stylesheet">
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/style.css" />
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.7.2/css/all.min.css" integrity="sha512-Evv84Mr4kqVGRNSgIGL/F/aIDqQb7xQ2vcrdIwxfjThSH8CSR7PBEakCr51Ck+w+/U6swU2Im1vVX0SVk9ABhg==" crossorigin="anonymous" referrerpolicy="no-referrer" />
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/richtext.min.css">
</head>
<body align="center">
	<div>
		
		<div>
			<a href="${pageContext.request.contextPath}/admin/">
				<img alt="logo here" src="<%= request.getContextPath() %>/images/bookStoreSVGLogo.svg" width="700" height="150"/>
			</a>
			
		</div>
		
		<div>
			<span>
				Welcome Admin!- <c:out value="${sessionScope.userEmail}"></c:out>
			</span>
			
			
			
			<ul style="list-style-type: none; padding: 0; margin: 0; display: inline;">
			  <li style="display: inline; margin-right: 5px; margin-left: 10px"> | </li>
			  <li style="display: inline; margin-right: 5px; margin-left: 10px"><a href="logout">Logout</a></li>
			</ul>	
		</div>
		
		<div>
			<br>
			
			<ul style="list-style-type: none; padding: 0; margin: 0; display: inline;">
			  <li style="display: inline-block; margin-right: 5px; margin-left: 10px"> <div style="box-shadow: rgba(100, 100, 111, 0.2) 0px 7px 29px 0px; width: 90px; height:90px; border-radius: 10px"> <div><a href="list_users"> <img alt="users icon" src="<%= request.getContextPath() %>/images/user-gif.gif" width="50" height="50"></a></div> <div>Users</div>  </div> </li>
			  <li style="display: inline-block; margin-right: 5px; margin-left: 10px"> <div style="box-shadow: rgba(100, 100, 111, 0.2) 0px 7px 29px 0px; width: 90px; height:90px; border-radius: 10px"> <div><a href="list_category"> <img alt="categories icon" src="<%= request.getContextPath() %>/images/categories-gif.gif" width="50" height="50" > </a></div>  <div >Categories</div> </div> </li>
			  <li style="display: inline-block; margin-right: 5px; margin-left: 10px"> <div style="box-shadow: rgba(100, 100, 111, 0.2) 0px 7px 29px 0px; width: 90px; height:90px; border-radius: 10px"> <div><a href="list_books"> <img alt="categories icon" src="<%= request.getContextPath() %>/images/books-gif.gif" width="50" height="50" > </a></div>  <div >Books</div> </div></a></li>
			  <li style="display: inline-block; margin-right: 5px; margin-left: 10px"> <div style="box-shadow: rgba(100, 100, 111, 0.2) 0px 7px 29px 0px; width: 90px; height:90px; border-radius: 10px"> <div><a href="list_customers"> <img alt="categories icon" src="<%= request.getContextPath() %>/images/customers-gif.gif" width="50" height="50" > </a></div>  <div >Customers</div> </div></a></li>
			  <li style="display: inline-block; margin-right: 5px; margin-left: 10px"> <div style="box-shadow: rgba(100, 100, 111, 0.2) 0px 7px 29px 0px; width: 90px; height:90px; border-radius: 10px"> <div><a href="list_reviews"> <img alt="categories icon" src="<%= request.getContextPath() %>/images/review-gif.gif" width="50" height="50" > </a></div>  <div >Reviews</div> </div></a></li>
			  <li style="display: inline-block; margin-right: 5px; margin-left: 10px"> <div style="box-shadow: rgba(100, 100, 111, 0.2) 0px 7px 29px 0px; width: 90px; height:90px; border-radius: 10px"> <div><a href="list_orders"> <img alt="categories icon" src="<%= request.getContextPath() %>/images/orders-gif.gif" width="50" height="50" > </a></div>  <div >Orders</div> </div></a></li>
		</ul>	
			
		</div>
		
		
	</div>
		

	
	
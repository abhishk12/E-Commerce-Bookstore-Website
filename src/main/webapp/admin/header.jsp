<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title><%= request.getAttribute("pageTitle") %> - Administrator</title>
<link rel="icon" href="<%= request.getContextPath() %>/images/reading-book.png">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Spicy+Rice&display=swap" rel="stylesheet">
</head>
<body style="font-family: 'Spicy Rice'; background-color: #dcdcdc;" align="center">
	<div>
		
		<div>
			<img alt="logo here" src="<%= request.getContextPath() %>/images/bookStoreSVGLogo.svg" width="700" height="150"/>
		</div>
		
		<div>
			Welcome Admin!
			
			
			<ul style="list-style-type: none; padding: 0; margin: 0; display: inline;">
			  <li style="display: inline; margin-right: 5px; margin-left: 10px"> | </li>
			  <li style="display: inline; margin-right: 5px; margin-left: 10px"><a href="">Logout</a></li>
			</ul>	
		</div>
		
		<div>
		<br>
		<ul style="list-style-type: none; padding: 0; margin: 0; display: inline;">
			  <li style="display: inline; margin-right: 5px; margin-left: 10px"><a href="list_users">Users</a></li>
			  <li style="display: inline; margin-right: 5px; margin-left: 10px"><a href="categories">Categories</a></li>
			  <li style="display: inline; margin-right: 5px; margin-left: 10px"><a href="books">Books</a></li>
			  <li style="display: inline; margin-right: 5px; margin-left: 10px"><a href="customers">Customers</a></li>
			  <li style="display: inline; margin-right: 5px; margin-left: 10px"><a href="reviews">Reviews</a></li>
			  <li style="display: inline; margin-right: 5px; margin-left: 10px"><a href="orders">Orders</a></li>
		</ul>	
		
		</div>
		
	</div>
		

	
	
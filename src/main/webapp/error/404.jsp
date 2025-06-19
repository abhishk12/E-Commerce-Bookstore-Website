<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Page Not Found</title>
<link rel="icon" href="<%= request.getContextPath() %>/images/reading-book.png">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Spicy+Rice&display=swap" rel="stylesheet">
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/style.css" />
</head>
<body align="center">
	<div>
		
		<div>
			<img alt="logo here" src="<%= request.getContextPath() %>/images/bookStoreSVGLogo.svg" width="700" height="150"/>
		</div>
		
		<h2>Sorry, the requested page could not be found.</h2>
		
		
	</div>
	
	<div>
		<p>Click <a href="javascript:history.go(-1);">here</a> to go back.</p>
		
	</div>

	<div align="center">
		<p>Copyright (C) 2025 by The Book Nook Pvt. Ltd.</p> 
		
		<ul style="list-style-type: none; padding: 0; margin: 0; display: inline;">
		  <li style="display: inline; margin-right: 5px; margin-left: 10px"><a href="">About Us</a> |</li>
		  <li style="display: inline; margin-right: 5px"><a href="">Contact Us</a>  |</li>
		  <li style="display: inline; margin-right: 5px"><a href="">Privacy Policy</a> |</li>
		  <li style="display: inline; margin-right: 10px"><a href="">Shipping & Delivery</a> </li>
		</ul>
	</div>
	
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>The Book Nook - An Online Bookstore</title>
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
			<input type="text" name="keyword" size="50" placeholder="Search by book name / category / author / keyword" />
			<input type="button" value="Search"/>
			
			<ul style="list-style-type: none; padding: 0; margin: 0; display: inline;">
			  
			  <li style="display: inline; margin-right: 5px; margin-left: 10px"><a href="">Sign In</a> |</li>
			  <li style="display: inline; margin-right: 5px"><a href="">Register</a>  |</li>
			  <li style="display: inline; margin-right: 10px"><a href="">Cart</a> </li>
			</ul>

			
		</div>
		
	</div>
		

	
	
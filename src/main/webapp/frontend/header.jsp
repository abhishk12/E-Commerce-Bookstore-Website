<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>${pageTitle}</title>
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
		
		<div>
			<input type="text" name="keyword" size="50" placeholder="Search by book name / category / author / keyword" />
			<input type="button" value="Search"/>
			
			<ul style="list-style-type: none; padding: 0; margin: 0; display: inline;">
			  
			  <li style="display: inline; margin-right: 5px; margin-left: 10px"><a href="">Sign In</a> |</li>
			  <li style="display: inline; margin-right: 5px"><a href="">Register</a>  |</li>
			  <li style="display: inline; margin-right: 10px"><a href="">Cart</a> </li>
			</ul>

			
		</div>
			
		<div>
			<br>
			
			
			<ul style="list-style-type: none; padding: 0; margin: 0; display: inline;">
			  <c:forEach var="category" items="${listCategory}" varStatus="status">
			  	
				<li style="display: inline; margin-right: 15px; margin-left: 15px"><a href="<%= request.getContextPath()%>/view_category?id=${category.category_id}&name=${category.name}">${category.name}</a></li><c:if test="${not status.last}"> | </c:if> 
			  </c:forEach>
			  
			</ul>
		</div>
		
	</div>
		

	
	
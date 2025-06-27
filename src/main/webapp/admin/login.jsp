<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title><%= request.getAttribute("pageTitle") %> - Administrator</title>
<link rel="icon" href="<%= request.getContextPath() %>/images/reading-book.png">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Spicy+Rice&display=swap" rel="stylesheet">
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/style.css" />
</head>
<body align="center">
	<div>
		
		<div>
			<a href="${pageContext.request.contextPath}/home">
				<img alt="logo here" src="<%= request.getContextPath() %>/images/bookStoreSVGLogo.svg" width="700" height="150"/>
			</a>
		</div>
		
		<h2>Administrative Login</h2>
		<p style="color:DarkGreen;">
			<c:if test="${message != null}">
				<c:out value="${message}"></c:out>
			</c:if>
			<c:if test="${message == null}">
				
			</c:if>
		</p>
		<div align="center">
			<form action="login" method="post" onsubmit="return validateFormInput()">
				<table>
					<tr>
						<td align="right"> 
							<label for="admin_email" >Email: </label>
							
						</td>
						<td>
							<input type="text" id="admin_email" name="admin_email" />
						</td>
						
					</tr>
					
					<tr>
						<td align="right">
							<label for="admin_password">Password: </label>
							
						</td>
						<td>
							<input type="password" id="admin_password" name="admin_password" />
						</td>
						
					</tr>
					
					<tr>
						<td colspan="2" align="center">
							<input type="submit" value="Login" />
						</td>
					</tr>
					
				</table>
				
			</form>
		</div>
		
	</div>

<script type="text/javascript">
	function validateFormInput(){
		var fieldEmail = document.getElementById("admin_email");	

		var fieldPassword = document.getElementById("admin_password");	
		
		if(fieldEmail.value.length == 0){
			alert("Email is required!");
			fieldEmail.focus();
			return false;
		}
		
		if(fieldPassword.value.length == 0){
			alert("Password is required!");
			fieldPassword.focus();
			return false;
		}
		
		return true;
	}
</script>

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
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="header.jsp"></jsp:include>
	
	<br><br>
	
	<h2> Customer Profile Page</h2>
	
	<h4> Welcome, ${loggedCustomer.full_name} </h4>
	
	<p>
		<c:if test="${update_message == null }"> </c:if>
		<c:if test="${update_message != null }">${update_message} </c:if>
	</p>
	
	<p>
		<c:if test="${message == null }"> </c:if>
		<c:if test="${message != null }">${message} </c:if>
	</p>
	
	<div align="center">
		<table border="1" cellpadding="5">
			<tr>
				<td align="right" >Email: </td>
				<td>${loggedCustomer.email }</td>
			</tr>
			<tr>
				<td align="right" >Full Name: </td>
				<td>${loggedCustomer.full_name}</td>
			</tr>
			<tr>
				<td align="right">Phone Number: </td>
				<td>${loggedCustomer.phone}</td>
			</tr>
			<tr>
				<td align="right" >Address: </td>
				<td>${loggedCustomer.address}</td>
			</tr>
			<tr>
				<td align="right" >City: </td>
				<td>${loggedCustomer.city}</td>
			</tr>
			<tr>
				<td align="right" >Country: </td>
				<td>${loggedCustomer.country}</td>
			</tr>
			<tr>
				<td align="right" >ZipCode: </td>
				<td>${loggedCustomer.zip_code}</td>
			</tr>
		</table>
	</div>
	
	<p> <a href="edit_profile">Edit Profile</a> </p>
	
	<br><br>
	
<jsp:include page="footer.jsp"></jsp:include>
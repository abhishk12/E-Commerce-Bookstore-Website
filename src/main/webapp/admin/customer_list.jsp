<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:include page="header.jsp"></jsp:include>

	<br>
	
	<h2>Customer Management</h2>
	<a href="customer_form.jsp">Create New Customer</a>
	<hr width="60%">
	
	<c:if test="${newCustomerMessage != null}">
		<div align="center">
			<p style="color:DarkGreen;"><i>${newCustomerMessage}</i></p>
		</div>
	</c:if>
	<div align="center">
		<table border="1" cellpadding="5">
			<tr>
				<th>Index</th>
				<th>ID</th>
				<th>Email</th>
				<th>Full Name</th>
				<th>City</th>
				<th>Country</th>
				<th>Registration Date</th>
				<th>Actions</th>
			</tr>

			<c:forEach var="cust" items="${listCustomer}" varStatus="status">
				<tr>
					<td>${status.count}</td>
					<td>${cust.customer_id}</td>
					<td>${cust.email}</td>
					<td>${cust.full_name}</td>
					<td>${cust.city}</td>
					<td>${cust.country}</td>
					<td><fmt:formatDate pattern='MM/dd/yyyy' value='${cust.register_date}'/></td>
					<td>
						<a href="edit_customer?id=${cust.customer_id}">Edit</a> | <a href="javascript:confirmDelete(${cust.customer_id})">Delete</a>
					</td>
				</tr>
			</c:forEach>
			
		</table>
	</div>
	
	<hr width="60%">
	<br><br>

<script type="text/javascript">
	function confirmDelete(customerId){
		if (confirm("Are you sure you want to delete customer with Id: " + customerId + " ?")){
			window.location = "delete_customer?id=" + customerId;
		}
	}	
</script>	
<jsp:include page="footer.jsp"></jsp:include>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> 
<jsp:include page="header.jsp"></jsp:include>

	<br>
	
	<h2>Order Management</h2>
	<hr width="60%">
	
	<c:if test="${updateOrderMessage != null}">
		<div align="center">
			<p style="color:DarkGreen;"><i>${updateOrderMessage}</i></p>
		</div>
	</c:if>
	<div align="center">
		<table border="1" cellpadding="5">
			<tr>
				<th>Index</th>
				<th>Order ID</th>
				<th>Order by </th>
				<th>Book Copies</th>
				<th>Total</th>
				<th>Payment Method</th>
				<th>Status</th>
				<th>Order Date</th>
				<th>Actions</th>
			</tr>

			<c:forEach var="order" items="${listOrder}" varStatus="status">
				<tr>
					<td>${status.count}</td>
					<td>${order.order_id}</td>
					<td>${order.customer.full_name }</td>
					<td>${order.bookCopies }</td>
					<td>${order.total}</td>
					<td>${order.payment_method}</td>
					<td>${order.status}</td>
					<td>${order.order_date}</td>
					<td>
						<a href="view_order?order_id=${order.order_id}">Details</a> | <a href="edit_order?order_id=${order.order_id}">Edit</a> | <a href="javascript:confirmDelete(${order.order_id})">Delete</a>
					</td>
				</tr>
			</c:forEach>
			
		</table>
	</div>
	
	<hr width="60%">
	<br><br>

<script type="text/javascript">
	function confirmDelete(orderId){
		if (confirm("Are you sure you want to delete order with Id: " + orderId + " ?")){
			window.location = "delete_order?id=" + orderId;
		}
	}	
</script>	
<jsp:include page="footer.jsp"></jsp:include>
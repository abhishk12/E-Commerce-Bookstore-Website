<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> 
<jsp:include page="header.jsp"></jsp:include>

	<br>
	
	<h2>My Order History</h2>
	<hr width="60%">
	
	<c:if test="${fn:length(listOrder)==0 }">
		You have not placed any orders.
	</c:if>
	
	<c:if test="${fn:length(listOrder)>0 }">
		<div align="center">
		<table border="1" cellpadding="5">
			<tr>
				<th>Index</th>
				<th>Order ID</th>

				<th>Quantity</th>
				<th>Total Amount</th>
				<th>Order Date</th>
				<th>Status</th>
				
				<th></th>
			</tr>

			<c:forEach var="order" items="${listOrder}" varStatus="status">
				<tr>
					<td>${status.count}</td>
					<td>${order.order_id}</td>

					<td>${order.bookCopies }</td>
					<td>${order.total}</td>
					<td>${order.order_date}</td>
					<td>${order.status}</td>
					
					<td>
						<a href="view_order?order_id=${order.order_id}">View Details</a>
					</td>
				</tr>
			</c:forEach>
			
		</table>
	</div>
	</c:if>
	
	
	
	<hr width="60%">
	<br><br>

	
<jsp:include page="footer.jsp"></jsp:include>
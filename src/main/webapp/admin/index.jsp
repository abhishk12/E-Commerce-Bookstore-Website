<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="header.jsp"></jsp:include>
	
	<br><br>
	
	<h2>Administrative Dashboard</h2>
	
	<div>
		<hr width="60%">
		<h2>Quick Actions:</h2>
		<ul style="list-style-type: none; padding: 0; margin: 0; display: inline;">
			  <li style="display: inline; margin-right: 5px; margin-left: 10px"><a href="new_book">New Book</a></li>
			  <li style="display: inline; margin-right: 5px; margin-left: 10px"><a href="user_form.jsp">New User</a></li>
			  <li style="display: inline; margin-right: 5px; margin-left: 10px"><a href="category_form.jsp">New Category</a></li>
			  <li style="display: inline; margin-right: 5px; margin-left: 10px"><a href="customer_form.jsp">New Customer</a></li>
		</ul>	
		
	</div>
	<hr width="60%">
	<div >
	
		<h2>Recent Sales:</h2>
		
		<c:if test="${bookOrder == null }">
			No recent orders
		</c:if>
		
		<c:if test="${bookOrder != null }">
			
			<table border="1" cellPadding="5" align="center"> 
					<tr>
						<th> Order ID </th>
						<th> Ordered By </th>
						<th> Book Copies </th>
						<th> Total </th>
						<th> Payment Method </th>
						<th> Status </th>
						<th> Order Date </th>
					</tr>
			
				<c:forEach items="${bookOrder }" varStatus="status" var="order">
					
					<tr>
						<td> <a href="view_order?order_id=${order.order_id}"> ${order.order_id} </a> </td>
						<td> ${order.customer.full_name} </td>
						<td> ${order.bookCopies} </td>
						<td> ${order.total} </td>
						<td> ${order.payment_method} </td>
						<td> ${order.status} </td>
						<td> ${order.order_date} </td>
					</tr>
					
				</c:forEach>
			</table>
		</c:if>
	
	</div>
	<hr width="60%">
	<div>
	
		<h2>Recent Reviews:</h2>
		
		<c:if test="${listReviews == null }">
			No recent reviews
		</c:if>
		
		<c:if test="${listReviews != null }">
			
			<table border="1" cellPadding="5" align="center"> 
					<tr>
						<th> Book </th>
						<th> Rating </th>
						<th> Headline </th>
						<th> Customer </th>
						<th> Review On</th>
					</tr>
			
				<c:forEach items="${listReviews }" varStatus="status" var="review">
					
					<tr>
						<td> ${review.book.title} </td>
						<td> ${review.rating} </td>
						<td> <a href="edit_review?id=${review.review_id}">${review.headline}</a> </td>
						<td> ${review.customer.full_name} </td>
						<td> ${review.review_time} </td>
					</tr>
					
				</c:forEach>
			</table>
		</c:if>
	
	</div>
	<hr width="60%">
	<div>
	
		<h2>Statistics:</h2>
		
		Total Users: ${totalUsers } &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		Total Books: ${totalBooks } &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		Total Customers: ${totalCustomer } &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		Total Reviews: ${totalReviews } &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		Total Orders: ${totalOrders }
	
	</div>
	<hr width="60%">
	<br><br>
	
<jsp:include page="footer.jsp"></jsp:include>
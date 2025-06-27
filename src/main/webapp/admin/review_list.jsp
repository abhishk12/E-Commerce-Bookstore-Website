<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:include page="header.jsp"></jsp:include>

	<br>
	
	<h2>Review Management</h2>

	<hr width="60%">
	
	<c:if test="${reviewMessage != null}">
		<div align="center">
			<p style="color:DarkGreen;"><i>${reviewMessage}</i></p>
		</div>
	</c:if>
	<div align="center">
		<table border="1" cellpadding="5">
			<tr>
				<th>Index</th>
				<th>ID</th>
				<th>Book</th>
				<th>Rating</th>
				<th>Headline</th>
				<th>Customer</th>
				<th>Review Date &amp; Time</th>
				<th>Actions</th>
			</tr>

			<c:forEach var="review" items="${listReviews}" varStatus="status">
				<tr>
					<td>${status.count}</td>
					<td>${review.review_id}</td>
					<td>${review.book.title}</td>
					<td>${review.rating}</td>
					<td>${review.headline}</td>
					<td>${review.customer.full_name}</td>
					<td>${review.review_time}</td>
					<td>
						<a href="edit_review?id=${review.review_id}">Edit</a> | <a href="javascript:confirmDelete(${review.review_id})">Delete</a>
					</td>
				</tr>
			</c:forEach>
			
		</table>
	</div>
	
	<hr width="60%">
	<br><br>

<script type="text/javascript">
	function confirmDelete(reviewId){
		if (confirm("Are you sure you want to delete review with Id: " + reviewId + " ?")){
			window.location = "delete_review?id=" + reviewId;
		}
	}	
</script>	
<jsp:include page="footer.jsp"></jsp:include>
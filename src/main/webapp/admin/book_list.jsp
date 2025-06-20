<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:include page="header.jsp"></jsp:include>

	<br>
	
	<h2>Book Management</h2>
	<a href="new_book">Create New Book</a>
	<hr width="60%">
	
	<c:if test="${newBookMessage != null}">
		<div align="center">
			<p style="color:DarkGreen;"><i>${newBookMessage}</i></p>
		</div>
	</c:if>
	<div align="center">
		<table border="1" cellpadding="5">
			<tr>
				<th>Index</th>
				<th>ID</th>
				<th>Book Cover</th>
				<th>Title</th>
				<th>Author</th>
				<th>Category</th>
				<th>ISBN</th>
				<th>Price (in &#8377;)</th>
				<th>Last Updated</th>
				<th>Actions</th>
			</tr>

			<c:forEach var="book" items="${listBooks}" varStatus="status">
				<tr>
					<td>${status.count}</td>
					<td>${book.book_id}</td>
					<td> 
						<img alt="book cover here" src="data:image/jpg;base64,${book.base64Image}" width="100" height="150">
					</td>
					<td>${book.title}</td>
					<td>${book.author}</td>
					<td>${book.category.name}</td>
					<td>${book.isbn}</td>
					<td>${book.price}</td>
					<td><fmt:formatDate pattern='MM/dd/yyyy' value='${book.last_update_time}'/></td>
					<td>
						<a href="edit_book?id=${book.book_id}">Edit</a> | <a href="javascript:confirmDelete(${book.book_id})">Delete</a>
					</td>
				</tr>
			</c:forEach>
			
		</table>
	</div>
	
	<hr width="60%">
	<br><br>

<script type="text/javascript">
	function confirmDelete(bookId){
		if (confirm("Are you sure you want to delete book with Id: " + bookId + " ?")){
			window.location = "delete_book?id=" + bookId;
		}
	}	
</script>	
<jsp:include page="footer.jsp"></jsp:include>
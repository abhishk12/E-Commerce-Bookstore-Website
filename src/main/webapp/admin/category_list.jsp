<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="header.jsp"></jsp:include>

	<br>
	
	<h2>Category Management</h2>
	<a href="category_form.jsp">Create New Category</a>
	<hr width="60%">
	
	<c:if test="${newCategoryMessage != null}">
		<div align="center">
			<p style="color:DarkGreen;"><i>${newCategoryMessage}</i></p>
		</div>
	</c:if>
	
	
	
	<div align="center">
		<table border="1" cellpadding="5">
			<tr>
				<th>Index</th>
				<th>ID</th>
				<th>Category</th>
				<th>Action</th>
			</tr>

			<c:forEach var="category" items="${listCategory}" varStatus="statu">
				<tr>
					<td>${statu.count}</td>
					<td>${category.category_id}</td>
					<td>${category.name}</td>
					<td>
						<a href="edit_category?id=${category.category_id}">Edit</a> | <a href="javascript:confirmDelete(${category.category_id})">Delete</a>
					</td>
				</tr>
			</c:forEach>
			
		</table>
	</div>
	
	<hr width="60%">
	<br><br>

<script type="text/javascript">
	function confirmDelete(userId){
		if (confirm("Are you sure you want to delete category with Id: " + userId + " ?")){
			window.location = "delete_category?id=" + userId;
		}
	}	
</script>	
<jsp:include page="footer.jsp"></jsp:include>
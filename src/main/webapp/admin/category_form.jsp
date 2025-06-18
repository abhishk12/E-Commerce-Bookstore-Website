<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="header.jsp"></jsp:include>
	
	<br><br>
	
	<h2>
		<c:if test="${categoryObj != null }">
			Edit Category
		</c:if>
		
		<c:if test="${categoryObj == null }">
			Create New Category
		</c:if>
		
	</h2>
	<div align="center">
	
		<c:if test="${categoryObj != null}">
			<form action="update_category" method="post" onsubmit="return validateFormInput()">
			<input type="hidden" name="category_id" value="${categoryObj.category_id}" />
		</c:if>
		<c:if test="${categoryObj == null}">
			<form action="create_category" method="post" onsubmit="return validateFormInput()">
		</c:if>
		
			<table cellpadding="5">
			
			<tr>
				<td align="right">
					<label for="category_name">Category Name: </label>
				</td>
				<td>
					<input type="text" id="category_name" name="category_name" value="${categoryObj.name}" />
				</td>
			</tr>
			
			
			<tr>
				<td align="center">
					<input type="submit" value="Save" />
				</td>
				
				<td align="Center">
					<input type="button" value="Cancel" onclick="history.go(-1);" >
				</td>
			
			</tr>
				
			</table>
		</form>
	</div>
	
	
	
	<br><br>

<script type="text/javascript">
	function validateFormInput(){
		var categoryName = document.getElementById("category_name");	
		
		if(categoryName.value.length == 0){
			alert("Category Name is required!");
			categoryName.focus();
			return false;
		}
		
		
		return true;
	}
</script>

<jsp:include page="footer.jsp"></jsp:include>
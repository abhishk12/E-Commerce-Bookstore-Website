<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="header.jsp"></jsp:include>
	
	<br><br>
	
	<h2>
		<c:if test="${userObj != null }">
			Edit User
		</c:if>
		
		<c:if test="${userObj == null }">
			Create New User
		</c:if>
		
	</h2>
	<div align="center">
	
		<c:if test="${userObj != null}">
			<form action="update_user" method="post" onsubmit="return validateFormInput()">
			<input type="hidden" name="user_id" value="${userObj.user_id}" />
		</c:if>
		<c:if test="${userObj == null}">
			<form action="create_user" method="post" onsubmit="return validateFormInput()">
		</c:if>
		
			<table cellpadding="5">
			
			<tr>
				<td align="right">
					<label for="user_email">Email: </label>
				</td>
				<td>
					<input type="text" id="user_email" name="user_email" value="${userObj.email}" />
				</td>
			</tr>
			
			<tr>
				<td align="right">
					<label for="user_full_name">Full Name: </label>
				</td>
				<td>
					<input type="text" id="user_full_name" name="user_full_name" value="${userObj.full_name}" />
				</td>
			</tr>
			
			<tr>
				<td align="right">
					<label for="user_password">Password: </label>
				</td>
				<td>
					<input type="password" id="user_password" name="user_password" value="${userObj.password}" />
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
		var fieldEmail = document.getElementById("user_email");	
		var fieldFullName = document.getElementById("user_full_name");	
		var fieldPassword = document.getElementById("user_password");	
		
		if(fieldEmail.value.length == 0){
			alert("Email is required!");
			fieldEmail.focus();
			return false;
		}
		
		if(fieldFullName.value.length == 0){
			alert("Full Name is required!");
			fieldFullName.focus();
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

<jsp:include page="footer.jsp"></jsp:include>
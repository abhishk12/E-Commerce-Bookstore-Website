<jsp:include page="header.jsp"></jsp:include>
	
	<br><br>
	
	<h2>Create New User</h2>
	<div align="center">
		<form action="create_user" method="post" onsubmit="return validateFormInput()">
			<table cellpadding="5">
			
			<tr>
				<td align="right">
					<label for="user_email">Email: </label>
				</td>
				<td>
					<input type="text" id="user_email" name="user_email" required />
				</td>
			</tr>
			
			<tr>
				<td align="right">
					<label for="user_full_name">Full Name: </label>
				</td>
				<td>
					<input type="text" id="user_full_name" name="user_full_name" required />
				</td>
			</tr>
			
			<tr>
				<td align="right">
					<label for="user_password">Password: </label>
				</td>
				<td>
					<input type="password" id="user_password" name="user_password" required />
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
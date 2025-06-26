<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:include page="header.jsp"></jsp:include>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.14.1/jquery-ui.min.js" integrity="sha512-MSOo1aY+3pXCOCdGAYoBZ6YGI0aragoQsg1mKKBHXCYPIWxamwOE7Drh+N5CPgGI5SA9IEKJiPjdfqWFWmZtRA==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
<script src="<%= request.getContextPath() %>/js/jquery.richtext.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.21.0/jquery.validate.min.js" integrity="sha512-KFHXdr2oObHKI9w4Hv1XPKc898mE4kgYx58oqsc/JqqdLMDI4YjOLzom+EMlW8HFUd0QfjfAvxSL6sEq/a42fQ==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.14.1/themes/base/jquery-ui.min.css" integrity="sha512-TFee0335YRJoyiqz8hA8KV3P0tXa5CpRBSoM0Wnkn7JoJx1kaq1yXL/rb8YFpWXkMOjRcv5txv+C6UluttluCQ==" crossorigin="anonymous" referrerpolicy="no-referrer" />
	<br><br>
	
	<h2> Register as a Customer</h2>
	<div align="center">
		<form action="register_customer" method="post" id="customer_form">
			<table cellpadding="5">

			<tr>
				<td align="right">
					<label for="customer_email">Email: </label>
				</td>
				<td>
					<input type="text" id="customer_email" name="customer_email" />
				</td>
			</tr>
			
			<tr>
				<td align="right">
					<label for="customer_full_name">Full Name: </label>
				</td>
				<td>
					<input type="text" id="customer_full_name" name="customer_full_name" />
				</td>
			</tr>
			
			<tr>
				<td align="right">
					<label for="customer_password">Password: </label>
				</td>
				<td>
					<input type="password" id="customer_password" name="customer_password" />
				</td>
			</tr>
			
			<tr>
				<td align="right">
					<label for="customer_confirm_password">Confirm Password: </label>
				</td>
				<td>
					<input type="password" id="customer_confirm_password" name="customer_confirm_password" />
				</td>
			</tr>
			
			<tr>
				<td align="right">
					<label for="customer_address">Address: </label>
				</td>
				<td>
					<input type="text" id="customer_address" name="customer_address" />
				</td>
			</tr>
			
			<tr>
				<td align="right">
					<label for="customer_zipcode">Zip Code: </label>
				</td>
				<td>
					<input type="text" id="customer_zipcode" name="customer_zipcode"  />
				</td>
			</tr>
			
			<tr>
				<td align="right">
					<label for="customer_city">City: </label>
				</td>
				<td>
					<input type="text" id="customer_city" name="customer_city"  />
				</td>
			</tr>
			
			<tr>
				<td align="right">
					<label for="customer_country">Country: </label>
				</td>
				<td>
					<input type="text" id="customer_country" name="customer_country" />
				</td>
			</tr>
			
			<tr>
				<td align="right">
					<label for="customer_phone">Phone: </label>
				</td>
				<td>
					<input type="text" id="customer_phone" name="customer_phone"  />		
				</td>
			</tr>
			
			
			<tr>
				<td align="center" colspan="2">
					<input type="submit" value="Save" />
					<input type="button" value="Cancel" onclick="history.go(-1);" >
				</td>
				

			
			</tr>
				
			</table>
		</form>
	</div>
	
	
	
	<br><br>

<script type="text/javascript">
	
	$(document).ready(function(){
		$("#customer_form").validate({
			rules: {
				customer_email: {
					required: true,
					email: true
				},
				customer_full_name: "required",
				customer_password: "required",
				customer_confirm_password: {
					required: true,
					equalTo: "#customer_password"
				},
				customer_address: "required",
				customer_zipcode: "required",
				customer_city: "required",
				customer_country: "required",
				customer_phone: "required"
			},
			
			messages: {
				customer_email: {
					required: "Please enter email address",
					email: "Please enter valid email"
				},
				customer_full_name: "Please enter full name",
				customer_password: "Please enter password",
				customer_confirm_password: {
					required: "Please confirm password",
					equalTo: "Confirm password does not match password"
				},
				customer_address: "Please enter address",
				customer_zipcode: "Please enter zip code",
				customer_city: "Please enter city",
				customer_country: "Please enter country",
				customer_phone: "Please enter phone",
			}
		});
	});


	
	
</script>

<jsp:include page="footer.jsp"></jsp:include>
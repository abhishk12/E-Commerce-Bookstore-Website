<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:include page="header.jsp"></jsp:include>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.14.1/jquery-ui.min.js" integrity="sha512-MSOo1aY+3pXCOCdGAYoBZ6YGI0aragoQsg1mKKBHXCYPIWxamwOE7Drh+N5CPgGI5SA9IEKJiPjdfqWFWmZtRA==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
<script src="<%= request.getContextPath() %>/js/jquery.richtext.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.21.0/jquery.validate.min.js" integrity="sha512-KFHXdr2oObHKI9w4Hv1XPKc898mE4kgYx58oqsc/JqqdLMDI4YjOLzom+EMlW8HFUd0QfjfAvxSL6sEq/a42fQ==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.14.1/themes/base/jquery-ui.min.css" integrity="sha512-TFee0335YRJoyiqz8hA8KV3P0tXa5CpRBSoM0Wnkn7JoJx1kaq1yXL/rb8YFpWXkMOjRcv5txv+C6UluttluCQ==" crossorigin="anonymous" referrerpolicy="no-referrer" />
	
	<br><br>
	
	<h2>Edit Review</h2>
	<div align="center">
	
		<form action="update_review" method="post" id="review_form" >
			<input type="hidden" name="review_id" value="${reviewObj.review_id}" />

		
			<table cellpadding="5">
			
			<tr>
				<td align="right">
					Book: 
				</td>
				<td >
					${reviewObj.book.title}
				</td>
			</tr>
			
			<tr>
				<td align="right">
					Rating: 
				</td>
				<td>
					${reviewObj.rating}
				</td>
			</tr>
			
			<tr>
				<td align="right">
					Customer Name: 
				</td>
				<td>
					${reviewObj.customer.full_name}
				</td>
			</tr>
			
			<tr>
				<td align="right">
					<label for="review_headline">Headline: </label>
				</td>
				<td>
					<input type="text" size="30" id="review_headline" name="review_headline" value="${reviewObj.headline}" />
				</td>
			</tr>
			
			<tr>
				<td align="right">
					<label for="review_comment">Comment: </label>
				</td>
				<td>
					<textarea rows="5" cols="30" id="review_comment" name="review_comment" >${reviewObj.comment}</textarea>
				</td>
			</tr>
			
			<tr>
				
			</tr>
			
			
			
			
			<tr>
				<td align="center" >
					<input type="submit" value="Confirm Edit" />
				</td>
				
				<td align="center">
					<input type="button" value="Cancel" onclick="history.go(-1);" >
				</td>
			
			</tr>
				
			</table>
		</form>
	</div>
	
	
	
	<br><br>

<script type="text/javascript">
$(document).ready(function(){
	$("#review_form").validate({
		rules: {
			review_headline: "required",
			review_comment: "required"
		},
		
		messages: {
			review_headline: "Please enter headline",
			review_comment: "Please enter comment",
		}
	});
});

</script>

<jsp:include page="footer.jsp"></jsp:include>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:include page="header.jsp"></jsp:include>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.14.1/jquery-ui.min.js" integrity="sha512-MSOo1aY+3pXCOCdGAYoBZ6YGI0aragoQsg1mKKBHXCYPIWxamwOE7Drh+N5CPgGI5SA9IEKJiPjdfqWFWmZtRA==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
<script src="<%= request.getContextPath() %>/js/jquery.richtext.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.21.0/jquery.validate.min.js" integrity="sha512-KFHXdr2oObHKI9w4Hv1XPKc898mE4kgYx58oqsc/JqqdLMDI4YjOLzom+EMlW8HFUd0QfjfAvxSL6sEq/a42fQ==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/rateYo/2.3.2/jquery.rateyo.min.css">
<script src="https://cdnjs.cloudflare.com/ajax/libs/rateYo/2.3.2/jquery.rateyo.min.js"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.14.1/themes/base/jquery-ui.min.css" integrity="sha512-TFee0335YRJoyiqz8hA8KV3P0tXa5CpRBSoM0Wnkn7JoJx1kaq1yXL/rb8YFpWXkMOjRcv5txv+C6UluttluCQ==" crossorigin="anonymous" referrerpolicy="no-referrer" />

	<br><br>
	
	<h2> Review Submitted</h2>
	<div align="center">
		
			<table cellpadding="5">
			
			<tr>
				<td>
					Your Reviews
				</td>
				<td>
					&nbsp;&nbsp;&nbsp;&nbsp;
				</td>
				<td>
					${loggedCustomer.full_name}
				</td>
			</tr>
			
			<tr>
				<td colspan="3"> <hr> </td>
			</tr>
			
			<tr>
				<td>
					${bookDetail.title } <br>
					<img alt="book cover here" src="data:image/jpg;base64,${bookDetail.base64Image}" width="180" height="250"> 
				</td>
				
				<td>
					${message }
				</td>
			</tr>
				
			</table>
		</form>
	</div>
	
	
	
	<br><br>

<script type="text/javascript">
	
	$(document).ready(function(){
		$("#customer_review_form").validate({
			rules: {
				review_headline: "required",
				review_comment: "required",
			},
			
			messages: {
				review_headline: "Please enter headline",
				review_comment: "Please enter comment",
			}
		});
		$("#rateYo").rateYo({
			fullStar:true,
			onSet: function(rating, rateYoInstance){
				$("#rating").val(rating);
			}
		});
	});


	
	
</script>

<jsp:include page="footer.jsp"></jsp:include>
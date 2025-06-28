<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:include page="header.jsp"></jsp:include>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.14.1/jquery-ui.min.js" integrity="sha512-MSOo1aY+3pXCOCdGAYoBZ6YGI0aragoQsg1mKKBHXCYPIWxamwOE7Drh+N5CPgGI5SA9IEKJiPjdfqWFWmZtRA==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
<script src="<%= request.getContextPath() %>/js/jquery.richtext.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.21.0/jquery.validate.min.js" integrity="sha512-KFHXdr2oObHKI9w4Hv1XPKc898mE4kgYx58oqsc/JqqdLMDI4YjOLzom+EMlW8HFUd0QfjfAvxSL6sEq/a42fQ==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.14.1/themes/base/jquery-ui.min.css" integrity="sha512-TFee0335YRJoyiqz8hA8KV3P0tXa5CpRBSoM0Wnkn7JoJx1kaq1yXL/rb8YFpWXkMOjRcv5txv+C6UluttluCQ==" crossorigin="anonymous" referrerpolicy="no-referrer" />

	<br><br>
		<div align="center" style="max-width:80%;">
			<table width="80%" border="0">
				<tr>
					<td colspan="3"> <h2> ${bookDetail.title} </h2> <i>by ${bookDetail.author}</i> </td>
				</tr>
				
				<tr>
					<td rowspan="2"> <img alt="book cover here" src="data:image/jpg;base64,${bookDetail.base64Image}" width="250" height="350"> </td>
					<td valign="top" align="left"> 
						<jsp:include page="book_rating.jsp"> 
							<jsp:param value="${bookDetail.ratingStars}" name="ratingStars"/>
						</jsp:include>
						<a href="#review_section"> Reviews (${fn:length(bookDetail.review_ids)})</a>
					</td>
					<td valign="top" rowspan="2" width="20%"> Price: <span style="font-weight: 800;">&#8377;</span> ${bookDetail.price} <br><br> <button> Add to Cart </button></td>

				</tr>
				
				<tr>
					<td style="text-align: justify; font-family: 'Roboto', sans-serif; font-weight: 200; font-size: 0.75em;"> ${bookDetail.description} </td>
				</tr>
				
				<tr> 
					<td> &nbsp; </td>
				</tr>
				
				<tr>
					<td> <h4> <a id="review_section">Customer Reviews </a>  </h4> </td>
					<td colspan="2" align="center"> <button id = "writeReviewButton"> Write a customer review </button> </td>
				</tr>
				
				<tr>
					<td colspan="3" align="left">
						<table border="0" cellpadding="5">
							<c:forEach items="${bookDetail.review_ids}" var="review">
								<tr>
									<td>
										<c:forTokens items="${review.stars}" delims="," var="star">
											<c:if test="${star eq 'on' }">
												<img alt="rating" src="<%= request.getContextPath() %>/images/full-star.png" width="12" height="12"/>
											</c:if>
											
											<c:if test="${star eq 'off' }">
												<img alt="rating" src="<%= request.getContextPath() %>/images/empty-star.png" width="11" height="11"/>
											</c:if>
										</c:forTokens>	
										- ${review.headline}
									</td>
									
								</tr>
								
								<tr>
									<td style="font-size:0.75em; font-family: Arial;">
										<i>by ${review.customer.full_name}</i> on ${review.review_time }
									</td>
								</tr>
								
								<tr>
									<td style="font-size:0.75em; font-family: Arial;">
										<i>${review.comment}</i> 
									</td>
								</tr>
								
								<tr>
									<td style="font-size:0.65em;">
										&nbsp;&nbsp;
									</td>
								</tr>
								
							</c:forEach>
						</table>
					</td>
					
				</tr>
				
			</table>
		</div>
	<br><br>

<script type="text/javascript">

	$(document).ready(function(){
		$("#writeReviewButton").click(function(){
			window.location = "write_review?book_id=" + ${bookDetail.book_id}; 
		});
	});	
	
</script>

<jsp:include page="footer.jsp"></jsp:include>
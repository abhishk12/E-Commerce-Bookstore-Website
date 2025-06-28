<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> 
<jsp:include page="header.jsp"></jsp:include>
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
					<td style="text-align: justify; font-family: 'Roboto', sans-serif; font-weight: 200;"> ${bookDetail.description} </td>
				</tr>
				
				<tr> 
					<td> &nbsp; </td>
				</tr>
				
				<tr>
					<td> <h4> <a id="review_section">Customer Reviews </a>  </h4> </td>
					<td colspan="2" align="center"> <button> Write a customer review </button> </td>
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
<jsp:include page="footer.jsp"></jsp:include>
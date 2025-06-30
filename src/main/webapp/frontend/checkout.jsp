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
	<h2>Checkout</h2>
	
	<c:set var="cart" value="${sessionScope['cart'] }" />
	<p>Review Your Order Details &nbsp;|&nbsp; <a href="view_cart">Edit</a>  </p>
	<div align="center" style="font-family:Arial;">
		
		<c:if test="${cart.totalItems == 0 }">
			Cart is empty!
		</c:if>
		
		<c:if test="${cart.totalItems > 0 }">
			
			
				<div>
					
					<table border="1" cellPadding="5">
					
						<tr>
							<th> No </th>
							<th colspan=2"> Book </th>
							<th>Author</th>
							<th> Price </th>
							<th> Quantity </th>
							<th> Subtotal </th>
						</tr>
						
						<c:forEach items="${cart.items }" var="item" varStatus="status">
							<tr>
								<td> ${status.count } </td>
								<td >
									<img alt="book cover here" src="data:image/jpg;base64,${item.key.base64Image}" width="100" height="125"> 
									
								</td>
								<td>
									${item.key.title }
								</td>
								
								<td>
									${item.key.author }
								</td>
								
								<td> ${item.key.price }</td>
								
								<td> 
									<input type="hidden" name="book_id" value="${item.key.book_id }" />
									<input type="text" name="quantity${status.count }" value="${item.value }" size="5" disabled="disabled" />
								</td>
								
								<td> ${item.value*item.key.price }</td>
							</tr>
						</c:forEach>
						
						<tr>
						
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td> ${cart.totalQuantity } Book(s)</td>
							<td> Total: </td>
							<td colspan="2" > <b>${cart.totalAmount }</b> </td>
						</tr>
						
					</table>
					
					<h2>Your Shipping Information</h2>
					
					<form action="place_order" method="post" id="shippingOrderForm">
						<table>
							<tr>
								<td align="right"> <b> <label for="recipient_name">Recipient Name:</label> </b> </td>
								<td> <input type="text" name="recipient_name" id="recipient_name" value="${loggedCustomer.full_name }" > </td>
							</tr>
							
							<tr>
								<td align="right"> <b> <label for="recipient_phone">Recipient Phone:</label></b> </td>
								<td> <input type="text" name="recipient_phone" id="recipient_phone" value="${loggedCustomer.phone }" > </td>
							</tr>
							
							<tr>
								<td align="right"> <b> <label for="recipient_street_address">Street Address:</label></b> </td>
								<td> <input type="text" name="recipient_street_address" id="recipient_street_address" value="${loggedCustomer.address }" > </td>
							</tr>
							
							<tr>
								<td align="right"> <b><label for="recipient_city">City:</label> </b> </td>
								<td> <input type="text" name="recipient_city" id="recipient_city" value="${loggedCustomer.city }"> </td>
							</tr>
							
							<tr>
								<td align="right"> <b> <label for="recipient_zipcode">ZipCode:</label></b> </td>
								<td> <input type="text" name="recipient_zipcode" id="recipient_zipcode" value="${loggedCustomer.zip_code }"> </td>
							</tr>
							
							<tr>
								<td align="right"> <b><label for="recipient_country">Country:</label></b> </td>
								<td> <input type="text" name="recipient_country" id="recipient_country" value="${loggedCustomer.country }"> </td>
							</tr>
							
						</table>
						
						<div>
							<h2>Payment</h2>
							Choose your payment method: 
							&nbsp;&nbsp;&nbsp;
							<select name="payment_method">
								<option value="Pay On Delivery"> Pay On Delivery </option>
								
							</select>
						</div>
						<br><br>
						<div>
					<table border="0">
						<tr>
							<td>
								<button id="placeOrder" type="submit" >Place Order</button>
							</td>
							
							<td>
								<a href="${pageContext.request.contextPath }/home">Continue Shopping</a>
							</td>
						</tr>
					</table>
				</div>
						
					</form>
					
				</div>
				
				

		</c:if>
	
	</div>
		

	<br><br>

	<script type="text/javascript">
		
	$(document).ready(function(){
		$("#shippingOrderForm").validate({
			rules:{
				recipient_name: "required",
				recipient_phone: "required",
				recipient_street_address: "required",
				recipient_city: "required",
				recipient_zipcode: "required",
				recipient_country: "required"
			},
			messages:{
				recipient_name: "Please enter recipient name",
				recipient_phone: "Please enter recipient phone",
				recipient_street_address: "Please enter recipient street address",
				recipient_city: "Please enter recipient city",
				recipient_zipcode: "Please enter recipient zip code",
				recipient_country: "Please enter recipient country"
			}
		});
	});
	
	
	</script>
<jsp:include page="footer.jsp"></jsp:include>















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
	<h3>Your Cart Details</h3>
	
	<c:set var="cart" value="${sessionScope['cart'] }" />
	
	<div align="center" style="font-family:Arial;">
		
		<c:if test="${cart.totalItems == 0 }">
			Cart is empty!
		</c:if>
		
		<c:if test="${cart.totalItems > 0 }">
			
			<form action="update_cart" method="post" id="updateCartForm">
				<div>
					<table border="1" cellPadding="5">
					
						<tr>
							<th> No </th>
							<th colspan=2"> Book </th>
							<th> Quantity </th>
							<th> Price </th>
							<th> Subtotal </th>
							<th> Cart </th>
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
									<input type="hidden" name="book_id" value="${item.key.book_id }" />
									<input type="text" name="quantity${status.count }" value="${item.value }" size="5" />
								</td>
								<td> ${item.key.price }</td>
								<td> ${item.value*item.key.price }</td>
								<td> <a href="remove_from_cart?book_id=${item.key.book_id }">Remove</a> </td>
							</tr>
						</c:forEach>
						
						<tr>
						
							<td></td>
							<td></td>
							<td></td>
							<td> ${cart.totalQuantity } Book(s)</td>
							<td> Total: </td>
							<td colspan="2" > <b>${cart.totalAmount }</b> </td>
						</tr>
						
					</table>
				</div>
				
				<div>
					<table border="0">
						<tr>
							<td></td>
							<td>
								<button id="updateCart" type="submit" >Update</button>
							</td>
							<td>
								<input type="button" id="clearCart" type="submit" value= "Clear Cart" >
							</td>
							
							<td>
								<a href="${pageContext.request.contextPath }/home">Continue Shopping</a>
							</td>
							
							<td>
								<a href="">Checkout</a>
							</td>
						</tr>
					</table>
				</div>
				
			</form>
			
		</c:if>
	
	</div>
		

	<br><br>

	<script type="text/javascript">
		
	$(document).ready(function(){
		$("#updateCartForm").validate({
			rules:{
				<c:forEach items="${cart.items }" var="item" varStatus="status">
					quantity${status.count}: {
						required:true,
						number:true,
						min: 1
					},
				</c:forEach>
			},
			messages:{
				<c:forEach items="${cart.items }" var="item" varStatus="status">
				quantity${status.count}: {
					required:"Please enter quantity",
					number: "Quantity must be a number",
					min: "Quantity must be greater than zero."
				},
				</c:forEach>
			}
		});
		$("#clearCart").click(function(){
			window.location = 'clear_cart';
		});
	});
	
	
	</script>
<jsp:include page="footer.jsp"></jsp:include>















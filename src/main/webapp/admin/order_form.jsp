<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> 
<jsp:include page="header.jsp"></jsp:include>

	<br>
	
	<h2>Edit Order ID: ${orderObj.order_id }</h2>
	<hr width="60%">
	
	<form id="updateOrderAdminForm" action="update_order" method="post">
		
		<div align="center">

			<table border="1" cellpadding="5" style="font-family: Arial; font-size: 0.75em">
				
				<tr> 
					<td align="right"><b>Order By:</b></td>
					<td>${orderObj.customer.full_name }</td>
				</tr>
				
				
				<tr> 
					<td align="right"><b>Order Date:</b></td>
					<td>${orderObj.order_date }</td>
				</tr>
				
				<tr> 
					<td align="right"><b>Recipient Name:</b></td>
					<td> <input type="text" size="50" name="recipient_name" id="recipient_name" value="${orderObj.recipient_name }"> </td>
				</tr>
				
				<tr> 
					<td align="right"><b>Recipient Phone:</b></td>
					<td> <input type="text" size="50" name="recipient_name" id="recipient_name" value="${orderObj.recipient_phone }"> </td>
				</tr>
				
				<tr> 
					<td align="right"><b>Shipping To:</b></td>
					<td> <input type="text" size="50" name="recipient_name" id="recipient_name" value="${orderObj.shipping_address }"> </td>
				</tr>
				
				<tr> 
					<td align="right"><b>Payment Method:</b></td>
					<td>
						
						<select name="payment_method" id="payment_method">
							<option value="Pay On Delivery">Pay On Delivery</option>
						</select>
					</td>
				</tr>
				
				
				<tr> 
					<td align="right"><b>Order Status:</b></td>
					<td>

						<select name="order_status" id="order_status">
							<option value="Processing"> Processing</option>
							<option value="Shipping"> Shipping</option>
							<option value="Delivered"> Delivered</option>
							<option value="Completed"> Completed</option>
							<option value="Cancelled"> Cancelled</option>
						</select>
					</td>
				</tr>
				
				
				
				
				
			</table>
			
			<p>Ordered Books</p>
			<table border="1" cellpadding="5" style="font-family: Arial; font-size: 0.75em">
				<tr>
					<th>Index</th>
					<th >Book Title</th>
					<th>Author</th>
					<th>Price</th>
					<th>Quantity</th>
					<th>Subtotal</th>
					<th> <a href="">Add Books</a> </th>
				</tr>
				
				<c:forEach items="${orderObj.order_details }" var="orderDetail" varStatus="status">
					<tr>
						<td>${status.count }</td>
						<td>${orderDetail.book.title }</td>
						<td>${orderDetail.book.author }</td>
						<td>${orderDetail.book.price }</td>
						<td>
							
							<input type="text" size="5" name="quantity" id="quantity" value="${orderDetail.quantity }"/>
						</td>
						<td>${orderDetail.sub_total }</td>
						<td> <a href="">Remove</a> </td>
					</tr>
				</c:forEach>
				
				<tr>
					<td colspan="4" align="right"> <b><i>TOTAL:</i></b> </td>
					<td><b>${orderObj.bookCopies }</b> </td>
					<td> <b>${orderObj.total }</b> </td>
				</tr>
			
			</table>
			
			
		</div>
		
		<div>
			<br>
			<a href="javascript:showAddBookPopup();"> Add Books</a>
			&nbsp;&nbsp;&nbsp;&nbsp;
			<input type="submit" value="Confirm Edit">
			&nbsp;&nbsp;&nbsp;&nbsp;
			<input type="button" value="Cancel">			
		</div>
		
	</form>

	<hr width="60%">
	<br><br>

<script type="text/javascript">
	
	function showAddBookPopup(){
		var width = 650;
		var left = (screen.width / 2) - (width/2)
		var height = 200;
		var top = (screen.height - height)/2;
		window.open("add_book_form", "_blank", "width="+ width +", height=" + height + ", top=" + top + ", left=" + left);
	}
	
</script>

<jsp:include page="footer.jsp"></jsp:include>









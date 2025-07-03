<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> 
<jsp:include page="header.jsp"></jsp:include>

	<br>
	
	<h2>Details of Order ID: ${orderObj.order_id }</h2>
	<hr width="60%">
	
	<c:if test="${updateOrderMessage != null}">
		<div align="center">
			<p style="color:DarkGreen;"><i>${updateOrderMessage}</i></p>
		</div>
	</c:if>
	<div align="center">
		<p>Order Overview</p>
		<table border="1" cellpadding="5" style="font-family: Arial; font-size: 0.75em">
			<tr> 
				<td> <b>Ordered By</b> </td>
				<td>${orderObj.customer.full_name }</td>
			</tr>
			
			<tr> 
				<td> <b>Book Copies</b> </td>
				<td>${orderObj.bookCopies}</td>
			</tr>
			
			<tr> 
				<td> <b> Total Amount</b> </td>
				<td>${orderObj.total }</td>
			</tr>
			
			<tr> 
				<td><b>Recipient Name</b></td>
				<td>${orderObj.recipient_name }</td>
			</tr>
			
			<tr> 
				<td><b>Recipient Phone</b></td>
				<td>${orderObj.recipient_phone }</td>
			</tr>
			
			<tr> 
				<td><b>Payment Method</b></td>
				<td>${orderObj.payment_method }</td>
			</tr>
			
			<tr> 
				<td><b>Shipping Address</b></td>
				<td>${orderObj.shipping_address }</td>
			</tr>
			
			<tr> 
				<td><b>Order Status</b></td>
				<td>${orderObj.status }</td>
			</tr>
			
			<tr> 
				<td><b>Order Date</b></td>
				<td>${orderObj.order_date }</td>
			</tr>
			
		</table>
		
		<p>Ordered Books</p>
		<table border="1" cellpadding="5" style="font-family: Arial; font-size: 0.75em">
			<tr>
				<th>Index</th>
				<th>Book Title</th>
				<th>Author</th>
				<th>Price</th>
				<th>Quantity</th>
				<th>Subtotal</th>
			</tr>
			
			<c:forEach items="${orderObj.order_details }" var="orderDetail" varStatus="status">
				<tr>
					<td>${status.count }</td>
					<td>${orderDetail.book.title }</td>
					<td>${orderDetail.book.author }</td>
					<td>${orderDetail.book.price }</td>
					<td>${orderDetail.quantity }</td>
					<td>${orderDetail.sub_total }</td>
				</tr>
			</c:forEach>
			
			<tr>
				<td colspan="4" align="right"> <b><i>Total</i></b> </td>
				<td><b>${orderObj.bookCopies }</b> </td>
				<td> <b>${orderObj.total }</b> </td>
			</tr>
		
		</table>
		
		
	</div>
	<br>
	<div align="center">
		<a href="edit_order?order_id=${orderObj.order_id}">Edit Order</a> &nbsp;| &nbsp; <a href="">Delete Order</a> 
	</div>
	
	<hr width="60%">
	<br><br>

<script type="text/javascript">
	function confirmDelete(orderId){
		if (confirm("Are you sure you want to delete order with Id: " + orderId + " ?")){
			window.location = "delete_order?id=" + orderId;
		}
	}	
</script>	
<jsp:include page="footer.jsp"></jsp:include>
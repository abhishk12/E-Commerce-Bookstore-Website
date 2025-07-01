<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> 
<jsp:include page="header.jsp"></jsp:include>

	<br>
	
	<h2>Your Order ID: ${orderObj.order_id }</h2>
	<hr width="60%">
	
	<c:if test="${orderObj==null }">
		<h2>Sorry, this order does not exist.</h2>
	</c:if>
	
	<c:if test="${orderObj!=null }">
		<div align="center">

			<table border="1" cellpadding="5" style="font-family: Arial; font-size: 0.75em">
				<tr> 
					<td align="right"><b>Order Status:</b></td>
					<td>${orderObj.status }</td>
				</tr>
				<tr> 
					<td align="right"><b>Order Date:</b></td>
					<td>${orderObj.order_date }</td>
				</tr>
				<tr> 
					<td align="right"> <b>Quantity:</b> </td>
					<td>${orderObj.bookCopies}</td>
				</tr>
				
				<tr> 
					<td align="right"> <b> Total Amount:</b> </td>
					<td>${orderObj.total }</td>
				</tr>
				
				<tr> 
					<td align="right"><b>Recipient Name:</b></td>
					<td>${orderObj.recipient_name }</td>
				</tr>
				
				<tr> 
					<td align="right"><b>Recipient Phone:</b></td>
					<td>${orderObj.recipient_phone }</td>
				</tr>
				
				<tr> 
					<td align="right"><b>Shipping To:</b></td>
					<td>${orderObj.shipping_address }</td>
				</tr>
				
				<tr> 
					<td align="right"><b>Payment Method:</b></td>
					<td>${orderObj.payment_method }</td>
				</tr>
				
				
				
				
				
				
				
			</table>
			
			<p>Ordered Books</p>
			<table border="1" cellpadding="5" style="font-family: Arial; font-size: 0.75em">
				<tr>
					<th>No</th>
					<th colspan="2">Book</th>
					<th>Author</th>
					<th>Price</th>
					<th>Quantity</th>
					<th>Subtotal</th>
				</tr>
				
				<c:forEach items="${orderObj.order_details }" var="orderDetail" varStatus="status">
					<tr>
						<td>${status.count }</td>
						<td>
							<img alt="book cover here" src="data:image/jpg;base64,${orderDetail.book.base64Image}" width="100" height="125">
						</td>
						<td>${orderDetail.book.title }</td>
						<td>${orderDetail.book.author }</td>
						<td>${orderDetail.book.price }</td>
						<td>${orderDetail.quantity }</td>
						<td>${orderDetail.sub_total }</td>
					</tr>
				</c:forEach>
				
				<tr>
					<td></td>
					<td colspan="4" align="right"> <b><i>TOTAL:</i></b> </td>
					<td><b>${orderObj.bookCopies }</b> </td>
					<td> <b>${orderObj.total }</b> </td>
				</tr>
			
			</table>
			
			
		</div>
	</c:if>
	
	<hr width="60%">
	<br><br>

<jsp:include page="footer.jsp"></jsp:include>
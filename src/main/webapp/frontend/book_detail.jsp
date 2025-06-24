<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="header.jsp"></jsp:include>
	<br><br>
		<div align="center" style="max-width:80%;">
			<table width="80%" border="0">
				<tr>
					<td colspan="3"> <h2> ${bookDetail.title} </h2> <i>by ${bookDetail.author}</i> </td>
				</tr>
				
				<tr>
					<td rowspan="2"> <img alt="book cover here" src="data:image/jpg;base64,${bookDetail.base64Image}" width="250" height="350"> </td>
					<td valign="top" align="left"> Rating **** </td>
					<td valign="top" rowspan="2" width="20%"> Price: <span style="font-weight: 800;">&#8377;</span> ${bookDetail.price} <br><br> <button> Add to Cart </button></td>

				</tr>
				
				<tr>
					<td style="text-align: justify; font-family: 'Roboto', sans-serif; font-weight: 200;"> ${bookDetail.description} </td>
				</tr>
				
				<tr> 
					<td> &nbsp; </td>
				</tr>
				
				<tr>
					<td> <h4> Customer Reviews </h4> </td>
					<td colspan="2" align="center"> <button> Write a customer review </button> </td>
				</tr>
				
			</table>
		</div>
	<br><br>
<jsp:include page="footer.jsp"></jsp:include>
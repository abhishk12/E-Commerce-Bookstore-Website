<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> 

	<div align="center">
		<h2>Add book to Order ID: ${orderObj.order_id }</h2>
		<hr width="60%">
		
		<form action="add_book_to_order" method="post" id="add_book_to_order">
			<table cellPadding="5" border="1">
					
				
				<tr>
					<td align="right">
						<label for="selected_book_id">Select a book:</label>
					</td>
					<td>
						<select name="selected_book_id" id="selected_book_id" style="font-size: 0.75em;">
							<c:forEach items="${listBook}" var="book" varStatus="status">
								<option value="${book.book_id }">${book.title } - ${book.author }</option>
							</c:forEach>
						</select>
					</td>
				</tr>
				
				<tr>
					<td align="right">
						<label for="selected_number_of_copies">Number of Copies:</label>
					</td>
					<td>
						<select name="selected_number_of_copies" id="selected_number_of_copies">
							<option value="1">1</option>
							<option value="2">2</option>
							<option value="3">3</option>
							<option value="4">4</option>
							<option value="5">5</option>
						</select>
					</td>
				</tr>
				
				<tr>
					<td colspan="2" align="center">
						<input type="submit" value="Add" />
						&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="button" value="Cancel" onclick="javascript:self.close();" />
					</td>

				</tr>
				
				
			</table>
		</form>
		
		<hr width="60%">
	</div>



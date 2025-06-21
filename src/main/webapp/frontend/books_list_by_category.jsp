<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="header.jsp"></jsp:include>
	<br><br>
		
		<h2>${categoryName}</h2>
		
		<div align="center" style="width:80%; margin: 0 auto;">
			
			<c:forEach items="${listBooksByCategory}" var="book">
				<div style="display:inline-block; border: 1px solid grey; margin:10px; width:200px; padding:5px">
					<div>
						<a href="view_book?id=${book.book_id}">
							<img alt="book cover here" src="data:image/jpg;base64,${book.base64Image}" width="100" height="150">
						</a>
						
					</div>
					<div style="font-size:1em">
						<a href="view_book?id=${book.book_id}">
							${book.title}
						</a>
						
					</div>
					<div style="font-size:0.75em">
						Rating ****
					</div>
					<div style="font-size:0.75em;">
						<i> ${book.author} </i> 
					</div>
					<div style="font-size:0.75em">
						&#8377; ${book.price}
					</div>
				</div>
			</c:forEach>
			
		</div>
	
	<br><br>
<jsp:include page="footer.jsp"></jsp:include>
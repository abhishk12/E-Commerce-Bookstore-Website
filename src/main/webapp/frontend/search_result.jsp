<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> 
<jsp:include page="header.jsp"></jsp:include>
	<br><br>
	<div align="center">
		<h2> Search Results for '${queryString}' </h2>
		
		<c:if test="${fn:length(resultList) == 0}">
			<p style="color:red;"> No results found for '${queryString}' </p>
		</c:if>
		
		<c:if test="${fn:length(resultList) > 0}">
				<c:forEach items="${resultList}" var="book">
					<div style="border-bottom: 1px solid grey; margin:10px; width:60%">
						<div style="display:inline-block; padding:5px" align="left">
							<div>
								<a href="view_book?id=${book.book_id}">
									<img alt="book cover here" src="data:image/jpg;base64,${book.base64Image}" width="100" height="150">
								</a>
								
							</div>
						
						</div>
						<div style="display:inline-block; width:200px; padding:5px; vertical-align: top;" align="left">
							<div style="font-size:1em">
								<a href="view_book?id=${book.book_id}">
									${book.title}
								</a>
								
							</div>
							<div style="font-size:0.75em">
								Rating ****
							</div>
							<div style="font-size:0.75em;">
								<i> by ${book.author} </i> 
							</div>
							<div style="font-size:0.65em;">
								<p> ${fn:substring(book.description, 0, 100)}... </p>
							</div>
							
						</div>	
						<div style="display:inline-block; width:200px; padding:5px; vertical-align:top;">
							<div style="font-size:1em">
								&#8377; ${book.price}
							</div>
							<div >
								<a href="">Add to Cart</a>
							</div>
							  	
						</div>					
					</div>
				</c:forEach>
		</c:if>
		
		
		
	</div>
	<br><br>
<jsp:include page="footer.jsp"></jsp:include>
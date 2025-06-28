<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:forTokens items="${param.ratingStars}" delims="," var="star">
	<c:if test="${star eq 'on' }">
		<img alt="rating" src="<%= request.getContextPath() %>/images/full-star.png" width="12" height="12"/>
	</c:if>
	
	<c:if test="${star eq 'off' }">
		<img alt="rating" src="<%= request.getContextPath() %>/images/empty-star.png" width="11" height="11"/>
	</c:if>
	
	<c:if test="${star eq 'half' }">
		<img alt="rating" src="<%= request.getContextPath() %>/images/half-star.png" width="12" height="12"/>
	</c:if>
</c:forTokens>
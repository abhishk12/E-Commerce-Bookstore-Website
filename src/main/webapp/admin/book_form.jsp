<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:include page="header.jsp"></jsp:include>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.14.1/jquery-ui.min.js" integrity="sha512-MSOo1aY+3pXCOCdGAYoBZ6YGI0aragoQsg1mKKBHXCYPIWxamwOE7Drh+N5CPgGI5SA9IEKJiPjdfqWFWmZtRA==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.14.1/themes/base/jquery-ui.min.css" integrity="sha512-TFee0335YRJoyiqz8hA8KV3P0tXa5CpRBSoM0Wnkn7JoJx1kaq1yXL/rb8YFpWXkMOjRcv5txv+C6UluttluCQ==" crossorigin="anonymous" referrerpolicy="no-referrer" />
	<br><br>
	
	<h2>
		<c:if test="${bookObj != null }">
			Edit Book
		</c:if>
		
		<c:if test="${bookObj == null }">
			Create New Book
		</c:if>
		
	</h2>
	<div align="center">
	
		<c:if test="${bookObj != null}">
			<form action="update_book" method="post" onsubmit="return validateFormInput()" enctype="multipart/form-data" >
			<input type="hidden" name="book_id" value="${bookObj.book_id}" />
		</c:if>
		<c:if test="${bookObj == null}">
			<form action="create_book" method="post" onsubmit="return validateFormInput()" enctype="multipart/form-data" >
		</c:if>
		
			<table cellpadding="5">
			
			<tr>
				<td align="right">
					<label for="book_category">Category: </label>
				</td>
				<td>
					<select id="book_category" name="book_category">
						<c:forEach items="${listCategory}" var="category">
							<c:if test="${category.category_id eq bookObj.category.category_id}">
								<option value="${category.category_id}" selected> ${category.name} </option>
							</c:if>
							<c:if test="${category.category_id ne bookObj.category.category_id}">
								<option value="${category.category_id}"> ${category.name} </option>
							</c:if>
							
						</c:forEach>
					</select>
				</td>
			</tr>
			
			<tr>
				<td align="right">
					<label for="book_title">Title: </label>
				</td>
				<td>
					<input type="text" id="book_title" name="book_title" value="${bookObj.title}" />
				</td>
			</tr>
			
			<tr>
				<td align="right">
					<label for="book_author">Author Name: </label>
				</td>
				<td>
					<input type="text" id="book_author" name="book_author" value="${bookObj.author}" />
				</td>
			</tr>
			
			<tr>
				<td align="right">
					<label for="book_isbn">ISBN Number: </label>
				</td>
				<td>
					<input type="text" id="book_isbn" name="book_isbn" value="${bookObj.isbn}" />
				</td>
			</tr>
			
			<tr>
				<td align="right">
					<label for="book_publish_date">Publish Date: </label>
				</td>
				<td>
					<input type="text" id="book_publish_date" name="book_publish_date" value="<fmt:formatDate pattern='MM/dd/yyyy' value='${bookObj.publish_date}'/>" />
				</td>
			</tr>
			
			<tr>
				<td align="right">
					<label for="book_cover">Book Cover: </label>
				</td>
				<td>
					<input type="file" id="book_cover" name="book_cover" />
					<br>
					<img src="data:image/jpg;base64,${bookObj.base64Image}" alt="preview image" id="preview_thumbnail" width="100" height="150" style="margin-top: 10px">
				</td>
			</tr>
			
			<tr>
				<td align="right">
					<label for="book_price">Price: </label>
				</td>
				<td>
					<input type="text" id="book_price" name="book_price" value="${bookObj.price}"/>
				</td>
			</tr>
			
			<tr>
				<td align="right">
					<label for="book_description">Description: </label>
				</td>
				<td>
					<textarea rows="5" cols="20" name="book_description" id="book_description" >${bookObj.description}</textarea>
				</td>
			</tr>
			

			
			<tr>
				<td align="center" colspan="2">
					<input type="submit" value="Save" />
					<input type="button" value="Cancel" onclick="history.go(-1);" >
				</td>
				

			
			</tr>
				
			</table>
		</form>
	</div>
	
	
	
	<br><br>

<script type="text/javascript">
	
	$(function() {
	    $("#book_publish_date").datepicker({
	      dateFormat: "mm/dd/yy",
	      changeMonth: true,
	      changeYear: true,
	      yearRange: "c-100:c+5",
	      minDate: "-100Y",
	      maxDate: "+5Y"
	    });
	    
	    
	  });
	
	$(document).ready(function(){
		$("#book_cover").change(function (){
	    	showPreviewThumbnail(this);
	    });
	})

	function validateFormInput(){
		var fieldCategory = document.getElementById("book_category");	
		var fieldTitle = document.getElementById("book_title");	
		var fieldAuthor = document.getElementById("book_author");
		var fieldISBN = document.getElementById("book_isbn");
		var fieldPublishDate = document.getElementById("book_publish_date");
		var fieldBookCover = document.getElementById("book_cover");
		var fieldPrice = document.getElementById("book_price");
		var fieldBookDesc = document.getElementById("book_description");
		
		if(fieldBookDesc.value.length == 0){
			alert("Book description is required!");
			fieldBookDesc.focus();
			return false;
		}
		if(fieldPrice.value.length == 0){
			alert("Price is required!");
			fieldPrice.focus();
			return false;
		}
		<c:if test="${bookObj.image == null}">
		if(fieldBookCover.value.length == 0){
			alert("Book cover is required!");
			fieldBookCover.focus();
			return false;
		}
		</c:if>
		if(fieldPublishDate.value.length == 0){
			alert("Publish date is required!");
			fieldPublishDate.focus();
			return false;
		}
		if(fieldISBN.value.length == 0){
			alert("ISBN is required!");
			fieldISBN.focus();
			return false;
		}
		if(fieldAuthor.value.length == 0){
			alert("Author is required!");
			fieldAuthor.focus();
			return false;
		}
		if(fieldTitle.value.length == 0){
			alert("Title is required!");
			fieldTitle.focus();
			return false;
		}
		if(fieldCategory.value.length == 0){
			alert("Category is required!");
			fieldCategory.focus();
			return false;
		}
		
		
		return true;
	}
	
	function showPreviewThumbnail(fileInput){
		var file = fileInput.files[0];
		var reader = new FileReader();
		reader.onload = function(e){
			$("#preview_thumbnail").attr("src", e.target.result);
		};
		reader.readAsDataURL(file);
	}
	
</script>

<jsp:include page="footer.jsp"></jsp:include>
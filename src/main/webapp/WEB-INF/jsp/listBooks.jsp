<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>JSP Page</title>
<style>
.checked {
	color: orange;
}
</style>
<!-- 	<script
    src="https://code.jquery.com/jquery-3.3.1.js"
    integrity="sha256-2Kok7MbOyxpgUVvAk/HJ2jigOSYS2auK4Pfzbm7uH60="
    crossorigin="anonymous">
</script> -->
</head>
<body>

	<jsp:include page="header.jsp" />

	<table border="1" cellpadding="5" cellspacing="5">
	<c:set var="chckBooks" value="${requestScope.books}" />
	<c:if test="${empty chckBooks}"> No Books to explore</c:if>
		<c:forEach var="book" items="${requestScope.books}">
			<tr>
				<td><a href="bookPage${book.bookid}"><img height=200 width=100 src="/bookreview/images/${book.image}" /></a></td>
				<td><a href="bookPage${book.bookid}">${book.name}</a><br /> ${book.description} <br /> 
				<c:set var="rating" value="${book.rating}" /> 
				<c:forEach var="i" begin="1" end="5">
						<span
							class="fa fa-star 
							<c:if test="${i <= rating}">
							checked
							</c:if>">
						</span>

					</c:forEach>
				</td>
				<td>
				<%--<c:set var="status" value="${book.readingList}" />--%>
				<c:set var="userExists" value="${sessionScope.user}" /> 
				<c:set var="author" value="${sessionScope.user.role}" />
					<c:if test="${not empty userExists}">
						<c:if test="${not empty author}">
							<!-- <a href="editBookPage.htm" class="navbar-brand">Edit</a> -->
							<a href="deleteBook${book.bookid}" class="navbar-brand">Delete</a> 		
						</c:if>
						<br>
						<br>
							<a  href="addToShelf${book.bookid}">Add to Shelf</a> 
							<!-- <a  href="removeFromShelf${book.bookid}">Remove From Shelf</a> -->
						

								
					</c:if>
				</td>


			</tr>
		</c:forEach>

	</table>
	<jsp:include page="footer.jsp" />
</body>
</html>
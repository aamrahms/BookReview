<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<html>
<head>
<title>Home</title>
<style>
	.flex{
	display: flex;
	flex-direction: row;
	flex-wrap: wrap ;
	justify-content: flex-start;
	gap: 2% 2%; 
}
.item{
	align-self: auto ;
}

</style>
</head>
<body>

	<jsp:include page="header.jsp" />
	<c:set var="userExists" value="${sessionScope.user}" />
	<h1>Hello 
		<c:if test="${not empty userExists}"> ${sessionScope.user.username}</c:if> 
		!
	</h1>
	<c:if test="${empty userExists}">
	Are you a new user? Please <a href="registerPage.htm">register</a>!<br/>
	Returning users please <a href="loginPage.htm">login</a><br>
	</c:if>
	<h2>Discover a book lovers paradise! Check out all the latest books here!</h2>
	<c:set var="books" value="${requestScope.books}" />
	<div class="container" style="height: 50%">
		
		<c:if test="${empty books}"> No Books to explore</c:if>
	
		<div class="flex">
			<c:forEach var="book" items="${books}">
				<a href="bookPage${book.bookid}" class="item"><img height=200 width=100 src="/bookreview/images/${book.image}" /></a>
			</c:forEach>
		</div>
	</div>
	<jsp:include page="footer.jsp" />
</body>
</html>

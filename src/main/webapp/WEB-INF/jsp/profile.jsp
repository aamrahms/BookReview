
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
.container{
  height: 20%;
  overflow-y: scroll;

}
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

/*.grid{
	display : grid;
	grid-template-columns: 50% 50%;
	gap: 5%;
}
.posts{

}*/

</style>

</head>
<body>

	<jsp:include page="header.jsp" />
	<h3>${requestScope.thisuser.name}'s Profile</h3>
	
	
	<!-- <div class="grid"> -->
	<div class="container posts">
	<h2>Recent Posts</h2>	
	<c:set var="posts" value="${requestScope.myposts}" />
	<c:if test="${empty posts}"> You have no posts</c:if>	
	<c:forEach var="review" items="${posts}">
	
	  
		<div class="media" >
	    	<div class="media-left">
	      		<img src="/bookreview/images/nopic.jpeg" class="media-object" style="width:45px">
	    	</div>
	    	<div class="media-body">	
	    	<h4 class="media-heading"><small>You reviewed </small><a href="bookPage${review.book.bookid}">${review.book.name}</a></h4>
	    	<h6>
	    	<c:set var="rating" value="${review.rating}" /> 
			<c:forEach var="i" begin="1" end="5">
						<span
							class="fa fa-star 
							<c:if test="${i <= rating}">
							checked
							</c:if>">
						</span>
				</c:forEach>

	    	<i>Posted on ${review.dateOfPost}</i></small></h6>
	    	<p>${review.review}</p>

			</div>
		</div>  	
		
	</c:forEach>
	
	</div>

	
	<div class="container comments" style="height: 30%"">
	<h2>Recent Comments</h2>	
		<c:set var="comments" value="${requestScope.mycomments}" />	
		<c:if test="${empty comments}"> You have no comments</c:if>
				<c:forEach var="comment" items="${comments}">
			    	<div class="media">
		        		<div class="media-left">
		          			<img src="/bookreview/images/nopic.jpeg" class="media-object" style="width:45px">
				        </div>
				        <div class="media-body">	
					    	<h4 class="media-heading"><small>You commented on <b>${comment.user.name}'s</b> post on </small><a href="bookPage${comment.post.book.bookid}">${comment.post.book.name}</a><small></h4>
					    	<h6> <h5 class="media-heading">${comment.post.user.name}</h5>
					    	<c:set var="rating" value="${comment.post.rating}" /> 
								<c:forEach var="i" begin="1" end="5">
										<span
											class="fa fa-star 
											<c:if test="${i <= rating}">
											checked
											</c:if>">
										</span>
								</c:forEach>

					    	<i>Posted on ${comment.post.dateOfPost}</i></small></h6>
							<p>${comment.post.review}</p>
							<div class="media">	
				        		<div class="media-left">
				          			<img src="/bookreview/images/nopic.jpeg" class="media-object" style="width:45px">
						        </div>
						        <div class="media-body">
						          <h6 class="media-heading">${comment.user.name} <small><i>${comment.dateOfComment}</i></small></h6>
						          <p>${comment.message}</p>
						          	
						        </div>
				    		</div>
						</div>
						
					</div>
					
			    </c:forEach>
	</div>
	<!-- </div> -->
	
	<div class="container" style="height: 40%; overflow-x: scroll;">
		<h2>Reading List</h2>
		<c:set var="shelf" value="${requestScope.myshelf}" />	
		<c:if test="${empty shelf}"> You have no books on your shelf, explore books to add</c:if>
		<div class="flex">
			<c:forEach var="reading" items="${requestScope.myshelf}">
				<a href="bookPage${reading.bookid}" class="item"><img height=200 width=100 src="/bookreview/images/${reading.image}" /></a>
			</c:forEach>
		</div>
	</div>
	<div class="container" style="height: 40%;overflow-x: scroll;">
		<h2> Published Books</h2>
		<c:set var="publish" value="${requestScope.mybooks}" />	
		<c:if test="${empty publish}"> You have not published books</c:if>
		<div class="flex">
			<c:forEach var="pub" items="${requestScope.mybooks}">
				<a href="bookPage${pub.bookid}" class="item"><img height=200 width=100 src="/bookreview/images/${pub.image}" /></a>
			</c:forEach>
		</div>
	</div>
	<jsp:include page="footer.jsp" />
</body>
</html>
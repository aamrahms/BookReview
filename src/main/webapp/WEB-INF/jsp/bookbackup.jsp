<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="/bookreview/js/rateme.js"></script>
<script src="/bookreview/js/jquery.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  <link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
 --><!-- added later 
<!-- <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"> -->
<!-- <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>

 --><title>JSP Page</title>
<style>
.checked {
	color: orange;
}
.rate-popover {
  cursor: pointer;
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

				<img height=200 width=100 src="/bookreview/images/${thisbook.image}" />
				${thisbook.name}<br /> ${thisbook.description} <br />  ${thisbook.numberOfPages} ${thisbook.language} ${thisbook.author} ${thisbook.publishingDate }
				<c:set var="rating" value="${thisbook.rating}" /> 
				<c:forEach var="i" begin="1" end="5">
						<span
							class="fa fa-star 
							<c:if test="${i <= rating}">
							checked
							</c:if>">
						</span>
				</c:forEach>
				
				<%--<c:set var="status" value="${thisbook.readingList}" />--%>
				<c:set var="userExists" value="${sessionScope.user}" />
					<c:if test="${not empty userExists}">
						<div class="dropdown">
							<button class="btn btn-secondary dropdown-toggle" type="button"
										id="dropdownMenuButton" data-toggle="dropdown">Dropdown
										button
							</button>
										 
							<div class="dropdown-menu" >
								<a class="dropdown-item" href="updateReadingList/${thisbook.bookid}/wanttoread">Want to Read</a> 
								<a class="dropdown-item" href="updateReadingList/${thisbook.bookid}/reading">Reading</a> 									<a class="dropdown-item" href="updateReadingList/${thisbook.bookid}/read">Read</a>
							</div>
						</div>
					</c:if>

<!-- feedback -->
<a href="https://mdbootstrap.com/snippets/jquery/bartek-malanowski/451394#js-tab-view" > REF</a>
<span id="rateMe">
  <i class="fa fa-star py-2 px-1 rate-popover" data-index="0" data-html="true" data-toggle="popover" data-placement="top" title="Very bad"></i>
  <i class="fa fa-star py-2 px-1 rate-popover" data-index="1" data-html="true" data-toggle="popover" data-placement="top" title="Poor"></i>
  <i class="fa fa-star py-2 px-1 rate-popover" data-index="2" data-html="true" data-toggle="popover" data-placement="top" title="OK"></i>
  <i class="fa fa-star py-2 px-1 rate-popover" data-index="3" data-html="true" data-toggle="popover" data-placement="top" title="Good"></i>
  <i class="fa fa-star py-2 px-1 rate-popover" data-index="4" data-html="true" data-toggle="popover" data-placement="top" title="Excellent"></i>
</span>

<!-- rating.js file -->
<h2>Reviews</h2> 
  <!-- <p>Media objects can also be nested (a media object inside a media object):</p><br> -->
<c:set var="posts" value="${thisbook.bookReviews}" />	
<c:forEach var="review" items="${posts}">
	<div class="container">
	  
		<div class="media">
	    	<div class="media-left">
	      		<img src="img_avatar1.png" class="media-object" style="width:45px">
	    	</div>
	    <div class="media-body">
	    	thisbook.userid.username
	    	<h4 class="media-heading">review.userid.name<small><i>Posted on ${review.dateOfPost}</i></small></h4>
	      	<p>review.review</p>
	      	<!-- <c:if test="${review.comments}">
		      	<c:set var="comments" value="${review.comments}"/>
				<c:forEach var="comment" items="${comments}">
					<div class="media">
		        		<div class="media-left">
		          			<img src="img_avatar2.png" class="media-object" style="width:45px">
		        		</div>
		        		<div class="media-body">
		          			<h4 class="media-heading">${comment.userid.name} <small><i>Posted on ${comment.dateOfComment}</i></small>
		          			</h4>
		          			<p>${comment.message}</p>

					    </div>
		      
		    		</div>
				</c:forEach>				
		  	</c:if> -->
	      <!-- Nested media object--> 
	  	</div>
	</div>
</c:forEach> 
<jsp:include page="footer.jsp" />
</body>
</html>
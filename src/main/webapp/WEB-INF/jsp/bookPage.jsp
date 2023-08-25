<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<head>

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	
	<script>
		function toggle(id){
        const form=document.querySelector('#commentBox'+id);        
                if(form.style.display==="block")
                {
                    form.style.display="none";
                }
                else
                {
                    form.style.display="block";
                }            
     
    	}
    	// function submitPost(e){
    	// 	var xml= new XMLHttpRequest()
    	// }
    	// onsubmit="return validateFormOnSubmit(this);"
	</script>
	<style>
.checked {
	color: orange;
}
.rate-popover {
  cursor: pointer;
}
</style>
</head>
<body>
	<jsp:include page="header.jsp" />
	<div class="container">
		<div class="media">
		    	<div class="media-left">
					<img height=400px width=200px src="/bookreview/images/${thisbook.image}" />
				</div>
				<div class="media-body">
					<h3>${thisbook.name}</h3><br /> 
					<c:set var="rating" value="${thisbook.rating}" /> 
					<c:forEach var="i" begin="1" end="5">
							<span
								class="fa fa-star 
								<c:if test="${i <= rating}">
								checked
								</c:if>">
							</span>
					</c:forEach>
					<p>${rating}</p>
					<br/>
					<b>Synopsis </b><br/>${thisbook.description} <br /> 
					<b>Number of Pages :</b>${thisbook.numberOfPages}<br/> 
					<b>Language : </b>${thisbook.language} <br/> 
					<b> Author : </b> <a href="userProfile${thisbook.author.userid}.htm">${thisbook.author}</a><br/><b>Published on </b>${thisbook.publishingDate }
					
				
					<c:set var="userExists" value="${sessionScope.user}" />
					<c:set var="author" value="${sessionScope.user.role}" />
					<c:if test="${not empty userExists}">
					<br>

					<h4> <a  href="addToShelf${thisbook.bookid}">Add to Shelf</a> </h4>
						
					</c:if>
			</div>
		</div>
	</div>
	<br>
	<br>
	<br>	
	<div class="container">
		<c:if test="${not empty userExists}">
		<h4> Write a review </h4>
			<form model="post" method="post" action="post${thisbook.bookid}.htm" style="background-color: iris">
				<input type="text" placeholder="Enter your views on the book!" name="review"/>
				<input type="number" placeholder="Rate experience 1-5" min=1 max=5 name="rating" width="20px" />
				<input type="submit" value="Submit">
				
			</form>
		</c:if>
	</div>
	
	<div class="container">
	<c:set var="posts" value="${thisbook.bookReviews}" />	
	<c:forEach var="review" items="${posts}">
	
	  
		<div class="media">
	    	<div class="media-left">
	      		<img src="/bookreview/images/nopic.jpeg" class="media-object" style="width:45px">
	    	</div>
	    	<div class="media-body">	
	    	<h4 class="media-heading">${review.user.name}<small>
	    	<c:set var="rating" value="${review.rating}" /> 
				<c:forEach var="i" begin="1" end="5">
						<span
							class="fa fa-star 
							<c:if test="${i <= rating}">
							checked
							</c:if>">
						</span>
				</c:forEach>

	    	<i>Posted on ${review.dateOfPost}</i></small></h4>
	    	<p>${review.review}</p>
	    	<c:if test="${not empty userExists}">
	    		<button onclick="toggle(${review.postid})">Comment</button>
	    	</c:if>
	    	<div style="display:none; background-color: #F9D8D8" id="commentBox${review.postid}">
				<form  model="comment" method="post" action="addComment${review.postid}" > 
					<input type="text" name="message"/>
					<input type="submit" value="Post">
				</form>		
			</div>
	    	<c:set var="comments" value="${review.comments}" />	
				<c:forEach var="comment" items="${comments}">
			    	<div class="media">
		        		<div class="media-left">
		          			<img src="/bookreview/images/nopic.jpeg" class="media-object" style="width:45px">
				        </div>
				        <div class="media-body">
				          <h4 class="media-heading">${comment.user.name}<small><i>${comment.dateOfComment}</i></small></h4>
				          <p>${comment.message}</p>
				          	
				        </div>
			    	</div>
			    </c:forEach>

			</div>
		</div>
			    
			    
	    	
		
	</c:forEach>
	
	</div>
	

	 <jsp:include page="footer.jsp" />


</body>
</html>
<!DOCTYPE html>
<html>
<head>
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
	</script>
	
</head>
<body>
	<form model="post" method="post" action="post/1.htm" style="background-color: iris">
		<input type="text" name="review"/>
		<input type="number" name="rating"/>
		<input type="submit" value="Submit">
		
	</form>

	<button onclick="toggle(1)">Comment</button>
	<div style="display:none; background-color: #F9D8D8" id="commentBox1">
		<form  model="comment" method="post" action="addComment/$post.postid.htm" > <!-- commentBox${post.postid} -->
			<input type="text" name="review"/>
			<input type="submit" value="Post">
		</form>
	</div>
	


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
	      	<c:if test="${review.comments}">
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
		  	</c:if>
	      <!-- Nested media object--> 
	  	</div>
	</div>
</c:forEach> 

--------------

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
	      	<c:if test="${review.comments}">
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
		  	</c:if>
	      <!-- Nested media object--> 
	  	</div>
	</div>
</c:forEach> <c:set var="posts" value="${thisbook.bookReviews}" />	
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
	      	<c:if test="${review.comments}">
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
		  	</c:if>
	      <!-- Nested media object--> 
	  	</div>
	</div>
</c:forEach> 

</body>
</html>
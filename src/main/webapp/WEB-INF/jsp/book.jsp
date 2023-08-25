<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script>
	function changeFunc(){
		var author= document.getElementById("author");
		if(author.value=="other"){
			var y = document.getElementById("authorText");
			y.type= "text";
			var field = document.getElementById("field");
			field.display="inline"
		}
		else{
			var y = document.getElementById("authorText");
			y.type= "hidden";
			var field = document.getElementById("field");
			field.display="none"
		}
	}
</script>
<title>Books</title>
</head>
<body>
	
		<jsp:include page="header.jsp" />  
	<div class="container">
	<div class="row main">
		<div class="panel-heading">
			<div class="panel-title text-center">
				<b><c:if test="${addupdate==1}"> Add a Book</c:if><c:if test="${addupdate==2}">Edit a Book</c:if></b> 
				<hr />
			</div>
		</div>
		<div class="w-75 main-login main-center ">
			<c:set var="addupdate" value="${requestScope.addupdate}" />
					
			<form method="post" class="form-horizontal" enctype="multipart/form-data" model="book" action= <c:if test="${addupdate==1}"> "addBook.htm"</c:if><c:if test="${addupdate==2}">"editBook.htm"</c:if> >

				<div class="form-group">
					<label for="name" class="cols-sm-2 control-label">Name of
						the Book</label>
					<div class="cols-sm-10">
						<div class="input-group">
							<span class="input-group-addon"><i class="fa fa-user fa"
								aria-hidden="true"></i></span> <input type="text" class="form-control"
								path="name" name="name" id="name"
								placeholder="Enter the name of the book" autofocus required />
							<form:errors path="name" />
						</div>
					</div>
				</div>
				<!-- <div class="form-group">
					<label for="email" class="cols-sm-2 control-label">Description</label>
					<div class="cols-sm-10">
						<div class="input-group">
							<span class="input-group-addon"><i
								class="fa fa-envelope fa" aria-hidden="true"></i></span> <input
								type="text" class="form-control" path="description"
								name="description" id="description"
								placeholder="Enter the synopsis here" required />
							<form:errors path="description" />
						</div>
					</div>
				</div> -->

				<div class="form-group">
					<label for="username" class="cols-sm-2 control-label">Publishing
						Date</label>
					<div class="cols-sm-10">
						<div class="input-group">
							<span class="input-group-addon"><i class="fa fa-users fa"
								aria-hidden="true"></i></span> <input type="date" class="form-control"
								path="publishingDate" name="publishingDate" id="publishingDate"
								required />
							<form:errors path="publishingDate" />
						</div>
					</div>
				</div>

				<div class="form-group">
					<label for="password" class="cols-sm-2 control-label">Number
						of Pages</label>
					<div class="cols-sm-10">
						<div class="input-group">
							<span class="input-group-addon"><i
								class="fa fa-lock fa-lg" aria-hidden="true"></i></span> <input
								type ="number" class="form-control" name="numberOfPages"
								id="numberOfPages" placeholder="Enter number of pages" required />
							<form:errors path="numberOfPages" />
						</div>
					</div>
				</div>
				<div class="form-group">
					<label for="language" class="cols-sm-2 control-label">Language</label>
					<select class="form-select" aria-label="Default select example"
						name="language">
						<option value="English" selected>English</option>
						<option value="Hindi">Hindi</option>
						<option value="Japanese">Japanese</option>
					</select>
				</div>
				<div class="form-group">
					<label for="description" class="cols-sm-2 control-label">Synopsis</label>
					<textarea name="description" class="form-control"
						id="exampleFormControlTextarea1" rows="5"></textarea>
				</div>
				<div class="form-group">
				<div class="input-group mb-3">
					<div class="custom-file">
						<label class="custom-file-label" for="inputGroupFile02">Add the Book cover</label>
						<input type="file" name="imageFile" class="custom-file-input" id="inputGroupFile02">
						
						<form:errors path="imageFile" />
					</div>
				</div>
				</div>
				<div class="form-group">
				
						<div class="form-check form-check-inline">
							<input class="form-check-input" type="checkbox" value="fiction" name="genre"
								id="1"/>
							
							<label class="form-check-label" for="1"> Fiction </label>
						</div>
						<div class="form-check form-check-inline">
							<input class="form-check-input" type="checkbox" value="nonfiction" name="genre"
								id="2"/>
							
							<label class="form-check-label" for="2"> Non Fiction </label>
						</div>

						<div class="form-check form-check-inline">
							<input class="form-check-input" type="checkbox" value="fantasy" name="genre"
								id="3"/>
							
							<label class="form-check-label" for="3"> Fantasy </label>
						</div>
						<div class="form-check form-check-inline">
							<input class="form-check-input" type="checkbox" value="romance" name="genre"
								id="9"/>
							
							<label class="form-check-label" for="9"> Romance </label>
						</div>
						<div class="form-check form-check-inline">
							<input class="form-check-input" type="checkbox" value="sciencefiction" name="genre"
								id="4"/>
							
							<label class="form-check-label" for="4"> Science fiction </label>
						</div>
						<div class="form-check form-check-inline">
							<input class="form-check-input" type="checkbox" value="horror" name="genre"
								id="5"/>
							
							<label class="form-check-label" for="5"> Horror </label>
						</div>
						<div class="form-check form-check-inline">
							<input class="form-check-input" type="checkbox" value="youngadult" name="genre"
								id="6"/>
							
							<label class="form-check-label" for="6">Young Adult</label>
						</div>
						<div class="form-check form-check-inline">
							<input class="form-check-input" type="checkbox" value="historicalfiction" name="genre"
								id="7"/>
							
							<label class="form-check-label" for="7"> Historical Fiction </label>
						</div>
						<div class="form-check form-check-inline">
							<input class="form-check-input" type="checkbox" value="crime" name="genre"
								id="8"/>
							
							<label class="form-check-label" for="8"> Crime </label>
						</div>
				</div>
				

				
					
				<c:if test="${not empty authors}">
					<div class="form-group">
						<label for="author" class="cols-sm-2 control-label">Author</label>
						<select class="form-select" aria-label="Default select example"
							name="author">
							<c:forEach var="authorX" items="${requestScope.authors}">
							<option value="${authorX.userid}">${authorX.name}</option>
							</c:forEach>
							</a><option value="other" onChange="changeFunc()" id="other"><a href="#">Other</a></option>
						</select>
					</div>
				</c:if>
				<div class="form-group" style="display:none" id="field">
				<div class="cols-sm-10">
				<label for="author" class="cols-sm-2 control-label">Author</label>
						<div class="input-group">
						
							<span class="input-group-addon"><i
								class="fa fa-lock fa-lg" aria-hidden="true"></i></span> <input
								path="author" class="form-control" name="author" type="text"
								id="authorText" placeholder="Enter Author's name" />
							<form:errors path="author" />
						</div>
					</div>
					</div>

				<div class="form-group ">
					<button type="submit"
						class="btn btn-primary btn-lg btn-block login-button">Add</button>
				</div>
				
			</form>

		</div>
	</div>
	</div>
	<jsp:include page="footer.jsp" /> 
</body>
</html>
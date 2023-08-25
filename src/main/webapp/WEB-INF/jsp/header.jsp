<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- <link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"> -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<script
    src="https://code.jquery.com/jquery-3.3.1.js"
    integrity="sha256-2Kok7MbOyxpgUVvAk/HJ2jigOSYS2auK4Pfzbm7uH60="
    crossorigin="anonymous">
	
</script>
<script type="text/javascript" src="assets/js/bootstrap.js"></script>
<style>
nav a{
color: white;
text-shadow: 1px 1px black;
}
.navbar-custom {
  height: 10%;
}
</style>
</head>
<body>
	<header style="background-color: #EF5DA8" >

<nav class="navbar navbar-custom">
  <!-- <a class="navbar-brand" href="#">Navbar</a> -->
  <a class="navbar-brand" href="home.htm">
    <img src="/bookreview/images/logo.png" width="70" height="50" alt="">
  </a>

	<!-- <a href="home.htm" class="navbar-brand">Home</a> -->
	<a href="registerPage.htm" class="navbar-brand">Register User</a>
	<!-- <a href="search.htm" target="contents">Search a Book</a><br> -->
	<a href="listBooks.htm"class="navbar-brand">Explore</a>
	<!-- <a href="listadverts.htm">List Adverts</a> -->
	<c:set var="userExists" value="${sessionScope.user}" />
	<c:if test="${not empty userExists}">
		<!-- <a href="addBookPage.htm" class="navbar-brand" >Add a Book</a> -->
		<a href="userProfile${sessionScope.user.userid}.htm" class="navbar-brand" >My Profile</a>
		
	</c:if>
 	<!-- <c:set var="isAuthor" value="${sessionScope.user.role}" /> -->
	<c:if test="${not empty isAuthor}">
		<a href="addBookPage.htm" class="navbar-brand">Add a Book</a>
		
	</c:if>
  <div class="collapse navbar-collapse navbar-brand"  id="navbarSupportedContent">
    
    <form class="form-inline my-2 my-lg-0" action="searchBook.htm" method="post">
      <input class="form-control mr-sm-2" type="search" placeholder="Search (title/author/genre)" name="keyword" aria-label="Search">
      <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
    </form>
  </div>
  	<c:if test="${not empty userExists}">
 		 <a href="logout.htm" class="navbar-brand">Sign Out</a>
	</c:if>
</nav>
	
	</header>
</body>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Post Comments</title>
    </head>
    <body>
    	<a href="home.htm" target="contents">Home</a><br>
        <a href="registerPage.htm" target="contents">Register User</a><br>
        <a href="search.htm" target="contents">Search a Book</a><br>
        
        <a href="listadverts.htm" target="contents">List Adverts</a><br>
        <c:set var="userExists" value="${sessionScope.user}"/>
        <c:if test="${not empty userExists}">
        	<a href="addBookPage.htm" target="contents">Add a Book</a><br>
           	<a href="userProfile.htm" target="contents">My Profile</a><br> 
           	<a href="logout.htm" target="contents">Sign Out</a><br> 
        </c:if>
        <c:set var="isAuthor" value="${sessionScope.author}"/>
        <c:if test="${not empty isAuthor}">
           <a href="addBook.htm" target="contents">Add a Book</a><br>
        </c:if>
    </body>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Game Details</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/style.css"> 
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="header">
		<h1><c:out value="${game.name}"/></h1>
		<a href="/dashboard">dashboard</a>
	</div>
	<div class="container mx-auto">
		<p>Name: <c:out value="${game.name}"/></p>
		<p>Reviewer: <c:out value="${game.user.userName}"/></p>
		<p>Description: <c:out value="${game.description}"/></p>
	</div>
			
	<c:if test="${game.user.id == sessionScope.userId}">
		<a href="/delete/${game.id}">Delete</a>
	</c:if>
	<c:if test="${game.user.id == sessionScope.userId}">
		<a href="/games/${game.id}/edit">Edit</a>
	</c:if>
</body>
</html>
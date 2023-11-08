<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isErrorPage="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Game Workshop Dashboard</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/style.css"> 
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="header">
		<h1>Welcome, <c:out value="${user.userName}"/></h1>
		<a href="/logout">Log out</a>
	</div>
<div class="container-main mx-auto">
	<div class="container mx-auto">
	
	<h1>All Reviews</h1>
	
	<table class="table table-striped">
		<thead>
			<tr>
				<th scope="col">Game Name</th>
				<th scope="col">Genre</th>
				<th scope="col">Review</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="game" items="${allgames}">
				<tr>
					<td><a href="games/${game.id}"><c:out value="${game.name}"/></a></td>
					<td><c:out value="${game.genre}"/></td>
					<td><c:out value="${game.description}"/><td>
				</tr>
			</c:forEach>
		</tbody>
		</table>
		<a href="/games/new"><input type="submit" value="Create New Review" class="btn-primary"/></a>
	</div>

</div>
</body>
</html>
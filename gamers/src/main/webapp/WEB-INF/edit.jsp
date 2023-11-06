<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ page isErrorPage="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Game</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/style.css"> 
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="header">
		<h1>Edit Game</h1>
		<a href="/dashboard">dashboard</a>
	</div>
	
	<div class="container mx-auto">
		<form:form action="/games/${game.id}" method="put" modelAttribute="game" class="form">
			<div class="form-row">
			 		<form:errors path="name"/>
					<form:label for="name" path="name">Name:</form:label>
					<form:input type="text" path="name" class="form-control"/>
				</div>
			
				<div class="form-row">
					<form:errors path="genre"/>
					<form:label for="genre" path="genre">Genre:</form:label>
					<form:input type="text" path="genre" class="form-control"/>
				</div>
			
				<div class="form-row">
					<form:errors path="description"/>
					<form:label for="description" path="description">Description:</form:label>
					<form:input type="textarea" path="description" class="form-control"/>
				</div>
				<div>
					<input type="submit" value="Submit" class="btn-primary"/>
				</div>
		</form:form>
	</div>
</body>
</html>
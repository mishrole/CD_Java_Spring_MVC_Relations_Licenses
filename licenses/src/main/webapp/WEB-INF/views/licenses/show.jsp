<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>License</title>
	<!-- Bootstrap -->
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>
	
	<div class="container py-5">
		<div class="d-flex justify-content-center">
			<div class="container">
				<div class="pt-2 pb-4"><a href="/licenses">Go back</a></div>
				<h3 class="text-center">License Details</h3>
				
				<div class="d-flex justify-content-between align-items-center pt-2 pb-4">
					<a href="/licenses/${license.id}/edit" class="btn btn-info text-white">Edit</a>
					<form action="/licenses/${license.id}" method="post">
			      		<input type="hidden" name="_method" value="DELETE">
			      		<button type="submit" class="btn btn-danger">Delete</button>
			      	</form>
				</div>
				
				<div class="card">
					<div class="card-header">
						<h3><c:out value="${license.number}"></c:out></h3>
					</div>
					<div class="card-body">
						<p><span class="fw-bold">Expiration Date:</span> <fmt:formatDate pattern = "dd/MM/yyyy" value = "${license.expirationDate}" /></p>
						<p><span class="fw-bold">State:</span> <c:out value="${license.state}"></c:out></p>
						<p><span class="fw-bold">Person:</span> <c:out value="${license.person.firstName}"></c:out> <c:out value="${license.person.lastName}"></c:out></p>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	<!--Bootstrap -->
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>
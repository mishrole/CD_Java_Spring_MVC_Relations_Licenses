<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Reading Books</title>
	<!-- Bootstrap -->
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>
	
	<div class="container py-5">
		<div class="d-flex justify-content-center">
			<div class="container">
				<div class="pt-2 pb-4"><a href="/books">Go back</a></div>
				
				<div class="card">
					<div class="card-header">
						<h3><c:out value="${book.title}"></c:out></h3>
					</div>
					<div class="card-body">
						<p><span class="fw-bold">Description:</span> <c:out value="${book.description}"></c:out></p>
						<p><span class="fw-bold">Language:</span> <c:out value="${book.language}"></c:out></p>
						<p><span class="fw-bold">Number of Pages:</span> <c:out value="${book.numberOfPages}"></c:out></p>
					</div>
					<div class="card-footer">
						<div class="d-flex justify-content-center align-items-center">
						<a href="/books">Go back</a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	<!--Bootstrap -->
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>
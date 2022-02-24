<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!-- PUT -->
<%@ page isErrorPage="true" %> 
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Edit Book</title>
	<!-- Bootstrap -->
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>
	
	<div class="container py-5">
		<div class="d-flex justify-content-center">
			<div class="container">
				<div class="pt-2 pb-4"><a href="/books">Go back</a></div>
			
				<h3 class="text-center">Edit Book</h3>
				<div class="card">
					<div class="card-body">
						<form:form action="/books/${book.id}" method="POST" id="validate" modelAttribute="book">
							<input type="hidden" name="_method" value="PUT">
							
							<div class="row mx-auto">
								<div class="col-12">
									<div class="form-floating mb-3">
									  <form:input path="title" type="text" class="form-control requires-validation validate-save" name="title" id="title"/>
									  <div class="invalid-feedback"></div>
									  <form:errors path="title" class="text-danger backend-validation" />
									  <form:label for="title" path="title">Title</form:label>
									</div>
								</div>

								<div class="col-12">
									<div class="form-floating mb-3">
									  <form:textarea path="description" name="description" class="form-control requires-validation validate-save" id="description"></form:textarea>
									  <div class="invalid-feedback"></div>
									  <form:errors path="description" class="text-danger backend-validation" />
									  <form:label path="description" for="description">Description</form:label>
									</div>
								</div>
								
								<div class="col-12">
									<div class="form-floating mb-3">
									  <form:input path="language" type="text" class="form-control requires-validation validate-save" name="language" id="language" />
									  <div class="invalid-feedback"></div>
									  <form:errors path="language" class="text-danger backend-validation" />
									  <form:label path="language" for="language">Language</form:label>
									</div>
								</div>
								
								<div class="col-12">
									<div class="form-floating mb-3">
									  <form:input path="numberOfPages" type="number" class="form-control requires-validation validate-save validate-minimum" name="numberOfPages" id="numberOfPages" min="100" />
									  <div class="invalid-feedback"></div>
									  <form:errors path="numberOfPages" class="text-danger backend-validation" />
									  <label for=numberOfPages>Number of Pages</label>
									</div>
								</div>
								
								<div class="col-12">
									<div class="d-flex align-items-center justify-content-end">
										<button class="btn btn-primary" type="submit" value="Submit">Edit</button>
									</div>
								</div>
							</div>
						</form:form>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	<!-- jQuery (No necesario en Bootstrap 5) -->
	<!-- <script src="/webjars/jquery/jquery.min.js"></script> -->
	<!--Bootstrap -->
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
	<!-- Javascript Local -->
	<script src="/js/validateHelper.js"></script>
	<script src="/js/validateForm.js"></script>
</body>
</html>
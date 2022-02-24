<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>New License</title>
	<!-- Bootstrap -->
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>
	
	<div class="container py-5">
		<div class="d-flex justify-content-center">
			<div class="container">
				<div class="pt-2 pb-4"><a href="/licenses">Go back</a></div>
				
				<h3 class="text-center">New License</h3>
				<div class="card">
					<div class="card-body">
						<form:form action="/licenses" method="POST" id="validate" modelAttribute="license">
							<div class="row mx-auto">
								<div class="col-12">
									<div class="form-floating mb-3">
									  <form:input path="number" type="text" class="form-control requires-validation validate-save" name="number" id="number" />
									  <div class="invalid-feedback"></div>
									  <form:errors path="number" class="text-danger backend-validation" />
									  <form:label for="number" path="number">Number</form:label>
									</div>
								</div>
								
								<div class="col-12">
									<div class="form-floating mb-3">
									  <form:input path="expirationDate" type="date" class="form-control requires-validation validate-save" name="expirationDate" id="expirationDate" />
									  <div class="invalid-feedback"></div>
									  <form:errors path="expirationDate" class="text-danger backend-validation" />
									  <form:label path="expirationDate" for="expirationDate">Expiration Date</form:label>
									</div>
								</div>
								
								<div class="col-12">
									<div class="form-floating mb-3">
									  <form:input path="state" type="text" class="form-control requires-validation validate-save" name="state" id="state" />
									  <div class="invalid-feedback"></div>
									  <form:errors path="state" class="text-danger backend-validation" />
									  <form:label path="state" for="state">State</form:label>
									</div>
								</div>

								<div class="col-12">
									<div class="form-floating mb-3">
										<form:select path="person" id="person" class="form-select requires-validation validate-save ">
									        <c:forEach var="onePerson" items="${persons_list}">
									            <form:option value="${onePerson.id}" path="person">
									                <c:out value="${onePerson.firstName}"/>
									                <c:out value="${onePerson.lastName}" />
									            </form:option>
									        </c:forEach>
									    </form:select>
										<div class="invalid-feedback"></div>
										<form:errors path="person" class="text-danger backend-validation" />
										<label for="person">Select a person</label>
									</div>
								</div>
								
								<div class="col-12">
									<div class="d-flex align-items-center justify-content-end">
										<button class="btn btn-primary" type="submit" value="Submit">Save</button>
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
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Licenses</title>
	<!-- Bootstrap -->
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
	<link rel="stylesheet" href="/css/style.css" />
</head>
<body>
	
	<div class="container py-5">
		<div class="d-flex justify-content-center">
			<div class="container">
				<div class="pt-2 pb-4"><a href="/">Go back</a></div>
				
				<div class="d-flex justify-content-between align-items-center pb-4">
					<h3>All licenses</h3>
					<div>
						<a href="/licenses/new" class="btn btn-primary">New License</a>
					</div>
				</div>
				
				<div class="table-responsive">
					<table class="table table-hover">
					  <thead>
					    <tr>
					      <th scope="col">Id</th>
					      <th scope="col">Number</th>
					      <th scope="col">Expiration</th>
					      <th scope="col">State</th>
					      <th scope="col">Actions</th>
					    </tr>
					  </thead>
					  <tbody>
						  <c:forEach var="license" items="${licenses}">
							<tr>
						      <th scope="row">${license.id}</th>
						      <td><a href="/licenses/${license.id}">${license.number}</a></td>
						      <td><fmt:formatDate pattern = "dd/MM/yyyy" value = "${license.expirationDate}" /></td>
						      <td>${license.state}</td>
						      <td>
						      	<div class="d-flex justify-content-between align-items-center">
							      	<a href="/licenses/${license.id}/edit">Edit</a>
								      <form action="/licenses/${license.id}" method="post">
								      	<input type="hidden" name="_method" value="DELETE">
								      	<button type="submit" class="btn btn-default link">Delete</button>
								      </form>
						      	</div>
						      </td>
						    </tr>
						</c:forEach>
					  </tbody>
					</table>
				</div>
				
			</div>
		</div>
	</div>
	
	<!--Bootstrap -->
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>
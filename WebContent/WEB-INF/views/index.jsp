<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<jsp:include page="head.jsp"/>
	
<!--<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home Page</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet"">
</head>-->

<body>
	<form action="${actionValue}" method="post">
	
	<input type="text" name="id" value="${idValue}"/>
	
		<div class="container">
		
			<jsp:include page="title.jsp"/>
			
			<div class="row pt-5">
				<div class="col-md-4">Enter Name: </div>
				<div class="col-md-4"><input type="text" name="name" class="form-control" value="${nameValue}"/></div>
				<div class="col-md-4 text-danger">${nameError}</div>
			</div>
			
			<div class="row pt-5">
				<div class="col-md-4">Enter Address: </div>
				<div class="col-md-4"><input type="text" name="age" class="form-control" value="${addressValue}"/></div>
				<div class="col-md-4 text-danger">${addressError}</div>
			</div>
			
			<div class="row pt-5">
				<div class="col-md-4">Enter City: </div>
				<div class="col-md-4"><input type="text" name="phone" class="form-control" value="${cityValue}"/></div>
				<div class="col-md-4 text-danger">${cityError}</div>
			</div>
			
			<div class="row pt-5">
				<div class="col-md-4">Enter State: </div>
				<div class="col-md-4"><input type="text" name="phone" class="form-control" value="${stateValue}"/></div>
				<div class="col-md-4 text-danger">${stateError}</div>
			</div>
			
			<div class="row pt-5">
				<div class="col-md-6 text-danger"><h4>${fieldsError}</h4></div>
			</div>
			
			<div class="row pt-5">
				<div class="col-md-4"><input type="submit" value="${buttonValue}" class="btn btn-primary"/> <a href="./"><input type="button" value="REFRESH" class="btn btn-info"/></a> </div>
			</div>
			
			<div class="row pt-5">
				<div class="col-md-7 text-success"><h4>${successMessage}</h4></div>
			</div>
			
			<div class="row pt-5">
				<div class="col-md-6 text-danger"><h4>${errorMessage}</h4></div>
			</div>
			
			<div class="row">
				<div class="col-md-9">
					<table width="100%" class="table">
						
						<tr>
							<th>ACTION</th>
							<th>ID</th>
							<th>NAME</th>
							<th>AGGRESS</th>
							<th>CITY</th>
							<th>STATE</th>
						</tr>
						
						<c:forEach items="${userList}" var="per">  
   							<tr>
   								<td><a href="./getPersonEdit?id=${per.getId()}">EDIT</a>||<a href="./getPersonDelete?id=${per.getId()}">DELETE</a></td>
   								<td>${per.getId()}</td>
   								<td>${per.getName()}</td>
   								<td>${per.getAddress()}</td>
   								<td>${per.getCity()}</td>
   								<td>${per.getState()}</td>
   							</tr>
						</c:forEach>
						
					</table>
				</div>
			</div>
			
		</div>
	</form>


	<!--<form action="./submitPerson" method="get">
		Enter Name: <input type="text" name="name"/><br><br>
		<input type="submit" value="SUBMIT"/>
	</form>
	
	<h3 style="color:red">${error}</h3>
	<h3 style="color:green">${success}</h3>-->
	
</body>

</html>
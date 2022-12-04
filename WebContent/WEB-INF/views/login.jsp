<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee Registration</title>

<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
  <a class="navbar-brand" href="#">Registration</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
        <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
      </li>
      
    </ul>
    <form class="form-inline my-2 my-lg-0">
      <a href="login" class="btn btn-light my-2 my-sm-0 mr-2" type="submit">Login</a>
      <a href="signup1" class="btn btn-light my-2 my-sm-0" type="submit">Signup</a>
    </form>
  </div>
</nav>

<body>
	
	<center><form action="./validateLogin" method="post">
		<div class="container">
			<jsp:include page="title.jsp"/>
			<div class="card body" style="margin-top: 50px; margin-left: 250px; margin-right: 250px"><br>
			<div class="row pt-4">
				<div class="col-md-12 pt-4 mylogin">
					<div class="row p-2">
						<div class="col-md-6">Enter UserName: </div>
						<div class="col-md-6"><input type="text" name="username" class="form-control"/></div>
					</div>
					
					<div class="row p-2">
						<div class="col-md-6">Enter Password: </div>
						<div class="col-md-6"><input type="password" name="password" class="form-control"/></div>
					</div>
					
					<div class="row p-2">
						<div class="col-md-12"><input type="submit" value="LOGIN" class="btn btn-success"/></div>
					</div>
					
					<div class="row">
						<div class="col-md-12 text-danger">
							<h2>${error}</h2>
						</div>
					</div>
					
				</div>
				
				<div class="col-md-4"></div>
				
			</div>
		</div>
	</form></center>
</body>
</html>
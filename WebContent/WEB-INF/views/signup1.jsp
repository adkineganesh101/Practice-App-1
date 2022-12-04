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

<form action="./userSubmit" method="post">
	<div class="container" >
		<div class="card body" style="margin-top: 50px; margin-left: 250px; margin-right: 250px"><br>
			<center><h1>Registration Form</h1></center><br><br>
			<center><h1>${SuccessMessage }</h1></center>
			<div class="row">
				<div class="col-md-3">
					<h4>Name</h4>
				</div>
				<div class="col-md-9">
					<input type="text" name="name" class="form-control" required/>
				</div>
			</div><br>
			
			<div class="row">
				<div class="col-md-3">
					<h4>Date Of Birth</h4>
				</div>
				<div class="col-md-9">
					<input type="date" name="dob" class="form-control" required/>
				</div>
			</div><br>
			
			<div class="row">
				<div class="col-md-3">
					<h4>Gender</h4>
				</div>
				<div class="col-md-9">
					<input type="radio" name="gender" value="male" checked/>Male
					<input type="radio" name="gender" value="female" />Female
				</div>
			</div><br>
			
			<div class="row">
				<div class="col-md-3">
					<h4>Address</h4>
				</div>
				<div class="col-md-9">
					<textarea type="text" name="address" class="form-control" required></textarea>
				</div>
			</div><br>
			
			<div class="row">
				<div class="col-md-3">
					<h4>City</h4>
				</div>
				<div class="col-md-9">
					<input type="text" name="city" class="form-control" required/>
				</div>
			</div><br>
			
			<div class="row">
				<div class="col-md-3">
					<h4>State</h4>
				</div>
				<div class="col-md-9">
					<input type="text" name="state" class="form-control" required/>
				</div>
			</div><br>
			
			<div class="row">
				<div class="col-md-3">
					<h4>Login id</h4>
				</div>
				<div class="col-md-9">
					<input type="text" name="username" class="form-control" required/>
				</div>
			</div><br>
			
			<div class="row">
				<div class="col-md-3">
					<h4>Password</h4>
				</div>
				<div class="col-md-9">
					<input type="password" name="password" class="form-control" required/>
				</div>
			</div><br>
			
			<div class="row">
			<div class="col-md-12">
				<center><input type="submit" name="signup1" class="btn btn-outline-primary"/></center>
			</div></div><br>
		</div><br><br>
	</div>


</form>

</body>
</html>
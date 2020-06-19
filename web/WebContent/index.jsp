<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Login</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
</head>
<body>
<div class="container col-sm-5">
	<div class="card text-center">
		<div class="card-body" >
			<h3 >Login</h3>
			<h6 class="text-danger">${erro}</h6>
			<form action="LoginServlet" method="post">
				<div class="form-group row ">
					<label class="col-sm-3 text-right">Email:</label>
					<div class="col-sm-8">
						<input class="form-control" id="email" type="text" name="email" placeholder="Email" required/>
					</div>
				</div>
				<div class="form-group row">
					<label class="col-sm-3 text-right">Senha:</label>
					<div class="col-sm-8">
						<input class="form-control" id="password" type="password" name="pass" placeholder="Password" required/>
					</div>
				</div>
				<input type="submit" value="Sign In" class="btn btn-primary center-block form-control col-sm-10"/>
			</form>
		</div>
		 
		<label style="color: green;">${sucess}</label> 
	</div>
</div>
</body>
</html>
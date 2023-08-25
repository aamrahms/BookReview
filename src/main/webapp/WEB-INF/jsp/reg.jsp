<!DOCTYPE html>
<html lang="en">
<head>
<title>Registration</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

</head>
<body>
	
	<jsp:include page="header.jsp" />  

	<div class="container">
		<div class="row main">
			<div class="panel-heading">
				<div class="panel-title text-center">
					<b>REGISTRATION</b>
					<hr />
				</div>
			</div>
			<div class="main-login main-center">
				<form method="post" action="register.htm" class="form-horizontal">

					<div class="form-group">
						<label for="name" class="cols-sm-2 control-label">Your
							Name</label>
						<div class="cols-sm-10">
							<div class="input-group">
								<span class="input-group-addon"><i class="fa fa-user fa"
									aria-hidden="true"></i></span> <input type="text" class="form-control"
									path="name" name="name" id="name"
									placeholder="Enter your First Name" autofocus required />
								<form:errors path="name" />
							</div>
						</div>
					</div>
					<div class="form-group">
						<label for="email" class="cols-sm-2 control-label">Your
							Email</label>
						<div class="cols-sm-10">
							<div class="input-group">
								<span class="input-group-addon"><i
									class="fa fa-envelope fa" aria-hidden="true"></i></span> <input
									type="text" class="form-control" path="email" name="email"
									id="email" placeholder="Enter your Email" required />
								<form:errors path="email" />
							</div>
						</div>
					</div>

					<div class="form-group">
						<label for="username" class="cols-sm-2 control-label">Username</label>
						<div class="cols-sm-10">
							<div class="input-group">
								<span class="input-group-addon"><i class="fa fa-users fa"
									aria-hidden="true"></i></span> <input type="text" class="form-control"
									path="username" name="username" id="username"
									placeholder="Enter your Username" required />
								<form:errors path="username" />
							</div>
						</div>
					</div>

					<div class="form-group">
						<label for="password" class="cols-sm-2 control-label">Password</label>
						<div class="cols-sm-10">
							<div class="input-group">
								<span class="input-group-addon"><i
									class="fa fa-lock fa-lg" aria-hidden="true"></i></span> <input
									path="password" class="form-control" name="password"
									id="password" placeholder="Enter your Password" required />
								<form:errors path="password" />
							</div>
						</div>
					</div>

					<div class="form-group">
						<div class="form-check">
							<input class="form-check-input" type="checkbox" value="author" name="role"
								id="flexCheckChecked"> <label
								class="form-check-label" for="flexCheckChecked"> Author Profile? </label>
						</div>
					</div>

					<div class="form-group ">
						<button type="submit"
							class="btn btn-primary btn-lg btn-block login-button">Register</button>
					</div>

				</form>
				<div class="form-group ">
					<a href="loginPage.htm">
						<button class="btn btn-primary btn-lg btn-block login-button">Already
							a Member? Login</button>
					</a>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="footer.jsp" /> 
	

	
</body>
</html>
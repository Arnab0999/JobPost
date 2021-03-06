<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<title>Home</title>
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
		<link rel="stylesheet" href="styles.css">
		<script src="jobs.js"></script>
	</head>
	<body>
		<nav class="navbar navbar-expand-lg navbar-light bg-light">
			<a class="navbar-brand" href="#">JOB PORTAL</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
			</button>

		<div class="collapse navbar-collapse" id="navbarSupportedContent">
		<ul class="navbar-nav mr-auto">
		<li class="nav-item active">
			<a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
		</li>
	   <li class="nav-item">
        <a class="nav-link" href="#">About</a>
      </li>
	   <li class="nav-item">
        <a class="nav-link" href="#">Contact Us</a>
	  </li>
	</ul>
	<div>
		<form class="form-inline my-2 my-lg-0">
			<input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search" style="color: blue;">
			<button class="btn btn-outline-primary my-2 my-sm-0" type="submit">Search</button>
		</form>
	</div>
    <div class="btn-group open" id="register">
        <button type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown">
            Register
            <span class="caret"></span>
        </button>
        <ul class="dropdown-menu" role="menu">
            <li>
                <a class="nav-link" href="StudentReg.jsp">As Student</a>
            </li>
            <li>
                <a class="nav-link" href="compReg.html">As Company</a>
            </li>
        </ul> 
    </div>
    </div>
	</nav>
	<div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
		<ol class="carousel-indicators">
			<li data-target="#carouselExampleIndicators" data-slide-to="0" ></li>
			<li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
			<li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
		</ol>
		<div class="carousel-inner">
			<div class="carousel-item active">
				<form class="box" action="loginprocess" method="post">
					<h1>Login</h1>
					<p>${message}</p>
					<input type="text" placeholder="User name" name="userid">
					<input type="password" placeholder="Password" name="passwd">
					<input type="submit" value="Login" name="submit">
				</form>
				<img class="d-block w-100" src="Assets/Careers2.jpg" alt="First slide">
			</div>
			<div class="carousel-item">
				<form class="box1">
					<h1>See recent jobs here.</h1>
					<input type="submit" value="See jobs">
				</form>
				<img class="d-block w-100" src="Assets/findjob.jpg" alt="Second slide">
			</div>
			<div class="carousel-item">
				<form class="box1">
					<h1>See recent candidates here.</h1>
					<input type="submit" value="See candidates">
				</form>
				<img class="d-block w-100" src="Assets/hirecomp.jpg" alt="Third slide">
			</div>
		</div>
		<a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
			<span class="carousel-control-prev-icon" aria-hidden="true"></span>
			<span class="sr-only">Previous</span>
		</a>
		<a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
			<span class="carousel-control-next-icon" aria-hidden="true"></span>
			<span class="sr-only">Next</span>
		</a>
	</div>
	<div>
		<h1 style="text-align: center;">Our top companies</h1>
		<div class="card">
			<img src="Assets/google.jpg" alt="Avatar" style="width:300px;">
			<div class="container">
			  <h4><b>Google</b></h4>
			  <p>See jobs from Google</p>
			</div>
		</div>
	</div>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
	</body>
</html>
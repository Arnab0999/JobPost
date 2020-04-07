<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>
            Employee Register
        </title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
        <link rel="stylesheet" href="styles.css">
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
    <div>
        <form class="form-inline my-2 my-lg-0">
            <input class="btn btn-outline-primary my-2 my-sm-0" type="button" value="Login">
        </form>
    </div>
    </div>
    </nav>
    <div class="carousel">
        <div class="carousel-inner">
			<div class="carousel-item active">
				<form class="sox" method="post" action="loginprocess">
					<h1>Get your dream Jobs!</h1>
					<input type="text" placeholder="UserID" name="userid">
                    <input type="password" placeholder="Password" name="passwd">
                    <input type="text" placeholder="First Name" name="firstname">
                    <input type="text" placeholder="Last Name" name="lastname">
                    <input type="number" placeholder="Age" name="age">
                    <input type="text" placeholder="College" name="college">
                    <input type="text" placeholder="Skill 1" name="interest1">
                    <input type="text" placeholder="Skill 2" name="interest2">
                    <input type="text" placeholder="Skill 3" name="interest3">
                    <input type="submit" value="Register" name="submit">
                </form>
                <img class="d-block w-100" src="Assets/emp.jpeg" alt="First Slide">
            </div>
        </div>
    </div>
    </body>
</html>
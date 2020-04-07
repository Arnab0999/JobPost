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
    <div class="btn-group open" id="profile">
        <button type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown">
           	Welcome ${name} !
            <span class="caret"></span>
        </button>
        <ul class="dropdown-menu" role="menu">
            <li>
                <a class="nav-link" href="empReg.html">As Employee</a>
            </li>
            <li>
                <a class="nav-link" href="compReg.html">As Company</a>
            </li>
        </ul> 
    </div>
    </div>
	</nav>
	<p>Skill: ${interest1}</p>
	</body>
</html>
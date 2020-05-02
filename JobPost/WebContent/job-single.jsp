<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="show.jobs.JobData" %>
<%@ page import="login.post.registartion.Customer" %>
<% 	String CompanyName = request.getParameter("CompanyName");
	String JobTitle = request.getParameter("Post");
	String Location = request.getParameter("Location");
	String Description = request.getParameter("Description");
	String Salary = request.getParameter("Salary");
	String Website = request.getParameter("Website");
%>
<!DOCTYPE html>
<html>
<head>
    <title>Job Single</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="" />
    <meta name="keywords" content="" />
    <meta name="author" content="Free-Template.co" />
    <link rel="shortcut icon" href="ftco-32x32.png">
    
    <link rel="stylesheet" href="css/custom-bs.css">
    <link rel="stylesheet" href="css/jquery.fancybox.min.css">
    <link rel="stylesheet" href="css/bootstrap-select.min.css">
    <link rel="stylesheet" href="fonts/icomoon/style.css">
    <link rel="stylesheet" href="fonts/line-icons/style.css">
    <link rel="stylesheet" href="css/owl.carousel.min.css">
    <link rel="stylesheet" href="css/animate.min.css">

    <!-- MAIN CSS -->
    <link rel="stylesheet" href="css/style.css">    
  </head>
 <body id="top">
 <!-- NAVBAR -->
    <header class="site-navbar mt-3">
      <div class="container-fluid">
        <div class="row align-items-center">
          <div class="site-logo col-6"><a href="StudentHome.jsp">JobPost</a></div>

          <nav class="mx-auto site-navigation">
            <ul class="site-menu js-clone-nav d-none d-xl-block ml-0 pl-0">
              <li><a href="#" class="nav-link active">Home</a></li>
              <li><a href="about.jsp">About</a></li>
              <li class="has-children">
                <a href="job-listings.jsp">Job Listings</a>
                <ul class="dropdown">
                  <li><a href="job-single.jsp">Job Single</a></li>
                  <li><a href="#">Post a Job</a></li>
                </ul>
              </li>
              <li><a href="contact.jsp">Contact</a></li>
              <li class="d-lg-none"><a href="#">Arnab</a></li>
            </ul>
          </nav>
          <% Customer c = new Customer(); %>
          <div class="right-cta-menu text-right d-flex aligin-items-center col-6">
            <div class="ml-auto">
              <a href="StudentDetails.jsp" class="btn btn-outline-white border-width-2 d-none d-lg-inline-block"><span class="mr-2 icon-add"></span>Add details</a>
              <a href="login.jsp" class="btn btn-primary border-width-2 d-none d-lg-inline-block"><span class="mr-2 icon-lock_outline"></span><%=c.getUserid() %></a>
            </div>
            <a href="#" class="site-menu-toggle js-menu-toggle d-inline-block d-xl-none mt-lg-2 ml-3"><span class="icon-menu h3 m-0 p-0 mt-2"></span></a>
          </div>

        </div>
      </div>
    </header>
    <section class="home-section section-hero overlay bg-image" style="background-image: url('images/hero_1.jpg');" id="home-section">
    	
      <div class="container">
        <div class="row align-items-center justify-content-center">
          <div class="col-md-12">
            <div class="mb-5 text-center">
              <h1 class="text-white font-weight-bold"><%=CompanyName %></h1>
              <h2 class="text-black font-weight-bold"><%=JobTitle %></h2>
              <p>Job Description: <%=Description %></p>
              <ul class="keywords list-unstyled m-0 p-0">
                  	<li>Salary: <%=Salary %>LPA</li>
              </ul>
              <h3>Location: <%=Location%></h3>
              <a href="<%=Website %>">Visit Company website.</a>
              <button><a href="studentapply.jsp">Apply</a></button>
            </div>
          </div>
        </div>
      </div>
    </section>
  
    </body>
</html>
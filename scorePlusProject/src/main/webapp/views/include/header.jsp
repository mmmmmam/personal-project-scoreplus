<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
String userId = (String)session.getAttribute("cstId");
%>
<head>
<meta charset="UTF-8">
  <!-- Vendor CSS Files -->
  <link href="/scorePlusProject/static/assets/vendor/animate.css/animate.min.css" rel="stylesheet">
  <link href="/scorePlusProject/static/assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <link href="/scorePlusProject/static/assets/vendor/bootstrap-icons/bootstrap-icons.css" rel="stylesheet">
  <link href="/scorePlusProject/static/assets/vendor/boxicons/css/boxicons.min.css" rel="stylesheet">
  <link href="/scorePlusProject/static/assets/vendor/glightbox/css/glightbox.min.css" rel="stylesheet">
  <link href="/scorePlusProject/static/assets/vendor/swiper/swiper-bundle.min.css" rel="stylesheet">
  <link href="/scorePlusProject/static/css/testList.css" rel="stylesheet">
  <link rel="preconnect" href="https://fonts.googleapis.com">
  <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
  <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR&display=swap" rel="stylesheet">
  
  <!-- Template Main CSS File -->
  <link href="/scorePlusProject/static/css/style.css" rel="stylesheet"> 
<title>SCOREPLUS</title>
</head>
<!-- ======= Header ======= -->
	<header id="header" class="d-flex align-items-center">
	    <div class="container d-flex justify-content-between align-items-center">
	      <div class="logo">
	        <h1><a href="main.jsp">scorePlus</a></h1>
	      </div>
	      <nav id="navbar" class="navbar">
	        <ul>
	          <li><a class="active" href="testList.do">Test Schedule</a></li>
	          <li class="dropdown"><a href="#"><span>My Page</span> <i class="bi bi-chevron-down"></i></a>
	            <ul>
	              <li><a href="rgsList.do">Registration Management</a></li>
	              <li><a href="scoreList.do">Score Report</a></li>
	              <li><a href="myProfile.do">My Profile</a></li>
	            </ul>
	          </li>
			  <li><a href="logout.do">Logout</a></li>
	        </ul>
	        <i class="bi bi-list mobile-nav-toggle"></i>
	      </nav><!-- .navbar -->
	    </div>
	</header><!-- End Header -->
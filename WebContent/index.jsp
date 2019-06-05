<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!-- <body>


<a href="admin/login"><button>Admin Login</button></a>

<a href="user/login"><button>Login User</button></a>

<a href="guest/sellHouse"><button>Sell House</button></a>

<a href="guest/rentHouse"><button>Rent House</button></a>
</body>
 -->
 <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Housing Network</title>

<meta name="viewport"
	content="width=device-width, initial-scale=1, user-scalable=no" />
<link rel = "stylesheet" href="<c:url value= "/resource/assets/css/main.css"/>">
</head>
<body>

	<!-- Header -->
	<header id="header">
	<div class="inner">
		<a href="index.jsp" class="logo">E-Society</a>

		<nav id="nav"> <a href="admin/login">Admin Login</a> </nav>

		<nav id="nav"> <a href="user/login">Member Login</a> </nav>

		<nav id="nav"> <a href="guest/sellHouse">Sell</a> </nav>

		<nav id="nav"> <a href="guest/rentHouse">Rent</a> </nav>
	</div>
	</header>
	<a href="#menu" class="navPanelToggle"><span class="fa fa-bars"></span></a>

	<!-- Main -->
	<section id="main">
	<div class="inner">
		<header class="major special">
		<h1>Home</h1>


		</header>
		<a href="#" class="image fit"><img src="${pageContext.request.contextPath}/resource/images/IMG01.jpg" alt="" /></a>
 <!-- To display  -->
		<h4>About Us</h4>
		<p>Student housing network is designed and proposed with the goal
			of making the complex task of orchestration of the workflow
			associated with student housing property look up and booking easier.
			Users can search and post property units for rent, summer sublets and
			off campus housing rentals, while also providing the property owners
			with a comprehensive solution for managing leased, owned and
			sub-leased properties. This module makes off campus housing and
			property look up hassle free with numerous property listings for rent
			and sublets enabling users to effectively manage property search and
			renting online. Users can leverage and benefit mutually from a wide
			network of people looking to rent and rent out property on the same
			platform. An email service is invoked by the server for the provision
			of furnishing contact details including Owner email, contact and
			office location to the registered email of the prospective tenants.</p>

	</div>
	</section>



	<!-- Footer -->
	<section id="footer">
	<div class="inner">
		<header>
		<h2>Get in Touch</h2>
		</header>
		<div class="field half first">
			<label for="name">Write Us To: housingforummail@gmail.com</label>

		</div>

		<div class="field half first">
			<label for="name">Call Us With: +1(980)-765 8896</label>

		</div>

	</div>
	</section>

	<!-- Scripts -->
	<script src="assets/js/jquery.min.js"></script>
	<script src="assets/js/skel.min.js"></script>
	<script src="assets/js/util.js"></script>
	<script src="assets/js/main.js"></script>
</body>
</html>
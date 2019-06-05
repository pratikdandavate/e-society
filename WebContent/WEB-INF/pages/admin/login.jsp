<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel = "stylesheet" href="<c:url value= "/resource/assets/css/main.css"/>">
</head>
<body>


<!-- Header -->
	<header id="header">
	<div class="inner">
		<a href="<c:url value= "/index.jsp"/>" class="logo">E-Society</a>
		<nav id="nav"> <a href="<c:url value= "/index.jsp"/>">Home</a> </nav>
	</div>
	</header>
	<a href="#menu" class="navPanelToggle"><span class="fa fa-bars"></span></a>

	<!-- Main -->
	<section id="main">
	<div class="inner">
		<header class="major special">
		<h1>Login</h1>
		<p>Login to view profile and rental listings.</p>
		<h3>${requestScope.error}</h3>
		</header>
		<!-- To display Login Window -->
		<h4>Please Enter Login Details</h4>
		<p>To continue with the website please enter your username and
			password.</p>
		<form method='post'>
			Username: <input type='text' name='userName' /><br> Password: <input
				type='password' name='password' /><br> 
				<input type='reset'
				value='clear'></input> 
				<a class='btn' href='submit'> 
				<input
				class='btn' type='submit' value='submit'></a><br> 
				</form>
	</div>
	</section>
<%-- <a href="#" class="image fit"><img src="${pageContext.request.contextPath}/resource/images/IMG01.jpg" alt="" /></a>
		
 --%>

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
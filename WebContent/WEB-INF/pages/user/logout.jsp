<%-- <%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h4>Hello , ${requestScope.user_dtls.name}</h4>
	<h4>You have logged out successfully</h4>
	<h4>Will be automatically taken to index page shortly....</h4>
</body>
</html> --%>
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
		
	<h1>Hello , ${requestScope.user_dtls.name}</h1>
	<h4>You have logged out successfully</h4>
	<h4>Will be automatically taken to index page shortly....</h4>
		</header>
		<!-- To display Login Window -->
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
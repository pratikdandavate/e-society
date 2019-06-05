<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html> 
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
${views}
</body>
</html> --%>

<%-- <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html> 
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<table style="background-color: cyan; margin: auto;" border="1">
		
				<tr><th>Rent ID</th>
				<th>House ID</th>
				<th>Society Name</th>
				<th>Rent Price</th>
				<th>Entry Date</th>
				<th>View</th></tr>
				
				<c:forEach var="vend" items="${requestScope.rentHouse}">
				<tr>	
				<td>${vend.rentId}</td>		
			    <td>${vend.houseId}</td>		
				<td>${vend.societyName}</td>		
				<td>${vend.rentPrice}</td>
				<td>${vend.entryDate}</td>	
				<td><a href="view?id=${vend.houseId}">View</a></td>		
				</tr> 		
				</c:forEach>
				

</table> 

</body>
</html> --%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Housing Network</title>

<meta name="viewport"
	content="width=device-width, initial-scale=1, user-scalable=no" />
<link rel="stylesheet" href="assets/css/main.css" />
<!-- <title>ManagerHome</title> -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset="UTF-8">
<title>Guest</title>
<link rel = "stylesheet" href="<c:url value= "/resource/assets/css/main.css"/>">
</head>



<body>
	<!-- Header -->
	<header id="header">
	<div class="inner">
		<a href="<c:url value= "/index.jsp"/>" class="logo">E-Society</a>

		<nav id="nav"> <a href="sellHouse">Back</a> 
		<!-- <a
			href="Logout.jsp">Logout</a>  -->
			</nav>
	</div>
	</header>
	<a href="#menu" class="navPanelToggle"><span class="fa fa-bars"></span></a>

	<!-- Main -->
	<section id="main">
	
	<div class="inner">
		<header class="major special">
		<h1>Owner Details</h1>
		<%-- <h3>${requestScope.error}</h3> --%> </header>
		<!-- To display  Window -->
		<h4>${requestScope.houseList}</h4>
		<h4>${requestScope.mandatory}</h4>


<table style="margin: auto;" border="1">
		
				<tr><th>Owner Name</th>
				<td>${views.firstName} ${views.lastName}</td>
				</tr>
				<tr><th>Flat No</th>
				<td>${views.userId}</td>
				</tr>
				<tr><th>Society Name</th>
				<td>${views.societyName}</td>
				</tr>
				<tr><th>Mobile No</th>
				<td>${views.mobileNo}</td>
				</tr>
				<tr><th>Email</th>
				<td>${views.email}</td>
				</tr>

</table> 


	</div>
	
	</section>



	<!-- To display Contact details -->
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
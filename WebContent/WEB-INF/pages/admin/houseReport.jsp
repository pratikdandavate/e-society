<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html> 
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form method="post">
<table style="background-color: cyan; margin: auto;" border="1">
<tr>
				<td>Select society :</td>
				<td><select item="soc" name = "societyName">
				<c:forEach var="vend" items="${requestScope.society_details}">
				<option value="${vend.societyName}">${vend.societyName}</option>		
				</c:forEach></select>
				</td>
				</tr>
				<tr>
				<td><input type="submit" value="Search" /></td>
			</tr>

</table>

</form>

<table style="background-color: cyan; margin: auto;" border="1">
		
				<c:forEach var="vend" items="${requestScope.houseList}">
				<tr><td>${vend.blockNo}</td>
				<td>${vend.type}</td>		
				<td>${vend.societyName}</td>		
				<td>${vend.detail}</td></tr>		
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
<title>Admin Dashboard</title>
<link rel = "stylesheet" href="<c:url value= "/resource/assets/css/main.css"/>">
</head>



<body>
	<!-- Header -->
	<header id="header">
	<div class="inner">
		<a href="home" class="logo">E-Society</a>

		<nav id="nav"> <a href="home">Home</a> 
		<!-- <a
			href="Logout.jsp">Logout</a>  -->
			<a href='logout'>Logout</a>
			</nav>
	</div>
	</header>
	<a href="#menu" class="navPanelToggle"><span class="fa fa-bars"></span></a>

	<!-- Main -->
	<section id="main">
	
	<div class="inner">
		<header class="major special">
		<h1>Admin Home</h1>
		<p>Welcome ${sessionScope.myadmin.userName}</p>
		<%-- <h3>${requestScope.error}</h3> --%> </header>
		<!-- To display  Window -->
				<h4>Please make a selection</h4>
		<a href="addSociety"><button>Add Society</button></a>
<a href="addHouse"><button>Add House</button></a>
<a href="addUser1"><button>Allocate House</button></a>
<a href="houseReport"><button>House Report</button></a>
<a href="newComplain"><button>Complain</button></a><br><br>

<form method="post">
<table style="margin: auto;" border="1">
<tr>
				<td>Select society :</td>
				<td><select item="soc" name = "societyName">
				<c:forEach var="vend" items="${requestScope.society_details}">
				<option value="${vend.societyName}">${vend.societyName}</option>		
				</c:forEach></select>
				</td>
				</tr>
				<tr>
				<td><input type="submit" value="Search" /></td>
			</tr>

</table>

</form>

<table style="margin: auto;" border="1">
				<tr>
				<td>Block No</td>
				<td>Type</td>
				<td>Society Name</td>
				<td>Entry Date</td>
				</tr> 
				<c:forEach var="vend" items="${requestScope.houseList}">
				<tr><td>${vend.blockNo}</td>
				<td>${vend.type}</td>		
				<td>${vend.societyName}</td>		
				<td>${vend.entryDate}</td></tr>		
				</c:forEach> 
				
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
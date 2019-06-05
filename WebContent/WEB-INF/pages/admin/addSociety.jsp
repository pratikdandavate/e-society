<%-- <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html> 
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body> --%>
<!-- <form method="post">
		<table style="background-color: cyan; margin: auto;" border="1">
			
			<tr>
				<td> Society Name</td>
				<td><input type="text" name="societyName"/></td>
			</tr>
			<tr>
				<td> Address</td>
				<td><textarea name="address"></textarea></td>
			</tr>
			<tr>
				<td>  City</td>
				<td><input type="text" name="city" /></td>
			</tr>
			<tr>
				<td>Pincode</td>
				<td><input type="text" name="pinCode" /></td>
			</tr>
			<tr>
				<td> No of house</td>
				<td><input type="text" name="noOfHouse" /></td>
			</tr>
			<tr>
				<td>Reg Date</td>
				<td><input type="date" name="entryDate" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="Register Society" /></td>
			</tr>
		</table>
	</form>
 -->
 
<%--  
	<form:form method="post" modelAttribute="societyList">
		<table style="background-color: cyan; margin: auto;" border="1">
			
			<tr>
				<td> Society Name</td>
				<td><form:input type="text" path="societyName"/></td>
			</tr>
			<tr>
				<td> Address</td>
				<td><form:input type="text" path="address" /></td>
			</tr>
			<tr>
				<td>  City</td>
				<td><form:input type="text" path="city" /></td>
			</tr>
			<tr>
				<td>pincode</td>
				<td><form:input type="text" path="pinCode" /></td>
			</tr>
			 <tr>
				<td> no of house</td>
				<td><form:input type="number" path="noOfHouse" /></td>
			</tr> 
			<tr>
				<td>Reg Date</td>
				<td><form:input type="text" path="entryDate" /></td>
			</tr> 
	    	<tr>
				<td><input type="submit" value="Register Society" /></td>
			</tr>
		</table>
	</form:form>
 
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
		<h4>${requestScope.error}</h4>
		<h4>${requestScope.mandatory}</h4>
				<h4>Please make a selection</h4>
		<a href="addSociety"><button>Add Society</button></a>
<a href="addHouse"><button>Add House</button></a>
<a href="addUser1"><button>Allocate House</button></a>
<a href="houseReport"><button>House Report</button></a>
<a href="newComplain"><button>Complain</button></a><br><br>

<form method='post' <%-- onsubmit='return validate();' --%>>
					<table style='width: 100%'>
						<tr>
							<td>Society Name <span id="res">*</span></td>
							<td><input type="text" rows='4' columns='2' name='societyName' id='societyName' required></input></td>
							
						</tr>
						
						<tr>
							<td>Address</td>
							<td><textarea rows='4' columns='2' name='address' id='address'></textarea></td>
						</tr>
						<!-- To capture user contact details -->
						<tr>
							<td>City  <span id="res">*</span></td>
							<td><input type="text" rows='4' columns='2' name='city' id='city' required></input></td>
						</tr>
						
						<!-- To capture user contact details -->
						<tr>
							<td>pincode  <span id="res">*</span></td>
							<td><input type="text" rows='4' columns='2' name='pinCode' id='pincode' required></input></td>
							<td><span id="res">${requestScope.pinerror}</span></td>
						</tr>
						
						<!-- To capture user contact details -->
						<tr>
							<td>no of House  <span id="res">*</span></td>
							<td><input type="text" rows='4' columns='2' name='noOfhouse' id='noOfhouse' required></input></td>
						</tr>
						
						<!-- To capture user contact details -->
						<tr>
							<td>Reg Date  <span id="res">*</span></td>
							<td><input type="text" rows='4' columns='2' name='entryDate' id='entryDate' required></input></td>
						</tr>


						</table>
					<input type='reset' value='clear' /> <a class='btn'></a> 
					<input type='submit' name='logout' value='submit'></input>
				</form>

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
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
<!-- <form method="get" action="home">
Society Name: <input type="text" name="sname"><br>
Society Address: <input type="text" name="saddr"><br>
Society Pin: <input type="text" name="spin"><br>
Society noOfHouses: <input type="text" name="shouses"><br>
Society date: <input type="text" name="sdate"><br>
Society city: <input type="text" name="scity"><br>

<input type="submit" value="Submit">

</form> -->



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
				<td><form:input  type="text" path="noOfHouse" /></td>
			</tr> 
			<%--  <tr>
				<td>Reg Date</td>
				<td><form:input type="date" path="entryDate" /></td>
			</tr>
			<tr>  --%>
				<td><input type="submit" value="Register Society"  /></td>
			</tr>
		</table>
	</form:form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html> 
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form method="get" action="abc">
<table style="background-color: cyan; margin: auto;" border="1">
			
			<tr>
				<td>First Name :</td>
				<td><input type="text" name="firstName"></td>
			</tr>
			
			<tr>
				<td>Last Name :</td>
				<td><input type="text" name="lastName"></td>
			</tr>
			
			<tr>
				<td>Email:</td>
				<td><input type="email" name="email"></td>
			</tr>
			
			<tr>
				<td>Mobile :</td>
				<td><input type="text" name="mobileNo"></td>
			</tr>
			
			<tr>
				<td>Birth Date :</td>
				<td><input type="Date" name="birthDate"></td>
			</tr>
			
			<tr>
				<td>Total Member :</td>
				<td><input type="number" name="totalMember"></td>
			</tr>
			
			<tr>
				<td>Select society :</td>
				<td><select item="soc" name = "societyName">
				<c:forEach var="vend" items="${requestScope.society_details}">
				<option value="${vend.societyName}">${vend.societyName}</option>		
				</c:forEach></select>
				</td>
			</tr>
			<tr>
				<td>House no :</td>
				<td><select item="bhk" name = "house">
				<option value="1">1</option>
				<option value="2">2</option>
				<option value="3">3</option>				
				</td>
			</tr>
			<tr>
				<td>UserName </td>
				<td><input type="text" name="userName"></td>
			</tr>
			
			<tr>
				<td>Password </td>
				<td><input type="text" name="password"></td>
			</tr>
			<tr>
				<td><input type="submit" value="Add House" /></td>
			</tr>
		</table>
</form>	
</body>
</html>
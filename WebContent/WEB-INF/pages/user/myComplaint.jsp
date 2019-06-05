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

<table style="background-color: cyan; margin: auto;" border="1">
		
				<c:forEach var="vend" items="${requestScope.complaint}">
				<tr><td>${vend.subject}</td>
				<td>${vend.status}</td>		
				</c:forEach>
				

</table>
</body>
</html>
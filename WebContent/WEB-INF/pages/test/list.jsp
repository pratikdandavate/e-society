<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@page import="java.sql.*" %>
<!DOCTYPE html> 
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<%! String driverName = "com.mysql.jdbc.Driver";%>
<%!String url = "jdbc:mysql://localhost:3306/society";%>
<%!String user = "root";%>
<%!String psw = "root";%>
<form action="abc.jsp" methos="post">
<%
Connection con = null;
PreparedStatement ps = null;
try
{
Class.forName(driverName);
con = DriverManager.getConnection(url,user,psw);
String sql = "SELECT * FROM societylist";
ps = con.prepareStatement(sql);
ResultSet rs = ps.executeQuery(); 
%>

<p>Select Society :
<select name="item">
<%
while(rs.next())
{
String sname = rs.getString("societyName"); 
%>
<option value="<%=sname %>"><%=sname %></option>
<%
}
%>
</select>
<input type="submit" value="Submit">
</p>

<%
}
catch(SQLException sqe)
{ 
out.println(sqe);
}
%>
</form>



</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html> 
<html>
<head>
<title>Jsp Frameset</title>
</head>
<frameset rows="10%,*">
<frame src="frame1.jsp" name="frame1"scrolling="no">
<frameset cols="20%,*">
<frame src="frame2.jsp" name="frame2">
<frame src="frame3.jsp" name="frame3">
</frameset>
</frameset>
</html>
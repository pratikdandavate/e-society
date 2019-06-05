<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html> 
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>select your model</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script>
       $(document).ready(function(){
    	   $('#typeid').on('change', function(){
    		  var tid= $('#typeid option:selected').val();
    		 // alert(tid);
    		   var url ="selectmenu?name="+tid;
    		  console.log("control is here");
    		  $.ajax({
    		      type:'GET',
    			  url:url,
    			  success:function(result){
    				  console.log("result");
    				  //console.log(result);
    				  var s='';
      					 s+='<option value="-1">Select House</option>';
      				   for(var i=0; i<result.length;i++){
      					 s+='<option value='+result[i]+'>'+result[i]+'</option>'; 
      				 }  
      			     <c:forEach var="type" items="${requestScope.house_list}">
						s+='<option value='result[i]'+'>'+${type.houseId}</option>'
					</c:forEach>  
      				 $('#manufactureid').html(s);
     			  }
    		 
    		  });
     });
       });
    </script>

</head>
<body>
	<form method="get" action="dropdown">
		<table style="margin: auto;">
			<tr>
				<td>Select Society :</td>
				<td><select id="typeid" name="societyName" >
				<option value="-1">Select Type</option>
						<c:forEach var="type" items="${requestScope.society_details}">
							<option value="${type.societyName}">${type.societyName}</option>
						</c:forEach>
				</select></td>
			</tr>
			<tr>
				<td>Select House</td>
				<td><select id="manufactureid" name="houseId">
						<option value="-1">Select house</option>
						
				</select></td>
			</tr>
		</table>

		<input type="submit" /> 
	</form>

</body>
</html>
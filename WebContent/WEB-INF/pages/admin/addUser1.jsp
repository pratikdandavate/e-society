<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Housing Network</title>
<meta name="viewport"
	content="width=device-width, initial-scale=1, user-scalable=no" />
<link rel = "stylesheet" href='<c:url value= "/resource/assets/css/main.css"/>'>
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
		<h4>${mandatory}</h4>
				<h4>Please make a selection</h4>
		<a href="addSociety"><button>Add Society</button></a>
<a href="addHouse"><button>Add House</button></a>
<a href="addUser1"><button>Allocate House</button></a>
<a href="houseReport"><button>House Report</button></a>
<a href="newComplain"><button>Complain</button></a></a><br><br>

	<!-- <h1>Housing Network</h1> -->


			<c:choose>
			<c:when test="${pageContext.session['new']}">
				<c:redirect url="Login" />
			</c:when>
			<c:when test="${!pageContext.session['new']}">

				<h1>Sign Up</h1>
				<form method='POST' enctype="multipart/form-data">
					<table style='width: 100%'>
						<tr>
							<td>First Name</td>
							<td><input type="text" rows='4' columns='2' name='firstName' required></input></td>
						</tr>
						
						<tr>
							<td>Last Name</td>
							<td><input type="text" rows='4' columns='2' name='lastName' required></input></td>
						</tr>
						<!-- To capture user contact details -->
						<tr>
							<td>Email ID</td>
							<td><input type="email" rows='4' columns='2' name='email' required></input></td>
						</tr>
						
						<!-- To capture user contact details -->
						<tr>
							<td>Mobile Number</td>
							<td><input type="text" rows='4' columns='2' name='mobileNo' required></input></td>
						</tr>
						
						<!-- To capture user contact details -->
						<tr>
							<td>Birth Date</td>
							<td><input type="text" rows='4' columns='2' name='birthDate' placeholder="dd-MM-yyyy" required></input></td>
						</tr>
						
						<!-- To capture user contact details -->
						<tr>
							<td>Total Member</td>
							<td><input type="number" rows='4' columns='2' name='totalMember' required></input></td>
						</tr> 


						<!-- To capture user contact details -->
						<tr>
				<td>Select Society :</td>
				<td><select id="typeid" name="societyName" required>
				<option value="-1">Select Type</option>
						<c:forEach var="type" items="${requestScope.society_details}">
							<option value="${type.societyName}">${type.societyName}</option>
						</c:forEach>
				</select></td>
			</tr>
			<tr>
				<td>Select House</td>
				<td><select id="manufactureid" name="houseId" required>
						<option value="-1">Select house</option>
						
				</select></td>
			</tr>
						<tr>
							<td>Upload Image</td>
							<td><input type="file" rows='4' columns='2' class="form-control-file" name='uploadImage' required></input></td>
						</tr>
						
						<tr>
							<td>Username</td>
							<td><input type="text" rows='4' columns='2' name='userName' required></input></td>
						</tr>
						
						<!-- To capture user password  -->
						<tr>
							<td>Password</td>
							<td><input type="password" rows='4' columns='2' name='password' required></input></td>
						</tr>
						
						
						</table>
					<input type='reset' value='clear' /> <a class='btn'></a> <input
						type='submit' name='logout' value='submit'></input>
				</form>

			</c:when>
		</c:choose>
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
</html> --%>
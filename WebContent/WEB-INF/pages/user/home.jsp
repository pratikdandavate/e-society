<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html> 
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<script type="text/javascript">
 
$(document).ready(function(){
 
    var counter = 2;
 
    $("#addButton").click(function () {
 
	if(counter>2){
            alert("Only 10 textboxes allow");
            return false;
	}   
 
	var newTextBoxDiv = $(document.createElement('div'))
	     .attr("id", 'TextBoxDiv' + counter);
 
	newTextBoxDiv.after('<label>Rent Price : </label>' + '<input type="text" name="textbox" id="textbox" value="" />').html('<form method="post" action="rentHouse"><label>Rent Price : </label>' + '<input type="text" name="rentPrice" id="rentPrice" value="" /><input type="hidden" name="rentId" value="${sessionScope.user.userId}"><input type="submit" value="Submit"></form>');
 
	newTextBoxDiv.appendTo("#TextBoxesGroup");
 
 
	counter++;
     });
	
    $("#sellButton").click(function () {
    	 
    	if(counter>2){
                alert("Only 10 textboxes allow");
                return false;
    	}   
     
    	var newTextBoxDiv = $(document.createElement('div'))
    	     .attr("id", 'TextBoxDiv' + counter);
     
    	newTextBoxDiv.after('<label>Rent Price : </label>' + '<input type="text" name="textbox" id="textbox" value="" />').html('<form method="post" action="sellHouse"><label>Rent Price : </label>' + '<input type="text" name="rentPrice" id="rentPrice" value="" /><input type="hidden" name="rentId" value="${sessionScope.user.userId}"><input type="submit" value="Submit"></form>');
    	     
    	newTextBoxDiv.appendTo("#TextBoxesGroup");
     
     
    	counter++;
         });

     
  });
</script>

</head>
<body>
${sessionScope.user.userId} 
${requestScope.complaint}
<div id='TextBoxesGroup'>
	<div id="TextBoxDiv1">
		
	</div>
</div>

<input type="hidden" name="rentId" value='${sessionScope.user.userId}'> 
<div id='TextBoxesGroup'>
	<div id="TextBoxDiv1">
		
	</div>
</div>
<input type='button' value='Rent House' id='addButton'>
<input type='button' value='Sell House' id='sellButton'>
<a href="makeComplaint"><button>Make Complaint</button></a>
<a href="myComplaint?id=${sessionScope.user.userId}"><button>My Complaint</button></a>

</body>
</html> --%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<script type="text/javascript">
 
$(document).ready(function(){
 
    var counter = 2;
 
    $("#addButton").click(function () {
 
	if(counter>2){
           // alert("Only 10 textboxes allow");
            return false;
	}   
 
	var newTextBoxDiv = $(document.createElement('div'))
	     .attr("id", 'TextBoxDiv' + counter);
 
	newTextBoxDiv.after('<label>Rent Price : </label>' + '<input type="text" name="textbox" id="textbox" value="" />').html('<form method="post" action="rentHouse"><label>Rent Price : </label>' + '<input type="text" name="rentPrice" id="rentPrice" value="" /><input type="hidden" name="rentId" value="${sessionScope.user.userId}"><input type="submit" value="Submit"></form>');
 
	newTextBoxDiv.appendTo("#TextBoxesGroup");
 
 
	counter++;
     });
	
    $("#sellButton").click(function () {
    	 
    	if(counter>2){
               // alert("Only 10 textboxes allow");
                return false;
    	}   
     
    	var newTextBoxDiv = $(document.createElement('div'))
    	     .attr("id", 'TextBoxDiv' + counter);
     
    	newTextBoxDiv.after('<label>Sell Price : </label>' + '<input type="text" name="textbox" id="textbox" value="" />').html('<form method="post" action="sellHouse"><label>Sell Price : </label>' + '<input type="text" name="rentPrice" id="rentPrice" value="" /><input type="hidden" name="rentId" value="${sessionScope.user.userId}"><input type="submit" value="Submit"></form>');
    	     
    	newTextBoxDiv.appendTo("#TextBoxesGroup");
     
     
    	counter++;
         });

     
  });
</script>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Housing Network</title>

<meta name="viewport"
	content="width=device-width, initial-scale=1, user-scalable=no" />
<link rel="stylesheet" href="assets/css/main.css" />
<!-- <title>ManagerHome</title> -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset="UTF-8">
<title>Member Dashboard</title>
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
	<img src="<c:url value="/resource/img/${sessionScope.user.image}" />" class="img-circle img-responsive" width="150" height="150" align="right"/>
	<!-- Main -->
	<section id="main">
	
	<div class="inner">
		<header class="major special">
		<h1>${sessionScope.user.userName} Home</h1>
		<p>Welcome ${sessionScope.user.userName}</p>
		
	
		<%-- <h3>${requestScope.error}</h3> --%> </header>
		<!-- To display  Window -->
			<h4>${requestScope.success}</h4>
				<h4>Please make a selection</h4>

			<div id='TextBoxesGroup'>
	<div id="TextBoxDiv1">
		
	</div>
</div>

<input type="hidden" name="rentId" value='${sessionScope.user.userId}'> 
<div id='TextBoxesGroup'>
	<div id="TextBoxDiv1">
		
	</div>
</div>
<input type='button' value='Rent House' id='addButton'>
<input type='button' value='Sell House' id='sellButton'>
<a href="makeComplaint"><button>Make Complaint</button></a>
				
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
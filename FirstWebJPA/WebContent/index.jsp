<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<title>Insert title here</title>
</head>
<body>
<%  
if(session.getAttribute("username") == null){%>  <!-- If there is now user then the login button will show -->
<div class="container">
	<div class="dropdown">
		<button class="btn pull-left btn-info dropdown-toggle" type="button"
			data-toggle="dropdown">
			Login<span class="caret"></span>
		</button>
		<ul class="dropdown-menu">
			<li><a href="#"></a>
				<div class="container">
					<form action="LoginServlet" method="post"> <!-- The input for email and password goes to the LoginServlet -->
						<div class="form-group">
							<label class="control-label col-sm-5">User Name: </label>
							<div class="col-sm-5">
								<input type="text" class="form-control" id="username" name="username" placeholder="User Name">
							</div>
						</div>
						<div class="form-group">
							<div class="col-sm-offset-2 col-sm-5">
								<center>
									<button type="submit"
										class="btn btn-primary btn-lg btn-block" value="addstudent">Login</button>
								</center>
							</div>
						</div>				
					</form>			
				</div></li>
		</ul>
	</div>
</div>	

<!-- Else, the username is displayed and there is an option of viewing your profile and logging out -->
<% }else{ %>
	
	<div>Welcome <%= session.getAttribute("username") %><a href = "LogoutServlet"><button>Logout</button></a><a href = "MessageServlet"><button>Messages</button></a></div><br><br>
	
	<form name = "myForm" class="form-horizontal" method="post" action="testJPA" onsubmit="return validateForm()">
	    <div class="form-group">
	        <label for="Assignment" class="col-sm-2 control-label">User Name</label>
	        <div class="col-sm-4">
	            <input type="text" class="form-control" id="username" name="username" value="<%= session.getAttribute("username") %>">
	        </div>
	    </div>
	    <div class="form-group">
	        <label for="Assignment" class="col-sm-2 control-label">Post</label>
	        <div class="col-sm-4">
	            <input type="text" class="form-control" id="post" name="post" value="">
	        </div>
	    </div>
	    <div class="form-group">
	        <label for="Grades" class="col-sm-2 control-label">Date</label>
	        <div class="col-sm-4">
	            <input class="form-control" id="postDate" name="postDate" value="">
	        </div>
	    </div> 
	    <div class="form-group">
	        <div class="col-sm-4 col-sm-offset-2">
	            <input id="submit" name="submit" type="submit" value="Submit" class="btn btn-primary">
	    	</div>
	    </div>
	</form>
<%}%>

<div class="container">
	<div class="jumbotron other-color">
		<center>
			 <h1>Welcome to Twitter!!</h1>
      			<p>Find hot posts in US</p>
      			<p><a href="testJPA" class="btn btn-success btn-lg">Find all posts now!!!!</a></p>
		</center>
	</div>
</div>
<img src="images/1.jpg" alt="Mountain View">
<img src="images/1.jpg" alt="Mountain View" style="width:24px; height:24px;">
</body>
</html>
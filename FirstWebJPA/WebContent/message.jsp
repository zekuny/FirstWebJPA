<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Profile</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<style>
.other-color {
	background: lightskyblue
} 

.jumbotron h1 {
	color: slategray
}
</style>

<script type="text/javascript">
function showData(value){ 
$.ajax({
    url : "ur_servlet?name=" + value,
    type : "POST",
    async : false,
    success : function(data) {
//Do something with the data here
    }
});
}
</script>

<title>Your messages!</title>
</head>
<body>
<h2>The messages you received</h2>
<table class="table table-striped">${table}</table>
<%-- ${tableEdit} --%>
<br><br>
<h2>The messages you sent</h2>
<table class="table table-striped">${table2}</table>
<br>
<form name = "myForm" class="form-horizontal" method="post" action="SendMessageServlet" onsubmit="return validateForm()">
	<h2>Send a message now!</h2>
    <div class="form-group">
        <label for="Assignment" class="col-sm-2 control-label">Send to: </label>
        <div class="col-sm-4">
            <input type="text" class="form-control" id="receiver" name="receiver" onkeyup="showData(this.value);" value="">
        </div>
    </div>
    <div class="form-group">
        <label for="Assignment" class="col-sm-2 control-label">Message</label>
        <div class="col-sm-4">
            <input type="text" class="form-control" id="message" name="message" value="">
        </div>
    </div>
    <div class="form-group">
        <div class="col-sm-4 col-sm-offset-2">
            <input id="submit" name="submit" type="submit" value="Send" class="btn btn-primary">
    	</div>
    </div>
</form>
<br>
<a href = "index.jsp"><button type="button" class="btn btn-info btn-lg">Return</button></a>
</body>	
	
		
		
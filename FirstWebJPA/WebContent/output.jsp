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
<h1>All new BMW 7Li</h1>
${table}
<br>
<br>

<form name = "myForm" class="form-horizontal" method="post" action="testJPA" onsubmit="return validateForm()">
    <div class="form-group">
        <label for="Assignment" class="col-sm-2 control-label">Search by keyword</label>
        <div class="col-sm-4">
            <input type="text" class="form-control" id="keyword" name="keyword" value="">
        </div>
    </div>

    <div class="form-group">
        <div class="col-sm-4 col-sm-offset-2">
            <input id="submit" name="submit" type="submit" value="Search" class="btn btn-primary">
    	</div>
    </div>
</form>

<a href = "index.jsp"><h1>Return</h1></a>
</body>
</html>
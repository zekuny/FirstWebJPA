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
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script src="//code.jquery.com/ui/1.10.4/jquery-ui.js"></script>	

<style>
.other-color {
	background: lightskyblue
} 

.jumbotron h1 {
	color: slategray
}

.ui-autocomplete {
  position: absolute;
  top: 100%;
  left: 0;
  z-index: 1000;
  float: left;
  display: none;
  min-width: 160px;
  _width: 160px;
  padding: 4px 0;
  margin: 2px 0 0 0;
  list-style: none;
  background-color: #ffffff;
  border-color: #ccc;
  border-color: rgba(0, 0, 0, 0.2);
  border-style: solid;
  border-width: 1px;
  -webkit-border-radius: 5px;
  -moz-border-radius: 5px;
  border-radius: 5px;
  -webkit-box-shadow: 0 5px 10px rgba(0, 0, 0, 0.2);
  -moz-box-shadow: 0 5px 10px rgba(0, 0, 0, 0.2);
  box-shadow: 0 5px 10px rgba(0, 0, 0, 0.2);
  -webkit-background-clip: padding-box;
  -moz-background-clip: padding;
  background-clip: padding-box;
  *border-right-width: 2px;
  *border-bottom-width: 2px;

  .ui-menu-item > a.ui-corner-all {
    display: block;
    padding: 3px 15px;
    clear: both;
    font-weight: normal;
    line-height: 18px;
    color: #555555;
    white-space: nowrap;

    &.ui-state-hover, &.ui-state-active {
      color: #ffffff;
      text-decoration: none;
      background-color: #0088cc;
      border-radius: 0px;
      -webkit-border-radius: 0px;
      -moz-border-radius: 0px;
      background-image: none;
    }
  }
}
</style>

<script type="text/javascript">
$(document).ready(function() {
    $(function() {
            $("#receiver").autocomplete({     
            source : function(request, response) {
            $.ajax({
                    url : "ur_servlet",
                    type : "GET",
                    data : {
                            term : request.term
                    },
                    dataType : "json",
                    success : function(data) {
                            response(data);
                    }
            });
    }
});
});
});
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
			<div class="search-container">
   				<div class=".ui-autocomplete">
            	<input type="text" class="form-control" id="receiver" name="receiver" class="search" />
   				</div>
			</div>
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
	
		
		
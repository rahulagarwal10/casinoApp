<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Roulette Login</title>
<link rel="stylesheet" type="text/css" href="/css/style.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script>
            function myclick(){
            	var a=document.getElementById("click");
            	a.play();
            }
            
            </script>

</head>
<body style="background-color: black">

	<audio id="click"> <source src="/sounds/click.mp3"
		type="audio/mpeg"> Your browser does not support the audio
	element. </audio>

	<div style="margin-left: 10%; margin-right: 10%">
		<div class=back>
			<div class=head>Roulette Game</div>
			<form style="margin-top: 40px;" action="/currentPlayer/"
				method="POST">
				<div class="form-group">
					<div>
						<label class="lbl" for="usr"> Enter your Unique Key: </label>
					</div>
					<div>
						<input type="text" class="form-control" id="usr" name="id">
					</div>
					<br>
					<c:if test="${fn:length(error) gt 0}">
						<p
							style="color: white; font-style: italic; margin-left: 200px; font-size: 15px;">
							<i class="fa fa-exclamation-triangle">${error}</i>
						</p>
						<div>${logerror}</div>
					</c:if>
					<c:if test="${fn:length(logerror) gt 0}">
						<p
							style="color: white; font-style: italic; margin-left: 200px; font-size: 15px;">
							<i class="fa fa-exclamation-triangle">${logerror}</i>
						</p>
					</c:if>

				</div>
				<button class="btn1 post" type="submit" onmouseover="myclick()">Start
					Play</button>
			</form>

		</div>

	</div>

</body>
</html>
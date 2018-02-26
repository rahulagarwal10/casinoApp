<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome To Roulette Game</title>
<link rel="stylesheet" type="text/css" href="/css/style1.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">



<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="/js/script.js"></script>


</head>
<body style="background-image: url('/images/back.png')">

<input type="hidden" id="modelAttr" name="modelAttr" value="${cbalance}"/>
	<audio id="music"> <source src="/sounds/RouletteWheel.mp3"
		type="audio/mpeg"> Your browser does not support the audio
	element. </audio>
	<audio id="click"> <source src="/sounds/click.mp3"
		type="audio/mpeg"> Your browser does not support the audio
	element. </audio>
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header" id="header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close"></button>
					<h4 class="modal-title" id="myModalLabel">Modal title</h4>
				</div>
				<div class="modal-body" id="modal-body">...</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal"
						id="dbutton">Close</button>
				</div>
			</div>
		</div>
	</div>
	<div class=row style="margin-top:20px">
		<div class=col-sm-3>


			<div class=total>
				Total Bet:<i class='fa fa-rupee'></i><span id="total">0</span>
			</div>
		</div>
		<div class=col-sm-2></div>
		<div class=col-sm-2>
			<div id="number" class="number">0</div>
		</div>
		<!--        <div class=col-sm-1></div>-->



		<div class=col-sm-2 >
			<img src="/images/coins.png"
				style="height: 60px; width: 60px; margin-top: -10px;"><i
				class="fa fa-inr inr"></i><label class="inr1" id="balance">${cbalance}</label>
		</div>
		<div class="col-sm-2 inr2 ">Welcome ${cname}</div>
		<div class="col-sm-1">
		<form action="/exit" method="post">
			<button id="button" class="exit" onclick="" type="submit">Exit</button>
			</form>
		</div>

	</div>
	<div style="margin-top:40px"></div>
	<img src="/images/girl.png" style="margin-left:350px;z-index:1;margin-top:-115px;" id="mygirl">




	<div class="row" style="margin-top:-230px;">

		<div class="col-sm-6">

<i class="fa fa-tasks task" aria-hidden="true" style="color:darkgoldenrod" onclick="showRules()"></i>


			<img src="/images/European-Roulette-Table_edited.jpg" class="image2">
			<img class="image" src="/images/wheel.png" id="rotate"> <img
				src="/images/arrow.png" class="image1">


		</div>
		<div col-sm-6>
			<div class=head>Select your Bet</div>

			<form style="margin-top: 300px; margin-left: 120px;">
				<div class="form-group">


					<div class=col-sm-1 style="margin-left: 60px;">
						<label>1st 12</label>
					</div>
					<div class=col-sm-1>
						<input type="number" class="form-control" 
							step=500 id="a1" min=0 placeholder=0>
					</div>
					<div class=col-sm-1>
						<label>2nd 12</label>
					</div>
					<div class=col-sm-1>
						<input type="number" class="form-control" 
							step="500" id="a2" min=0 placeholder=0>
					</div>
					<div class=col-sm-1>
						<label>3rd 12</label>
					</div>
					<div class=col-sm-1>
						<input type="number" class="form-control" 
							step="500" id="a3" min=0 placeholder=0>
					</div>
				</div>
				<br>
				<br>
				<br>


				<div class=col-sm-1 style="margin-left: 60px;">
					<label>0</label>
				</div>
				<div class=col-sm-1>
					<input type="number" class="form-control" 
						step="500" id="a4" min=0 placeholder=0>
				</div>
				<div class=col-sm-1>
					<label>1 to 18</label>
				</div>
				<div class=col-sm-1>
					<input type="number" class="form-control" 
						step="500" id="a5" min=0 placeholder=0>
				</div>
				<div class=col-sm-1>
					<label>19 to 36</label>
				</div>
				<div class=col-sm-1>
					<input type="number" class="form-control" 
						step="500" id="a6" min=0 placeholder=0>
				</div>
				<br>
				<br>
				<br>

				<div class=col-sm-1 style="margin-left: 180px;">
					<label>Even</label>
				</div>
				<div class=col-sm-1>
					<input type="number" class="form-control" 
						step="500" id="a7" min=0 placeholder=0>
				</div>
				<div class=col-sm-1>
					<label>Odd</label>
				</div>
				<div class=col-sm-1>
					<input type="number" class="form-control" 
						step="500" id="a8" min=0 placeholder=0>
				</div>
				



			</form>
 			<button id="buttonstart" class="btn1 post" onclick="check()">Spin</button>
 
		</div>

	</div>
	
	<div id="error_box" style="display:none">
	<div class="page">
<div class="box">
  <i class="fa fa-times cross" onclick="closebox()"></i>
  <div class="recharge"><h1>Error</h1></div>
  <div class="input">
    <div class="amount">Sorry Dear!<br>You have Insufficient balance!!</div>
  </div>
  <div style="margin-top:40px;" class="twobutton">
    <button onclick="closebox()" class="btn btn-primary btn2">Close</button>
        <button onclick="resetbox()" class="btn btn-primary btn3">Reset Game</button>
    
  </div>
</div>
</div>
</div>

<div id="confirm_box" style="display:none">
	<div class="page">
<div class="box">
  <i class="fa fa-times cross" onclick="closebox()"></i>
  <div class="luck"><h1>try Your Luck!</h1></div>
  <div class="input">
    <div class="amount">Are you sure you want to try your luck with your current selections?</div>
  </div>
  <div style="margin-top:40px;" class="twobutton">
    <button onclick="closebox()" class="btn btn-primary btn4">No</button>
        <button onclick="generateNumber()" class="btn btn-primary btn5">Sure</button>
    
  </div>
</div>
</div>
</div>

<div id="wrong_box" style="display:none">
	<div class="page">
<div class="box">
  <i class="fa fa-times cross" onclick="closebox()"></i>
  <div class="recharge"><h1>Error</h1></div>
  <div class="input">
    <div class="amount">Hey!<br>Your bet must be positive and a multiple of 500</div>
  </div>
  <div style="margin-top:40px;" class="twobutton">
    <button onclick="closebox()" class="btn btn-primary btn6">Close</button>
    
  </div>
</div>
</div>
</div>

<div id="wrong1_box" style="display:none">
	<div class="page">
<div class="box">
  <i class="fa fa-times cross" onclick="closebox()"></i>
  <div class="recharge"><h1>Error</h1></div>
  <div class="input">
    <div class="amount">Hey!<br>Please select any bet</div>
  </div>
  <div style="margin-top:40px;" class="twobutton">
    <button onclick="closebox()" class="btn btn-primary btn7">Close</button>
    
  </div>
</div>
</div>
</div>

<div id="rules_box" style="display:none">
	<div class="page">
<div class="box" style="overflow:scroll">
  <i class="fa fa-times cross" onclick="closebox()"></i>
  <div class="luck"><h1>Game Rules</h1></div>
  <div class="input">
    <div class="amount"><b>1.</b>The player can bet on a combination of the following options with following return rules in winning scenario.
    <br>->1st 12:1.5 times of bet amount<br>->2nd 12:1.5 times of bet amount<br>->3rd 12:1.5 times of bet amount<br>->0:10 times of bet amount<br>
    ->1 to 18:1.25 times the bet amount<br>->19 to 36:1.25 times the bet amount<br>->Even:1.25 times the bet amount<br>->Odd:1.25 times the bet amount<br>
    <b>2.</b>The minimum betting amount for any option is INR 500. <br><b>3.</b>	The betting amount will be in multiple of 500 only.
    
    
    </div>
  </div>
  <div style="margin-top:40px;" class="twobutton">
        <button onclick="closebox()" class="btn btn-primary btn7">Close</button>
    
  </div>
</div>
</div>
</div>





</body>
</html>
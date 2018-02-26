var rotated = false;

function showRules(){
	document.getElementById("rules_box").style.display = 'block';
}

function closebox() {
	document.getElementById("error_box").style.display = 'none';
	document.getElementById("confirm_box").style.display = 'none';
	document.getElementById("wrong_box").style.display = 'none';

	document.getElementById("wrong1_box").style.display = 'none';
	document.getElementById("rules_box").style.display = 'none';


	
};

function reset(){
	document.getElementById("a1").value = 0;
	document.getElementById("a2").value = 0;
	document.getElementById("a3").value = 0;
	document.getElementById("a4").value = 0;
	document.getElementById("a5").value = 0;
	document.getElementById("a6").value = 0;
	document.getElementById("a7").value = 0;
	document.getElementById("a8").value = 0;
	
}

function able(){
	
	document.getElementById("a1").disabled = false;
	document.getElementById("a2").disabled = false;
	document.getElementById("a3").disabled = false;
	document.getElementById("a4").disabled = false;
	document.getElementById("a5").disabled = false;
	document.getElementById("a6").disabled = false;
	document.getElementById("a7").disabled = false;
	document.getElementById("a8").disabled = false;
	
}

function disable(){
	document.getElementById("a1").disabled = true;
	document.getElementById("a2").disabled = true;
	document.getElementById("a3").disabled = true;
	document.getElementById("a4").disabled = true;
	document.getElementById("a5").disabled = true;
	document.getElementById("a6").disabled = true;
	document.getElementById("a7").disabled = true;
	document.getElementById("a8").disabled = true;

	
}

function resetbox() {
	
	reset();
	document.getElementById("error_box").style.display = 'none';

}

function confirm() {
	$('#mygirl').removeAttr("src");
	$('#mygirl').attr("src", "/images/girl.png");
	document.getElementById("confirm_box").style.display = 'block';
}

function check() {
	var checked=false;
	document.getElementById("confirm_box").style.display = 'none';
	var a1 = document.getElementById("a1").value;
	var a2 = document.getElementById("a2").value;
	var a3 = document.getElementById("a3").value;
	var a4 = document.getElementById("a4").value;
	var a5 = document.getElementById("a5").value;
	var a6 = document.getElementById("a6").value;
	var a7 = document.getElementById("a7").value;
	var a8 = document.getElementById("a8").value;

	var b1 = a1 == "" ? 0 : parseInt(a1);
	var b2 = a2 == "" ? 0 : parseInt(a2);
	var b3 = a3 == "" ? 0 : parseInt(a3);
	var b4 = a4 == "" ? 0 : parseInt(a4);
	var b5 = a5 == "" ? 0 : parseInt(a5);
	var b6 = a6 == "" ? 0 : parseInt(a6);
	var b7 = a7 == "" ? 0 : parseInt(a7);
	var b8 = a8 == "" ? 0 : parseInt(a8);
	
	if(b1%500!=0 || b1<0){checked=true;}
	if(b2%500!=0 || b2<0){checked=true;}
	if(b3%500!=0 || b3<0){checked=true;}
	if(b4%500!=0 || b4<0){checked=true;}
	if(b5%500!=0 || b5<0){checked=true;}
	if(b6%500!=0 || b6<0){checked=true;}
	if(b7%500!=0 || b7<0){checked=true;}
	if(b8%500!=0 || b8<0){checked=true;}
	
	if(checked){
		document.getElementById("wrong_box").style.display="block";
		return;
	}
	
	

	var balance = document.getElementById("balance");
	var currentbalance = balance.innerHTML;
	var selected_amount = b1 + b2 + b3 + b4 + b5 + b6 + b7 + b8;
	if(selected_amount==0){		
		document.getElementById("wrong1_box").style.display = 'block';
		return;
}
	else if (selected_amount > currentbalance) {
		document.getElementById("error_box").style.display = 'block';
		return;
	} else {
		confirm();
	}
}
function generateNumber() {
	document.getElementById("confirm_box").style.display = 'none';

	var modelAttr = $("#modelAttr").val();
	console.log("hello" + modelAttr);
	var a1 = document.getElementById("a1").value;
	var a2 = document.getElementById("a2").value;
	var a3 = document.getElementById("a3").value;
	var a4 = document.getElementById("a4").value;
	var a5 = document.getElementById("a5").value;
	var a6 = document.getElementById("a6").value;
	var a7 = document.getElementById("a7").value;
	var a8 = document.getElementById("a8").value;

	var b1 = a1 == "" ? 0 : parseInt(a1);
	var b2 = a2 == "" ? 0 : parseInt(a2);
	var b3 = a3 == "" ? 0 : parseInt(a3);
	var b4 = a4 == "" ? 0 : parseInt(a4);
	var b5 = a5 == "" ? 0 : parseInt(a5);
	var b6 = a6 == "" ? 0 : parseInt(a6);
	var b7 = a7 == "" ? 0 : parseInt(a7);
	var b8 = a8 == "" ? 0 : parseInt(a8);
	// console.log(obj);

	var balance = document.getElementById("balance");
	var currentbalance = balance.innerHTML;
	var selected_amount = b1 + b2 + b3 + b4 + b5 + b6 + b7 + b8;

	var obj = {
		"first12" : b1,
		"second12" : b2,
		"third12" : b3,
		"zero" : b4,
		"first18" : b5,
		"second18" : b6,
		"even" : b7,
		"odd" : b8
	}

	$.ajax({
		type : "POST",
		contentType : "application/json;",
		url : "http://localhost:8081/calculate",
		data : JSON.stringify(obj),
		success : function(result) {
			rotate(result)
		}
	});
	// $.post("http://localhost:8081/calculate",obj,function(result){rotate(result)});

}

function rotate(data) {

	document.getElementById("buttonstart").disabled = true;

	var myAudio = document.getElementById("music");
	myAudio.play();

	var cars = [ 0, 32, 15, 19, 4, 21, 2, 25, 17, 34, 6, 27, 13, 36, 11, 30, 8,
			23, 10, 5, 24, 16, 33, 1, 20, 14, 31, 9, 22, 18, 29, 7, 28, 12, 35,
			3, 26 ];

	disable();
	var totalbet = document.getElementById("total");
	var balance = document.getElementById("balance");

	totalbet.innerText = data[2];
	balance.innerText=parseInt(balance.innerHTML)-data[2];

	//    
	var x = data[0];
	var y = cars.indexOf(x);

	var degree = rotated ? (-y * 9.7297) + 7200 : (-y * 9.72) - 7200;

	var div = document.getElementById('rotate');
	deg = degree;

	div.style.webkitTransform = 'rotate(' + deg + 'deg)';
	div.style.mozTransform = 'rotate(' + deg + 'deg)';
	div.style.msTransform = 'rotate(' + deg + 'deg)';
	div.style.oTransform = 'rotate(' + deg + 'deg)';
	div.style.transform = 'rotate(' + degree + 'deg)';

	//    
	var game_amount = data[1];

	var z = document.getElementById("number");
	var box = document.getElementById("myModalLabel");
	var dialog_body = document.getElementById("modal-body");
	var balance = document.getElementById("balance");
	var girl = document.getElementById("girl");

	if (game_amount > 0) {
		box.innerHTML = "Congratulations <i class='fa fa-thumbs-up'></i>";
		dialog_body.innerHTML = "You have won <i class='fa fa-rupee'></i>"
				+ game_amount;
		$('#header').removeClass("header-loose");
		$('#modal-body').removeClass("body-loose");
		$('#dbutton').removeClass("button-loose");
		$('#header').addClass("header-won");
		$('#modal-body').addClass("body-won");
		$('#dbutton').addClass("button-won");
	} else if (game_amount < 0) {
		box.innerHTML = "Oops! Sorry <i class='fa fa-thumbs-down'></i>";
		dialog_body.innerHTML = "You have lost <i class='fa fa-rupee'></i>"
				+ (-1 * game_amount);
		$('#header').removeClass("header-won");
		$('#modal-body').removeClass("body-won");
		$('#dbutton').removeClass("button-won");
		$('#header').addClass("header-loose");
		$('#modal-body').addClass("body-loose");
		$('#dbutton').addClass("button-loose");
	} else {
		box.innerHTML = "Wow!Money Balance <i class='fa fa-balance-scale'></i>";
		dialog_body.innerHTML = "You have won <i class='fa fa-rupee'></i>"
				+ game_amount;
		$('#header').removeClass("header-loose");
		$('#modal-body').removeClass("body-loose");
		$('#dbutton').removeClass("button-loose");
		$('#header').addClass("header-won");
		$('#modal-body').addClass("body-won");
		$('#dbutton').addClass("button-won");

	}
	rotated = !rotated

	setTimeout(function() {
		if (game_amount > 0) {
			$('#mygirl').removeAttr("src");
			$('#mygirl').attr("src", "/images/girl2.png");

		} else if (game_amount < 0) {
			$('#mygirl').removeAttr("src");

			$('#mygirl').attr("src", "/images/girl1.png");

		}
		reset();
		able();

		

		z.innerText = x;
		$('#myModal').modal('show');
		document.getElementById("buttonstart").disabled = false;
		console.log(balance.innerHTML);
		console.log(data[1]);
		balance.innerText = parseInt(balance.innerHTML) + data[1]+data[2];
		totalbet.innerText = 0;

	}, 8000);

}

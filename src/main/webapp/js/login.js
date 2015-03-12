

function login() {
	var username = document.getElementById("username").value;
	var password = document.getElementById("password").value;
	var userRole;

	$.ajax({
		type : 'POST',
		url : "http://localhost:8080/LTEManager/rest/users/getuser",
		dataType : "json",
		data : {
			"username" : username, "password" : password},
			success : function(response) 
			{
				$.each(response, function(i,item) 
						{
					userRole = item.userType;
						})
			}
	});

	alert(1);
	setCookie("userRole", userRole, 1);
	checkCookie();
	alert(2);
}

function setCookie (cuserRole, cvalue, expdays) {
	var date = new Date();
	date.setTime(date.getTime() + (expdays*24*60*60*1000));
	var expires = "expires=" + date.toUTCString();
	document.cookie = cuserRole + "=" + cvalue + "; " + expires;
}

function getCookie(cuserRole){
	var userRole = cuserRole + "=";
	var char = document.cookie.split(';');
	for(var i=0; i<char.length; i++){
		var c = char[i];
		while (c.charAt(0)==' ') c = c.substring(1);
		if (c.indexOf(userRole) == 0)
			return c.substring(name.length, c.length);
	}
	return "";
}

function checkCookie() {
	var userRole = getCookie("userRole");
	if(userRole == "System Administrator"){
		alert(userRole);
	}
	if(userRole == "Customer Service Rep"){
		alert(userRole);
	}
	if(userRole == "Network Management Engineer"){
		alert(userRole);
	}
	if(userRole == "Supporty Engineer"){
		alert(userRole);
	}
	if(userRole == ""){
		alert("Empty");
	}
}

function deleteCookie(){
	document.cookie = "userRole=; expires=Thu, 01 Jan 1970 00:00:00 UTC";
}
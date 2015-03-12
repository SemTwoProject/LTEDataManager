function login() {
	var username = document.getElementById("username").value;
	var password = document.getElementById("password").value;
	var userRole;

	$.ajax({
		type : 'POST',
		url : "http://localhost:8080/LTEManager/rest/users/getuser",
		dataType : "json",
		data : {
			"username" : username,
			"password" : password
		},
		success : function(response) {
			$.each(response, function(i, item) {
				userRole = item.userType;
			})
		}
	});

	setTimeout(function() {
		setCookie("userRole", userRole, 1)
	}, 500);
	setTimeout(function() {
		checkCookie()
	}, 600);
	setTimeout(function() {
		window.location.replace("http://localhost:8080/LTEManager/home.html");
	}, 1000);
}

function setCookie(cuserRole, cvalue, expdays) {
	var date = new Date();
	date.setTime(date.getTime() + (expdays * 24 * 60 * 60 * 1000));
	var expires = "expires=" + date.toUTCString();
	document.cookie = cuserRole + "=" + cvalue + "; " + expires;
}

function getCookie(cuserRole) {
	var userRole = cuserRole + "=";
	var char = document.cookie.split(';');
	for (var i = 0; i < char.length; i++) {
		var c = char[i];
		while (c.charAt(0) == ' ')
			c = c.substring(1);
		if (c.indexOf(userRole) == 0)
			return c.substring(name.length, c.length);
	}
	return "";
}

function checkCookie() 
{
	if (document.cookie == "") 
	{
		window.location.replace("http://localhost:8080/LTEManager/index.html");
	} 
	else 
	{
		var userRole = getCookie("userRole");
		
		if (userRole == "userRole=Customer Service Rep") 
		{
			$('#sidenav').append($('<li><a href="customerservice.html">Customer Service</a></li>'));
		} 
		else if (userRole == "userRole=Support Engineer") 
		{
			$('#sidenav').append($('<li><a href="customerservice.html">Customer Service</a></li>'));
			$('#sidenav').append($('<li><a href="supportengineer.html">Support Engineer</a></li>'));
		}
		else if (userRole == "userRole=Network Management Engineer") 
		{
			$('#sidenav').append($('<li><a href="customerservice.html">Customer Service</a></li>'));
			$('#sidenav').append($('<li><a href="supportengineer.html">Support Engineer</a></li>'));
			$('#sidenav').append($('<li><a href="networkmanagement.html">Network Management</a></li>'));
		} 
		else if (userRole == "userRole=System Administrator") 
		{
			$('#sidenav').append($('<li><a href="systemadmin.html">System Administration</a></li>'));
		} 
		
	}
}

function deleteCookie() 
{
	document.cookie = "userRole=; expires=Thu, 01 Jan 1970 00:00:00 UTC";
}

function rememberMe() 
{
	if (document.cookie != "") 
	{
		window.location.replace("http://localhost:8080/LTEManager/home.html");
	}
}
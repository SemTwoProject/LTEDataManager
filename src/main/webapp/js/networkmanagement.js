$(document).ready(function() {
	$("#querydropdown").change(function() {
		$("select option:selected").each(function() {
			if ($(this).attr("value") == "totalfaults") 
			{			
				$("#dates").show();
				$("#modelsearchfield").prop("disabled", true);
				$("#phonemodeldropdown").prop("disabled", true);
				$('#datatable').empty();
				var table = $('<tr><th>IMSI</th><th>Total Failures</th><th>Total Duration</th></tr>');				
				$('#datatable').append(table);
			}
			if ($(this).attr("value") == "modelfailures") 
			{				
				$("#dates").hide();
				$("#modelsearchfield").prop("disabled", false);
				$("#phonemodeldropdown").prop("disabled", false);
				$('#datatable').empty();
				var table = $('<tr><th>Phone Model</th><th>Event ID</th><th>Cause Code</th><th>Number of Occurences</th></tr>');				
				$('#datatable').append(table);
			}
			if ($(this).attr("value") == "toptenmccmnccell") 
			{		
				$("#dates").show();
				$("#modelsearchfield").prop("disabled", true);
				$("#phonemodeldropdown").prop("disabled", true);
				$('#datatable').empty();
				var table = $('<tr><th>Market ID</th><th>Operator ID</th><th>Call ID</th><th>Count</th></tr>');				
				$('#datatable').append(table);
			}
			if ($(this).attr("value") == "toptenimsiovertime") 
			{		
				$("#dates").show();
				$("#modelsearchfield").prop("disabled", true);
				$("#phonemodeldropdown").prop("disabled", true);
				$('#datatable').empty();
				var table = $('<tr><th>IMSI</th><th>Count</th></tr>');				
				$('#datatable').append(table);
			}
		});
	}).change();
});


$("#submit").click(function()
		{	
	if ($("#querydropdown").attr("value") == "totalfaults") 
	{			
		var startdate = $('#startdate').data('date');
		var enddate = $('#enddate').data('date');

		$('#datatable').empty();
		var table = $('<tr><th>IMSI</th><th>Total Failures</th><th>Total Duration</th></tr>');				
		$('#datatable').append(table);
		if (startdate == ""){
			alert("Please enter a VALID Start Date");
		}
		else if (enddate == ""){
			alert("Please enter a VALID End Date");
		}
		else {
			$.ajax({
				type: 'POST',
				url: "http://localhost:8080/LTEManager/rest/fault/totalfaults",
				dataType: "json", 
				data: {"startdate": startdate, "enddate": enddate},
				success:function(response)
				{
					$.each(response, function(i, item) 
							{
						$tr = "";
						$tr = $('<tr>').append(
								$('<td>').text(item[0]),
								$('<td>').text(item[1]),
								$('<td>').text(item[2]));
						$('#datatable').append($tr);
							});          	
				}});
		}
	}
	else if ($("#querydropdown").attr("value") == "modelfailures") 
	{			
		var model = document.getElementById("modelsearchfield").value;
		alert(model);
		$('#datatable').empty();
		var table = $('<tr><th>Phone Model</th><th>Event ID</th><th>Cause Code</th><th>Number of Occurences</th></tr>');				
		$('#datatable').append(table);
		if (model == ""){
			alert("Please enter a valid model");
		}
		else{
			$.ajax({
				type: 'POST',
				url: "http://localhost:8080/LTEManager/rest/ue/modelfailures",
				dataType: "json", 
				data: {"model": model},
				success:function(response)
				{
					if(response == ""){
						alert("No data for given model");
					}
					else{
						$.each(response, function(i, item) 
								{
							$tr = "";
							$tr = $('<tr>').append(
									$('<td>').text(item[0]),
									$('<td>').text(item[1]),
									$('<td>').text(item[2]),
									$('<td>').text(item[3]));
							$('#datatable').append($tr);
								});
					}
				}});
		}
	}
	else if ($("#querydropdown").attr("value") == "toptenmccmnccell") 
	{			
		var startdate = $('#startdate').data('date');
		var enddate = $('#enddate').data('date');

		$('#datatable').empty();
		var table = $('<tr><th>Market ID</th><th>Operator ID</th><th>Call ID</th><th>Count</th></tr>');				
		$('#datatable').append(table);
		if (startdate == ""){
			alert("Please enter a VALID Start Date");
		}
		else if (enddate == ""){
			alert("Please enter a VALID End Date");
		}
		else {
			$.ajax({
				type: 'POST',
				url: "http://localhost:8080/LTEManager/rest/fault/toptenmnnmcncell",
				dataType: "json", 
				data: {"startdate": startdate, "enddate": enddate},
				success:function(response)
				{
					$.each(response, function(i, item) 
							{
						$tr = "";
						$tr = $('<tr>').append(
								$('<td>').text(item[0]),
								$('<td>').text(item[1]),
								$('<td>').text(item[2]),
								$('<td>').text(item[3]));
						$('#datatable').append($tr);
							});          	
				}});		
		}
	}

	else if ($("#querydropdown").attr("value") == "toptenimsiovertime") 
	{			
		var startdate = $('#startdate').data('date');
		var enddate = $('#enddate').data('date');

		$('#datatable').empty();
		var table = $('<tr><th>IMSI</th><th>Count</th></tr>');				
		$('#datatable').append(table);
		if (startdate == ""){
			alert("Please enter a VALID Start Date");
		}
		else if (enddate == ""){
			alert("Please enter a VALID End Date");
		}
		else {
			$.ajax({
				type: 'POST',
				url: "http://localhost:8080/LTEManager/rest/fault/toptenimsiovertime",
				dataType: "json", 
				data: {"startdate": startdate, "enddate": enddate},
				success:function(response)
				{
					$.each(response, function(i, item) 
							{
						$tr = "";
						$tr = $('<tr>').append(
								$('<td>').text(item[0]),
								$('<td>').text(item[1]));
						$('#datatable').append($tr);
							});          	
				}});			
		}
	}
		});
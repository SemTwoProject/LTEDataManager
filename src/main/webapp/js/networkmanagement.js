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
				var table = $('<tr></th><th>Event ID</th><th>Cause Code</th><th>Description</th><th>Number of Occurences</th></tr>');				
				$('#datatable').append(table);
			}
			if ($(this).attr("value") == "toptenmccmnccell") 
			{		
				$("#dates").show();
				$("#modelsearchfield").prop("disabled", true);
				$("#phonemodeldropdown").prop("disabled", true);
				$('#datatable').empty();
				var table = $('<tr><th>Market ID</th><th>Operator ID</th><th>Cell ID</th><th>Count</th></tr>');				
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


$("#submit").click(function(){	
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
		var table = $('<tr><th>Event ID</th><th>Cause Code</th><th>Description</th><th>Number of Occurences</th></tr>');				
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
					
					pieData = [{
						value: response[0][3],
						color:"#F7464A",
						highlight: "#F7464A",
						label: response[0][2] },

						{
						value: response[1][3],
						color:"#60a61e",
						highlight: "#60a61e",
						label: response[1][2] 
						},

						{
						value: response[2][3],
						color:"#00FFFF",
						highlight: "#00FFFF",
						label: response[2][2] 
						},

						{
						value: response[3][3],
						color:"#99FF66",
						highlight: "#99FF66",
						label: response[3][2] 
						},

						{
						value: response[4][3],
						color:"#FFFF00",
						highlight: "#FFFF00",
						label: response[4][2] 
						},

						{
						value: response[5][3],
						color:"#FF0066",
						highlight: "#FF0066",
						label: response[5][2] 
						}];

					var ctx = document.getElementById("myChart").getContext("2d");
					var myPieChart = new Chart(ctx).Pie(pieData);

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
		else if (enddate == "")
		{
			alert("Please enter a VALID End Date");
		}
		else 
		{
			var doughnutData = [];
			
			
			$.ajax({
				type: 'POST',
				url: "http://localhost:8080/LTEManager/rest/fault/toptenimsiovertime",
				dataType: "json", 
				data: {"startdate": startdate, "enddate": enddate},
				success:function(response)
				{$.each(response, function(i, item) {
					$tr = "";
					$tr = $('<tr>').append(
							$('<td>').text(item[0]),
							$('<td>').text(item[1]));
					$('#datatable').append($tr);
				});

				pieData = [{
					value: response[0][1],
					color:"#F7464A",
					highlight: "#F7464A",
					label: response[0][0] },

					{
					value: response[1][1],
					color:"#60a61e",
					highlight: "#60a61e",
					label: response[1][0] 
					},

					{
					value: response[2][1],
					color:"#00FFFF",
					highlight: "#00FFFF",
					label: response[2][0] 
					},

					{
					value: response[3][1],
					color:"#99FF66",
					highlight: "#99FF66",
					label: response[3][0] 
					},

					{
					value: response[4][1],
					color:"#FFFF00",
					highlight: "#FFFF00",
					label: response[4][0] 
					},

					{
					value: response[5][1],
					color:"#FF0066",
					highlight: "#FF0066",
					label: response[5][0] 
					}];

				var ctx = document.getElementById("myChart").getContext("2d");
				var myDoughnutChart = new Chart(ctx).Pie(pieData);

				}});

		}
	}

});
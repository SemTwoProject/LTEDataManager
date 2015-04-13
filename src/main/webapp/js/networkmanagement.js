var piechartData = new Array();
var ctx = document.getElementById("piechart").getContext("2d");
var colours = ['#00FF00', '#FF6600', '#0066FF', '#FFFF00', '#00FFFF', '#333333', '#CC9900', '#009999', '#660066', '#00CC99'];
var chart = new Chart(ctx).Pie(piechartData);

function clearChart()
{
	chart.clear();
	chart.destroy();
	$('#piechart').hide();
}

$(document).ready(function() {
	$("#querydropdown").change(function() {
		$("select option:selected").each(function() {
			if ($(this).attr("value") == "totalfaults") 
			{		
				clearChart();
				$("#dates").show();
				$("#modelsearchfield").prop("disabled", true);
				$("#phonemodeldropdown").prop("disabled", true);
				$('#datatable').empty();
				var table = $('<tr><th>IMSI</th><th>Total Failures</th><th>Total Duration</th></tr>');				
				$('#datatable').append(table);
			}
			if ($(this).attr("value") == "modelfailures") 
			{			
				clearChart();
				$("#dates").hide();
				$("#modelsearchfield").prop("disabled", false);
				$("#phonemodeldropdown").prop("disabled", false);
				$('#datatable').empty();
				var table = $('<tr></th><th>Event ID</th><th>Cause Code</th><th>Description</th><th>Number of Occurences</th></tr>');				
				$('#datatable').append(table);
			}
			if ($(this).attr("value") == "toptenmccmnccell") 
			{		
				clearChart();
				$("#dates").show();
				$("#modelsearchfield").prop("disabled", true);
				$("#phonemodeldropdown").prop("disabled", true);
				$('#datatable').empty();
				var table = $('<tr><th>Country</th><th>Operator</th><th>Cell ID</th><th>Count</th></tr>');				
				$('#datatable').append(table);
			}
			if ($(this).attr("value") == "toptenimsiovertime") 
			{		
				clearChart();
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
					
					var data = {
						    labels: ["January", "February", "March", "April", "May", "June", "July"],
						    datasets: [
						        {
						            label: "My First dataset",
						            fillColor: "rgba(220,220,220,0.5)",
						            strokeColor: "rgba(220,220,220,0.8)",
						            highlightFill: "rgba(220,220,220,0.75)",
						            highlightStroke: "rgba(220,220,220,1)",
						            data: [65, 59, 80, 81, 56, 55, 40]
						        },
						        {
						            label: "My Second dataset",
						            fillColor: "rgba(151,187,205,0.5)",
						            strokeColor: "rgba(151,187,205,0.8)",
						            highlightFill: "rgba(151,187,205,0.75)",
						            highlightStroke: "rgba(151,187,205,1)",
						            data: [28, 48, 40, 19, 86, 27, 90]
						        }
						    ]
						};
					chart = new Chart(ctx).Bar(data);	
				}});
		}
	}
	else if ($("#querydropdown").attr("value") == "modelfailures") 
	{			
		var model = document.getElementById("modelsearchfield").value;
		$('#datatable').empty();
		var table = $('<tr><th>Event ID</th><th>Cause Code</th><th>Description</th><th>Number of Occurences</th></tr>');				
		$('#datatable').append(table);
		if (model == ""){
			alert("Please enter a valid model");
		}
		else{
			$('#piechart').show();
			piechartData = [];
			
			$.ajax({
				type: 'POST',
				url: "http://localhost:8080/LTEManager/rest/fault/modelfailures",
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
							
							
							piechartData.push({
								value: response[i][3],
								color: colours[i%10],
								highlight: "#F7464A",
								label: " Event ID " + response[i][0] +  " Cause Code " + response[i][1] +  " Value "});	
								});
					}
					chart = new Chart(ctx).Doughnut(piechartData);	
				}
			});
		}
	}
	else if ($("#querydropdown").attr("value") == "toptenmccmnccell") 
	{			
		var startdate = $('#startdate').data('date');
		var enddate = $('#enddate').data('date');

		$('#datatable').empty();
		var table = $('<tr><th>Country</th><th>Operator</th><th>Cell ID</th><th>Count</th></tr>');				
		$('#datatable').append(table);
		if (startdate == ""){
			alert("Please enter a VALID Start Date");
		}
		else if (enddate == ""){
			alert("Please enter a VALID End Date");
		}
		else {
			$('#piechart').show();
			piechartData = [];
			
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
						
						piechartData.push({
							value: response[i][3],
							color: colours[i%10],
							highlight: "#F7464A",
							label: "Cell: " + response[i][2] + "  Count"});	
				});
				
					chart =  new Chart(ctx).Doughnut(piechartData,  { tooltipTemplate: " <%=label%>: <%= numeral(value).format('(00[.]00)') %> - <%= numeral(circumference / 6.283).format('(0[.][00]%)') %>" });
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
			$('#piechart').show();
			piechartData = [];
			$.ajax({
				type: 'POST',
				url: "http://localhost:8080/LTEManager/rest/fault/toptenimsiovertime",
				dataType: "json", 
				data: {"startdate": startdate, "enddate": enddate},
				success:function(response)
				{$.each(response, function(i, item) 
				{
					$tr = "";
					$tr = $('<tr>').append(
							$('<td>').text(item[0]),
							$('<td>').text(item[1]));
					$('#datatable').append($tr);

					
					piechartData.push({
						value: response[i][1],
						color: colours[i%10],
						highlight: "#F7464A",
						label: response[i][0]});					
				});						
				
				chart =  new Chart(ctx).Doughnut(piechartData,  { responsive: true, tooltipTemplate: " <%=label%>: <%= numeral(value).format('(00[.]00)') %> - <%= numeral(circumference / 6.283).format('(0[.][00]%)') %>" });
				document.getElementById("graphical").innerHTML = chart.generateLengent();
			}});
		}
	}
});


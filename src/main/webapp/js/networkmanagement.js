var table;
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

$(document).ready(function() 
{
	$("#querydropdown").change(function() 
	{
		$("select option:selected").each(function() 
		{
			if ($(this).attr("value") == "totalfaults") 
			{		
				clearChart();
				$("#dates").show();
				$("#modelsearchfield").prop("disabled", true);
				$("#phonemodeldropdown").prop("disabled", true);
				$('#datatable').empty();
				table = $('<tr><th>IMSI</th><th>Total Failures</th><th>Total Duration</th></tr>');				
				$('#datatable').append(table);
			}
			if ($(this).attr("value") == "modelfailures") 
			{			
				clearChart();
				$("#dates").hide();
				$("#modelsearchfield").prop("disabled", false);
				$("#phonemodeldropdown").prop("disabled", false);
				$('#datatable').empty();
				table = $('<tr></th><th>Event ID</th><th>Cause Code</th><th>Description</th><th>Number of Occurences</th></tr>');				
				$('#datatable').append(table);
			}
			if ($(this).attr("value") == "toptenmccmnccell") 
			{		
				clearChart();
				$("#dates").show();
				$("#modelsearchfield").prop("disabled", true);
				$("#phonemodeldropdown").prop("disabled", true);
				$('#datatable').empty();
				table = $('<tr><th>Market ID</th><th>Operator ID</th><th>Cell ID</th><th>Count</th></tr>');				
				$('#datatable').append(table);
			}
			if ($(this).attr("value") == "toptenimsiovertime") 
			{		
				clearChart();
				$("#dates").show();
				$("#modelsearchfield").prop("disabled", true);
				$("#phonemodeldropdown").prop("disabled", true);
				$('#datatable').empty();
				table = $('<tr><th>IMSI</th><th>Count</th></tr>');				
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
		table = $('<tr><th>IMSI</th><th>Total Failures</th><th>Total Duration</th></tr>');				
		$('#datatable').append(table);
		if (startdate == "")
		{
			alert("Please enter a VALID Start Date");
		}
		else if (enddate == "")
		{
			alert("Please enter a VALID End Date");
		}
		else 
		{
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
		$('#datatable').empty();
		table = $('<tr><th>Event ID</th><th>Cause Code</th><th>Description</th><th>Number of Occurences</th></tr>');				
		$('#datatable').append(table);
		if (model == "")
		{
			alert("Please enter a valid model");
		}
		else
		{
			$('#piechart').show();
			piechartData = [];
			
			$.ajax({
				type: 'POST',
				url: "http://localhost:8080/LTEManager/rest/fault/modelfailures",
				dataType: "json", 
				data: {"model": model},
				success:function(response)
				{
					if(response == "")
					{
						alert("No data for given model");
					}
					else
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
								label: " Event ID " + response[i][0] +  " Cause Code " + response[i][1] +  " Value "});	
						});
					}
					chart = new Chart(ctx).Pie(piechartData);	
				}
			});
		}
	}
	else if ($("#querydropdown").attr("value") == "toptenmccmnccell") 
	{			
		var startdate = $('#startdate').data('date');
		var enddate = $('#enddate').data('date');

		$('#datatable').empty();
		table = $('<tr><th>Market ID</th><th>Operator ID</th><th>Cell ID</th><th>Count</th></tr>');				
		$('#datatable').append(table);
		if (startdate == "")
		{
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
							label: response[i][0] + "/" + response[i][1] + "/" + response[i][2] + "  Count"});	
					});
					chart =  new Chart(ctx).Pie(piechartData,  { tooltipTemplate: " <%=label%>: <%= numeral(value).format('(00[.]00)') %> - <%= numeral(circumference / 6.283).format('(0[.][00]%)') %>" });
				}});		
		}
	}
	else if ($("#querydropdown").attr("value") == "toptenimsiovertime") 
	{	
		var startdate = $('#startdate').data('date');
		var enddate = $('#enddate').data('date');

		$('#datatable').empty();
		table = $('<tr><th>IMSI</th><th>Count</th></tr>');				
		$('#datatable').append(table);
		if (startdate == "")
		{
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
				{
					$.each(response, function(i, item) 
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
					chart =  new Chart(ctx).Pie(piechartData,  { tooltipTemplate: " <%=label%>: <%= numeral(value).format('(00[.]00)') %> - <%= numeral(circumference / 6.283).format('(0[.][00]%)') %>" });
					
					$("#piechart").click( function(evt)
	                {
						$('#drilldowntable').empty();
						table = $('<tr><th>Event ID</th><th>Cause Code</th><th>Description</th><th>Failure</th><th>Date</th></tr>');
						$('#drilldowntable').append(table);
	                    var activePoints = chart.getSegmentsAtEvent(evt);
	                    $('#drilldowninfo').text("Faults for IMSI: " + activePoints[0].label);
	                    $.ajax({
	        				type : 'POST',
	        				url : "http://localhost:8080/LTEManager/rest/fault/faultsbyimsi",
	        				dataType : "json",
	        				data : {
	        					"imsi" : activePoints[0].label
	        				},
	        				success : function(response) 
	        				{
	        					$.each(response, function(i, item) 
	        					{
	        						$tr = "";
	        						$tr = $('<tr>').append(
	        							$('<td>').text(item[0]),
	        							$('<td>').text(item[1]),
	        							$('<td>').text(item[2]),
	        							$('<td>').text(item[3]),
	        							$('<td>').text(item[4]));
	        						$('#drilldowntable').append($tr);	        							
	        					});	        					
	        				}
	        			});

						$('#drilldown').modal('show');
	                }
	             ); 
			}});
		}
	}
});


var table;
var piechartData = new Array();
var barchartLabels = new Array();
var barchartData = new Array();
var piectx = document.getElementById("piechart").getContext("2d");
var barctx = document.getElementById("barchart").getContext("2d");
var colours = ['#00FF00', '#FF6600', '#0066FF', '#FFFF00', '#00FFFF', '#333333', '#CC9900', '#009999', '#660066', '#00CC99'];
var piechartinfo;
var data = { labels: [""], datasets: [{ label: "", fillColor: "", strokeColor: "", highlightFill: "", highlightStroke: "", data: [] }]};		
var piechart = new Chart(piectx).Pie(piechartData);
var barchart = new Chart(barctx).Bar(data);

function clearChart()
{
	piechart.clear();
	piechart.destroy();
	barchart.clear();
	barchart.destroy();
	$('#graphical').hide();
	$('#barchart').hide();
	$('#piechart').attr('onclick','').unbind('click');
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
			$('#graphical').show();
			$('#barchart').show();
			piechartData = [];
			barchartLabels = [];
			barchartData = [];
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
						barchartLabels.push(item[0]);
						barchartData.push(item[2]);
						
						piechartData.push({
							value: response[i][2],
							color: colours[i%10],
							highlight: "#F7464A",
							label: response[i][0]});
					});   
					
				data = {
						labels: barchartLabels,
						datasets: 
						[{
							label: "Call Failures",
							fillColor: "rgba(0,0,255,0.5)",
				            strokeColor: "rgba(0,0,100,0.8)",
				            highlightFill: "rgba(255,0,0,0.75)",
				            highlightStroke: "rgba(100,0,0,1)",
				            data: barchartData
						}]
				};		
				piechart = new Chart(piectx).Pie(piechartData, { tooltipTemplate: " <%=label%>: <%= numeral(value).format('(00[.]00)') %> - <%= numeral(circumference / 6.283).format('(0[.][00]%)') %>" });
				barchart =  new Chart(barctx).Bar(data);	
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
			$('#graphical').show();
			piechartData = [];
			barchartData = [];
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
								label: response[i][0] +  ":" + response[i][1] + ": Value "});	
						});
					}
					piechart = new Chart(piectx).Pie(piechartData);	
					
					$("#piechart").click( function(evt)
					{
						$('#drilldowntable').empty();
						table = $('<tr><th>IMSI</th><th>Date</th></tr>');
						$('#drilldowntable').append(table);
					    piechartinfo = piechart.getSegmentsAtEvent(evt);
					    var ids = piechartinfo[0].label.split(":");
					    $('#drilldowninfo').text("Showing failures for Model: " + model + " with Event/Cause Combo:" + ids[0] + "/" + ids[1] );
					    $.ajax({
					        type : 'POST',
					        url : "http://localhost:8080/LTEManager/rest/fault/faultsformodeleventcombo",
					        dataType : "json",
					        data : {
					        	"model": model,
					        	"eventid": ids[0],
					        	"causecode": ids[1]
					        },
					        success : function(response) 
					        {
					        	$.each(response, function(i, item) 
					        	{
					        		$tr = "";
					        		$tr = $('<tr>').append(
					        		$('<td>').text(item[0]),
					        		$('<td>').text(item[5]));
					        		$('#drilldowntable').append($tr);	        							
					        	});	        					
					        }
					      });
						$('#drilldown').modal('show');
					});
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
			$('#graphical').show();
			piechartData = [];
			barchartData = [];
			
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
							label: response[i][0] + "/" + response[i][1] + "/" + response[i][2] + "/  Failures"});	
					});
					piechart =  new Chart(piectx).Pie(piechartData,  { tooltipTemplate: " <%=label%>: <%= numeral(value).format('(00[.]00)') %> - <%= numeral(circumference / 6.283).format('(0[.][00]%)') %>" });
				
					$("#piechart").click( function(evt)
			        {
						$('#drilldowntable').empty();
						table = $('<tr><th>IMSI</th><th>Cause Code</th><th>Event ID</th><th>Description</th><th>Failure</th><th>Date</th></tr>');
						$('#drilldowntable').append(table);
			            piechartinfo = piechart.getSegmentsAtEvent(evt);
			            var ids = piechartinfo[0].label.split("/");
			            $('#drilldowninfo').text("Showing failures for Cell: " + ids[2] + " Operator: " + ids[1] + " Market: " + ids[0]);
			            $.ajax({
			        		type : 'POST',
			        		url : "http://localhost:8080/LTEManager/rest/fault/faultsforcell",
			        		dataType : "json",
			        		data : {
			        			"marketid": ids[0],
			        			"operatorid": ids[1],
			        			"cellid": ids[2]
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
			        				$('<td>').text(item[4]),
			        				$('<td>').text(item[5]));
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
			$('#graphical').show();
			piechartData = [];
			barchartData = [];
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
					piechart =  new Chart(piectx).Pie(piechartData,  { tooltipTemplate: " <%=label%>: <%= numeral(value).format('(00[.]00)') %> - <%= numeral(circumference / 6.283).format('(0[.][00]%)') %>" });
					
					$("#piechart").click( function(evt)
	                {
						$('#drilldowntable').empty();
						table = $('<tr><th>Event ID</th><th>Cause Code</th><th>Description</th><th>Failure</th><th>Date</th></tr>');
						$('#drilldowntable').append(table);
	                    piechartinfo = piechart.getSegmentsAtEvent(evt);
	                    $('#drilldowninfo').text("Faults for IMSI: " + piechartinfo[0].label + " Total Faults: " + piechartinfo[0].value);
	                    $.ajax({
	        				type : 'POST',
	        				url : "http://localhost:8080/LTEManager/rest/fault/faultsbyimsi",
	        				dataType : "json",
	        				data : {
	        					"imsi" : piechartinfo[0].label
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


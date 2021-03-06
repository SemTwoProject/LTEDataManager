var table;
var piechartinfo;
var barchartinfo;
var ue_models = [];
var data = { labels: [""], datasets: [{ label: "", fillColor: "", strokeColor: "", highlightFill: "", highlightStroke: "", data: [] }]};		
var tabledata = new Array();
var piechartData = new Array();
var barchartData = new Array();
var barchartLabels = new Array();
var tableholder = document.getElementById("tableholder");
var piectx = document.getElementById("piechart").getContext("2d");
var barctx = document.getElementById("barchart").getContext("2d");
var barchart = new Chart(barctx).Bar(data);
var piechart = new Chart(piectx).Pie(piechartData);
var colours = ['#00FF00', '#FF6600', '#0066FF', '#FFFF00', '#00FFFF', '#333333', '#CC9900', '#009999', '#660066', '#00CC99'];


function clearTable()
{
	$('#datatable').remove();
	$('#datatable_wrapper').remove();
	$('#drilldowntable').remove();
	$('#drilldowntable_wrapper').remove();
}

function clearChart()
{
	piechart.clear();
	piechart.destroy();
	barchart.clear();
	barchart.destroy();
	$('#piechartheader').text("");
	$('#barchartheader').text("");
	$('#piechart').show();
	$('#barchart').show();
	$('#graphical').hide();
	$('#piechart').attr('onclick','').unbind('click');
}

$(document).ready(function() 
{
	$.ajax({
		type : 'GET',
		url : "http://localhost:8080/LTEManager/rest/fault/models",
		dataType : "json",
		success : function(response) 
		{
			$.each(response, function(i, item) 
			{
				ue_models.push(item);
			});
		}
	});
	

	$("#modelsearchfield").autocomplete({ source : ue_models, autoFocus : false, minLength:2 });
	
	
$("#querydropdown").change(function() 
{
	$("select option:selected").each(function() 
	{
		if ($(this).attr("value") == "totalfaults") 
		{		
			tableholder.className = "col-sm-12";
			clearChart();
			$("#dates").show();
			$("#modelsearchfield").prop("disabled", true);
			$("#phonemodeldropdown").prop("disabled", true);
			clearTable();
			table = $('<table class="display table table-bordered" cellspacing="0" id="datatable"><tr><th>IMSI</th><th>Total Failures</th><th>Total Duration</th></tr></table>');				
			$('#tablediv').append(table);
		}
		if ($(this).attr("value") == "modelfailures") 
		{		
			tableholder.className = "col-sm-8";
			clearChart();
			$("#dates").hide();
			$("#modelsearchfield").prop("disabled", false);
			$("#phonemodeldropdown").prop("disabled", false);
			clearTable();
			table = $('<table class="display table table-bordered" cellspacing="0" id="datatable"><tr></th><th>Event ID</th><th>Cause Code</th><th>Description</th><th>Number of Occurences</th></tr></table>');				
			$('#tablediv').append(table);
		}
		if ($(this).attr("value") == "toptenmccmnccell") 
		{		
			tableholder.className = "col-sm-8";
			clearChart();
			$("#dates").show();
			$("#modelsearchfield").prop("disabled", true);
			$("#phonemodeldropdown").prop("disabled", true);
			clearTable();
			table = $('<table class="display table table-bordered" cellspacing="0" id="datatable"><tr><th>Market ID</th><th>Operator ID</th><th>Cell ID</th><th>Count</th></tr></table>');				
			$('#tablediv').append(table);
		}
		if ($(this).attr("value") == "toptenimsiovertime") 
		{		
			tableholder.className = "col-sm-8";
			clearChart();
			$("#dates").show();
			$("#modelsearchfield").prop("disabled", true);
			$("#phonemodeldropdown").prop("disabled", true);
			clearTable();
			table = $('<table class="display table table-bordered" cellspacing="0" id="datatable"><tr><th>IMSI</th><th>Count</th></tr></table>');				
			$('#tablediv').append(table);
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
			clearChart();
			clearTable();
			$('#graphical').show();
			$('#piechart').hide();
			table = $('<table class="display table table-bordered" cellspacing="0" id="datatable"><tr><th>IMSI</th><th>Total Failures</th><th>Total Duration</th></tr></table>');				
			$('#tablediv').append(table);
			table = $('<table class="display table table-bordered" cellspacing="0" id="drilldowntable"></table>');				
			$('#drilltablediv').append(table);
			barchartLabels = [];
			barchartData = [];
			$.ajax({
				type: 'POST',
				url: "http://localhost:8080/LTEManager/rest/fault/toptentotalfaults",
				dataType: "json", 
				data: {"startdate": startdate, "enddate": enddate},
				success:function(response)
				{
					$.each(response, function(i, item) 
					{	
						barchartLabels.push(item[0]);
						barchartData.push(item[2]);
					});
			}});
			$('#drilldowntable').remove();
			$('#drilldowntable_wrapper').remove();
			table = $('<table class="display table table-bordered" cellspacing="0" id="drilldowntable"></table>');				
			$('#drilltablediv').append(table);
			
			setTimeout(function(){
				$('#barchartheader').text("Top Ten IMSI with Failures ordered by Duration");
				
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
					}]};
					
				barchart =  new Chart(barctx).Bar(data);
				$("#barchart").click( function(evt)
				{
					$('#drilldowntable').remove();
					$('#drilldowntable_wrapper').remove();
					table = $('<table class="display table table-bordered" cellspacing="0" id="drilldowntable"></table>');				
					$('#drilltablediv').append(table);
					
					barchartinfo = barchart.getBarsAtEvent(evt);
					$('#drilldowninfo').text("Displaying failures for IMSI: " + barchartinfo[0].label);
					$.ajax({
						type : 'POST',
						url : "http://localhost:8080/LTEManager/rest/fault/faultsbyimsi",
						dataType : "json",
						data : 
						{
							"imsi": barchartinfo[0].label
						},
						success : function(response) 
						{
							$('#drilldowntable').dataTable( 
							{
								"bDestroy": true,
								"bDeferRender": true,
								"pagingType": "full_numbers",
								"data": response,
								"columns": [
									{ "title": "Event ID" },
									{ "title": "Cause Code" },
									{ "title": "Description" },
									{ "title": "Failure" },
									{ "title": "Date" }
								]
							});        					
						}
					});
					$('#drilldown').modal('show');
				});
			}, 2000);
			
			
				
			$.ajax({
				type: 'POST',
				url: "http://localhost:8080/LTEManager/rest/fault/totalfaults",
				dataType: "json", 
				data: {"startdate": startdate, "enddate": enddate},
				success:function(response)
				{
					$('#datatable').dataTable( 
					{
						"bDestroy": true,
						"bDeferRender": true,
						"pagingType": "full_numbers",
						"data": response,
						"columns": [
							{ "title": "IMSI" },
							{ "title": "Total Failures" },
							{ "title": "Total Duration" }
			            ]
			        }); 
			}});
		}
	}
	else if ($("#querydropdown").attr("value") == "modelfailures") 
	{			
		var model = document.getElementById("modelsearchfield").value;
		if (model == "")
		{
			alert("Please enter a valid model");
		}
		else
		{
			clearChart();
			clearTable();
			table = $('<table class="display table table-bordered" cellspacing="0" id="datatable"><tr></th><th>Event ID</th><th>Cause Code</th><th>Description</th><th>Number of Occurences</th></tr></table>');				
			$('#tablediv').append(table);
			table = $('<table class="display table table-bordered" cellspacing="0" id="drilldowntable"></table>');				
			$('#drilltablediv').append(table);
			$('#graphical').show();
			$('#barchart').hide();
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
						$('#datatable').dataTable( 
						{
							"bDestroy": true,
							"bDeferRender": true,
							"pagingType": "full_numbers",
							"data": response,
							"columns": [
								{ "title": "Event ID" },
								{ "title": "Cause Code" },
								{ "title": "Description" },
								{ "title": "Number of Occurences" }
						    ]
						}); 
						$.each(response, function(i, item) 
						{
							piechartData.push({
								value: response[i][3],
								color: colours[i%10],
								highlight: "#F7464A",
								label: response[i][0] +  ":" + response[i][1] + ": Value "});
						});
					}	
					piechart =  new Chart(piectx).Pie(piechartData,  { tooltipTemplate: " <%=label%>: <%= numeral(value).format('(00[.]00)') %> - <%= numeral(circumference / 6.283).format('(0[.][00]%)') %>" });
					$('#piechartheader').text("Model Failures");

					$("#piechart").click( function(evt)
					{
						$('#drilldowntable').remove();
						$('#drilldowntable_wrapper').remove();
						table = $('<table class="display table table-bordered" cellspacing="0" id="drilldowntable"></table>');				
						$('#drilltablediv').append(table);
						piechartinfo = piechart.getSegmentsAtEvent(evt);
						var ids = piechartinfo[0].label.split(":");
						$('#drilldowninfo').text("Showing failures for model " + model + " with EventID/CauseCode combo: " + ids[0] + "/" + ids[1]);
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
								$('#drilldowntable').dataTable( 
								{
									"bDestroy": true,
									"bDeferRender": true,
									"pagingType": "full_numbers",
									"data": response,
									"columns": [
										{ "title": "Event ID" },
										{ "title": "Cause Code" },
										{ "title": "Description" },
										{ "title": "Failure" },
										{ "title": "Date" },
									]
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
			clearChart();
			clearTable();
			table = $('<table class="display table table-bordered" cellspacing="0" id="datatable"><tr><th>Market ID</th><th>Operator ID</th><th>Cell ID</th><th>Count</th></tr></table>');				
			$('#tablediv').append(table);
			table = $('<table class="display table table-bordered" cellspacing="0" id="drilldowntable"></table>');				
			$('#drilltablediv').append(table);
			$('#graphical').show();
			$('#barchart').hide();
			piechartData = [];

			$.ajax({
				type: 'POST',
				url: "http://localhost:8080/LTEManager/rest/fault/toptenmnnmcncell",
				dataType: "json", 
				data: {"startdate": startdate, "enddate": enddate},
				success:function(response)
				{
					$('#datatable').dataTable( 
					{
						"bDestroy": true,
						"bDeferRender": true,
						"pagingType": "full_numbers",
						"data": response,
						"columns": [
							{ "title": "Market ID" },
							{ "title": "Operator ID" },
							{ "title": "Cell ID" },
							{ "title": "Count" }
						]
					});  
					$.each(response, function(i, item) 
					{
						piechartData.push
						({
							value: item[3],
							color: colours[i%10],
							highlight: "#F7464A",
							label: item[0] + "/" + item[1] + "/" + item[2] + "/  Failures"});	
						});
					
					piechart =  new Chart(piectx).Pie(piechartData,  { tooltipTemplate: " <%=label%>: <%= numeral(value).format('(00[.]00)') %> - <%= numeral(circumference / 6.283).format('(0[.][00]%)') %>" });
					$('#piechartheader').text("Top 10 MCC");
				}});
			
			$("#piechart").click( function(evt)
			{
				$('#drilldowntable').remove();
				$('#drilldowntable_wrapper').remove();
				table = $('<table class="display table table-bordered" cellspacing="0" id="drilldowntable"></table>');				
				$('#drilltablediv').append(table);
				piechartinfo = piechart.getSegmentsAtEvent(evt);
				var ids = piechartinfo[0].label.split("/");
				$('#drilldowninfo').text("Showing failures for Cell: " + ids[2] + " Operator: " + ids[1] + " Market: " + ids[0]);
				$.ajax({
					type : 'POST',
					url : "http://localhost:8080/LTEManager/rest/fault/faultsforcell",
					dataType : "json",
					data : {
						"country": ids[0],
						"operator": ids[1],
						"cellid": ids[2]
					},
					success : function(response) 
					{
						$('#drilldowntable').dataTable( 
						{
							"bDestroy": true,
							"bDeferRender": true,
							"pagingType": "full_numbers",
							"data": response,
							"columns": [
								{ "title": "IMSI" },
								{ "title": "Cause Code" },
								{ "title": "Event ID" },
								{ "title": "Description" },
								{ "title": "Failure" },
								{ "title": "Date" },
							]
						});       					
					}
				});

				$('#drilldown').modal('show'); 		
			});		
		}
	}
	else if ($("#querydropdown").attr("value") == "toptenimsiovertime") 
	{	
		var startdate = $('#startdate').data('date');
		var enddate = $('#enddate').data('date');
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
			clearChart();
			clearTable();
			table = $('<table class="display table table-bordered" cellspacing="0" id="datatable"><tr><th>IMSI</th><th>Count</th></tr></table>');				
			$('#tablediv').append(table);
			table = $('<table class="display table table-bordered" cellspacing="0" id="drilldowntable"></table>');				
			$('#drilltablediv').append(table);
			$('#graphical').show();
			$('#barchart').hide();
			piechartData = [];
			$.ajax({
				type: 'POST',
				url: "http://localhost:8080/LTEManager/rest/fault/toptenimsiovertime",
				dataType: "json", 
				data: {"startdate": startdate, "enddate": enddate},
				success:function(response)
				{
					$('#datatable').dataTable( 
					{
						"bDestroy": true,
						"bDeferRender": true,
						"pagingType": "full_numbers",
						"data": response,
						"columns": [
							{ "title": "IMSI" },
							{ "title": "Count" }
						]
					});   
					$.each(response, function(i, item) 
					{
						piechartData.push({
							value: response[i][1],
							color: colours[i%10],
							highlight: "#F7464A",
							label: response[i][0]});					
							});						

					piechart =  new Chart(piectx).Pie(piechartData,  { responsive: true, tooltipTemplate: " <%=label%>: <%= numeral(value).format('(00[.]00)') %> - <%= numeral(circumference / 6.283).format('(0[.][00]%)') %>" });
					$('#piechartheader').text("Top 10 IMSI");
					$("#piechart").click( function(evt)
					{
						$('#drilldowntable').remove();
						$('#drilldowntable_wrapper').remove();
						table = $('<table class="display table table-bordered" cellspacing="0" id="drilldowntable"></table>');				
						$('#drilltablediv').append(table);
						
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
								$('#drilldowntable').dataTable( 
								{
									"bDestroy": true,
									"bDeferRender": true,
									"pagingType": "full_numbers",
									"data": response,
									"columns": [
										{ "title": "Event ID" },
										{ "title": "Cause Code" },
										{ "title": "Description" },
										{ "title": "Failure" },
										{ "title": "Date" },
									]
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


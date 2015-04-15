var failures = [];
var models = [];
var table;

function clearTable()
{
	$('#datatable').remove();
	$('#datatable_wrapper').remove();
}

$(document).ready(function() 
{
	$.ajax({
		type : 'GET',
		url : "http://localhost:8080/LTEManager/rest/fault/failuredescriptions",
		dataType : "json",
		success : function(response) 
		{
			$.each(response, function(i, item) 
			{
				failures.push(item);
			});
		}});
	
	$.ajax({
		type : 'GET',
		url : "http://localhost:8080/LTEManager/rest/fault/models",
		dataType : "json",
		success : function(response) 
		{
			$.each(response, function(i, item) 
			{
				models.push(item);
			});
		}
		});
	
	$("#modelsearchfield").autocomplete({ source : models, autoFocus : false });
	$("#causecodesearchfield").autocomplete({ source : failures, autoFocus : false });


	 
$("#querydropdown").change(function() 
{
	$("select option:selected").each(function() 
	{
		if ($(this).attr("value") == "imsiwithcallfailure") 
		{
			$("#dates").show();
			$("#causecodes").show();
			$("#causecodesearchfield").prop("disabled",true);
			$("#modelsearch").hide();
			clearTable();
			table = $('<table class="display table table-bordered" cellspacing="0" id="datatable"><tr><th>IMSI</th><th>Description</th><th>Failure</th><th>Operator</th><th>Country</th><th>Duration</th><th>Date</th></tr></table>');
			$('#tableholder').append(table);
		} 
		else if ($(this).attr("value") == "numberoffailures") 
		{
			$("#dates").show();
			$("#causecodes").hide();
			$("#modelsearch").show();
			clearTable();
			table = $('<table class="display table table-bordered" cellspacing="0" id="datatable"><tr><th>Manufacturer</th><th>Total Failures</th></tr></table>');
			$('#tableholder').append(table);
		} 
		else if ($(this).attr("value") == "imsisbycause") 
		{
				$("#dates").hide();
				$("#modelsearch").hide();
				$("#causecodes").show();
				$("#causecodesearchfield").prop("disabled",false);
				clearTable();
				table = $('<table class="display table table-bordered" cellspacing="0" id="datatable"><tr><th>IMSI</th><th>Description</th><th>Operator</th><th>Country</th><th>Date</th></tr></table>');
				$('#tableholder').append(table);
			}
		});
}).change();
});


function submit() 
{
	tabledata = [];
	if ($("#querydropdown").attr("value") == "imsiwithcallfailure") 
	{
		clearTable();
		table = $('<table class="display table table-bordered" cellspacing="0" id="datatable"><tr><th>IMSI</th><th>Description</th><th>Failure</th><th>Operator</th><th>Country</th><th>Duration</th><th>Date</th></tr></table>');
		$('#tableholder').append(table);
		var startdate = $('#startdate').data('date');
		var enddate = $('#enddate').data('date');
		
		$.ajax
		({
			type : 'POST',
			url : "http://localhost:8080/LTEManager/rest/fault/imsifailuresovertime",
			dataType : "json",
			data : 
			{
				"startdate" : startdate,
				"enddate" : enddate
			},
			success : function(response) 
			{	
				$('#datatable').dataTable( 
				{
					"bDeferRender": true,
					"pagingType": "full_numbers",
					"data": response,
					"columns": [
						{ "title": "IMSI" },
						{ "title": "Description" },
						{ "title": "Failure" },
						{ "title": "Operator"},
						{ "title": "Country"},
						{ "title": "Duration"},
						{ "title": "Date"}
                    ]
                }); 			
			},
			error: function(jqXHR,textStatus,errorThrown)
			{
				alert("You need to enter valid dates");
			}
		});
	} 
	else if ($("#querydropdown").attr("value") == "numberoffailures") 
	{
		clearTable();
		table = $('<table class="display table table-bordered" cellspacing="0" id="datatable"><tr><th>Manufacturer</th><th>Total Failures</th></tr></table>');
		$('#tableholder').append(table);
		var startdate = $('#startdate').data('date');
		var enddate = $('#enddate').data('date');
		var model = document.getElementById("modelsearchfield").value;
		
		if(model == "")
		{
			alert("Please enter a model");
		}
		else{
			$.ajax({
				type : 'POST',
				url : "http://localhost:8080/LTEManager/rest/fault/faultsbymodel",
				dataType : "json",
				data : 
				{
					"model" : model,
					"startdate" : startdate,
					"enddate" : enddate
				},
				success : function(response) 
				{
					$('#datatable').dataTable( 
					{
						"bDeferRender": true,
						"pagingType": "full_numbers",
						"data": response,
						"columns": [
							{ "title": "Manufacturer" },
							{ "title": "Total Failures" }
			             ]
			     }); 
				}
			});
		}
	}
	else if ($("#querydropdown").attr("value") == "imsisbycause") 
	{		 
		clearTable();
		table = $('<table class="display table table-bordered" cellspacing="0" id="datatable"><tr><th>IMSI</th><th>Description</th><th>Operator</th><th>Country</th><th>Date</th></tr></table>');
		$('#tableholder').append(table);
		var failure = $("#causecodesearchfield").attr("value");
		var failureCode = failures.indexOf(failure)-1;
		
		$.ajax({
			type : 'POST',
			url : "http://localhost:8080/LTEManager/rest/fault/imsiperfailurecode",
			dataType : "json",
			data : 
			{
				"failure": failureCode
			},
			success : function(response) 
			{
				$('#datatable').dataTable( 
				{
					"bDeferRender": true,
					"pagingType": "full_numbers",
					"data": response,
					"columns": [
						{ "title": "IMSI" },
						{ "title": "Description" },
						{ "title": "Operator" },
						{ "title": "Country" },
						{ "title": "Date" }
				     ]
				 }); 
			}
		});
	}
}
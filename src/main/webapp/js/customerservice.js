var imsis = [];
var table;

function clearTable()
{
	$('#datatable').remove();
	$('#datatable_wrapper').remove();
}
	

$(document).ready(function() 
{
	$('#dates').hide();
	
	$.ajax({
		type : 'GET',
		url : "http://localhost:8080/LTEManager/rest/fault/imsis",
		dataType : "json",
		success : function(response) 
		{
			$.each(response, function(i, item) 
			{
				imsis.push(item.toString());
			});
		}
	});
	
	$("#imsi").autocomplete({ source : imsis, autoFocus : false, minLength:2 });
	
$("select").change(function() 
{
	$("select option:selected").each(function() 
	{
		if ($(this).attr("value") == "callfailures") 
		{
			$("#dates").hide();
			clearTable();
			table = $('<table class="display table table-bordered" cellspacing="0" id="datatable"><tr><th>Event ID</th><th>Cause Code</th><th>Description</th><th>Failure</th><th>Date</th></tr></table>');				
			$('#tableholder').append(table);
		}
		else if ($(this).attr("value") == "numberoffailures") 
		{
			$("#dates").show();
			clearTable();
			table = $('<table class="display table table-bordered" cellspacing="0" id="datatable"><tr><th>Number of Failures</th><th>Total Duration</th></tr></table>');				
			$('#tableholder').append(table);
		}
		else if ($(this).attr("value") == "causecodes") 
		{
			$("#dates").hide();
			clearTable();
			table = $('<table class="display table table-bordered" cellspacing="0" id="datatable"><tr><th>Cause Code</th><th>Count</th></tr></table>');				
			$('#tableholder').append(table);
		}
	});
}).change();
});


function submit() 
{
	if ($("#querydropdown").attr("value") == "callfailures") 
	{
		clearTable();
		table = $('<table class="display table table-bordered" cellspacing="0" id="datatable"><tr><th>Event ID</th><th>Cause Code</th><th>Description</th><th>Failure</th><th>Date</th></tr></table>');				
		$('#tableholder').append(table);
		var imsi = document.getElementById("imsi").value;
		if (imsi == "") 
		{
			alert("Please enter a VALID IMSI. (Numbers only, 15 digits)");
		} 
		else 
		{
			$.ajax({
				type : 'POST',
				url : "http://localhost:8080/LTEManager/rest/fault/faultsbyimsi",
				dataType : "json",
				data : 
				{
					"imsi" : imsi
				},
				success : function(response) 
				{
					if (response == "") 
					{
						alert("No data for given IMSI");
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
								{ "title": "Failure"},
								{ "title": "Date"}
				              ]
				      }); 
					}
				}
			});
		}
	} 
	else if ($("#querydropdown").attr("value") == "numberoffailures") 
	{
		clearTable();
		table = $('<table class="display table table-bordered" cellspacing="0" id="datatable"></table>');				
		$('#tableholder').append(table);
		var startdate = $('#startdate').data('date');
		var enddate = $('#enddate').data('date');
		var imsi = document.getElementById("imsi").value;

		if (imsi == "") 
		{
			alert("Please enter a VALID IMSI. (Numbers only, 15 digits)");
		}
		else if (startdate == "")
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
				type : 'POST',
				url : "http://localhost:8080/LTEManager/rest/fault/imsicount",
				dataType : "json",
				data : 
				{
					"startdate" : startdate,
					"enddate" : enddate,
					"imsi" : imsi
				},
				success : function(response) 
				{
					$('#datatable').dataTable( 
					{
						"bDestroy": true,
						"bDeferRender": true,
						"pagingType": "full_numbers",
						"data": response,
						"columns": [
							{ "title": "Number of Failures" },
							{ "title": "Total Duration" }
					]}); 
					
				
				},
				error : function(jqXHR, textStatus, errorThrown) 
				{
					alert("You need to enter an IMSI");
				}
			});
		}
	} 
	else if ($("#querydropdown").attr("value") == "causecodes") 
	{
		clearTable();
		table = $('<table class="display table table-bordered" cellspacing="0" id="datatable"><tr><th>Cause Code</th><th>Count</th></tr></table>');				
		$('#tableholder').append(table);
		var imsi = document.getElementById("imsi").value;
		if (imsi == "") 
		{
			alert("Please enter a VALID IMSI. (Numbers only, 15 digits)");
		}
		else 
		{
			$.ajax({
				type : 'POST',
				url : "http://localhost:8080/LTEManager/rest/fault/imsicausecodes",
				dataType : "json",
				data : 
				{
					"imsi" : imsi
				},
				success : function(response) 
				{
					$('#datatable').dataTable( 
					{
						"bDestroy": true,
						"bDeferRender": true,
						"pagingType": "full_numbers",
						"data": response,
						"columns": [
							{ "title": "Cause Code" },
							{ "title": "Count" }
					]
					}); 
				},
				error : function(jqXHR, textStatus, errorThrown) 
				{
					alert("You need to enter an IMSI");
				}
			});
		}
	}
}


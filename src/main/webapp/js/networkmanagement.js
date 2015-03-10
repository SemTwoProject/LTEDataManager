$(document).ready(function() {
	$("#querydropdown").change(function() {
		$("select option:selected").each(function() {
			if ($(this).attr("value") == "totalfaults") 
			{			
				$("#dates").show();
				$("#phonemodeldropdown").prop("disabled", true);
				$('#datatable').empty();
				var table = $('<tr><th>IMSI</th><th>Total Failures</th><th>Total Duration</th></tr>');				
				$('#datatable').append(table);
			}
			if ($(this).attr("value") == "query2") 
			{				
				$("#dates").hide();
				$("#phonemodeldropdown").prop("disabled", false);
				$('#datatable').empty();
				var table = $('<tr><th>Phone Model</th><th>Event ID and Cause Code combination</th><th>Number of Occurences</th></tr>');				
				$('#datatable').append(table);
			}
			if ($(this).attr("value") == "query3") 
			{		
				$("#dates").show();
				$("#phonemodeldropdown").prop("disabled", true);
				$('#datatable').empty();
				var table = $('<tr><th>Rank</th><th>Market ID</th><th>Operator ID</th><th>Call ID</th></tr>');				
				$('#datatable').append(table);
			}
			if ($(this).attr("value") == "toptenimsiovertime") 
			{		
				$("#dates").show();
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
	else if ($("#querydropdown").attr("value") == "toptenimsiovertime") 
	{			
		var startdate = $('#startdate').data('date');
		var enddate = $('#enddate').data('date');
		
		$('#datatable').empty();
		var table = $('<tr><th>IMSI</th><th>Count</th></tr>');				
		$('#datatable').append(table);
		
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
});
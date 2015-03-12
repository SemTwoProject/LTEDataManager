$(document).ready(function() {
	$("#querydropdown").change(function() {
		$("select option:selected").each(function() {
			if ($(this).attr("value") == "imsiwithcallfailure") 
			{				
				$("#dates").show();
				$("#causecodesdropdown").prop("disabled", true);
				$("#modelsearch").hide();
				$('#datatable').empty();
				var table = $('<tr><th>IMSI</th><th>Event ID</th><th>Time</th></tr>');				
				$('#datatable').append(table);
			}
			if ($(this).attr("value") == "numberoffailures") 
			{
				$("#dates").show();
				$("#causecodes").hide();
				$("#modelsearch").show();
				$('#datatable').empty();
				var table = $('<tr><th>Phone Model</th><th>Total Failures</th></tr>');				
				$('#datatable').append(table);
			}
			if ($(this).attr("value") == "query3") 
			{
				$("#dates").hide();
				$("#modelsearch").hide();
				$("#causecodes").show();
				$('#datatable').empty();
				var table = $('<tr><th>IMSI</th><th>Time</th></tr>');				
				$('#datatable').append(table);
			}
		});
	}).change();
});


function submit()
		{
		if ($("#querydropdown").attr("value") == "imsiwithcallfailure") 
		{			
			var startdate = $('#startdate').data('date');
			var enddate = $('#enddate').data('date');
			$('#datatable').empty();
			var table = $('<tr><th>IMSI</th><th>Event ID</th><th>Time</th></tr>');				
			$('#datatable').append(table);
			$.ajax({
				type: 'POST',
				url: "http://localhost:8080/LTEManager/rest/fault/imsifailuresovertime",
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
		if ($("#querydropdown").attr("value") == "numberoffailures") 
		{			
			var startdate = $('#startdate').data('date');
			var enddate = $('#enddate').data('date');
			var model = document.getElementById("modelsearchbar").value;
			$('#datatable').empty();
			var table = $('<tr><th>Phone Model</th><th>Total Failures</th></tr>');				
			$('#datatable').append(table);
			
			$.ajax({
				type: 'POST',
				url: "http://localhost:8080/LTEManager/rest/fault/faultsbymodel",
				dataType: "json", 
				data: {"model": model, "startdate": startdate, "enddate": enddate},
				success:function(response)
				{
					$.each(response, function(i, item) 
					{
						alert("test3");
						$tr = "";
						$tr = $('<tr>').append(
								$('<td>').text(item[0]),
								$('<td>').text(item[1]));
						$('#datatable').append($tr);
					});          	
			}});			
		}}
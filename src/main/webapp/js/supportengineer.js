$(document).ready(function() 
		{
	$("#querydropdown").change(function() 
			{
		$("select option:selected").each(function() 
				{
			if ($(this).attr("value") == "imsiwithcallfailure") 
			{
				$("#dates").show();
				$("#causecodesdropdown").prop("disabled",true);
				$("#causecodes").show();
				$("#modelsearch").hide();
				$('#datatable').empty();
				var table = $('<tr><th>IMSI</th><th>Event ID</th><th>Time</th></tr>');
				$('#datatable').append(table);
			} 
			else if ($(this).attr("value") == "numberoffailures") 
			{
				$("#dates").show();
				$("#causecodes").hide();
				$("#modelsearch").show();
				$('#datatable').empty();
				var table = $('<tr><th>Phone Model</th><th>Total Failures</th></tr>');
				$('#datatable').append(table);
			} 
			else if ($(this).attr("value") == "imsisbycause") 
			{
				$("#dates").hide();
				$("#modelsearch").hide();
				$("#causecodes").show();
				$("#causecodesdropdown").prop("disabled",false);
				$('#datatable').empty();
				var table = $('<tr><th>IMSI</th><th>Time</th></tr>');
				$('#datatable').append(table);
			}
				});}).change();
		});

function submit() {
	if ($("#querydropdown").attr("value") == "imsiwithcallfailure") 
	{
		var startdate = $('#startdate').data('date');
		var enddate = $('#enddate').data('date');
		$('#datatable').empty();
		var table = $('<tr><th>IMSI</th><th>Event ID</th><th>Time</th></tr>');
		$('#datatable').append(table);
		$
		.ajax({
			type : 'POST',
			url : "http://localhost:8080/LTEManager/rest/fault/imsifailuresovertime",
			dataType : "json",
			data : {
				"startdate" : startdate,
				"enddate" : enddate
			},
			success : function(response) {
				$.each(response, function(i, item) {
					$tr = "";
					$tr = $('<tr>').append($('<td>').text(item[0]),
							$('<td>').text(item[1]),
							$('<td>').text(item[2]));
					$('#datatable').append($tr);
				});
			},
			error: function(jqXHR,textStatus,errorThrown)
			{
				alert("You need to enter valid dates");
			}
		});
	} 
	else if ($("#querydropdown").attr("value") == "numberoffailures") {
		var startdate = $('#startdate').data('date');
		var enddate = $('#enddate').data('date');
		var model = document.getElementById("modelsearchfield").value;
		$('#datatable').empty();
		var table = $('<tr><th>Phone Model</th><th>Total Failures</th></tr>');
		$('#datatable').append(table);

		if(model == ""){
			alert("Please enter a model");
		}
		else{
			$.ajax({
				type : 'POST',
				url : "http://localhost:8080/LTEManager/rest/fault/faultsbymodel",
				dataType : "json",
				data : {
					"model" : model,
					"startdate" : startdate,
					"enddate" : enddate
				},
				success : function(response) {
					if (response == ""){
						alert("No data for that model");
					}
					$.each(response, function(i, item) {
						$tr = "";
						$tr = $('<tr>').append($('<td>').text(item[0]),
								$('<td>').text(item[1]));
						$('#datatable').append($tr);
					});
				}
			});
		}
	}
	else if ($("#querydropdown").attr("value") == "imsisbycause") 
	{		 
		var cause = $("#querydropdown").attr("value");
		$('#datatable').empty();
		var table = $('<tr><th>IMSI</th><th>Time</th></tr>');
		$('#datatable').append(table);

		$.ajax({
			type : 'POST',
			url : "http://localhost:8080/LTEManager/rest/fault/imsiperfailurecode",
			dataType : "json",
			data : 
			{
				"cause": cause
			},
			success : function(response) 
			{
				$.each(response, function(i, item) 
						{
					$tr = "";
					$tr = $('<tr>').append(
							$('<td>').text(item[0]),
							$('<td>').text(item[1]));
					$('#datatable').append($tr);
						});
			}
		});
	}
}
var failures = [];
var models = [];
$(document).ready(function() 
		{

	$.ajax({
		type : 'GET',
		url : "http://localhost:8080/LTEManager/rest/fault/failuredescriptions",
		dataType : "json",
		success : function(response) {
		$.each(response, function(i, item) {
		failures.push(item);
		});
	},
	});
	$.ajax({
		type : 'GET',
		url : "http://localhost:8080/LTEManager/rest/fault/models",
		dataType : "json",
		success : function(response) {
		$.each(response, function(i, item) {
		models.push(item);
		});
	},
	});
	$("#querydropdown").change(function() 
			{
		$("select option:selected").each(function() 
				{
			if ($(this).attr("value") == "imsiwithcallfailure") 
			{
				$("#dates").show();
				$("#causecodesdropdown").prop("disabled",true);
				$("#causecodes").hide();
				$("#modelsearch").hide();
				$('#datatable').empty();
				var table = $('<tr><th>IMSI</th><th>Description</th><th>Failure</th><th>Operator</th><th>Country</th><th>Duration</th><th>Date</th></tr>');
				$('#datatable').append(table);
			} 
			else if ($(this).attr("value") == "numberoffailures") 
			{
				$("#modelsearchfield").autocomplete({
					source : models,
					autoFocus : false,
					});
				$("#dates").show();
				$("#causecodes").hide();
				$("#modelsearch").show();
				$('#datatable').empty();
				var table = $('<tr><th>Manufacturer</th><th>Total Failures</th></tr>');
				$('#datatable').append(table);
			} 
			else if ($(this).attr("value") == "imsisbycause") 
			{
				$("#causecodesearchfield").autocomplete({
					source : failures,
					autoFocus : false,
					});
				$("#dates").hide();
				$("#modelsearch").hide();
				$("#causecodes").show();
				$("#causecodesearchfield").prop("disabled",false);
				$('#datatable').empty();
				var table = $('<tr><th>IMSI</th><th>Description</th><th>Operator</th><th>Country</th><th>Date</th></tr>');
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
		var table = $('<tr><tr><th>IMSI</th><th>Description</th><th>Failure</th><th>Operator</th><th>Country</th><th>Duration</th><th>Date</th></tr></tr>');
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
							$('<td>').text(item[2]),
							$('<td>').text(item[3]),
							$('<td>').text(item[4]),
							$('<td>').text(item[5]),
							$('<td>').text(item[6]));
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
		var table = $('<tr><th>Manufacturer</th><th>Total Failures</th></tr>');
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
		var failure = $("#causecodesearchfield").attr("value");
		var failureCode = failures.indexOf(failure)-1;
		$('#datatable').empty();
		var table = $('<tr><th>IMSI</th><th>Description</th><th>Operator</th><th>Country</th><th>Date</th></tr>');
		$('#datatable').append(table);

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
				if (response == ""){
					alert("No data for that failure");
				}
				$.each(response, function(i, item) 
						{
					$tr = "";
					$tr = $('<tr>').append(
							$('<td>').text(item[0]),
							$('<td>').text(item[1]),
							$('<td>').text(item[2]),
							$('<td>').text(item[3]),
							$('<td>').text(item[4]));
					$('#datatable').append($tr);
						});
			}
		});
	}
}
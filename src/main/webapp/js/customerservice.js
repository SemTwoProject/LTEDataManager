$('#dates').hide();

$(document).ready(function() 
		{
	$("select").change(function() 
			{
		$("select option:selected").each(function() 
				{
			if ($(this).attr("value") == "callfailures") 
			{
				$("#dates").hide();
				$('#datatable').empty();
				var table = $('<tr><th>Event ID</th><th>Cause Code</th><th>Description</th><th>Failure</th><th>Date</th></tr>');				
				$('#datatable').append(table);
			}
			else if ($(this).attr("value") == "numberoffailures") 
			{
				$("#dates").show();
				$('#datatable').empty();
				var table = $('<tr><th>Number of Failures</th></tr>');				
				$('#datatable').append(table);
			}
			else if ($(this).attr("value") == "causecodes") 
			{
				$("#dates").hide();
				$('#datatable').empty();
				var table = $('<tr><th>Cause Code</th><th>Count</th></tr>');				
				$('#datatable').append(table);
			}
				});
			}).change();
		});


function submit() {
	if ($("#querydropdown").attr("value") == "callfailures") {
		var imsi = document.getElementById("imsi").value;
		$('#datatable').empty();
		var table = $('<tr><th>Event ID</th><th>Cause Code</th><th>Description</th><th>Failure</th><th>Date</th></tr>');
		$('#datatable').append(table);
		if (imsi == "") {
			alert("Please enter a VALID IMSI. (Numbers only, 15 digits)");
		} 
		else {
			$.ajax({
				type : 'POST',
				url : "http://localhost:8080/LTEManager/rest/fault/faultsbyimsi",
				dataType : "json",
				data : {
					"imsi" : imsi
				},
				success : function(response) {
					if (response == "") {
						alert("No data for given IMSI");
					} else {
						$.each(response, function(i, item) {
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
				}
			});
		}
	} 
	else if ($("#querydropdown").attr("value") == "numberoffailures") {
		var startdate = $('#startdate').data('date');
		var enddate = $('#enddate').data('date');
		var imsi = document.getElementById("imsi").value;

		$('#datatable').empty();
		var table = $('<tr><th>Number of Failures</th></tr>');
		$('#datatable').append(table);
		if (imsi == "") {
			alert("Please enter a VALID IMSI. (Numbers only, 15 digits)");
		}
		else if (startdate == ""){
			alert("Please enter a VALID Start Date");
		}
		else if (enddate == ""){
			alert("Please enter a VALID End Date");
		}
		else {
			$.ajax({
				type : 'POST',
				url : "http://localhost:8080/LTEManager/rest/fault/imsicount",
				dataType : "json",
				data : {
					"startdate" : startdate,
					"enddate" : enddate,
					"imsi" : imsi
				},
				success : function(response) {
					$.each(response, function(i, item) {
						$tr = "";
						$tr = $('<tr>').append($('<td>').text(item[0]));
						$('#datatable').append($tr);
					});
				},
				error : function(jqXHR, textStatus, errorThrown) {
					alert("You need to enter an IMSI");
				}

			});
		}
	} else if ($("#querydropdown").attr("value") == "causecodes") {
		var imsi = document.getElementById("imsi").value;
		$('#datatable').empty();
		var table = $('<tr><th>Cause Code</th><th>Count</th></tr>');
		$('#datatable').append(table);
		if (imsi == "") {
			alert("Please enter a VALID IMSI. (Numbers only, 15 digits)");
		} else {
			$
			.ajax({
				type : 'POST',
				url : "http://localhost:8080/LTEManager/rest/fault/imsicausecodes",
				dataType : "json",
				data : {
					"imsi" : imsi
				},
				success : function(response) {
					$.each(response, function(i, item) {
						$tr = "";
						$tr = $('<tr>').append
						($('<td>').text(item[0]),
						$('<td>').text(item[1]));
						$('#datatable').append($tr);
					});
				},
				error : function(jqXHR, textStatus, errorThrown) {
					alert("You need to enter an IMSI");
				}
			});
		}
	}
}

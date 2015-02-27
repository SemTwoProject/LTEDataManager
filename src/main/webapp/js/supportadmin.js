$(document).ready(function() {
	$("#querydropdown").change(function() {
		$("select option:selected").each(function() {
			if ($(this).attr("value") == "query1") 
			{				
				$("#dates").show();
				$("#causecodesdropdown").prop("disabled", true);
				$('#datatable').empty();
				var table = $('<tr><th>IMSI</th><th>Event ID</th><th>Time</th></tr>');				
				$('#datatable').append(table);
			}
			if ($(this).attr("value") == "query2") 
			{
				$("#dates").show();
				$("#causecodesdropdown").prop("disabled", true);
				$('#datatable').empty();
				var table = $('<tr><th>Phone Model</th><th>Total Failures</th></tr>');				
				$('#datatable').append(table);
			}
			if ($(this).attr("value") == "query3") 
			{
				$("#dates").hide();
				$("#causecodesdropdown").prop("disabled", false);
				$('#datatable').empty();
				var table = $('<tr><th>IMSI</th><th>Time</th></tr>');				
				$('#datatable').append(table);
			}
		});
	}).change();
});
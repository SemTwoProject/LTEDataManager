$('#dates').hide();

$(document).ready(function() {
	$("select").change(function() {
		$("select option:selected").each(function() {
			if ($(this).attr("value") == "1") 
			{
				$("#dates").hide();
				$('#datatable').empty();
				var table = $('<tr><th>IMSI</th><th>Event ID</th><th>Cause Code</th></tr>');				
				$('#datatable').append(table);
			}
			if ($(this).attr("value") == "2") 
			{
				$("#dates").show();
				$('#datatable').empty();
				var table = $('<tr><th>IMSI</th><th>Number of Failures</th></tr>');				
				$('#datatable').append(table);
			}
			if ($(this).attr("value") == "3") 
			{
				$("#dates").hide();
				$('#datatable').empty();
				var table = $('<tr><th>IMSI</th><th>Cause Code</th></tr>');				
				$('#datatable').append(table);
			}
		});
	}).change();
});
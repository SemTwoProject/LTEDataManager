$(document).ready(function() {
	$("#querydropdown").change(function() {
		$("select option:selected").each(function() {
			if ($(this).attr("value") == "query1") 
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
			if ($(this).attr("value") == "query4") 
			{		
				$("#dates").show();
				$("#phonemodeldropdown").prop("disabled", true);
				$('#datatable').empty();
				var table = $('<tr><th>Rank</th><th>IMSI</th></tr>');				
				$('#datatable').append(table);
			}
		});
	}).change();
});
$(document).ready(function() {
	$("#querydropdown").change(function() {
		$("select option:selected").each(function() {
			if ($(this).attr("value") == "totalfaults") 
			{			
				$("#dates").show();
				$("#phonemodelsearch").hide();
				$('#datatable').empty();
				var table = $('<tr><th>IMSI</th><th>Total Failures</th><th>Total Duration</th></tr>');				
				$('#datatable').append(table);			
			}
			if ($(this).attr("value") == "query2") 
			{				
				$("#dates").hide();
				$("#phonemodelsearch").show();
				$('#datatable').empty();
				var table = $('<tr><th>Phone Model</th><th>Event ID and Cause Code combination</th><th>Number of Occurences</th></tr>');				
				$('#datatable').append(table);
			}
			if ($(this).attr("value") == "query3") 
			{		
				$("#dates").show();
				$("#phonemodelsearch").hide();
				$('#datatable').empty();
				var table = $('<tr><th>Rank</th><th>Market ID</th><th>Operator ID</th><th>Call ID</th></tr>');				
				$('#datatable').append(table);
			}
			if ($(this).attr("value") == "query4") 
			{		
				$("#dates").show();
				$("#phonemodelsearch").hide();
				$('#datatable').empty();
				var table = $('<tr><th>Rank</th><th>IMSI</th></tr>');				
				$('#datatable').append(table);
			}
		});
	}).change();
});


$("#submit").click(function()
{
	var startdate = $('#startdate').data('date');
	var enddate = $('#enddate').data('date');
	
	if ($("#querydropdown").attr("value") == "totalfaults") 
	{	
		 $.ajax({
		        type: 'POST',
		        url: "http://localhost:8080/LTEManager/rest/fault/totalfaults",
		        dataType: "json", 
		        data: {"startdate": startdate, "enddate": enddate},
		        success:function(response)
		        {
		        	$.each(response, function(i, item) 
		        	{
		        		alert(item);
		        	});          	
		        }});
					
	}
});


//$.post("/rest/fault/totalfaults",
//		{
//			startdate: startdate,
//			enddate: enddate
//		},
//		 function(response)
//	        {
//	        	var $tr;
//	        	$.each(response, function(i, item) 
//	        	{
//	        		alert(response);
//	        		$tr = "";
//	        		$tr = $('<tr>').append(
//	                $('<td>').text(item.get(0)),
//	        	    $('<td>').text(item.get(1)),
//	        	    $('<td>').text(item.get(2)));
//	            	$('#usertable').append($tr);
//	        	});  
//	        });
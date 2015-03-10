$(document).ready(function() {
	$("#querydropdown").change(function() {
		$("select option:selected").each(function() {
			if ($(this).attr("value") == "query1") 
			{				
				$("#dates").show();
				$("modelsearch").hide();
				$("#causecodesdropdown").prop("disabled", true);
				$('#datatable').empty();
				var table = $('<tr><th>IMSI</th><th>Event ID</th><th>Time</th></tr>');				
				$('#datatable').append(table);
			}
			if ($(this).attr("value") == "numberoffailures") 
			{
				$("#dates").show();
				$("#causecodes").hide();
				$("modelsearch").show();
				$('#datatable').empty();
				var table = $('<tr><th>Phone Model</th><th>Total Failures</th></tr>');				
				$('#datatable').append(table);
			}
			if ($(this).attr("value") == "query3") 
			{
				$("#dates").hide();
				$("modelsearch").hide();
				$("#causecodes").show();
				$("#causecodesdropdown").prop("disabled", false);
				$('#datatable').empty();
				var table = $('<tr><th>IMSI</th><th>Time</th></tr>');				
				$('#datatable').append(table);
			}
		});
	}).change();
});
$("#submit").click(function()
{
	var startdate = $('#startdate').data('date');
	var enddate = $('#enddate').data('date');
	var model = $('modelsearchbar').val();
	alert(startdate);
	alert(enddate);
	alert(model);


	$('#datatable').empty();
	var table = $('<tr><th>Model</th><th>Total Failures</th>');
	$('#datatable').append(table);
	if($("#querydropdown").attr("value") == "numberoffailures"){
					

			$.ajax({
				type: 'POST',
				url: "http://localhost:8080/LTEManager/rest/fault/faultsbymodel",
				dataType: "json", 
				data: {"model": model,"startdate": startdate, "enddate": enddate},
				success:function(response)
				{
					$.each(response, function(i, item) 
							{
						$tr = "";
						$tr = $('<tr>').append(
								$('<td>').text(model),
								$('<td>').text(item[0]));
						$('#datatable').append($tr);
							});          	
				}});			
		}
	
});
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
				var table = $('<tr><th>IMSI</th><th>Event ID</th><th>Cause Code</th></tr>');				
				$('#datatable').append(table);
			}
			else if ($(this).attr("value") == "numberoffailures") 
			{
				$("#dates").show();
				$('#datatable').empty();
				var table = $('<tr><th>IMSI</th><th>Number of Failures</th></tr>');				
				$('#datatable').append(table);
			}
			else if ($(this).attr("value") == "causecodes") 
			{
				$("#dates").hide();
				$('#datatable').empty();
				var table = $('<tr><th>IMSI</th><th>Cause Code</th></tr>');				
				$('#datatable').append(table);
			}
				});
			}).change();
		});

function submit()
{
	if ($("#querydropdown").attr("value") == "callfailures") 
	{			
		var imsi = document.getElementById("imsi").value;
		$('#datatable').empty();
		var table = $('<tr><th>IMSI</th><th>Event ID</th><th>Cause Code</th></tr>');				
		$('#datatable').append(table);
		$.ajax({
			type: 'POST',
			url: "http://localhost:8080/LTEManager/rest/fault/faultsbyimsi",
			dataType: "json", 
			data: {"startdate": startdate, "enddate": enddate, "imsi":imsi},
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
			},
			error: function(jqXHR,textStatus,errorThrown)
			{
				alert("enter an imsi");
			}
		});			
	}
	else if ($("#querydropdown").attr("value") == "numberoffailures") 
	{			
		var startdate = $('#startdate').data('date');
		var enddate = $('#enddate').data('date');
		var imsi = document.getElementById("imsi").value;


		$('#datatable').empty();
		var table = $('<tr><th>IMSI</th><th>Number of Failures</th></tr>');				
		$('#datatable').append(table);				
		$.ajax({
			type: 'POST',
			url: "http://localhost:8080/LTEManager/rest/fault/imsicount",
			dataType: "json", 
			data: {"startdate": startdate, "enddate": enddate, "imsi":imsi},
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
			},
			error: function(jqXHR,textStatus,errorThrown)
			{
				alert("enter an imsi");
			}

		});			
	}
	else if ($("#querydropdown").attr("value") == "causecodes") 
	{
		var imsi = document.getElementById("imsi").value;
		$('#datatable').empty();
		var table = $('<tr><th>IMSI</th><th>Cause Code</th></tr>');				
		$('#datatable').append(table);		
		$.ajax({
			type: 'POST',
			url: "http://localhost:8080/LTEManager/rest/fault/imsicausecodes",
			dataType: "json", 
			data: {"imsi":imsi},
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
			},
			error: function(jqXHR,textStatus,errorThrown)
			{
				alert("enter an imsi");
			}
		});		
	}
}


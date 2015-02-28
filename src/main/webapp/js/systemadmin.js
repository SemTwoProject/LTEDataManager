$(document).ready(function() 
{	
	$('#usertable').empty();
	var table = $('<tr><th>User ID</th><th>Name</th></tr>');				
	$('#usertable').append(table);
	findAllUsers();
	
});

function findAllUsers() 
{
    $.ajax({
        type: 'GET',
        url: "http://localhost:8080/LTEManager/rest/users/list",
        dataType: "json", // data type of response
        success:function(response)
        {
        	var $tr;
        	$.each(response, function(i, item) 
        	{
        		$tr = "";
        		$tr = $('<tr>').append(
                $('<td>').text(item.id),
        	    $('<td>').text(item.name));
            	$('#usertable').append($tr);
        	});          	
        }});
}
$(document).ready(
	function() {

		// SUBMIT FORM
		$("#viewHr").submit(function(event) {
			// Prevent the form from submitting via the browser.
			event.preventDefault();
			ajaxGet();
		});

	});
	
// DO GET
var globleTableData=[]

function decPageNo()
{
	let page=Number($('#customerPageNo').text())
	//console.log(page,'prev')
	if(page!=1)
	page-=1
	pagedata(page)
;
	$('#customerPageNo').text(page)

}

function incPageNo()
{
	let page=Number($('#customerPageNo').text())
	//console.log(page,'prev')
	pagedata(page+1);
	$('#customerPageNo').text(page+1)
}
function pagedata(pageno){
	let tableData="";
	let startno=(pageno-1)*5
	let endno=(pageno*5)
	data=globleTableData.slice(startno,endno)
	data.forEach(function(item) {
				tableData += '<tr>' +
					'<td id = "Id' + item.hid + '">' + item.hid + '</td>' +
					'<td id = "Name' + item.name + '">' + item.name + '</td>' +
					'<td id = "Email' + item.email + '">' + item.email + '</td>' +
					'<td id = "Gender' + item.gender + '">' + item.gender + '</td>' +
					'<td id = "city' + item.city + '">' + item.city + '</td>' +
					'<td id = "Contact' + item.contactno + '">' + item.contactno + '</td>' +
					'<td id = "Password' + item.password + '">' + item.password + '</td>' +
					'<td>' +
					'<button type = "button" id = "edit' + item.hid + '" class = "btn btn-warning btn-md edit">Edit</button>' +
					'</td>' +
					'<td>' +
					'<button type = "button" id = "delet' + item.hid + '" class = "btn btn-danger btn-md delet" onclick = "delet(' + item.hid + ')">Delete</button>' +
					'</td>' +
					 
				
					'</tr>';
			});
			$("#myTable>tbody").html(tableData);
}













function ajaxGet() {
    var keyword = $("#keyword").val();
	var tableData = "";
	$.ajax({
		type: "GET",
		url: "/admin/hrs",
		data:{keyword: keyword},
		success: function(data) {
			globleTableData=data
			let page=Number($('#customerPageNo').text())
			console.log(globleTableData,'globleTableData')
			pagedata(page)

		},
	 	
	});
}


$(document).ready(function() {
	ajaxGet();
})

 //Delete 
function delet(hid){
	if (confirm('Do you really want to delete record?')) {
		var parent = $(this).parent().parent();
		alert(hid);
		$.ajax({
		type: "DELETE",
			url: "/admin/hrs/" +hid,
			cache: false,
			success: function() {
				parent.fadeOut('slow', function() {
					$(this).remove();
				});
				location.reload(true)
			},
			error: function() {
				$('#err').html('<span style=\'color:red; font-weight: bold; font-size: 30px;\'>Error deleting record').fadeIn().fadeOut(4000, function() {
					$(this).remove();
			});
			}
		});
	}
};



/* Edit */

$(document).delegate('.edit', 'click', function() {

	var parent = $(this).parent().parent();
	
	var hid = parent.children("td:nth-child(1)");
	var name = parent.children("td:nth-child(2)");
	var email = parent.children("td:nth-child(3)");
	var gender = parent.children("td:nth-child(4)");
	var city = parent.children("td:nth-child(5)");
	var contactno = parent.children("td:nth-child(6)");
	var password = parent.children("td:nth-child(7)");
	
    var buttons = parent.children("td:nth-child(8)");
    
   
	name.html("<input type='text' id='name' value='" + name.html() + "'/>");
	email.html("<input type='text' id='email' value='" + email.html() + "'/>");
	gender.html("<input type='text' id=gender  value='"+ gender.html() +"'/>");
	city.html("<input type='text' id='city' value='" + city.html() + "'/>");
	contactno.html("<input type='text' id='contactno' value='" + contactno.html() + "'/>");
	password.html("<input type='text' id='password' value='" + password.html() + "'/>");	
	buttons.html("<button id='save' class= 'btn btn-success'>Save</button>");
	
});

$(document).delegate('#save', 'click', function() {
	var parent = $(this).parent().parent();
	
	var hid = parent.children("td:nth-child(1)");
	var name = parent.children("td:nth-child(2)");
	var email = parent.children("td:nth-child(3)");
	var gender = parent.children("td:nth-child(4)");
	var city = parent.children("td:nth-child(5)");
	var contactno = parent.children("td:nth-child(6)");
	var password = parent.children("td:nth-child(7)");
    var buttons = parent.children("td:nth-child(8)");
    
    
    
	$.ajax({
		type: "POST",
		contentType: "application/json; charset=utf-8",
		url: "/admin/updateHrs",
		data: JSON.stringify({
			'hid': hid.html(), 'name': name.children("input[type=text]").val(),'email':email.children("input[type=text]").val(),'gender':gender.children("input[type=text]").val(), 
			'city': city.children("input[type=text]").val(),
			'contactno': contactno.children("input[type=text]").val(), 'password':password.children("input[type=text]").val(),
		}),
		cache: false,
		success: function() {
	    	name.html(name.children("input[type=text]").val());
	    	email.html(email.children("input[type=text]").val());
	    	gender.html(gender.children("input[type=text]").val());
	    	city.html(city.children("input[type=text]").val());
	    	contactno.html(contactno.children("input[type = text]").val());
	    	 password.html(password.children("input[type=text]").val()); 
	        
			buttons.html("<button class='btn btn-warning edit' id='" + hid.html() + "'>Edit</button>");
		},

	});

});



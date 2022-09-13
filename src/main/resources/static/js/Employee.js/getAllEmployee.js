	$(document).ready(
	function() {

		// SUBMIT FORM
		$("#viewEmployee").submit(function(event) {
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
					'<td id = "Id' + item.id + '">' + item.id + '</td>' +
					'<td id = "Name' + item.name + '">' + item.name + '</td>' +
					'<td id = "Email' + item.email + '">' + item.email + '</td>' +
					'<td id = "Gender' + item.gender + '">' + item.gender + '</td>' +
					'<td id = "city' + item.city + '">' + item.city + '</td>' +
					'<td id = "Department' + item.department + '">' + item.department + '</td>' +
					'<td id = "DOB' + item.dob + '">' + item.dob + '</td>' +
					'<td id = "Salary' + item.salary + '">' + item.salary + '</td>' +
					'<td id = "Contact' + item.contactno + '">' + item.contactno + '</td>' +
					'<td id = "Password' + item.password + '">' + item.password + '</td>' +
					
					
					
					'<td>' +
					'<button type = "button" id = "edit' + item.id + '" class = "btn btn-warning btn-md edit">Edit</button>' +
					'</td>' +
					'<td>' +
					'<button type = "button" id = "delet' + item.id + '" class = "btn btn-danger btn-md delet" onclick = "delet(' + item.id + ')">Delete</button>' +
					'</td>' +
					'<td id = "Projects' + item.id + '">' + '<a href="/hr/getProjects/' + item.id + '"+" class = "btn btn-warning btn-md "">' + 'Projects' + 
					'</td>' +
					'</tr>';
					 
					
					'</tr>';
			});
			$("#myTable>tbody").html(tableData);
}







function ajaxGet() {
    var keyword = $("#keyword").val();
	var tableData = "";
	$.ajax({
		type: "GET",
		url: "/hr/employees",
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



/* Delete */
function delet(id){
	if (confirm('Do you really want to delete record?')) {
		var parent = $(this).parent().parent();
		alert(id);
		$.ajax({
			type: "DELETE",
			url: "/hr/employees/" +id,
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
	var id = parent.children("td:nth-child(1)");
	var name = parent.children("td:nth-child(2)");
	var email = parent.children("td:nth-child(3)");
	var gender = parent.children("td:nth-child(4)");
	var city = parent.children("td:nth-child(5)");
	var department = parent.children("td:nth-child(6)");
	var dob = parent.children("td:nth-child(7)");
	var salary = parent.children("td:nth-child(8)");
	var contactno = parent.children("td:nth-child(9)");
	var password = parent.children("td:nth-child(10)");
    var buttons = parent.children("td:nth-child(11)");
    
    
   
	name.html("<input type='text' id='name' value='" + name.html() + "'/>");
	email.html("<input type='text' id='email' value='" + email.html() + "'/>");
	gender.html("<input type='text' id=gender  value='"+ gender.html() +"'/>");
	let citydropdown=`<select id="city" name="city" style="padding: 4px;">
                              <option value="ddun">Dehradun</option>
                              <option value="gurgaon">Gurgaon</option>
                              <option value="delhi">Delhi</option>
                              <option value="mumbai">Mumbai</option>
                               <option value="chennai">Chennai</option>
                               <option value="raipur">Raipur</option>
   			/select>`;
   		city.html(citydropdown);
		let departmentdropdown=`<select id="department" name="department" style="padding: 4px;">
                                <option value="it">IT</option>
                              <option value="cs">CS</option>
                              <option value="hr">HR</option>
                              <option value="marketing">Marketing</option>
                               <option value="other">Other</option>
                               
   			/select>`;
   	department.html(departmentdropdown);
	dob.html("<input type='date' id='dob' value='" + dob.html() + "'/>");
	salary.html("<input type='text' id='salary' value='" + salary.html() + "'/>");
	contactno.html("<input type='text' id='contactno' value='" + contactno.html() + "'/>");
	password.html("<input type='password' id='password' value='" + password.html() + "'/>");	
	buttons.html("<button id='save' class= 'btn btn-success'>Save</button>");
	
});

$(document).delegate('#save', 'click', function() {
	var parent = $(this).parent().parent();
	var id = parent.children("td:nth-child(1)");
	var name = parent.children("td:nth-child(2)");
	var email = parent.children("td:nth-child(3)");
	var gender = parent.children("td:nth-child(4)");
	var city = parent.children("td:nth-child(5)");
	var department = parent.children("td:nth-child(6)");
	var dob = parent.children("td:nth-child(7)");
	var salary = parent.children("td:nth-child(8)");
	var contactno = parent.children("td:nth-child(9)");
	var password = parent.children("td:nth-child(10)");
    var buttons = parent.children("td:nth-child(11)");
    
    
    
	$.ajax({
		type: "POST",
		contentType: "application/json; charset=utf-8",
		url: "/hr/updateEmployees",
		data: JSON.stringify({
			'id': id.html(), 'name': name.children("input[type=text]").val(),'email':email.children("input[type=text]").val(),'gender':gender.children("input[type=text]").val(), 
			 'city': city.find(":selected").text(),'department': department.find(":selected").text(),'dob':dob.children("input[type=date]").val(),
			'salary':salary.children("input[type=text]").val(),'contactno': contactno.children("input[type=text]").val(), 'password':password.children("input[type=password]").val(),
		}),
		cache: false,
		success: function() {
	    	name.html(name.children("input[type=text]").val());
	    	email.html(email.children("input[type=text]").val());
	    	gender.html(gender.children("input[type=text]").val());
	    	city.html(city.find(":selected").text());
	    	department.html(department.find(":selected").text());
	    	dob.html(dob.children("input[type=date]").val());
	    	salary.html(salary.children("input[type=text]").val());
	    	contactno.html(contactno.children("input[type = text]").val());
	    	 password.html(password.children("input[type=password]").val()); 
	        
			buttons.html("<button class='btn btn-warning edit' id='" + id.html() + "'>Edit</button>");
		},

	});

});



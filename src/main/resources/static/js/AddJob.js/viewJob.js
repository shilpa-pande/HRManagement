	$(document).ready(
	function() {

		// SUBMIT FORM
		$("#getJob").submit(function(event) {
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
					'<td id = "companyName' + item.companyName + '">' + item.companyName + '</td>' +
					'<td id = "jobSkills' + item.jobSkills + '">' + item.jobSkills + '</td>' +
					'<td id = "date' + item.date + '">' + item.date + '</td>' +
					'<td id = "city' + item.city + '">' + item.city + '</td>' +
					'<td id = "description' + item.description + '">' + item.description + '</td>' +
					
					'<td>' +
					'<button type = "button" id = "edit' + item.id + '" class = "btn btn-warning btn-md edit">Edit</button>' +
					'</td>' +
					'<td>' +
					'<button type = "button" id = "delet' + item.id + '" class = "btn btn-danger btn-md delet" onclick = "delet(' + item.id + ')">Delete</button>' +
					'</td>' +
					
					'<td id = "Appliers' + item.id + '">' + '<a href="/getApplier/' + item.id + '"+" class = "btn btn-warning btn-md "">' + 'Appliers' + 
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
		url: "/hr/jobList",
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
			url: "/hr/deleteJob/" +id,
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
	var companyName = parent.children("td:nth-child(2)");
	var jobSkills = parent.children("td:nth-child(3)");
	var date = parent.children("td:nth-child(4)");
	var city = parent.children("td:nth-child(5)");
	var description = parent.children("td:nth-child(6)");
	
    var buttons = parent.children("td:nth-child(7)");
    

	jobSkills.html("<input type='text' id='jobSkills' value='" + jobSkills.html() + "'/>");
	  let citydropdown=`<select id="city" name="city" style="padding: 4px;">
                              <option value="ddun">Dehradun</option>
                              <option value="gurgaon">Gurgaon</option>
                              <option value="delhi">Delhi</option>
                              <option value="mumbai">Mumbai</option>
                               <option value="chennai">Chennai</option>
                               <option value="raipur">Raipur</option>
   			/select>`;
   			city.html(citydropdown);
	description.html("<textarea id=description >"+ description.html() +"</textarea>");
	
	buttons.html("<button id='save' class= 'btn btn-success'>Save</button>");

});

$(document).delegate('#save', 'click', function() {
	var parent = $(this).parent().parent();

	var id = parent.children("td:nth-child(1)");
	var companyName = parent.children("td:nth-child(2)");
	var jobSkills = parent.children("td:nth-child(3)");
	var date = parent.children("td:nth-child(4)");
	var city = parent.children("td:nth-child(5)");
	var description = parent.children("td:nth-child(6)");
	
    var buttons = parent.children("td:nth-child(7)");
 
	$.ajax({
		type: "POST",
		contentType: "application/json; charset=utf-8",
		url: "/hr/updateJob",
		data: JSON.stringify({
			'id': id.html(), 'companyName': companyName.html(), 'jobSkills': jobSkills.children("input[type=text]").val(), 'date': date.html(),
			 'city': city.find(":selected").text(),'description':description.children("textarea").val(),
		}),
		cache: false,
		success: function() {
	    	jobSkills.html(jobSkills.children("input[type = text]").val());
	       	city.html(city.find(":selected").text());
	        description.html(description.children("textarea").val());
	        
			buttons.html("<button class='btn btn-warning edit' id='" + id.html() + "'>Edit</button>");
		},

	});

});


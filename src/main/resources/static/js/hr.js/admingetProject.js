$(document).ready(
	function() {

		// SUBMIT FORM
		$("#admingetProject").submit(function(event) {
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
					'<td id = "Id' + item.pid + '">' + item.pid + '</td>' +
					'<td id = "ProjectName' + item.projectName + '">' + item.projectName + '</td>' +
					'<td id = "ClientName' + item.clientName + '">' + item.clientName + '</td>' +
					'<td id = "ProjectManager' + item.projectManager + '">' + item.projectManager + '</td>' +
					'<td id = "frontendTechnology' + item.frontendTechnology + '">' + item.frontendTechnology + '</td>' +
					'<td id = "backendTechnology' + item.backendTechnology + '">' + item.backendTechnology + '</td>' +
					'<td id = "databaseTechnology' + item.databaseTechnology + '">' + item.databaseTechnology + '</td>' +
					'<td>' +
					'<button type = "button" id = "edit' + item.pid + '" class = "btn btn-warning btn-md edit">Edit</button>' +
					'</td>' +
					'<td>' +
					'<button type = "button" id = "delet' + item.pid + '" class = "btn btn-danger btn-md delet" onclick = "delet(' + item.pid + ')">Delete</button>' +
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
		url: "/getProject",
		data:{keyword: keyword},
		success: function(data) {
			globleTableData=data
			let page=Number($('#customerPageNo').text())
			console.log(globleTableData,'globleTableData')
			pagedata(page)
			
//				data.forEach(function(item) {
//				tableData += '<tr>' +
//					'<td id = "Id' + item.pid + '">' + item.pid + '</td>' +
//					'<td id = "ProjectName' + item.projectName + '">' + item.projectName + '</td>' +
//					'<td id = "ClientName' + item.clientName + '">' + item.clientName + '</td>' +
//					'<td id = "ProjectManager' + item.projectManager + '">' + item.projectManager + '</td>' +
//					'<td id = "frontendTechnology' + item.frontendTechnology + '">' + item.frontendTechnology + '</td>' +
//					'<td id = "backendTechnology' + item.backendTechnology + '">' + item.backendTechnology + '</td>' +
//					'<td id = "databaseTechnology' + item.databaseTechnology + '">' + item.databaseTechnology + '</td>' +
//					'<td>' +
//					'<button type = "button" id = "edit' + item.pid + '" class = "btn btn-warning btn-md edit">Edit</button>' +
//					'</td>' +
//					'<td>' +
//					'<button type = "button" id = "delet' + item.pid + '" class = "btn btn-danger btn-md delet" onclick = "delet(' + item.pid + ')">Delete</button>' +
//					'</td>' +
//					 
//					'</tr>';
//			});
//			$("#myTable>tbody").html(tableData);
		},
	 	
	});
}


$(document).ready(function() {
	ajaxGet();
})

/* Delete */
function delet(pid){
	if (confirm('Do you really want to delete record?')) {
		var parent = $(this).parent().parent();
		alert(pid);
		$.ajax({
			type: "DELETE",
			url: "/deleteProjects/" +pid,
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

	var pid = parent.children("td:nth-child(1)");
	var projectName = parent.children("td:nth-child(2)");
	var clientName = parent.children("td:nth-child(3)");
	var projectManager = parent.children("td:nth-child(4)");
	var frontendTechnology = parent.children("td:nth-child(5)");
	var backendTechnology = parent.children("td:nth-child(6)");
	var databaseTechnology = parent.children("td:nth-child(7)");


    var buttons = parent.children("td:nth-child(8)");
    
   
	projectName.html("<input type='text' id='projectname' value='" + projectName.html() + "'/>");
	clientName.html("<input type='text' id='clientName' value='" + clientName.html() + "'/>");
	projectManager.html("<input type='text' id=projectManager  value='"+ projectManager.html() +"'/>");
	frontendTechnology.html("<input type='text' id='frontendTechnology' value='" + frontendTechnology.html() + "'/>");
	backendTechnology.html("<input type='text' id='backendTechnology' value='" + backendTechnology.html() + "'/>");
	databaseTechnology.html("<input type='text' id='databaseTechnology' value='" + databaseTechnology.html() + "'/>");
	buttons.html("<button id='save' class= 'btn btn-success'>Save</button>");
	
});

$(document).delegate('#save', 'click', function() {
	var parent = $(this).parent().parent();

	var pid = parent.children("td:nth-child(1)");
	var projectName = parent.children("td:nth-child(2)");
	var clientName = parent.children("td:nth-child(3)");
	var projectManager = parent.children("td:nth-child(4)");
	var frontendTechnology = parent.children("td:nth-child(5)");
	var backendTechnology = parent.children("td:nth-child(6)");
	var databaseTechnology = parent.children("td:nth-child(7)");


    var buttons = parent.children("td:nth-child(8)");
    
    
	$.ajax({
		type: "POST",
		contentType: "application/json; charset=utf-8",
		url: "/admin/updateProjects",
		data: JSON.stringify({
			'pid': pid.html(), 'projectName': projectName.children("input[type=text]").val(),'clientName':clientName.children("input[type=text]").val(),'projectManager':projectManager.children("input[type=text]").val(), 
			'frontendTechnology': frontendTechnology.children("input[type=text]").val(),'backendTechnology': backendTechnology.children("input[type=text]").val(),'databaseTechnology':databaseTechnology.children("input[type=text]").val(),
			
		}),
		cache: false,
		success: function() {
	    	projectName.html(projectName.children("input[type=text]").val());
	    	clientName.html(clientName.children("input[type=text]").val());
	    	projectManager.html(projectManager.children("input[type=text]").val());
	    	frontendTechnology.html(frontendTechnology.children("input[type=text]").val());
	    	backendTechnology.html(backendTechnology.children("input[type=text]").val());
	    	databaseTechnology.html(databaseTechnology.children("input[type=text]").val());
	    	 
	        
			buttons.html("<button class='btn btn-warning edit' id='" + pid.html() + "'>Edit</button>");
		},

	});

});





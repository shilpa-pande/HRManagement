$(document).ready(
	function() {

		// SUBMIT FORM
		$("#getProject").submit(function(event) {
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
						 
					'<td id = "Appliers' + item.pid + '">' + '<a href="/hr/getAssigners/' + item.pid + '"+" class = "btn btn-warning btn-md "">' + 'AssignTo' + 
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
		url: "/hr/getProject",
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


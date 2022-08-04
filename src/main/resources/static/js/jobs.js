	$(document).ready(
	function() {

		// SUBMIT FORM
		$("#Jobs").submit(function(event) {
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
					
				
					'<td id = "Apply' + item.id + '">' + '<a href="/apply/' + item.id + '"+" class = "btn btn-danger btn-md "">' + 'Apply' + 
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
		url: "/jobList",
		data:{keyword: keyword},
		success: function(data) {
			globleTableData=data
			let page=Number($('#customerPageNo').text())
			console.log(globleTableData,'globleTableData')
			pagedata(page)
			
//			data.forEach(function(item) {
//				tableData += '<tr>' +
//					'<td id = "Id' + item.id + '">' + item.id + '</td>' +
//					'<td id = "companyName' + item.companyName + '">' + item.companyName + '</td>' +
//					'<td id = "jobSkills' + item.jobSkills + '">' + item.jobSkills + '</td>' +
//					'<td id = "date' + item.date + '">' + item.date + '</td>' +
//					'<td id = "city' + item.city + '">' + item.city + '</td>' +
//					'<td id = "description' + item.description + '">' + item.description + '</td>' +
//					
//				
//					'<td id = "Apply' + item.id + '">' + '<a href="/apply' + '"+" class = "btn btn-danger btn-md "">' + 'Apply' + 
//					'</td>' +
//					'</tr>';
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


//function apply(id) {
//	var parent = $(this).parent().parent();
//
//	var button = parent.children("td:nth-child(8)");
//	$.ajax({
//		type: "POST",
//		contentType: "application/json; charset=utf-8",
//		url: "/Employee/applyJobs/" + id,
//		cache: false,
//		success: function() {
//			alert("Applied");
//			location.reload();
//		},
//	});
//};
//
//


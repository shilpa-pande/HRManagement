$(document).ready(
	function() {

		// SUBMIT FORM
		$("#viewhrdoc").submit(function(event) {
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
					'<td id = "Name' + item.description + '">' + item.description + '</td>' +
					'<td id = "Name' + item.docName + '">' + item.docName + '</td>' +
					
					'<td>' +
					'<button type = "button" id = "delet' + item.id + '" class = "btn btn-danger btn-md delet" onclick = "delet(' + item.id + ')">Delete</button>' +
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
		url: "/hr/hrDocs",
		data:{keyword: keyword},
		success: function(data) {
			
			
			globleTableData=data
			let page=Number($('#customerPageNo').text())
			console.log(globleTableData,'globleTableData')
			pagedata(page)
			
//			data.forEach(function(item) {
//				tableData += '<tr>' +
//					'<td id = "Id' + item.id + '">' + item.id + '</td>' +
//					'<td id = "Name' + item.name + '">' + item.name + '</td>' +
//					'<td id = "Name' + item.description + '">' + item.description + '</td>' +
//					'<td id = "Name' + item.docName + '">' + item.docName + '</td>' +
//					
//					'<td>' +
//					'<button type = "button" id = "delet' + item.id + '" class = "btn btn-danger btn-md delet" onclick = "delet(' + item.id + ')">Delete</button>' +
//					'</td>' +
//					 
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
function delet(id){
	if (confirm('Do you really want to delete record?')) {
		var parent = $(this).parent().parent();
		alert(id);
		$.ajax({
			type: "DELETE",
			url: "/hr/deleteDoc/" +id,
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


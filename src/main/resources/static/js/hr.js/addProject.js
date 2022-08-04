$(document).ready(
	function() {
		$("#addProject").submit(function(event) {
			event.preventDefault();
			ajaxPost();
		});

		function ajaxPost() {

			var data = new FormData($("#addProject")[0]);

			$.ajax({

				type: "POST",
				enctype: 'multipart/form-data',
				url: "/hr/saveProject",
				data: data,
				processData: false,
				contentType: false,
				cache: false,
				success: function()  
				   
		        	{
				   
		        	if (data != null) 
					{
						
						 alert(" successfully added project");
                   		 window.location = "/hr/vProject";
					}
					else 
					{
						 alert("something went wrong");
                   		 window.location = "/hr/vProject";
						
					}
					},
		
				
				});

			}

		})
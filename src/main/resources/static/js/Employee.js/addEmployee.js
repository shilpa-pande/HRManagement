$(document).ready(
	function() {
		$("#employeesignupform").submit(function(event) {
			event.preventDefault();
			ajaxPost();
		});

		function ajaxPost() {

			var data = new FormData($("#employeesignupform")[0]);

			$.ajax({

				type: "POST",
				enctype: 'multipart/form-data',
				url: "/hr/employees",
				data: data,
				processData: false,
				contentType: false,
				cache: false,
				success: function()  
				   
		        	{
				   
		        	if (data != null) 
					{
						
						 alert(" successfully added project");
                   		 window.location = "/hr/viewEmployee";
					}
					else 
					{
						 alert("something went wrong");
                   		 window.location = "/hr/viewEmployee";
						
					}
					},
		
				
				});

			}

		})
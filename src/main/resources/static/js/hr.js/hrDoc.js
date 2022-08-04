$(document).ready(
	function() {
		$("#submit").submit(function(event) {
			event.preventDefault();
			ajaxPost();
		});

		function ajaxPost() {
		var data = new FormData($("#submit")[0]);
		
			$.ajax({
				type: 'POST',
				enctype: 'multipart/form-data',
				data: data,
				url: "/hr/hrDoc",
				processData: false,
				contentType: false,
				cache: false,
				success: function() 
				 {
				   
		        	if (data != null) 
					{
						
						 alert(" successfully uploaded documents");
                   		 window.location = "/hr/viewhrDoc";
					}
					else 
					{
						 alert("something went wrong");
                   		 window.location = "/hr/viewhrDoc";
						
					}
					},
		
				
				});

			}

		})
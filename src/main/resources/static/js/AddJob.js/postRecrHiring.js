$(document).ready(
	function() {
		$("#saveJobDetails").submit(function(event) {
			event.preventDefault();
			ajaxPost();
		});

		function ajaxPost() {

			var data = new FormData($("#saveJobDetails")[0]);

			$.ajax({

				type: "POST",
				enctype: 'multipart/form-data',
				url: "/hr/saveJob",
				data: data,
				processData: false,
				contentType: false,
				cache: false,
				success: function() 
 {
				   
		        if (data != null) 
					{
						
						 alert(" Job Posted Successfully");
                   		 window.location = "/hr/viewJob";
					}
					else 
					{
						 alert("something went wrong");
                   		 window.location = "/hr/viewJob";
						
					}
					},
		
				
				});

			}

		})
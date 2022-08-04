$(document).ready(
	function() {
		$("#adminsaveJobDetails").submit(function(event) {
			event.preventDefault();
			ajaxPost();
		});

		function ajaxPost() {

			var data = new FormData($("#adminsaveJobDetails")[0]);

			$.ajax({

				type: "POST",
			
				url: "/saveJob",
				data: data,
				processData: false,
				contentType: false,
				cache: false,
				success: function() {
				   
		        	if (data != null) 
					{
						
						 alert(" successfully added job");
                   		 window.location = "/admin/viewJob";
					}
					else 
					{
						 alert("something went wrong");
                   		 window.location = "/admin/viewJob";
						
					}
					},
		
				
				});

			}

		})
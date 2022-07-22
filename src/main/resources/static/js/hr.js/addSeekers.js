$(document).ready(
	function() {
		$("#seekersform").submit(function(event) {
			event.preventDefault();
			ajaxPost();
		});

		function ajaxPost() {

			var data = new FormData($("#seekersform")[0]);

			$.ajax({

				type: "POST",
				enctype: 'multipart/form-data',
				url: "/saveseekers",
				data: data,
				processData: false,
				contentType: false,
				cache: false,
				success: function()  
				   
		        	{
				   
		        	if (data != null) 
					{
						
						 alert("successfully apply for job");
                   		 window.location = "/jobs";
					}
					else 
					{
						 alert("something went wrong");
                   		 window.location = "/jobs";
						
					}
					},
		
				
				});

			}

		})
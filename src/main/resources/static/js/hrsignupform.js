$(document).ready(
		function() {

			// SUBMIT FORM
			$("#signupform").submit(function(event) {
				// Prevent the form from submitting via the browser.
				event.preventDefault();
				ajaxPost();
			});

			function ajaxPost() {

				// PREPARE FORM DATA
				var formData = {
					name : $("#name").val(),
					email : $("#email").val(),
				gender:$("#gender").val(),
					city:$("#city").val(),
					contactno : $("#contactno").val(),
					password : $("#password").val()
					
					
				}
				
				// DO POST
				$.ajax({
					type : "POST",
					contentType : "application/json",
					url : "/hrs",
					data : JSON.stringify(formData),
					dataType : 'json',
					success : function(data)
					  {
				   
		        	if (data != null) 
					{
						
						 alert("Hr successfully registered");
                   		 window.location = "/admin/viewHr";
					}
					else 
					{
						 alert("something went wrong");
                   		 window.location = "/admin/viewHr";
						
					}
					},
		
				
				});

			}

		})
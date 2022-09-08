package com.hr_management.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminViewController {

	

		@RequestMapping("/index")
		private String adminHome() {
			return "admin/index";
		}
		
		
	
			@RequestMapping("/viewHr")
			private String viewHr() {
				return "admin/viewHr";	
			}
			
			
	
			@RequestMapping("/viewEmployee")
			private String viewemp() {
				return "admin/viewEmployee";
			}
			
	
			@RequestMapping("/addJob")
			private String addJob() {
				return "admin/postRecrHiring";
			}
			
	
			@RequestMapping("/viewJob")
			private String viewJob() {
				return "admin/viewJob";
			}
			
			
			
			@RequestMapping("/aviewProject")
			private String viewProject() {
				return "admin/viewProject";
			}
			
			
			@RequestMapping("/aviewCompanyDetails")
			private String viewCompanyDetails() {
				return "admin/viewCompanyDetails";
			}
			
		
			@RequestMapping("/aviewCompanyDocuments")
			private String viewCompanyDocuments() {
				return "admin/companydocuments";
			}
			
			@RequestMapping("/signup")
			public String signup() {
				return "admin/signup";
			}
			
			
			
			
			
				
				
			


	
}

package com.hr_management.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hr_management.Repository.AddProjectRepo;
import com.hr_management.entity.Project;
import com.hr_management.service.EmpService;

@RequestMapping("/hr")
@Controller
public class HrViewController {
	
@Autowired
private EmpService empService;




@Autowired
private AddProjectRepo repo;

	
		@RequestMapping("/index")
		private String emphome() {
			return "hr/index";
		}
	
		@RequestMapping("/addEmployee")
		private String addemp() {
			return "hr/addEmployee";
		}
		
		
		@RequestMapping("/viewEmployee")
		private String viewemp() {
			return "hr/viewEmployee";
		}
		
		
	
		@RequestMapping("/addJob")
		private String addJob() {
			return "hr/postRecrHiring";
		}
		
		
		@RequestMapping("/viewJob")
		private String viewJob() {
			return "hr/viewJob";
		}
		
		
		
		@RequestMapping("/saveProject")
		private String addProject() {
			return "hr/addProject";
		}
		
		
		
		
		@RequestMapping("/vProject")
		private String getProject() {
		return "hr/getProject";
		}
	
		@RequestMapping("/hrDoc")
		private String addHrDocuments() {
			
		return "hr/hrDoc";
		}
		
		@RequestMapping("/viewhrDoc")
		private String gethrDoc() {
		return "hr/viewhrDoc";
		}
		
		
		

	
		@GetMapping("/getAssigners/{pid}")
		public String getAppliersList( Model model,@PathVariable("pid") Integer pid) {
			

			 @SuppressWarnings("deprecation")
			Project pr=repo.getById(pid);
		
			  model.addAttribute("pr", pr);
        
				return "hr/emp";

			
		}
		
		@RequestMapping("/assignproject")
		public String getAppliersList( String email,Integer pid) {
			
			empService.saveemp(email, pid);
           return "hr/getProject";
				

			
		}	
		
		@GetMapping("/getProjects/{id}")
		public String getProjectList( Model model,@PathVariable("id") Integer id) {
			
		Set<Project> pr=this.repo.findByEmployees_id(id);
		model.addAttribute("pr", pr);
			
			
        
				return "hr/projectByEmp";

			
		}
	
		
	
		
		
		
		
		


}

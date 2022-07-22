package com.hr_management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hr_management.Repository.EmployeeRepo;
import com.hr_management.entity.Employee;

@RequestMapping("/hr")
@Controller
public class HrViewController {
	
@Autowired
private EmployeeRepo empService;








	
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
		
		
		

	
		@GetMapping("/getAssigners/{id}")
		public String getAppliersList( Model model,@PathVariable int id) {
			
			List<Employee> emp=this.empService.getEmpByProject(id);
			model.addAttribute("emp", emp);

				return "hr/showEmployee";

			
		}
		
		
	
		
	
		
		
		
		
		


}

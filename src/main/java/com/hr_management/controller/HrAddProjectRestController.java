package com.hr_management.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hr_management.entity.Project;
import com.hr_management.service.AddProjectService;

@RestController
public class HrAddProjectRestController {

	@Autowired
	private AddProjectService addProjectService;
	
	
	
	
	
	
	
	

	
	@PostMapping("/hr/saveProject")
	private Project addProject(
			@RequestParam("projectName") String projectName,
			@RequestParam("clientName") String clientName,
			@RequestParam("projectManager") String projectManager,
			@RequestParam("frontendTechnology") String frontendTechnology,
			@RequestParam("backendTechnology") String backendTechnology,
			@RequestParam("databaseTechnology") String databaseTechnology
			
			
			)
	{
		Project pr = new Project();
		
		pr.setProjectName(projectName);
		pr.setClientName(clientName);
		pr.setProjectManager(projectManager);
		pr.setFrontendTechnology(frontendTechnology);
		pr.setBackendTechnology(backendTechnology);
		pr.setDatabaseTechnology(databaseTechnology);

		
		addProjectService.saveProject(pr);
		return pr;
	}
	

	
		@GetMapping("/hr/getProject")
		private List<Project> getPRoject(@RequestParam String keyword) {
			if(keyword == null) {		
				List<Project> listAllprojects = addProjectService.getprojectList();
	     		return listAllprojects;
			}else {	
	     		List<Project> listAllproject = addProjectService.getprojectByKeyword(keyword);
				return listAllproject;
			}
		}
		
		
//		  @GetMapping("/project")
//		  public List<Project> getAllProjects() {
//		    List<Project> pr = new ArrayList<Project>();
//		    prRepo.findAll().forEach(pr::add);
//			return pr;
//		    }
//		  
//		  
//		  @GetMapping("/getAssign/{id}/project")
//		  public List<Employee> getAllEmployeeByProjectId(@PathVariable(value = "id") Integer id) {
//		    
//		    List<Employee> emp = empRepo.findEmployeeById(id);
//			return emp;
//		
//			
//		   
//		  }
//		  
//	
		
	
	
}

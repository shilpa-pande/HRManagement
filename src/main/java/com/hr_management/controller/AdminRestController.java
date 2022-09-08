package com.hr_management.controller;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hr_management.entity.AddJob;
import com.hr_management.entity.Employee;
import com.hr_management.entity.HrDocuments;
import com.hr_management.entity.HumanResource;
import com.hr_management.entity.Project;
import com.hr_management.service.AddJobService;
import com.hr_management.service.AddProjectService;
import com.hr_management.service.AdminService;
import com.hr_management.service.EmpService;
import com.hr_management.service.HrDocsService;


@RestController

public class AdminRestController {

	@Autowired
	private AdminService adminService;
	
	@Autowired
	private EmpService  empService;
	
	@Autowired
	private AddProjectService prService;
	
	@Autowired
	private HrDocsService hrService;
	
	
	@Autowired
	private AddJobService addJobService;
   
	
	//HR REST Controllers

		@GetMapping("/admin/hrs")
		private List<HumanResource> getHr(@RequestParam String keyword) {
			if(keyword == null) {		
				List<HumanResource> hrs = adminService.getHr();
	     		return hrs;
			}else {	
	     		List<HumanResource> hr = adminService.gethrByKeyword(keyword);
				return hr;
			}
		}
		
		
		@RequestMapping(method = RequestMethod.DELETE, value = "/admin/hrs/{id}")
		public void deleteHrById(@PathVariable int id) {
			adminService.deleteHrById(id);
		}
		
		
		@PostMapping("/admin/updateHrs")
		private HumanResource updateHr(@RequestBody HumanResource hr) {
			hr.setRoles("ROLE_USER");
			adminService.savehr(hr);
			return hr;
		}
		
		
		
		//Employee Rest Controllers
		@GetMapping("/employees")
		private List<Employee> getEmp(@RequestParam String keyword) {
			if(keyword == null) {		
				List<Employee> emps = empService.getEmployee();
	     		return emps;
			}else {	
	     		List<Employee> emp = empService.getemployeeByKeyword(keyword);
				return emp;
			}
		}
		
	
		
		@PostMapping("/admin/updateEmployees")
		private void updateEmp(String email,Integer pid) {
			empService.saveemp(email,pid);
		
		}
		
		
		@RequestMapping(method = RequestMethod.DELETE, value = "/employees/{id}")
		public ResponseEntity<Object> deleteEmpById(@PathVariable int id) {
			empService.deleteEmpById(id);
			return new ResponseEntity<>("Employee is deleted successfully", HttpStatus.OK);
		}
		
		


		
		//JOB REST controller
		@PostMapping("/saveJob")
		public ResponseEntity<Object> addjob(@RequestParam("companyName") String companyName
				,@RequestParam("jobSkills") String jobSkills,@RequestParam("date") Date date
				,@RequestParam("city") String city,@RequestParam("description") String description)
		{
			AddJob addjob = new AddJob();
			addjob.setCompanyName(companyName);
			addjob.setJobSkills(jobSkills);
			addjob.setDate(date);
			addjob.setCity(city);
			addjob.setDescription(description);
			addJobService.saveJob(addjob);
			
			return new ResponseEntity<>("Job is created successfully", HttpStatus.CREATED);
		}
		
		
		
				@GetMapping("/admin/jobList")
				private List<AddJob> getJobs(@RequestParam String  keyword) {
					if(keyword == null) {		
						List<AddJob> listAlljobs = addJobService.getJobList();
			     		return listAlljobs;
					}else {	
			     		List<AddJob> listAlljobs = addJobService.getjobByKeyword(keyword);
						return listAlljobs;
					}
				}
				
				
				@PostMapping("/updateJob")
				public ResponseEntity<Object>  updateJob(@RequestBody AddJob addjob) {
					addJobService.saveJob(addjob);
					return new ResponseEntity<>("job is updated successsfully", HttpStatus.OK);
				}
				
				
				
				
				@RequestMapping(method = RequestMethod.DELETE, value = "/deleteJob/{id}")
				 public ResponseEntity<Object> deleteJobById(@PathVariable int id) {
					addJobService.deleteJobById(id);
					return new ResponseEntity<>("Job is deleted successsfully", HttpStatus.OK);
				}
				
				

				
					//Project Rest Controllers		
					@GetMapping("/getProject")
					private List<Project> getPRoject(@RequestParam String keyword) {
						if(keyword == null) {		
							List<Project> listAllprojects = prService.getprojectList();
				     		return listAllprojects;
						}else {	
				     		List<Project> listAllproject = prService.getprojectByKeyword(keyword);
							return listAllproject;
						}
					}
					
				

					@RequestMapping(method = RequestMethod.DELETE, value = "/deleteProjects/{pid}")
					public ResponseEntity<Object> deleteProjectById(@PathVariable int pid) {
						prService.deleteProjectById(pid);
						return new ResponseEntity<>("Project is deleted successsfully", HttpStatus.OK);	
					}
					
					
					@PostMapping("/admin/updateProjects")
					private Project updateProjects(@RequestBody Project pr) {
						prService.saveProject(pr);
						return pr;
					}
					
				
					
					//hrDocs Rest Controllers
					
					@GetMapping("/hrDocs")
					private List<HrDocuments> getdoc(@RequestParam String keyword) {
						
						if(keyword == null) {		
							List<HrDocuments> hrdocs = hrService.gethrDocs();
				     		return hrdocs;
						}else {	
				     		List<HrDocuments> hrdoc = hrService.gethrDocByKeyword(keyword);
							return hrdoc;
						}
					
					
					
					}
					
					
					@RequestMapping(method = RequestMethod.DELETE, value = "/deleteDoc/{pid}")
					public ResponseEntity<Object> deleteDocById(@PathVariable int pid) {
						hrService.deleteDocById(pid);
						return new ResponseEntity<>("Document is deleted successfully", HttpStatus.OK);
					}
					
					
					
				
			
		
	
		
		
}

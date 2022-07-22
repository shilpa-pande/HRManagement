package com.hr_management.controller;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
   
	
	

		@GetMapping("/admin/hrs")
		private List<HumanResource> getHr(@RequestParam String keyword) {
			if(keyword == null) {		
				List<HumanResource> hrs = adminService.getEmployee();
	     		return hrs;
			}else {	
	     		List<HumanResource> hr = adminService.getemployeeByKeyword(keyword);
				return hr;
			}
		}
		
		
	
		@GetMapping("/admin/employees")
		private List<Employee> getEmp(@RequestParam String keyword) {
			if(keyword == null) {		
				List<Employee> emps = empService.getEmployee();
	     		return emps;
			}else {	
	     		List<Employee> emp = empService.getemployeeByKeyword(keyword);
				return emp;
			}
		}
		
	
		@RequestMapping(method = RequestMethod.DELETE, value = "/admin/hrs/{id}")
		public void deleteHrById(@PathVariable int id) {
			adminService.deleteHrById(id);
		}
		
		

		@PostMapping("/admin/updateHrs")
		private HumanResource updateEmp(@RequestBody HumanResource hr) {
			hr.setRoles("ROLE_USER");
			adminService.savehr(hr);
			return hr;
		}
		
	
		@PostMapping("/admin/updateEmployees")
		private Employee updateEmp(@RequestBody Employee emp,int prid) {
			empService.saveemp(emp,prid);
			return emp;
		}
		
	
		@RequestMapping(method = RequestMethod.DELETE, value = "/admin/employees/{id}")
		public void deleteEmpById(@PathVariable int id) {
			empService.deleteEmpById(id);
		}
		

	
		@PostMapping("/admin/saveJob")
		private AddJob addjob(@RequestParam("companyName") String companyName
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
			
			return addjob;
		}
		
		
				@GetMapping("/admin/jobList")
				private List<AddJob> getJobs(@RequestParam String keyword) {
					if(keyword == null) {		
						List<AddJob> listAlljobs = addJobService.getJobList();
			     		return listAlljobs;
					}else {	
			     		List<AddJob> listAlljobs = addJobService.getjobByKeyword(keyword);
						return listAlljobs;
					}
				}
				
				
				@PostMapping("/admin/updateJob")
				private AddJob updateJob(@RequestBody AddJob addjob) {
					addJobService.saveJob(addjob);
					return addjob;
				}
				
				
				@RequestMapping(method = RequestMethod.DELETE, value = "/admin/deleteJob/{id}")
				public void deleteJobById(@PathVariable int id) {
					addJobService.deleteJobById(id);
				}
				
				

				
					@GetMapping("/admin/getProject")
					private List<Project> getPRoject(@RequestParam String keyword) {
						if(keyword == null) {		
							List<Project> listAllprojects = prService.getprojectList();
				     		return listAllprojects;
						}else {	
				     		List<Project> listAllproject = prService.getprojectByKeyword(keyword);
							return listAllproject;
						}
					}
					
				
					@RequestMapping(method = RequestMethod.DELETE, value = "/admin/deleteProjects/{pid}")
					public void deleteProjectById(@PathVariable int pid) {
						prService.deleteProjectById(pid);
					}
					
					
					@PostMapping("/admin/updateProjects")
					private Project updateProjects(@RequestBody Project pr) {
						prService.saveProject(pr);
						return pr;
					}
					
					
					
					@GetMapping("/admin/hrDocs")
					private List<HrDocuments> getdoc(@RequestParam String keyword) {
						
						if(keyword == null) {		
							List<HrDocuments> hrdocs = hrService.gethrDocs();
				     		return hrdocs;
						}else {	
				     		List<HrDocuments> hrdoc = hrService.gethrDocByKeyword(keyword);
							return hrdoc;
						}
					
					
					
					}
					
					
					@RequestMapping(method = RequestMethod.DELETE, value = "/admin/deleteDoc/{pid}")
					public void deleteDocById(@PathVariable int pid) {
						hrService.deleteDocById(pid);
					}
					
					
					
				
			
		
	
		
		
}

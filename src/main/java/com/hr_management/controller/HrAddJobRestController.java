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
import com.hr_management.service.AddJobService;

@RestController
public class HrAddJobRestController {
	
	
	
	@Autowired
	private AddJobService addJobService;
   
	
	
	@PostMapping("/hr/saveJob")
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
	
	
		@GetMapping("/hr/jobList")
		private List<AddJob> getJobs(@RequestParam String keyword) {
			if(keyword == null) {		
				List<AddJob> listAlljobs = addJobService.getJobList();
	     		return listAlljobs;
			}else {	
	     		List<AddJob> listAlljobs = addJobService.getjobByKeyword(keyword);
				return listAlljobs;
			}
		}
		
	
		@PostMapping("/hr/updateJob")
		private AddJob updateJob(@RequestBody AddJob addjob) {
			addJobService.saveJob(addjob);
			return addjob;
		}
		
		
		@RequestMapping(method = RequestMethod.DELETE, value = "/hr/deleteJob/{id}")
		public void deleteJobById(@PathVariable int id) {
			addJobService.deleteJobById(id);
		}
	
	

}
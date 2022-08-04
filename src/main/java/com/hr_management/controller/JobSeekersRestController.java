package com.hr_management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hr_management.entity.AddJob;
import com.hr_management.entity.Seekers;
import com.hr_management.service.AddJobService;
import com.hr_management.service.SeekersService;


@RestController
public class JobSeekersRestController {
	
	@Autowired
	private AddJobService addJobService;
	
	@Autowired
	private SeekersService skService;
	
	
			@GetMapping("/jobList")
			private List<AddJob> getJobs(@RequestParam String keyword) {
				if(keyword == null) {		
					List<AddJob> listAlljobs = addJobService.getJobList();
		     		return listAlljobs;
				}else {	
		     		List<AddJob> listAlljobs = addJobService.getjobByKeyword(keyword);
					return listAlljobs;
				}
			}
			
			
			@PostMapping("/saveseekers")
			private Seekers addSeeker(
					@RequestParam("name") String name,
					@RequestParam("email") String email,
					@RequestParam("gender") String gender,
					@RequestParam("city") String city,
					@RequestParam("dob") String dob,
					@RequestParam("skills") String skills,
					@RequestParam("contactno") long contactno,
				Integer id )			{
				Seekers sk = new Seekers();
				sk.setName(name);
				sk.setEmail(email);
				sk.setGender(gender);
				sk.setCity(city);
				sk.setDob(dob);
				sk.setSkills(skills);
				sk.setContactno(contactno);
				
				skService.saveSeekers(sk,id);
				return sk;
			}
			
			

}

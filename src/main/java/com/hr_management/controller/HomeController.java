package com.hr_management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.hr_management.Repository.AddJobRepo;
import com.hr_management.Repository.SeekersRepo;
import com.hr_management.entity.AddJob;
import com.hr_management.entity.Seekers;

@Controller
public class HomeController {
	
	
	
	
	@Autowired
	private SeekersRepo skService;
	
	
	@Autowired
	private AddJobRepo repo;

	@RequestMapping(path = "/")
	public String home(Model model) {
		model.addAttribute("title","Human Resource Management");
		return "home";
	}
	
	@RequestMapping(path = "/signup")
	public String signup() {
		return "signup";
	}
	
	@RequestMapping("/login")
	public String login() {
		return "login";
	}
	
	
	@RequestMapping("/jobs")
	public String jobs() {
		return "jobs";
	}
	@RequestMapping("/apply/{id}")
	public String applyJobs(Model model,@PathVariable("id") Integer id) {
		@SuppressWarnings("deprecation")
		AddJob job=repo.getById(id);
		
		  model.addAttribute("job", job);
		return "apply";
	}
	
	@GetMapping("/getApplier/{id}")
	public String getAppliersList( Model model,@PathVariable int id) {
		
		List<Seekers> sk=this.skService.getSeekersByJob(id);
		model.addAttribute("sk", sk);

			return "hr/showSeekers";

		
	}
	
	
}

package com.hr_management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hr_management.entity.HumanResource;
import com.hr_management.service.HumanResourceService;

@RestController
public class HomeRestController {

	@Autowired
	private HumanResourceService hrService;
	
	
	
	
	@PostMapping("/hrs")
	public HumanResource saveHr(@RequestBody HumanResource hrs) 
	{
		boolean cheack = hrService.findbyEmail(hrs.getEmail());
       
		if (cheack == true) {
			hrs = null;
			return hrs;
		} else {
			
			hrs.setRoles("ROLE_USER");
			hrService.saveHr(hrs);
			return hrs;
		}
	}
	

	
}

package com.hr_management.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hr_management.Repository.HumanResourceRepo;
import com.hr_management.entity.HumanResource;


@Service
public class HumanResourceService {

	@Autowired
	private HumanResourceRepo hrRepo;
	

	

	
	public void saveHr(HumanResource humanresource) {
		hrRepo.save(humanresource);	
	}

	//this is used for find one employee by their ID
		public boolean findbyEmail(String email) 
		{
	        boolean cheackDetails = false;
			
	        for (HumanResource hrs : hrRepo.findAll()) 
			{
				if (email.equals(hrs.getEmail())) 
				{
					cheackDetails = true;
				}
			}
			
			return cheackDetails;
		}
		
		
	

	
}

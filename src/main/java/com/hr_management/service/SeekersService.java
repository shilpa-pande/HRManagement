package com.hr_management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hr_management.Repository.AddJobRepo;
import com.hr_management.Repository.SeekersRepo;
import com.hr_management.entity.AddJob;
import com.hr_management.entity.Seekers;

@Service
public class SeekersService {


	@Autowired
	private SeekersRepo skRepo;
	
	
	@Autowired
	private AddJobRepo ajRepo;
	
	
	
	
	
public Seekers saveSeekers(Seekers sk,Integer skid) {
	
	
	System.out.println(skid);
	
	@SuppressWarnings("deprecation")
	AddJob aj=ajRepo.getById(skid);
	sk.setSeekersId(aj);
	
		  
		return skRepo.save(sk);
		
	}


public List<Seekers> getseekersByJob(int id) {
	
	return skRepo.getSeekersByJob(id);
}

	
}

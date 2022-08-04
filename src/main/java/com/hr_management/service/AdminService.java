package com.hr_management.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hr_management.Repository.HumanResourceRepo;
import com.hr_management.entity.HumanResource;

@Service
public class AdminService {

	@Autowired
	private HumanResourceRepo hrRepo;
	
	public List<HumanResource> getHr() {
		List<HumanResource> hrs = new ArrayList<HumanResource>();
		for (HumanResource hr : hrRepo.findAll()) {
			hrs.add(hr);
		}
		return hrs;
	}

	public List<HumanResource> gethrByKeyword(String keyword) {
		return hrRepo.gethrByKeyword(keyword);
	}
	
	

	public void deleteHrById(int id) {
		hrRepo.deleteById(id);
		
	}

	public void savehr(HumanResource hr) {
		
		hrRepo.save(hr);	
	}
	



}

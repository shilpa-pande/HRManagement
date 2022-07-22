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
	
	public List<HumanResource> getEmployee() {
		List<HumanResource> hrs = new ArrayList<HumanResource>();
		for (HumanResource hr : hrRepo.findAll()) {
			hrs.add(hr);
		}
		return hrs;
	}

	public List<HumanResource> getemployeeByKeyword(String keyword) {
		return hrRepo.gethrByKeyword(keyword);
	}
	
	

	public void deleteHrById(int id) {
		hrRepo.deleteById(id);
		
	}

	public void savehr(HumanResource hr) {
		
		hrRepo.save(hr);	
	}
	
//	// used for getting the all jobs
//	public HumanRe getEmpByEmpId(int id) {
//		Employee job = new Employee();
//		for (Employee addJob : empRepo.findAll()) {
//			if (id == addJob.getId()) {
//				job.setId(addJob.getId());
//				job.setCity(addJob.getCity());
//				job.setName(addJob.getName());
//				job.setContactno(addJob.getContactno());
//				job.setDepartment(addJob.getDepartment());
//				job.setDob(addJob.getDob());
//				job.setGender(addJob.getGender());
//				job.setPassword(addJob.getPassword());
//				job.setSalary(addJob.getSalary());
//				job.setEmail(addJob.getEmail());
//				
//			}
//		}
//		return job;
//	}
	
	


}

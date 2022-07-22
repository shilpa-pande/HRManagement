package com.hr_management.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hr_management.Repository.HrDocRepo;
import com.hr_management.entity.HrDocuments;


@Service
public class HrDocsService {

	
	@Autowired
	private HrDocRepo hrRepo;
	
	public HrDocuments saveHrDocs(HrDocuments HrDocs) 
	{
		return this.hrRepo.save(HrDocs);
	}

	public List<HrDocuments> gethrDocs() {
		List<HrDocuments> hrdocs = new ArrayList<HrDocuments>();
		for (HrDocuments hrdoc : hrRepo.findAll()) {
			hrdocs.add(hrdoc);
		}
		return hrdocs;
	}
	
	

	public List<HrDocuments> gethrDocByKeyword(String keyword) {
		return hrRepo.gethrDocByKeyword(keyword);	
	}

	public void deleteDocById(int pid) {
		hrRepo.deleteById(pid);
		
	}
	
	
	
	


}

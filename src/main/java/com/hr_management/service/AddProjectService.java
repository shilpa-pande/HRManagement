package com.hr_management.service;


import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hr_management.Repository.AddProjectRepo;
import com.hr_management.entity.Project;

@Service
public class AddProjectService {
	
	@Autowired
	private AddProjectRepo addProjectRepo; 
	
	
	
	

	
	public Project saveProject( Project project) {
		
		
//		System.out.println(empid);
//		@SuppressWarnings("deprecation")
//		
//		Employee emp=empRepo.getById(empid);
//		
//		
//		
//		//Set<Project> pr=new HashSet<>();
//	     //pr.add(project);
//	   project.setEmp(emp);
	      
		return addProjectRepo.save(project);
		
	}
	
	
	
	
	// used for getting the all jobs
		public List<Project> getprojectList() {
			List<Project> prList = new ArrayList<Project>();
			for (Project pr : addProjectRepo.findAll()) {
				prList.add(pr);
			}
			return prList;
		}
		
		public List<Project> getprojectByKeyword(String keyword) {
			
			return addProjectRepo.getprojectByKeyword(keyword);
		}
		
		public void deleteProjectById(int pid) {
			addProjectRepo.deleteById(pid);
			
		}
		
		/*
		 * public List<Project> getprojectListBYID(int id) {
		 * 
		 * List<Project> pr = addProjectRepo.findAllByEmpId(1); return pr; }
		 */
		


	
}

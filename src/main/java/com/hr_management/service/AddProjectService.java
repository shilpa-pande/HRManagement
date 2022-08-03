package com.hr_management.service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hr_management.Repository.AddProjectRepo;
import com.hr_management.entity.Project;

@Service
public class AddProjectService {
	
	@Autowired
	private AddProjectRepo addProjectRepo; 
	
	
	
	

	
	public Project saveProject( Project project) {
		
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
		
		
		    
		
			public Optional<Project> findById(int id) {

		        return addProjectRepo.findById(id);
		    }
		
	

			
			public Optional<Project> ProjectById(Integer pid) {
				return addProjectRepo.findById(pid);
				
				
				
			}
			




	
}

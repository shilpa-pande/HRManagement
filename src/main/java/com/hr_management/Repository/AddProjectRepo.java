package com.hr_management.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hr_management.entity.Project;

public interface AddProjectRepo extends JpaRepository<Project, Integer> {
	
	@Query("SELECT a from Project a WHERE  a.projectName LIKE %?1%"+" OR a.clientName LIKE %?1%" +" OR a.projectManager LIKE %?1%"+" OR a.frontendTechnology LIKE %?1%")
	public List<Project> getprojectByKeyword(String keyword);

	

	    
	
}

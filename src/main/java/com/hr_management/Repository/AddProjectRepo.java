package com.hr_management.Repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hr_management.entity.Project;

public interface AddProjectRepo extends JpaRepository<Project, Integer> {
	
	@Query("SELECT a from Project a WHERE  a.projectName LIKE %?1%"+" OR a.clientName LIKE %?1%" +" OR a.projectManager LIKE %?1%"+" OR a.frontendTechnology LIKE %?1%")
	public List<Project> getprojectByKeyword(String keyword);

	
	
//	@Query("SELECT s from Project s WHERE pid =?1")
//	public Set<Project> getProjectByEmp(int id);
//	
	
	
//	  @Query(value = "SELECT * FROM project t1 INNER JOIN employees_projects t2 ON t1.pid = t2.project_id WHERE t2.employee_id = ?1 ")
//	  public Set<Employee> getProjectByEmp(int id);
//	
	
	Set<Project> findByEmployees_id(int id);
	
	
	


	
	



	    
	
}

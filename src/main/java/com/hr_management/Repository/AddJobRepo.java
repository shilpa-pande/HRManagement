package com.hr_management.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hr_management.entity.AddJob;



public interface AddJobRepo extends JpaRepository<AddJob, Integer>{

	@Query("SELECT a from AddJob a WHERE  a.city LIKE %?1%"+" OR a.jobSkills LIKE %?1%" +" OR a.companyName LIKE %?1%"+" OR a.description LIKE %?1%")
	public List<AddJob> getjobByKeyword(String keyword);
	
	
}

package com.hr_management.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hr_management.entity.Seekers;

public interface SeekersRepo extends JpaRepository<Seekers, Integer>
 {

	
	@Query("SELECT s from Seekers s WHERE seekers_id_id =?1")
    public List<Seekers> getSeekersByJob(int id); 
	
}

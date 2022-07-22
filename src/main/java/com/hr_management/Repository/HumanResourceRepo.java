package com.hr_management.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hr_management.entity.HumanResource;


@Repository
@EnableJpaRepositories
public interface HumanResourceRepo extends JpaRepository<HumanResource, Integer>{

	@Query("SELECT u FROM HumanResource u WHERE u.email = :email")
    public HumanResource getUserByUsername(@Param("email") String email);
	
	

	
	
	
	
	@Query("SELECT a from HumanResource a WHERE  a.name LIKE %?1%"+" OR a.city LIKE %?1%" +" OR a.email LIKE %?1%"+" OR a.id LIKE %?1%" +" OR a.gender LIKE %?1%")
	List<HumanResource> gethrByKeyword(String keyword);
	
	
	
}

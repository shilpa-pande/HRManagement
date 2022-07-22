package com.hr_management.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hr_management.entity.HrDocuments;

public interface HrDocRepo extends JpaRepository<HrDocuments, Integer> {

	
	@Query("SELECT a from HrDocuments a WHERE  a.name LIKE %?1%"+" OR a.id LIKE %?1%" +" OR a.description LIKE %?1%"+" OR a.docName LIKE %?1%")
	List<HrDocuments> gethrDocByKeyword(String keyword);

}

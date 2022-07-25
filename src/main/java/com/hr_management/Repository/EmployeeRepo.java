package com.hr_management.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.hr_management.entity.Employee;


public interface EmployeeRepo extends JpaRepository<Employee, Integer>{

	 @Query("SELECT a from Employee a WHERE  a.name LIKE %?1%"+" OR a.city LIKE %?1%" +" OR a.department LIKE %?1%"+" OR a.id LIKE %?1%")
	List<Employee> getemployeeByKeyword(String keyword);

	
	@Query(value = "select u from Employee u where u.email = :email")
	public Employee getUserByEmail(@Param("email") int email);
	
	@Query("SELECT s from Employee s WHERE pr_id_pid =?1")
    public List<Employee> getEmpByProject(int id); 
	
//	@Query(value = "select pr_id_pid from Employee u where u.id =?1")
//	public int  getprid( int id);


	
	 
	 
	
	 
	 
	
}

package com.hr_management;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hr_management.Repository.EmployeeRepo;
import com.hr_management.entity.Employee;

@SpringBootTest
public class EmpTest {


	
	@Autowired EmployeeRepo empRepo;
	
	
	
	//test for creating emp
		@Test
		void createEmp() {
			Employee emp=new Employee();
		
			 emp.setName("arti");
		     emp.setEmail("arti@mail.com");
		     emp.setGender("female");
		     emp.setCity("delhi");
		     emp.setDepartment("IT");
		     emp.setDob("12-03-1994");
		     emp.setSalary("100000");
		     emp.setContactno(8433001626L);
		     emp.setRole("ROLE_EMP");
		     emp.setPassword("123");
		     empRepo.save(emp);
		
		}
		
		
	
}

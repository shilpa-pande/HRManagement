package com.hr_management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hr_management.entity.Employee;
import com.hr_management.service.EmpService;


@RestController
public class HrEmployeeRestController {
	
	@Autowired
	private EmpService  empService;
	


	@PostMapping("/hr/employees")
	public Employee saveemp(@RequestParam("name") String name,
			@RequestParam("email") String email,
			@RequestParam("gender") String gender,
			@RequestParam("city") String city,
			@RequestParam("department") String department,
			@RequestParam("dob") String dob,
			@RequestParam("salary") String salary,
			@RequestParam("contactno") long contactno,
			@RequestParam("password") String password,
			
			Integer prid
			) 
	
	{		
		Employee emp=new Employee();
		
			emp.setRole("ROLE_Emp");
			emp.setName(name);
			emp.setEmail(email);
			emp.setGender(gender);
			emp.setCity(city);
			emp.setDepartment(department);
			emp.setDob(dob);
			emp.setSalary(salary);
			emp.setContactno(contactno);
			emp.setPassword(password);
			empService.saveemp(emp,prid);
			return emp;
	}
	

	
	@GetMapping("/hr/employees")
	private List<Employee> getEmp(@RequestParam String keyword) {
		
		if(keyword == null) {		
			List<Employee> emps = empService.getEmployee();
     		return emps;
		}else {	
     		List<Employee> emp = empService.getemployeeByKeyword(keyword);
			return emp;
		}
	
	
	
	}
	

	
			@PostMapping("/hr/updateEmployees")
			private Employee updateEmp(@RequestBody Employee emp,int prid) {
				
				
				empService.saveemp(emp, prid);
				return emp;
			}
			
			
			@RequestMapping(method = RequestMethod.DELETE, value = "/hr/employees/{id}")
			public void deleteEmpById(@PathVariable int id) {
				empService.deleteEmpById(id);
			}
			
			
			
			@GetMapping("/hr/getAppliers/{id}")
			private List<Employee> getEmpByPRoject(@RequestParam int id) {
				
				
		     		List<Employee> emp = empService.getemployeeByProject(id);
					return emp;
				}
			
			
			
			}
			
			
		
	
	
	


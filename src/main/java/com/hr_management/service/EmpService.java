package com.hr_management.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hr_management.Repository.AddProjectRepo;
import com.hr_management.Repository.EmployeeRepo;
import com.hr_management.entity.Employee;
import com.hr_management.entity.Project;


@Service
public class EmpService {

	@Autowired
	private EmployeeRepo empRepo;
	
	@Autowired
	private AddProjectRepo prRepo; 
	
	
	
	public Employee saveemp(Employee emp,Integer prid) {
				
				
				System.out.println(prid);
				
				@SuppressWarnings("deprecation")
				Project pr=prRepo.getById(prid);
				emp.setPrId(pr);
				
				return empRepo.save(emp);
					
			}
	
			


			public List<Employee> getEmployee() {
				List<Employee> emps = new ArrayList<Employee>();
				for (Employee emp : empRepo.findAll()) {
					emps.add(emp);
				}
				return emps;
			}
			
		
			
			//this is used to search job by keyword
			public List<Employee> getemployeeByKeyword(String keyword) {
				
				return empRepo.getemployeeByKeyword(keyword);
			}

			

			public void deleteEmpById(int id) {
				empRepo.deleteById(id);
				
			}
			
		
			public Employee getEmpByEmpId(int id) {
				Employee job = new Employee();
				for (Employee addJob : empRepo.findAll()) {
					if (id == addJob.getId()) {
						job.setId(addJob.getId());
						job.setCity(addJob.getCity());
						job.setName(addJob.getName());
						job.setContactno(addJob.getContactno());
						job.setDepartment(addJob.getDepartment());
						job.setDob(addJob.getDob());
						job.setGender(addJob.getGender());
						job.setPassword(addJob.getPassword());
						job.setSalary(addJob.getSalary());
						job.setEmail(addJob.getEmail());
						
					}
				}
				return job;
			}

			
			
			
			
		
			
			public List<Employee> getemployeeByProject(int id) {
			
				return empRepo.getEmpByProject(id);
		}

			
		
			  
		
			
			
			
		
		

			
	
}

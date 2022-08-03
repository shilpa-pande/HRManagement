package com.hr_management.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.*;  
import javax.persistence.Table;




@Entity
@Table(name = "employee")
public class Employee {
	
	
	
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	
	@Column(unique = true)  
	private String email;
	private String gender;
	private String city;
	private String department;
	private String dob;
	private String salary;
	private long contactno;
	private String role;
	private String password;
	@ManyToMany(cascade = {
	        CascadeType.MERGE
	    })
	    @JoinTable(
	        name = "employees_projects",
	        joinColumns = {
	            @JoinColumn(name = "employee_id")
	        },
	        inverseJoinColumns = {
	            @JoinColumn(name = "project_id")
	        }
	    )
	    Set <Project> projects = new HashSet < Project > ();
	

	



	
	
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	


	public Employee(String name, String email) {
		super();
		this.name = name;
		this.email = email;
	}



	public Set<Project> getProjects() {
		return projects;
	}
	public void setProjects(Set<Project> projects) {
		this.projects = projects;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getSalary() {
		return salary;
	}
	public void setSalary(String salary) {
		this.salary = salary;
	}
	public long getContactno() {
		return contactno;
	}
	public void setContactno(long contactno) {
		this.contactno = contactno;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", email=" + email + "]";
	}
	
	
	

	

	
	
	
	
	
	
	
	

	

}

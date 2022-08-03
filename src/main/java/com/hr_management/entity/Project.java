package com.hr_management.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "project")
public class Project {
	
	
	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int pid;
	private String projectName;
	private String clientName;
	private String projectManager;
	private String frontendTechnology;
	private String backendTechnology;
	private String databaseTechnology;
   
	
	@ManyToMany(mappedBy = "projects", cascade = { CascadeType.MERGE })
    @JsonIgnore
    private Set<Employee> employees = new HashSet<Employee>();
	
	
	

	 

	
    
	public Set<Employee> getEmployees() {
		return employees;
	}
	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getClientName() {
		return clientName;
	}
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	public String getProjectManager() {
		return projectManager;
	}
	public void setProjectManager(String projectManager) {
		this.projectManager = projectManager;
	}
	public String getFrontendTechnology() {
		return frontendTechnology;
	}
	public void setFrontendTechnology(String frontendTechnology) {
		this.frontendTechnology = frontendTechnology;
	}
	public String getBackendTechnology() {
		return backendTechnology;
	}
	public void setBackendTechnology(String backendTechnology) {
		this.backendTechnology = backendTechnology;
	}
	public String getDatabaseTechnology() {
		return databaseTechnology;
	}
	public void setDatabaseTechnology(String databaseTechnology) {
		this.databaseTechnology = databaseTechnology;
	}
	@Override
	public String toString() {
		return "Project [pid=" + pid + ", projectName=" + projectName + ", clientName=" + clientName
				+ ", projectManager=" + projectManager + ", frontendTechnology=" + frontendTechnology
				+ ", backendTechnology=" + backendTechnology + ", databaseTechnology=" + databaseTechnology + "]";
	}

	
	

	
	
	
	

	

	
	

	
	
	
	
	

}

package com.hr_management.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "project")
public class Project implements Serializable{
	
	
	private static final long serialVersionUID = -4357411223179608187L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int pid;
	private String projectName;
	private String clientName;
	private String projectManager;
	private String frontendTechnology;
	private String backendTechnology;
	private String databaseTechnology;
	
	
	

	 @OneToMany(cascade = CascadeType.MERGE, mappedBy = "prId")
		private List<Employee> pr=new ArrayList<>();
		
	 

	

	public List<Employee> getPr() {
		return pr;
	}
	public void setPr(List<Employee> pr) {
		this.pr = pr;
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

	
	
	
	

	

	
	

	
	
	
	
	

}

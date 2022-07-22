package com.hr_management.entity;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class AddJob {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private String companyName;
	
	private String jobSkills; 
	
	private Date date;
	private String city;
	private String description;
	
	

	 @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "seekersId")
		private List<Seekers> sk=new ArrayList<>();
		

	 
	 
	 
	public List<Seekers> getSk() {
		return sk;
	}

	public void setSk(List<Seekers> sk) {
		this.sk = sk;
	}

	public int getId() {
		return id;
	}
	
	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	

	public String getJobSkills() {
		return jobSkills;
	}

	public void setJobSkills(String jobSkills) {
		this.jobSkills = jobSkills;
	}

	public void setId(int id) {
		this.id = id;
	}

	

	
	
}

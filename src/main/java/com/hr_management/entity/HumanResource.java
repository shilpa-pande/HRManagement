package com.hr_management.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * @author shilpapandey
 *
 */
/**
 * @author shilpapandey
 *
 */
/**
 * @author shilpapandey
 *
 */
@Entity
@Table(name = "HR")
public class HumanResource {

	@Id
  
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int hid;
	private String name;
	
	@Column(unique = true)  
	private String email;
	private String gender;
	private String city;
	private long contactno;
	private String password;
	private String roles;
	
	



	public int getHid() {
		return hid;
	}
	public void setHid(int hid) {
		this.hid = hid;
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
	public String getRoles() {
		return roles;
	}
	public void setRoles(String roles) {
		this.roles = roles;
	}

	


	
	
	
	
}

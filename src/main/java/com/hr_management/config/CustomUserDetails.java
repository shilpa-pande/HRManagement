package com.hr_management.config;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.hr_management.entity.HumanResource;

public class CustomUserDetails implements UserDetails{
	
	private static final long serialVersionUID = 7259985727812852235L;
	private HumanResource hr;
	
	
	
	
	public CustomUserDetails(HumanResource hr) {
		super();
		this.hr = hr;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
	
		
		SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(hr.getRoles());
		
		return List.of(simpleGrantedAuthority) ;
	}

	
	public int getId()
	{
		return hr.getHid();
	}
	
	
	@Override
	public String getPassword() {
		
		return hr.getPassword();
	}

	@Override
	public String getUsername() {
		
		return hr.getEmail();
	}

	@Override
	public boolean isAccountNonExpired() {
		
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		
		return true;
	}

	@Override
	public boolean isEnabled() {
		
		return true;
	}
	
	

}

package com.hr_management.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.hr_management.Repository.HumanResourceRepo;
import com.hr_management.entity.HumanResource;



public class UserDetailServiceImpl implements UserDetailsService{

	@Autowired
	private HumanResourceRepo hrRepo;
	

	// fetching user from database
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		
		HumanResource hrs=hrRepo.getUserByUsername(username);
		
		if(hrs==null) {
			
			throw new UsernameNotFoundException("user 404");
		}
		return new CustomUserDetails(hrs);
	}

}

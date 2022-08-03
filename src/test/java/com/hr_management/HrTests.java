package com.hr_management;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hr_management.Repository.HumanResourceRepo;
import com.hr_management.entity.HumanResource;


@SpringBootTest
public class HrTests {

	
	
	@Autowired
	private HumanResourceRepo hrRepo;
	
	
	
	
	//test for creating hr
	@Test
	void createHr() {
		HumanResource hr=new HumanResource();
	
		hr.setName("arti");
		hr.setEmail("arti1234@gmail.com");
		hr.setGender("female");
		hr.setCity("dehradun");
		hr.setContactno(8433001626L);
		hr.setPassword("123");
		hr.setRoles("ROLE_USER");
		hrRepo.save(hr);
	
	}
	
	
	//test for getting all hr
	@Test
	void getAllHr() {
		List<HumanResource> hr=hrRepo.findAll();
		assertThat(hr).size().isGreaterThan(0);
		
	}
	

	
	//test for delete hr
	@Test
	void deleteHr() {
		hrRepo.findById(3);
		assertThat(hrRepo.existsById(3)).isFalse();
		
	}
	
	
	
	
	//test for update hr
	@Test
	void updateHr() {
		HumanResource hr=hrRepo.findById(1).get();
		hr.setCity("chennai");
		hrRepo.save(hr);
		assertNotEquals("Mumbai",hrRepo.findById(1).get().getCity());
		
	}
}

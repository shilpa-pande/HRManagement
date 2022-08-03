package com.hr_management;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.hr_management.controller.AdminRestController;
import com.hr_management.entity.Employee;
import com.hr_management.service.EmpService;


@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest
public class EmployeeRestControllerTest extends AbstractTest{
	
	
	@Autowired
	private MockMvc mvc;
	
	
	@Mock
	EmpService empService;
	 
	 @InjectMocks
	   AdminRestController controllerUnderTest;
	 
	 @SuppressWarnings("deprecation")
	 @Before
	    public void setup() {
	        MockitoAnnotations.initMocks(this);

	        this.mvc = MockMvcBuilders.standaloneSetup(controllerUnderTest).build();

	    }
	
	@Test
	   public void getEmpList() throws Exception {
	      String uri = "/employees?keyword=arti";
	 
	      MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
	         .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
	      
	      int status = mvcResult.getResponse().getStatus();
	      assertEquals(200, status);
	      String content = mvcResult.getResponse().getContentAsString();
	      Employee[] emplist = super.mapFromJson(content, Employee[].class);
	      assertTrue(emplist.length > 0);
	   }
	
	
	 @Test
	   public void createEmp() throws Exception {
	      String uri = "/hr/employees";
	      Employee emp = new Employee();
	     emp.setName("arti");
	     emp.setEmail("arti@mail.com");
	     emp.setGender("female");
	     emp.setCity("delhi");
	     emp.setDepartment("IT");
	     emp.setDob("12-03-1994");
	     emp.setSalary("100000");
	     emp.setContactno(8433001626L);
	     emp.setRole("ROLE_EMP");
	     emp.setPassword("123");
	      String inputJson = super.mapToJson(emp);
	      MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
	      .contentType(MediaType.APPLICATION_JSON_VALUE)
	      .content(inputJson)).andReturn();
	      
	      int status = mvcResult.getResponse().getStatus();
	      assertEquals(201, status);
	      String content = mvcResult.getResponse().getContentAsString();
	      assertEquals(content, "Employee is created successfully");
	   }

	 
	 @Test
	   public void deleteEmp() throws Exception {
	      String uri = "/employees/61";
	      MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.delete(uri)).andReturn();
	      int status = mvcResult.getResponse().getStatus();
	      assertEquals(200, status);
	      String content = mvcResult.getResponse().getContentAsString();
	      assertEquals(content, "Employee is deleted successfully");
	   }

	


}








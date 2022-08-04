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
import com.hr_management.entity.Project;
import com.hr_management.service.AddJobService;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest
public class ProjectRestControllerTest extends AbstractTest{

	@Autowired
	private MockMvc mvc;
	
	
	@Mock
	 AddJobService addJobService;
	 
	 @InjectMocks
	   AdminRestController controllerUnderTest;
	 
	 
	 
	 
	 
	 @SuppressWarnings("deprecation")
	 @Before
	    public void setup() {
	        MockitoAnnotations.initMocks(this);

	        this.mvc = MockMvcBuilders.standaloneSetup(controllerUnderTest).build();

	    }
	 
	 
		@Test
		   public void getProjectList() throws Exception {
		      String uri = "/getProject?keyword=hr";
		 
		      MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
		         .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
		      
		      int status = mvcResult.getResponse().getStatus();
		      assertEquals(200, status);
		      String content = mvcResult.getResponse().getContentAsString();
		      Project[] emplist = super.mapFromJson(content, Project[].class);
		      assertTrue(emplist.length > 0);
		   }
		 @Test
		   public void deleteProject() throws Exception {
		      String uri = "/deleteProjects/26";
		      MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.delete(uri)).andReturn();
		      int status = mvcResult.getResponse().getStatus();
		      assertEquals(200, status);
		      String content = mvcResult.getResponse().getContentAsString();
		      assertEquals(content, "Project is deleted successsfully");
		   }
		 
		 
		
		
	
	
	
}

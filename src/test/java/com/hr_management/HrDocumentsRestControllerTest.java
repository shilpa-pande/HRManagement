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
import com.hr_management.entity.HrDocuments;
import com.hr_management.service.EmpService;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest
public class HrDocumentsRestControllerTest extends AbstractTest{

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
	   public void deleteDoc() throws Exception {
	      String uri = "/deleteDoc/64";
	      MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.delete(uri)).andReturn();
	      int status = mvcResult.getResponse().getStatus();
	      assertEquals(200, status);
	      String content = mvcResult.getResponse().getContentAsString();
	      assertEquals(content, "Document is deleted successfully");
	   }
	 
	 
		@Test
		   public void getDocList() throws Exception {
		      String uri = "/hrDocs?keyword=shi";
		 
		      MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
		         .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
		      
		      int status = mvcResult.getResponse().getStatus();
		      assertEquals(200, status);
		      String content = mvcResult.getResponse().getContentAsString();
		      HrDocuments[] doc = super.mapFromJson(content, HrDocuments[].class);
		      assertTrue(doc.length > 0);
		   }
		

	
	
}

package com.cleidsonpc.webapp.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.cleidsonpc.webapp.WebappApplication;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = WebappApplication.class)
@WebAppConfiguration
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PersonControllerTest {

	private MockMvc mockMvc;
	
	@Autowired
	private WebApplicationContext webApplicationContext;
	
	@Before
	public void before() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}
	
	@Test
	public void testSave() throws Exception {
		
	}
	
	@Test
	public void testfindAll() throws Exception {
		
		mockMvc.perform(get("http://localhost:8080/webapp/persons/"))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$[0].addressline1", is("Allies Computing Ltd")));
		
	}
	
	@Test
	public void testFindById() throws Exception {
		
		mockMvc.perform(get("http://localhost:8080/webapp/persons/1"))
			.andExpect(status().isOk())
			.andExpect(jsonPath("$[0].addressline1", is("Allies Computing Ltd")));
		
	}
	
//	@Test
	public void testDelete() {
		
	}
}

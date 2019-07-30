package com.spring.cloud.testcontroller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class TestClassController {
	
	@Autowired
	private MockMvc mocMvc;
	
	@Test
	public void findAllTest() throws Exception{
		this.mocMvc.perform(get("/classes"))
		.andExpect(status().isOk());
	}
	
	@Test
	public void findbyIdTest() throws Exception{
		this.mocMvc.perform(get("/classes/1"))
		.andExpect(status().isOk());
	}

}

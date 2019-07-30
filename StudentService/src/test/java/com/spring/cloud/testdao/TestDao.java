package com.spring.cloud.testdao;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.spring.cloud.controller.StudentController;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class TestDao  {
	
	@Autowired
	private MockMvc mocMvc;
	
	@Test
	public void findAllTest() throws Exception{
		this.mocMvc.perform(get("/students"))
		.andExpect(status().isOk());
	}
	
	@Test
	public void findbyIdTest() throws Exception{
		this.mocMvc.perform(get("/students/1"))
		.andExpect(status().isOk());
	}
	


}

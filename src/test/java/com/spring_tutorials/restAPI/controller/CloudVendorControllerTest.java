package com.spring_tutorials.restAPI.controller;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.spring_tutorials.restAPI.model.cloudVendor;
import com.spring_tutorials.restAPI.service.CloudVendorService;

@WebMvcTest(CloudVendorController.class)
public class CloudVendorControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private CloudVendorService cloudVendorService;
	
	cloudVendor cloudVendorOne;
	cloudVendor cloudVendorTwo;
	List<cloudVendor> cloudVendorList = new ArrayList<>();
	
	@BeforeEach
	void setUp() {
		cloudVendorOne = new cloudVendor("1", "Amazon", "USA", "XXXXX");
		cloudVendorTwo = new cloudVendor("2", "GCP", "UK", "YYYYY");
		cloudVendorList.add(cloudVendorOne);
		cloudVendorList.add(cloudVendorTwo);
	}
	
	@AfterEach
	void tearDown() {
		
	}
	
	@Test
	void testGetCloudVendorDetails() throws Exception {
		when(cloudVendorService.getCloudVendor("1")).thenReturn(cloudVendorOne);
		this.mockMvc.perform(get("/cloudvendor/1")).andDo(print()).andExpect(status().isOk());
	}
	
	@Test
	void testGetAllCloudVendorDetails() throws Exception {
		when(cloudVendorService.getAllCloudVendors()).thenReturn(cloudVendorList);
		this.mockMvc.perform(get("/cloudvendor")).andDo(print()).andExpect(status().isOk());	
	}
	
	@Test
	void testCreateCloudVendorDetails() throws Exception{
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
		ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
		String requestJson = ow.writeValueAsString(cloudVendorOne);
		
		when(cloudVendorService.createCloudVendor(cloudVendorOne)).thenReturn("Success");
		this.mockMvc.perform(post("/cloudvendor").contentType(MediaType.APPLICATION_JSON).content(requestJson)).andDo(print()).andExpect(status().isOk());
	}
	
	@Test
	void testUpdateCloudVendorDetails() throws Exception{
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
		ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
		String requestJson = ow.writeValueAsString(cloudVendorOne);
		
		when(cloudVendorService.updateCloudVendor(cloudVendorOne)).thenReturn("Success");
		this.mockMvc.perform(put("/cloudvendor").contentType(MediaType.APPLICATION_JSON).content(requestJson)).andDo(print()).andExpect(status().isOk());
	}
	
	@Test
	void testDeleteCloudVendorDetails() throws Exception {
		when(cloudVendorService.deleteCloudVendor("1")).thenReturn("Success");
		this.mockMvc.perform(delete("/cloudvendor/1")).andDo(print()).andExpect(status().isOk());
	}

}

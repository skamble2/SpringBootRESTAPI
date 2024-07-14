package com.spring_tutorials.restAPI.service.impl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Answers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.spring_tutorials.restAPI.model.cloudVendor;
import com.spring_tutorials.restAPI.repository.CloudVendorRepository;
import com.spring_tutorials.restAPI.service.CloudVendorService;

public class CloudVendorServiceImplTest {
	
	@Mock
	private CloudVendorRepository cloudVendorRepository;
	private CloudVendorService cloudVendorService;
	AutoCloseable autoCloseable;
	cloudVendor CloudVendor;

	
	@BeforeEach
	void setUp() {
		autoCloseable = MockitoAnnotations.openMocks(this);
		cloudVendorService = new CloudVendorServiceImpl(cloudVendorRepository);
		CloudVendor = new cloudVendor("1", "Amazon", "USA", "XXXXX");
	}
	
	@AfterEach
	void tearDown() throws Exception {
		autoCloseable.close();
	}
	
	@Test
	void testCreateCloudVendor() {
		mock(cloudVendor.class);
		mock(CloudVendorRepository.class);
		
		when(cloudVendorRepository.save(CloudVendor)).thenReturn(CloudVendor);
		
		assertThat(cloudVendorService.createCloudVendor(CloudVendor)).isEqualTo("Success");
	}
	
	@Test
	void testUpdateCloudVendor() {
		mock(cloudVendor.class);
		mock(CloudVendorRepository.class);
		
		when(cloudVendorRepository.save(CloudVendor)).thenReturn(CloudVendor);
		
		assertThat(cloudVendorService.updateCloudVendor(CloudVendor)).isEqualTo("Success");
	}
	
	@Test
	void testDeleteCloudVendor() {
		mock(cloudVendor.class);
		mock(CloudVendorRepository.class, Mockito.CALLS_REAL_METHODS);
		
		doAnswer(Answers.CALLS_REAL_METHODS).when(cloudVendorRepository).deleteAllById(any());
		assertThat(cloudVendorService.deleteCloudVendor("1")).isEqualTo("Success");
	}
	
	@Test
	void testGetCloudVendor() {
		mock(cloudVendor.class);
		mock(CloudVendorRepository.class);
		
		when(cloudVendorRepository.findById("1")).thenReturn(Optional.ofNullable(CloudVendor));
		assertThat(cloudVendorService.getCloudVendor("1").getVendorName()).isEqualTo(CloudVendor.getVendorName());
	}
	
	
	@Test
	void testGetAllCloudVendor() {
		mock(cloudVendor.class);
		mock(CloudVendorRepository.class);
		
		when(cloudVendorRepository.findAll()).thenReturn(new ArrayList<cloudVendor>(Collections.singleton(CloudVendor)));
		assertThat(cloudVendorService.getAllCloudVendors().get(0).getVendorPhoneNumber()).isEqualTo(CloudVendor.getVendorPhoneNumber());
	}

}


package com.spring_tutorials.restAPI.repository;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import com.spring_tutorials.restAPI.model.cloudVendor;
import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class CloudVendorRepositoryTest {
	
	@Autowired
	private CloudVendorRepository cloudVendorRepository;
	cloudVendor CloudVendor;

	@BeforeEach
	void setUp() {
		CloudVendor = new cloudVendor("1", "Amazon", "USA", "XXXXXX");
		cloudVendorRepository.save(CloudVendor);
	}
	
	@AfterEach
	void tearDown() {
		CloudVendor = null;
		cloudVendorRepository.deleteAll();
	}
	
	//Test case Success
	
	@Test
	void testFindByVendorName_Found() {
		List<cloudVendor> cloudVendorList = cloudVendorRepository.findByVendorName("Amazon");
		assertThat(cloudVendorList.get(0).getVendorID()).isEqualTo(CloudVendor.getVendorID());
		assertThat(cloudVendorList.get(0).getVendorAddress()).isEqualTo(CloudVendor.getVendorAddress());
	}
	
	//Test case Failure
	@Test
	void testFindByVendorName_NotFound() {
		List<cloudVendor> cloudVendorList = cloudVendorRepository.findByVendorName("GCP");
		assertThat(cloudVendorList.isEmpty()).isTrue();
	}
	
	
}

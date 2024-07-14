package com.spring_tutorials.restAPI.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.spring_tutorials.restAPI.model.cloudVendor;
import com.spring_tutorials.restAPI.repository.CloudVendorRepository;
import com.spring_tutorials.restAPI.service.CloudVendorService;


@Service
public class CloudVendorServiceImpl implements CloudVendorService{
	
	CloudVendorRepository cloudVendorRepository;
	
	public CloudVendorServiceImpl(CloudVendorRepository cloudVendorRepository) {
		this.cloudVendorRepository = cloudVendorRepository;
	}

	@Override
	public String createCloudVendor(cloudVendor CloudVendor) {
		
		//More Business Logic
		cloudVendorRepository.save(CloudVendor);
		return "Success";
	}

	@Override
	public String updateCloudVendor(cloudVendor CloudVendor) {
		
		//More Business Logic
		cloudVendorRepository.save(CloudVendor);
		return "Success";
	}

	@Override
	public String deleteCloudVendor(String cloudVendorID) {
		
		//More Business Logic
		cloudVendorRepository.deleteById(cloudVendorID);
		return "Success";
	}

	@Override
	public cloudVendor getCloudVendor(String cloudVendorID) {	
		return cloudVendorRepository.findById(cloudVendorID).get();
	}

	@Override
	public List<cloudVendor> getAllCloudVendors() {
		return cloudVendorRepository.findAll();
	}

}

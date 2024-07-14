package com.spring_tutorials.restAPI.service;

import java.util.List;

import com.spring_tutorials.restAPI.model.cloudVendor;

public interface CloudVendorService {
	
	public String createCloudVendor(cloudVendor CloudVendor);
	public String updateCloudVendor(cloudVendor CloudVendor);
	public String deleteCloudVendor(String cloudVendorID);
	public cloudVendor getCloudVendor(String cloudVendorID);
	public List<cloudVendor> getAllCloudVendors();
	
}

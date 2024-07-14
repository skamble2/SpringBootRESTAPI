package com.spring_tutorials.restAPI.controller;

import com.spring_tutorials.restAPI.model.cloudVendor;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cloudvendor")
public class CloudAPIService {
	
	cloudVendor CloudVendor;
	
	@GetMapping("{vendorID}")
	public cloudVendor getCloudVendorDetails(String vendorID) {
		return CloudVendor;
				
		//new cloudVendor("C1","Vendor 1","Address 1","XXXXX");
	}
	
	@PostMapping
	public String createCloudVendorDetails(@RequestBody cloudVendor CloudVendor) {
		
		this.CloudVendor = CloudVendor;
		return "Cloud Vendor Created Successfully";
	}
	
	@PutMapping
	public String updateCloudVendorDetails(@RequestBody cloudVendor CloudVendor) {
		
		this.CloudVendor = CloudVendor;
		return "Cloud Vendor Updated Successfully";
	}
	
	@DeleteMapping("{vendorID}")
	public String deleteCloudVendorDetails(String vendorID) {
		
		this.CloudVendor = null;
		return "Cloud Vendor Deleted Successfully";
	}
	
	
}

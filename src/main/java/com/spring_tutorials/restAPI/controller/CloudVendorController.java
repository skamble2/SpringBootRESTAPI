package com.spring_tutorials.restAPI.controller;

import com.spring_tutorials.restAPI.model.cloudVendor;
import com.spring_tutorials.restAPI.response.ResponseHandler;
import com.spring_tutorials.restAPI.service.CloudVendorService;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cloudvendor")
public class CloudVendorController {
	
	CloudVendorService cloudVendorService;
	
	public CloudVendorController(CloudVendorService cloudVendorService) {
		this.cloudVendorService = cloudVendorService;
	}

	//Read Specific Cloud Vendor Details
	@GetMapping("{vendorID}")
	public ResponseEntity<Object> getCloudVendorDetails(@PathVariable("vendorID") String vendorID) {
		
		return ResponseHandler.responseBuilder("Requested Vendor Details are given here", HttpStatus.OK, cloudVendorService.getCloudVendor(vendorID));
		

	}
	
	//Read All Cloud Vendor Details from DB
	@GetMapping()
	public List<cloudVendor> getAllCloudVendorDetails() {
	
		return cloudVendorService.getAllCloudVendors();

	}
	
	@PostMapping
	public String createCloudVendorDetails(@RequestBody cloudVendor CloudVendor) {
		
		cloudVendorService.createCloudVendor(CloudVendor);
		return "Cloud Vendor Created Successfully";
	}
	
	@PutMapping
	public String updateCloudVendorDetails(@RequestBody cloudVendor CloudVendor) {
		
		cloudVendorService.updateCloudVendor(CloudVendor);
		return "Cloud Vendor Updated Successfully";
	}
	
	@DeleteMapping("{vendorID}")
	public String deleteCloudVendorDetails(@PathVariable("vendorID") String vendorID) {
		
		cloudVendorService.deleteCloudVendor(vendorID);
		return "Cloud Vendor Deleted Successfully";
	}
	
	
}

package com.spring_tutorials.restAPI.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="cloud_vendor_info")
@ApiModel(description = "This table holds cloud vendor information")
public class cloudVendor {
	
	@Id
	@ApiModelProperty(notes = "This is a cloud vendor id. It should be unique")
	private String vendorID;
	private String vendorName;
	private String vendorAddress;
	private String vendorPhoneNumber;
	
	public cloudVendor() {
		
	}

	public cloudVendor(String vendorID, String vendorName, String vendorAddress, String vendorPhoneNumber) {
		this.vendorID = vendorID;
		this.vendorName = vendorName;
		this.vendorAddress = vendorAddress;
		this.vendorPhoneNumber = vendorPhoneNumber;
	}
	
	
	public String getVendorID() {
		return vendorID;
	}

	public void setVendorID(String vendorID) {
		this.vendorID = vendorID;
	}

	public String getVendorName() {
		return vendorName;
	}

	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}

	public String getVendorAddress() {
		return vendorAddress;
	}

	public void setVendorAddress(String vendorAddress) {
		this.vendorAddress = vendorAddress;
	}

	public String getVendorPhoneNumber() {
		return vendorPhoneNumber;
	}

	public void setVendorPhoneNumber(String vendorPhoneNumber) {
		this.vendorPhoneNumber = vendorPhoneNumber;
	}
	

}

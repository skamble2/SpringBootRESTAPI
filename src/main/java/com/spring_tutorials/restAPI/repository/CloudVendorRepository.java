package com.spring_tutorials.restAPI.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.spring_tutorials.restAPI.model.cloudVendor;

public interface CloudVendorRepository extends JpaRepository<cloudVendor, String>{
	List<cloudVendor> findByVendorName(String vendorName);
}

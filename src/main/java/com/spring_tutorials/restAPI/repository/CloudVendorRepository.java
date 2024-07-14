package com.spring_tutorials.restAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.spring_tutorials.restAPI.model.cloudVendor;

public interface CloudVendorRepository extends JpaRepository<cloudVendor, String>{

}

package com.spring.asap.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.asap.entities.UserDetails;
import com.spring.asap.services.UserDetailService;
import com.spring.asap.util.ServiceResponse;


@RestController
@RequestMapping("/api/users")

public class UserController {

	@Autowired
	private  UserDetailService userDetailsService;

  
   
    //  save user details
    @PostMapping("/saveUserDetails")
    public ServiceResponse saveUserDetails(@RequestBody UserDetails userDetails) {
    	ServiceResponse savedUser = userDetailsService.saveUserDetails(userDetails);
        return savedUser;
    }

    // Endpoint to retrieve all user details
    @GetMapping("/getAllUserDetails")
    public ServiceResponse getAllUserDetails() {
    	ServiceResponse userDetailsList = userDetailsService.getAllUserDetails();
        return userDetailsList;
    }
    
    
    @DeleteMapping("/deleteIdea/{userId}")
    public ServiceResponse deleteIdea(@PathVariable("userId") Long userId) {
    	ServiceResponse userDetailsList = userDetailsService.deleteIdea(userId);
        return userDetailsList;
    }
    
    
    
    @PutMapping("/updateUserDetails")
    public ServiceResponse updateUserDetails(@RequestBody UserDetails userDetails) {
    	ServiceResponse savedUser = userDetailsService.saveUserDetails(userDetails);
        return savedUser;
    }
	
	
	
}

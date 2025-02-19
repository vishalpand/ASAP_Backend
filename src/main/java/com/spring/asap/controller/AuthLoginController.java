package com.spring.asap.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.asap.dto.AuthLoginDTO;
import com.spring.asap.entities.AuthLogin;
import com.spring.asap.services.AuthLoginService;
import com.spring.asap.util.ServiceResponse;

@RestController
//@CrossOrigin(origins ="*")
@RequestMapping("/api/users")
public class AuthLoginController {
	
	
	
	@Autowired
	private AuthLoginService authLoginService;
	
	
	 @PostMapping("/login")
	    public ServiceResponse checkAuthLogin(@RequestBody AuthLoginDTO authLoginDTO) {
	    	ServiceResponse savedUser = authLoginService.checkAuthLogin(authLoginDTO);
	        return savedUser;
	    }

	 @PostMapping("/authSave")
	    public ServiceResponse Authlogin(@RequestBody AuthLogin authlogin) {
	    	ServiceResponse savedUser = authLoginService.Authlogin(authlogin);
	        return savedUser;
	    }

	 
	 @PostMapping("/updatePassword")
	    public ServiceResponse updatePass(@RequestBody AuthLoginDTO authLoginDTO) {
	    	ServiceResponse savedUser = authLoginService.updatePass(authLoginDTO);
	        return savedUser;
	    }
	 
	 
	 
	 // New check user existence endpoint
	    @PostMapping("/check-user-existence")
	    public ServiceResponse checkUserExistence(@RequestBody AuthLoginDTO authLoginDTO) {
	        ServiceResponse response = authLoginService.checkUserExistence(authLoginDTO);
	        return  response;
	    }
	 
	 
}

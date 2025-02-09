package com.spring.asap.services;


import com.spring.asap.entities.UserDetails;
import com.spring.asap.util.ServiceResponse;

public interface UserDetailService {
	
	public ServiceResponse saveUserDetails( UserDetails userDetails);
	 public ServiceResponse getAllUserDetails();
	 public ServiceResponse deleteIdea(Long userId);
	 public ServiceResponse updateUserDetails( UserDetails userDetails);

}

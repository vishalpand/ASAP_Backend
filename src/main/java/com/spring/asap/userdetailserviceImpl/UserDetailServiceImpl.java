package com.spring.asap.userdetailserviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.asap.entities.UserDetails;
import com.spring.asap.services.UserDetailService;
import com.spring.asap.userdetailrepository.UserDetailRepository;
import com.spring.asap.util.ServiceResponse;

@Service
public class UserDetailServiceImpl implements UserDetailService {

	
	@Autowired
	private UserDetailRepository userDetailRepository;
	
	
	@Override
	public ServiceResponse saveUserDetails(UserDetails userDetails) {
		
		ServiceResponse response = new ServiceResponse();
		
		try {
			
			
			UserDetails user = userDetailRepository.save(userDetails);
			if(user != null) {
				response.setServiceResponse("UserDetails Save Successfully !!!");
				response.setServiceStatus(response.STATUS_SUCCESS);
				response.setServiceError("");
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
			response.setServiceResponse("Unable to save UserDetails !!!");
			response.setServiceStatus(response.STATUS_FAIL);
			response.setServiceError(e.getMessage());
		}
		
		
		return response;
		
	}

	@Override
	public ServiceResponse getAllUserDetails() {
		
     ServiceResponse response = new ServiceResponse();
		
		try {
			
			   List<UserDetails> userDetailsList = userDetailRepository.findAll();
				response.setServiceResponse(userDetailsList);
				response.setServiceStatus(response.STATUS_SUCCESS);
				response.setServiceError("");
			
			
		} catch (Exception e) {
			e.printStackTrace();
			response.setServiceResponse("Unable to fetch UserDetails !!!");
			response.setServiceStatus(response.STATUS_FAIL);
			response.setServiceError(e.getMessage());
		}
		
		
		return response;
	}

	@Override
	public ServiceResponse deleteIdea(Long userId) {
		 ServiceResponse response = new ServiceResponse();
		 
		 try {
			
			 Optional<UserDetails> userdetails = userDetailRepository.findById(userId);
			 
			    if (userdetails.isPresent()) {
			    	userDetailRepository.delete(userdetails.get());
			    	response.setServiceResponse("UserDetails Deleted Successfully !!!");
					response.setServiceStatus(response.STATUS_SUCCESS);
					response.setServiceError("");
			    }
			 
		} catch (Exception e) {
			e.printStackTrace();
			response.setServiceResponse("Unable to save UserDetails !!!");
			response.setServiceStatus(response.STATUS_FAIL);
			response.setServiceError(e.getMessage());
		}
		 
		 
		 return response;
		 
		 
	}

	public ServiceResponse updateUserDetails(UserDetails userDetails) {
		
		ServiceResponse response = new ServiceResponse();
		
		try {
			
			 Optional<UserDetails> existingUserOpt = userDetailRepository.findById(userDetails.getUserId());
		        
		        if (existingUserOpt.isPresent()) {
		            UserDetails existingUser = existingUserOpt.get();
		           

		            userDetailRepository.save(userDetails);
		            response.setServiceResponse("UserDetails Update Successfully !!!");
					response.setServiceStatus(response.STATUS_SUCCESS);
					response.setServiceError("");
		            
		            
		        } else {
		            
					response.setServiceResponse("User not found");
					response.setServiceStatus(response.STATUS_FAIL);
					response.setServiceError("");
		        }
			
		} catch (Exception e) {
			e.printStackTrace();
			response.setServiceResponse("Unable to fetch UserDetails !!!");
			response.setServiceStatus(response.STATUS_FAIL);
			response.setServiceError(e.getMessage());
		}
		
		return response;
    }

}

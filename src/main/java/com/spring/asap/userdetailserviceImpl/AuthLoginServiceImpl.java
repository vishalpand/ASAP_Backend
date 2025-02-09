package com.spring.asap.userdetailserviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.asap.dto.AuthLoginDTO;
import com.spring.asap.entities.AuthLogin;
import com.spring.asap.entities.UserDetails;
import com.spring.asap.services.AuthLoginService;
import com.spring.asap.userdetailrepository.AuthLoginRepository;
import com.spring.asap.util.ServiceResponse;

@Service
public class AuthLoginServiceImpl implements AuthLoginService {

	
	
	@Autowired
	private AuthLoginRepository authLoginRepository;
	
	@Override
	public ServiceResponse checkAuthLogin(AuthLoginDTO authLoginDTO) {
		ServiceResponse response = new ServiceResponse();
		
		 Optional<AuthLogin> userOptional;
		
		try {
			
			
			if (authLoginDTO.getEmailid().contains("@")) {
	            // Identifier is assumed to be an email
	            userOptional = authLoginRepository.findByEmailid(authLoginDTO.getEmailid());
	        } else {
	            // Identifier is assumed to be a mobile number
	            userOptional = authLoginRepository.findByMobileNumber(authLoginDTO.getMobileNumber());
	        }

	        // Check if user exists
	        if (userOptional.isEmpty()  ) {
	        	
	        	response.setServiceResponse("User not found");
				response.setServiceStatus(response.STATUS_FAIL);
				response.setServiceError("");
	        }
	        
             
	        

	           AuthLogin AuthUser = userOptional.get();

	        // Validate password (in a real application, use hashed password comparison)
	        if (AuthUser.getPassword().equals(authLoginDTO.getPassword())) {
	        	response.setServiceResponse("Login Successfully !!!");
				response.setServiceStatus(response.STATUS_SUCCESS);
				response.setServiceError("");
	        } else {
	        	response.setServiceResponse("Invalid Password !!!");
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

	@Override
	public ServiceResponse Authlogin(AuthLogin authLogin) {
		
		ServiceResponse response = new ServiceResponse();
		
try {
			
			
			AuthLogin user = authLoginRepository.save(authLogin);
			if(user != null) {
				response.setServiceResponse("User Save Successfully !!!");
				response.setServiceStatus(response.STATUS_SUCCESS);
				response.setServiceError("");
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
			response.setServiceResponse("Unable to save User !!!");
			response.setServiceStatus(response.STATUS_FAIL);
			response.setServiceError(e.getMessage());
		}
		
		
		
		return response;
	}
	
	
	@Override
	public ServiceResponse updatePass(AuthLoginDTO authLoginDTO) {
	    ServiceResponse response = new ServiceResponse();
	    
	    // Validate inputs
	    if (authLoginDTO.getEmailid() == null || authLoginDTO.getEmailid().isEmpty()) {
	        response.setServiceResponse("Email is required.");
	        response.setServiceStatus(response.STATUS_FAIL);
	        return response;
	    }

	    if (authLoginDTO.getNewPassword() == null || authLoginDTO.getNewPassword().isEmpty()) {
	        response.setServiceResponse("New password is required.");
	        response.setServiceStatus(response.STATUS_FAIL);
	        return response;
	    }

	    // Initialize the Optional to fetch user
	    Optional<AuthLogin> userOptional = findUserByIdentifier(authLoginDTO);

	    if (userOptional.isPresent()) {
	        AuthLogin user = userOptional.get();
	        
	        // Update password (in plaintext, for simplicity)
	        user.setPassword(authLoginDTO.getNewPassword());
	        
	        // Save the updated user to the database
	        authLoginRepository.save(user);

	        // Success response
	        response.setServiceResponse("Password updated successfully.");
	        response.setServiceStatus(response.STATUS_SUCCESS);
	        response.setServiceError("");  // No error
	    } else {
	        // User not found
	        response.setServiceResponse("User not found.");
	        response.setServiceStatus(response.STATUS_FAIL);
	        response.setServiceError("No user found with the provided email/mobile number.");
	    }

	    return response;
	}

	private Optional<AuthLogin> findUserByIdentifier(AuthLoginDTO authLoginDTO) {
	    // Check if the identifier is an email or a mobile number and fetch accordingly
	    if (authLoginDTO.getEmailid().contains("@")) {
	        // If it's an email
	        return authLoginRepository.findByEmailid(authLoginDTO.getEmailid());
	    } else {
	        // If it's a mobile number
	        return authLoginRepository.findByMobileNumber(authLoginDTO.getMobileNumber());
	    }
	}

	
	
	
	 public ServiceResponse checkUserExistence(AuthLoginDTO authLoginDTO) {
	        ServiceResponse response = new ServiceResponse();

	        // Validate inputs
	        if (authLoginDTO.getEmailid() == null && authLoginDTO.getMobileNumber() == null) {
	            response.setServiceResponse("Either email or mobile number is required.");
	            response.setServiceStatus(response.STATUS_FAIL);
	            return response;
	        }

	        boolean userExists = false;

	        // Check for user existence based on email ID
	        if (authLoginDTO.getEmailid() != null) {
	            // Fetch the list of users by email (to handle possible duplicates)
	            List<AuthLogin> usersByEmail = authLoginRepository.findUsersByEmailid(authLoginDTO.getEmailid());
	            if (!usersByEmail.isEmpty()) {
	                userExists = true; // If at least one user exists
	            }
	        }

	        // Check for user existence based on mobile number
	        if (authLoginDTO.getMobileNumber() != null) {
	            Optional<AuthLogin> userByMobile = authLoginRepository.findByMobileNumber(authLoginDTO.getMobileNumber());
	            if (userByMobile.isPresent()) {
	                userExists = true; // If a user with the mobile number exists
	            }
	        }

	        // Construct the response based on user existence
	        if (userExists) {
	            response.setServiceResponse("User exists.");
	            response.setServiceStatus(response.STATUS_SUCCESS);
	        } else {
	            response.setServiceResponse("User does not exist.");
	            response.setServiceStatus(response.STATUS_FAIL);
	        }

	        return response;
	    }

}

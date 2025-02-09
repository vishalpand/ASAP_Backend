package com.spring.asap.services;






import org.springframework.web.bind.annotation.RequestBody;

import com.spring.asap.dto.AuthLoginDTO;
import com.spring.asap.entities.AuthLogin;
import com.spring.asap.util.ServiceResponse;

public interface AuthLoginService {
	
	public ServiceResponse checkAuthLogin(AuthLoginDTO authLoginDTO);
	public ServiceResponse Authlogin(AuthLogin authLoginDTO);
	public ServiceResponse updatePass(AuthLoginDTO authLoginDTO);
	public ServiceResponse checkUserExistence( AuthLoginDTO authLoginDTO);
}

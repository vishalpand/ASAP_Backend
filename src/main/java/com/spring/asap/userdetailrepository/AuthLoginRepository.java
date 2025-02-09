package com.spring.asap.userdetailrepository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.spring.asap.entities.AuthLogin;


public interface AuthLoginRepository extends JpaRepository<AuthLogin, Long>  {
	
	    Optional<AuthLogin> findByEmailid(String email);
	    Optional<AuthLogin> findByMobileNumber(String mobile);
	    
	    @Query("SELECT u FROM AuthLogin u WHERE u.emailid = :emailid")
	    List<AuthLogin> findUsersByEmailid(String emailid);

}

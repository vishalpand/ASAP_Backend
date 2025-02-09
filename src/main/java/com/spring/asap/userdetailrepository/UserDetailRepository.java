package com.spring.asap.userdetailrepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.asap.entities.UserDetails;



public interface UserDetailRepository  extends JpaRepository<UserDetails, Long>{

}

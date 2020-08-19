package com.dfwcomputech.scrap.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.dfwcomputech.scrap.persistence.domain.User;
import com.dfwcomputech.scrap.persistence.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		log.info("Loading User");
		User user = userRepository.findByEmail(email);
		if(user!=null)		
			return user;
		
		throw new UsernameNotFoundException(
                "User '" + email + "' not found");
	}

}

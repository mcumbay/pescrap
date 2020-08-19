package com.dfwcomputech.scrap.web.form;

import org.springframework.security.crypto.password.PasswordEncoder;

import com.dfwcomputech.scrap.persistence.domain.User;

import lombok.Data;

@Data
public class RegistrationForm {
	  private String email;
	  private String password;

	  public User toUser(PasswordEncoder passwordEncoder) { 
		 return new User(null,email,passwordEncoder.encode(password),true);
	  }
}

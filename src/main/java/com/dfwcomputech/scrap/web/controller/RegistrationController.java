package com.dfwcomputech.scrap.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dfwcomputech.scrap.persistence.repository.UserRepository;
import com.dfwcomputech.scrap.web.form.RegistrationForm;

@Controller
@RequestMapping(value="/register")
public class RegistrationController {
	
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;


	  @GetMapping
	  public String registerForm() {
	    return "registration";
	  }

	  @PostMapping
	  public String processRegistration(RegistrationForm form) {
		userRepository.save(form.toUser(passwordEncoder));
	    return "redirect:/login";
	  }
}

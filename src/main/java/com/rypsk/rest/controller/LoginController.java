package com.rypsk.rest.controller;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rypsk.rest.model.User;
import com.rypsk.rest.repository.UsersRepository;

@RestController
@RequestMapping(value = "/api/login")
public class LoginController {
	
	private final Logger LOG = LoggerFactory.getLogger(getClass());
	
	private final UsersRepository usersRepository;
	
	public LoginController(UsersRepository usersRepository) {
		this.usersRepository = usersRepository;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Optional<User> loginUser(@PathVariable String id) {
		LOG.info("Logging user with ID: {}.", id);
		return usersRepository.findById(id);
	}

}

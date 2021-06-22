package com.rypsk.rest.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rypsk.rest.model.Users;
import com.rypsk.rest.repository.UsersRepository;

@RestController
@RequestMapping(value = "/api")
public class UsersController {

	private final Logger LOG = LoggerFactory.getLogger(getClass());

	private final UsersRepository usersRepository;
	
	public UsersController(UsersRepository usersRepository) {
		this.usersRepository = usersRepository;
	}

	@RequestMapping(value = "", method = RequestMethod.GET)
	public List<Users> getAllUsers() {
		LOG.info("Getting all users.");
		return usersRepository.findAll();
	}

	@RequestMapping(value = "/{nif}", method = RequestMethod.GET)
	public Optional<Users> getUser(@PathVariable String nif) {
		LOG.info("Getting user with ID: {}.", nif);
		return usersRepository.findById(nif);
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public Users addUser(@RequestBody Users user) {
		LOG.info("Saving user.");
		return usersRepository.save(user);
	}
	
	@RequestMapping(value = "/delete/{nif}", method = RequestMethod.DELETE)
	public void deleteUser(@RequestBody String nif) {
		LOG.info("Delete user.");
		usersRepository.deleteById(nif);
	}

}

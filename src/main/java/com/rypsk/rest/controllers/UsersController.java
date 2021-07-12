package com.rypsk.rest.controllers;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rypsk.rest.models.User;
import com.rypsk.rest.repositories.UsersRepository;

@RestController
@RequestMapping(value = "rypsk/api/users")
public class UsersController {

	private final Logger LOG = LoggerFactory.getLogger(getClass());

	private final UsersRepository usersRepository;
	
	public UsersController(UsersRepository usersRepository) {
		this.usersRepository = usersRepository;
	}

	@RequestMapping(value = "", method = RequestMethod.GET)
	public List<User> getAllUsers() {
		LOG.info("Getting all users.");
		return usersRepository.findAll();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Optional<User> getUser(@PathVariable String id) {
		LOG.info("Getting user with ID: {}.", id);
		return usersRepository.findById(id);
	}

	@RequestMapping(value = "", method = RequestMethod.POST)
	public User addUser(@RequestParam User user) {
		LOG.info("Saving user.");
		return usersRepository.save(user);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void deleteUser(@RequestParam String id) {
		LOG.info("Delete user.");
		usersRepository.deleteById(id);
	}

}

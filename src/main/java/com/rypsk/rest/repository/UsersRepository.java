package com.rypsk.rest.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.rypsk.rest.model.User;


public interface UsersRepository extends MongoRepository<User, String> {

}

package com.rypsk.rest.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.rypsk.rest.models.User;


public interface UsersRepository extends MongoRepository<User, String> {

}

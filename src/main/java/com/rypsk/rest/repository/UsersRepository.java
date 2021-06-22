package com.rypsk.rest.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.rypsk.rest.model.Users;


public interface UsersRepository extends MongoRepository<Users, String> {

}

package com.pocjasper.pocjasper.repository;


import com.pocjasper.pocjasper.entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface UserRepository extends MongoRepository<User, UUID> {

}

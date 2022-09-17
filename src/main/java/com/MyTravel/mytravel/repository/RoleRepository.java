package com.MyTravel.mytravel.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.MyTravel.mytravel.model.ERole;
import com.MyTravel.mytravel.model.Role;

public interface RoleRepository extends MongoRepository<Role, String> {
    Optional<Role> findByName(ERole name);
}
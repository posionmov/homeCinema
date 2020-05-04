package com.sagalanov.repositories;

import com.sagalanov.models.auth.Role;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RoleRepository extends MongoRepository<Role, String> {
    Role findRoleByName(String name);
}

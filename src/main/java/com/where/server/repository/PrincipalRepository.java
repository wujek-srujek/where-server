package com.where.server.repository;


import java.util.Optional;

import com.where.server.entity.Principal;
import org.springframework.data.repository.Repository;


public interface PrincipalRepository extends Repository<Principal, Long> {

    Optional<Principal> findByUsername(String username);
}

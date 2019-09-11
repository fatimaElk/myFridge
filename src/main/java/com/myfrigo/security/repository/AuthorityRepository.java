package com.myfrigo.security.repository;

import com.myfrigo.model.security.Authority;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AuthorityRepository extends JpaRepository<Authority, Long> {

    Authority findByName(String name);
    Authority findAuthorityById (Long id);
  
}

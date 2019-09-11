package com.myfrigo.repository;


import com.myfrigo.model.security.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    // C

    // R
    User findUserById (Long id);
    User findByUsername (String username);
    User findByEmail (String email);

    // U

    // D



}


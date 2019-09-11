package com.myfrigo.service;

import com.myfrigo.model.security.Authority;
import com.myfrigo.model.security.User;
import com.myfrigo.repository.UserRepository;
import com.myfrigo.security.repository.AuthorityRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    // =================================
    // ========== Attributes ===========
    // =================================

    UserRepository userRepository;
    AuthorityRepository authorityRepository;

    // =================================
    // ========= Constructors ==========
    // =================================




    // =================================
    // ======= Getters & Setters =======
    // =================================


    // =================================
    // =========== Methods =============
    // =================================


    @Override
    @Transactional
    public User newUser(User user) {
        // Check if username doesn't already exists.
        if (userRepository.findByUsername(user.getUsername()) != null) {
            user.setUsername(null);
            return user;
        }

        // Check if email doesn't already exists.
        else if (userRepository.findByEmail(user.getEmail()) != null){
            user.setEmail(null);
            return  user;
        }

        else {
            user.setEnabled(true);


            user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
            List<Authority> authorities = new ArrayList<>();
            authorities.add(authorityRepository.findAuthorityById(1L));


            user.setAuthorities(authorities);


            userRepository.save(user);
            return user;
        }
    }
}

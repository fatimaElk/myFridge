package com.myfrigo.rest;

import com.myfrigo.model.security.User;
import com.myfrigo.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;




@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserRest {

    // =================================
    // ========== Attributes ===========
    // =================================

    UserService userService;

    // =================================
    // ========= Constructors ==========
    // =================================

    public UserRest(UserService userService){
        this.userService = userService;
    }


    // =================================
    // ======= Getters & Setters =======
    // =================================


    // =================================
    // =========== Methods =============
    // =================================

    @PostMapping("/newuser")
    public ResponseEntity<?> newUser (@RequestBody User user ){
        user = userService.newUser(user);

        if (user.getUsername() == null){
            return new ResponseEntity<>("Username already exists.", HttpStatus.CONFLICT);
        }

        else if (user.getEmail() == null) {
            return new ResponseEntity<>("Email already exists.", HttpStatus.CONFLICT);
        }

        else {
            return new ResponseEntity<>(user, HttpStatus.CREATED);
        }
    }



}

package Backendproject.controllers;

import Backendproject.entities.UserSecurity;
import Backendproject.services.UsersecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserSecurityController {

    @Autowired
    UsersecurityService usersecurityService;

    @PostMapping("/users")
    public ResponseEntity<UserSecurity> createUser(@RequestBody UserSecurity user) {
        UserSecurity newUser = usersecurityService.save(user);
        return new ResponseEntity<UserSecurity>(newUser, HttpStatus.CREATED);
    }

}

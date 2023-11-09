package Backendproject.controllers;


import Backendproject.dtos.DTOToken;
import Backendproject.dtos.UserDTO;
import Backendproject.entities.Client;
import Backendproject.entities.User;
import Backendproject.entities.UserSecurity;
import Backendproject.security.JwtUtilService;
import Backendproject.security.SecurityUser;
import Backendproject.services.UserService;
import org.apache.xmlbeans.impl.xb.xsdschema.Attribute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")

public class UserController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    UserDetailsService userDetailsService;

    @Autowired
    private JwtUtilService jwtUtilService;

    @Autowired
    UserService userService;

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.listAll();
        return new ResponseEntity<List<User>>(users, HttpStatus.OK);
    }

    @PostMapping("/users/create")
    public ResponseEntity<User> createUser(@RequestBody UserDTO user) {
        User newUser = userService.registerUser(user);
        return new ResponseEntity<User>(newUser, HttpStatus.CREATED);
    }

    @PutMapping("/users/update")
    public ResponseEntity<User> updateUser(@RequestBody UserDTO user) {
        User newUser = userService.changePassword(user);
        return new ResponseEntity<User>(newUser, HttpStatus.OK);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") Long id) {
        User user=userService.findById(id);
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }


    @DeleteMapping("/users/delete/{id}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable("id") Long id) {
        userService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }




    @PostMapping("/users/login")
    public ResponseEntity<DTOToken> authenticate(@RequestBody UserDTO user) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(user.getUserName(),
                        user.getPassword()));
        SecurityUser securityUser = (SecurityUser) this.userDetailsService.loadUserByUsername(
                user.getUserName());
        String jwt = jwtUtilService.generateToken(securityUser);
        Long id= securityUser.getUser().getId();
        return new ResponseEntity<DTOToken>(new DTOToken(jwt,id), HttpStatus.OK);

    }

}







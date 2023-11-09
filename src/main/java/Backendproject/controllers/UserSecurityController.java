package Backendproject.controllers;

import Backendproject.dtos.DTOToken;
import Backendproject.dtos.UserDTO;
import Backendproject.entities.User;
import Backendproject.entities.UserSecurity;
import Backendproject.security.JwtUtilService;
import Backendproject.security.SecurityUser;
import Backendproject.services.UserService;
import Backendproject.services.UsersecurityService;
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
public class UserSecurityController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    UserDetailsService userDetailsService;

    @Autowired
    private JwtUtilService jwtUtilService;

    @Autowired
    UserService userService;

    @Autowired
    UsersecurityService usersecurityService;

    @GetMapping("/users")
    public ResponseEntity<List<UserSecurity>> getAllUsers() {
        List<UserSecurity> users = usersecurityService.listAll();
        return new ResponseEntity<List<UserSecurity>>(users, HttpStatus.OK);
    }

    @PostMapping("/users")
    public ResponseEntity<UserSecurity> createUser(@RequestBody UserDTO user) {
        UserSecurity newUser = usersecurityService.registerUser(user);
        return new ResponseEntity<UserSecurity>(newUser, HttpStatus.CREATED);
    }

    @PutMapping("/users/update")
    public ResponseEntity<UserSecurity> updateUser(@RequestBody UserDTO user) {
        UserSecurity newUser = usersecurityService.changePassword(user);
        return new ResponseEntity<UserSecurity>(newUser, HttpStatus.OK);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<UserSecurity> getUserById(@PathVariable("id") Long id) {
        UserSecurity user=usersecurityService.findById(id);
        return new ResponseEntity<UserSecurity>(user, HttpStatus.OK);
    }


    @DeleteMapping("/users/delete/{id}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable("id") Long id) {
        usersecurityService.delete(id);
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

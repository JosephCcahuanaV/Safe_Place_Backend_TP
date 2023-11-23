package Backendproject.controllers;

import Backendproject.dtos.DTOToken;
import Backendproject.dtos.UserSecurityDTO;
import Backendproject.entities.UserSecurity;
import Backendproject.security.JwtUtilService;
import Backendproject.services.UsersecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;
import Backendproject.security.SecurityUser;

import java.util.List;


@CrossOrigin(origins = "http://localhost:4200")
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
    UsersecurityService usersecurityService;

    //Nuevo
    @PostMapping("/users")//create
    public ResponseEntity<UserSecurity> createUser(@RequestBody UserSecurityDTO user) {
        UserSecurity newUser = usersecurityService.register(user);
        return new ResponseEntity<UserSecurity>(newUser, HttpStatus.CREATED);
    }

    @PutMapping("/users")
    public ResponseEntity<UserSecurity> updateUser(@RequestBody UserSecurityDTO user) {
        UserSecurity newUser = usersecurityService.changePassword(user);
        return new ResponseEntity<UserSecurity>(newUser, HttpStatus.OK);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<UserSecurity> getUserById(@PathVariable("id") Long id) {
        UserSecurity user = usersecurityService.findById(id);
        return new ResponseEntity<UserSecurity>(user, HttpStatus.OK);
    }

    @PostMapping("/users/login")
    public ResponseEntity<DTOToken> authenticate(@RequestBody UserSecurityDTO user) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(user.getUserName(),
                        user.getPassword()));
        SecurityUser securityUser = (SecurityUser) this.userDetailsService.loadUserByUsername(
                user.getUserName());
        String jwt = jwtUtilService.generateToken(securityUser);
        Long id = securityUser.getUser().getId();
        return new ResponseEntity<DTOToken>(new DTOToken(jwt, id, user.getType()), HttpStatus.OK);
    }

    @GetMapping("/users")
    public ResponseEntity<List<UserSecurity>> getAllUsers() {
        List<UserSecurity> userSecurities = usersecurityService.listAll();
        return new ResponseEntity<List<UserSecurity>>(userSecurities, HttpStatus.OK);
    }



}

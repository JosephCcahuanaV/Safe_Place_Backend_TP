package Backendproject.controllers;

import Backendproject.entities.User;
import Backendproject.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")

public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/users2")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.listAll();
        return new ResponseEntity<List<User>>(users, HttpStatus.OK);
    }

    @PostMapping("/users2/create")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User newUser = userService.save(user);
        return new ResponseEntity<User>(newUser, HttpStatus.CREATED);
    }

    @DeleteMapping("/users2/delete/{id}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable("id") Long id) {
        userService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}







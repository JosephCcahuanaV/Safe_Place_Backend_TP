package Backendproject.controllers;

import Backendproject.entities.Review;
import Backendproject.entities.Rol;
import Backendproject.services.ReviewService;
import Backendproject.services.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api")

public class RolController {

    @Autowired
    RolService rolService;

    @GetMapping("/roles")
    public ResponseEntity<List<Rol>> getAllRoles() {
        List<Rol> roles = rolService.listAll();
        return new ResponseEntity<List<Rol>>(roles, HttpStatus.OK);
    }

    @PostMapping("/roles/create")
    public ResponseEntity<Rol> createRol(@RequestBody Rol rol) {
        Rol newRol = rolService.save(rol);
        return new ResponseEntity<Rol>(newRol, HttpStatus.CREATED);
    }

    @DeleteMapping("/roles/{id}")
    public ResponseEntity<HttpStatus> deleteRol(@PathVariable("id") Long id) {
        rolService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }
}

package Backendproject.controllers;

import Backendproject.entities.Client;
import Backendproject.entities.Renter;
import Backendproject.repositories.RenterRepository;
import Backendproject.services.RenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api")

public class RenterController {

    @Autowired
    RenterService renterService;

    @GetMapping("/renters")
    public ResponseEntity<List<Renter>> getAllRenters() {
        List<Renter> renters = renterService.listAll();
        return new ResponseEntity<List<Renter>>(renters, HttpStatus.OK);
    }

    @PostMapping("/renters/create")
    public ResponseEntity<Renter> createRenter(@RequestBody Renter renter) {
        Renter newRenter = renterService.save(renter);
        return new ResponseEntity<Renter>(newRenter, HttpStatus.CREATED);
    }
    @DeleteMapping("/renters/{id}")
    public ResponseEntity<HttpStatus> deleteRenter(@PathVariable("id") Long id) {
        renterService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }




    }

package Backendproject.controllers;

import Backendproject.dtos.LocalDTO;
import Backendproject.dtos.RenterDTO;
import Backendproject.entities.Client;
import Backendproject.entities.Local;
import Backendproject.entities.Renter;
import Backendproject.repositories.RenterRepository;
import Backendproject.services.RenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")

public class RenterController {

    @Autowired
    RenterService renterService;

    @GetMapping("/renters")
    public ResponseEntity<List<Renter>> getAllRenders() {
        List<Renter> renters = renterService.listAll();
        return new ResponseEntity<List<Renter>>(renters, HttpStatus.OK);
    }

    @GetMapping("/renters/{id}")
    public ResponseEntity<Renter> getARenderById(@PathVariable("id") Long id) {
        Renter renter = renterService.findById(id);
        return new ResponseEntity<Renter>(renter, HttpStatus.OK);
    }

    @PostMapping("/renters/create")
    public ResponseEntity<Renter> createRender(@RequestBody Renter renter) {
        Renter newRenter = renterService.save(renter);
        return new ResponseEntity<Renter>(newRenter, HttpStatus.CREATED);
    }
    @DeleteMapping("/renters/delete/{id}")
    public ResponseEntity<HttpStatus> deleteRender(@PathVariable("id") Long id) {
        renterService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/renters/update/{id}")
    public ResponseEntity<Renter> updateRender(@RequestBody Renter renter, @PathVariable("id") Long id) {
        Renter foundRenter = renterService.findById(id);
        if (renter.getName()!=null) {
            foundRenter.setName(renter.getName());
        }

        if (renter.getLastname()!=null) {
            foundRenter.setLastname(renter.getLastname());
        }

        if (renter.getEmail()!=null) {
            foundRenter.setEmail(renter.getEmail());
        }

        if (renter.getNumberPhone()!=null) {
            foundRenter.setNumberPhone(renter.getNumberPhone());
        }

        if (renter.getDni()!=null) {
            foundRenter.setDni(renter.getDni());
        }




        Renter newRenter = renterService.save(foundRenter);
        return new ResponseEntity<Renter>(newRenter, HttpStatus.OK);
    }




}





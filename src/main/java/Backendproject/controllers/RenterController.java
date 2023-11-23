package Backendproject.controllers;

import Backendproject.dtos.RenterDTO;
import Backendproject.entities.Renter;
import Backendproject.services.RenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "**")
public class RenterController {
    @Autowired
    RenterService renterService;

    @GetMapping("/renters")
    public ResponseEntity<List<Renter>> getAllRenters() {
        List<Renter> renters = renterService.listAll();
        return new ResponseEntity<List<Renter>>(renters, HttpStatus.OK);
    }

    @GetMapping("/renters/{id}")
    public ResponseEntity<Renter> getARenderById(@PathVariable("id") Long id) {
        Renter renter = renterService.findById(id);
        renter.setLocals(null);

        return new ResponseEntity<Renter>(renter, HttpStatus.OK);
    }

    @PostMapping("/renters/create")
    public ResponseEntity<Renter> createRenter(@RequestBody Renter renter) {
        Renter newRenter = renterService.save(renter);
        return new ResponseEntity<Renter>(newRenter, HttpStatus.CREATED);
    }
    @DeleteMapping("/renters/delete/{id}")
    public ResponseEntity<HttpStatus> deleteRenter(@PathVariable("id") Long id) {
        renterService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/renters/update/{id}")
    public ResponseEntity<Renter> updateRenter(@RequestBody Renter renter, @PathVariable("id") Long id) {
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

        if (renter.getNumberphone()!=null) {
            foundRenter.setNumberphone(renter.getNumberphone());
        }

        if (renter.getDni()!=null) {
            foundRenter.setDni(renter.getDni());
        }

        if (renter.getRuc()!=null) {
            foundRenter.setRuc(renter.getRuc());
        }

        if (renter.getAddress()!=null) {
            foundRenter.setAddress(renter.getAddress());
        }
        if (renter.getNacionality()!=null) {
            foundRenter.setNacionality(renter.getNacionality());
        }

        if (renter.getBankAccount()!=null) {
            foundRenter.setBankAccount(renter.getBankAccount());
        }

        Renter newRenter = renterService.save(foundRenter);
        return new ResponseEntity<Renter>(newRenter, HttpStatus.OK);
    }

    @GetMapping("/nationality")
    public ResponseEntity<List<RenterDTO>> countRentersByNationality() {
        List<RenterDTO> result = renterService.countRentersByNationality2();
        return ResponseEntity.ok(result);
    }


}





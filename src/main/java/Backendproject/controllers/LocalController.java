package Backendproject.controllers;

import Backendproject.entities.Contract;
import Backendproject.entities.Local;
import Backendproject.services.ContractService;
import Backendproject.services.LocalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class LocalController {
    @Autowired
    LocalService localService;
    @GetMapping("/locals")
    public ResponseEntity<List<Local>> getAllReviews() {
        List<Local> locals = localService.listAll();
        return new ResponseEntity<List<Local>>(locals, HttpStatus.OK);
    }
    @PostMapping("/locals/create")
    public ResponseEntity<Local> createRenter(@RequestBody Local local) {
        Local newLocal = localService.save(local);
        return new ResponseEntity<Local>(newLocal, HttpStatus.CREATED);
    }
    @DeleteMapping("/locals/{id}")
    public ResponseEntity<HttpStatus> deleteReview(@PathVariable("id") Long id) {
        localService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}


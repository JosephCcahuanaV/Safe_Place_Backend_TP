package Backendproject.controllers;

import Backendproject.entities.Contract;
import Backendproject.entities.Review;
import Backendproject.services.ContractService;
import Backendproject.services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api")
public class ContractController {
    @Autowired
    ContractService contractService;
    @GetMapping("/contracts")
    public ResponseEntity<List<Contract>> getAllReviews() {
        List<Contract> contracts = contractService.listAll();
        return new ResponseEntity<List<Contract>>(contracts, HttpStatus.OK);
    }
    @PostMapping("/contracts/create")
    public ResponseEntity<Contract> createRenter(@RequestBody Contract contract) {
        Contract newContract = contractService.save(contract);
        return new ResponseEntity<Contract>(newContract, HttpStatus.CREATED);
    }
    @DeleteMapping("/contracts/{id}")
    public ResponseEntity<HttpStatus> deleteReview(@PathVariable("id") Long id) {
        contractService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

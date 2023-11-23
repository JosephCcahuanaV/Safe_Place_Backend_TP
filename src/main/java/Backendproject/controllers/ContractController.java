package Backendproject.controllers;

import Backendproject.entities.Contract;
import Backendproject.services.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "**")
public class ContractController {
    @Autowired
    ContractService contractService;
    @GetMapping("/contracts")
    public ResponseEntity<List<Contract>> getAllReviews() {
        List<Contract> contracts = contractService.listAll();
        return new ResponseEntity<List<Contract>>(contracts, HttpStatus.OK);
    }
    @GetMapping("/contracts/{id}")
    public ResponseEntity<Contract> getAContractById(@PathVariable("id") Long id) {
        Contract contract = contractService.findById(id);
        return new ResponseEntity<Contract>(contract, HttpStatus.OK);
    }

    @PostMapping("/contracts/create")
    public ResponseEntity<Contract> createContract(@RequestBody Contract contract) {
        Contract newContract = contractService.save(contract);
        return new ResponseEntity<Contract>(newContract, HttpStatus.CREATED);
    }
    @DeleteMapping("/contracts/delete/{id}")
    public ResponseEntity<HttpStatus> deleteContract(@PathVariable("id") Long id) {
        contractService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

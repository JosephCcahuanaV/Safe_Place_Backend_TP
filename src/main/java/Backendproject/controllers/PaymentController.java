package Backendproject.controllers;

import Backendproject.dtos.PaymentDTO;
import Backendproject.entities.Payment;
import Backendproject.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins="**")
public class PaymentController {
    @Autowired
    PaymentService paymentService;

    @GetMapping("/payments")
    public ResponseEntity<List<Payment>> getAllReviews() {
        List<Payment> payments = paymentService.listAll();
        return new ResponseEntity<List<Payment>>(payments, HttpStatus.OK);
    }

    @PostMapping("/payments/create")
    public ResponseEntity<String> createRenter(@RequestBody PaymentDTO payment) {
        paymentService.save(payment);
        return new ResponseEntity<String>("Created", HttpStatus.CREATED);
    }

    @DeleteMapping("/payments/delete/{id}")
    public ResponseEntity<HttpStatus> deleteReview(@PathVariable("id") Long id) {
        paymentService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}


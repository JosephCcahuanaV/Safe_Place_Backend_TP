package Backendproject.controllers;

import Backendproject.entities.Payment;
import Backendproject.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PaymentController {
    @Autowired
    PaymentService paymentService;
    @GetMapping("/payments")
    public ResponseEntity<List<Payment>> getAllPayments() {
        List<Payment> payments = paymentService.listAll();
        return new ResponseEntity<List<Payment>>(payments, HttpStatus.OK);
    }

    @PostMapping("/payments/create")
    public ResponseEntity<Payment> createPayment(@RequestBody Payment payment) {
        Payment newPayment = paymentService.save(payment);
        return new ResponseEntity<Payment>(newPayment, HttpStatus.CREATED);
    }
    @DeleteMapping("/payments/delete/{id}")
    public ResponseEntity<HttpStatus> deletePayment(@PathVariable("id") Long id) {
        paymentService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}


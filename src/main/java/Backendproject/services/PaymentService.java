package Backendproject.services;

import Backendproject.entities.Payment;

import java.util.List;

public interface PaymentService {

    public List<Payment> listAll();
    public Payment save(Payment payment);
    public void delete(Long id);

    public Payment findById(Long id);


}


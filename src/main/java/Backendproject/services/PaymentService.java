package Backendproject.services;

import Backendproject.dtos.PaymentDTO;
import Backendproject.entities.Payment;

import java.util.List;

public interface PaymentService {

    public List<Payment> listAll();
    public void save(PaymentDTO payment);
    public void delete(Long id);

    public Payment findById(Long id);
}


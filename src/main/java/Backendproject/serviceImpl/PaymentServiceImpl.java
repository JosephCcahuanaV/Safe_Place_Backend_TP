package Backendproject.serviceImpl;

import Backendproject.entities.Client;
import Backendproject.entities.Payment;
import Backendproject.exceptions.ResourceNotFoundException;
import Backendproject.repositories.PaymentRepository;
import Backendproject.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    PaymentRepository paymentRepository;
    @Override
    public List<Payment> listAll() {
        List<Payment> payments = paymentRepository.findAll();
        return payments;
    }

    @Override
    public Payment save(Payment payment) {
        return paymentRepository.save(payment);
    }

    @Override
    public void delete(Long id) {
        Payment payment = findById(id);
        paymentRepository.delete(payment);


    }

    @Override
    public Payment findById(Long id) {
        Payment paymentFound = paymentRepository.findById(id).orElse(null);
        if (paymentFound == null) {
            throw new ResourceNotFoundException("There are no object with the id: "+String.valueOf(id));
        }

        return paymentFound;
    }
}


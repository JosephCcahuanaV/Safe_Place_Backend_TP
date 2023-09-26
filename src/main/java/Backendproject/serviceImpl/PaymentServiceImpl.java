package Backendproject.serviceImpl;

import Backendproject.entities.Payment;
import Backendproject.repositories.ContractRepository;
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
        return null;
    }

    @Override
    public Payment save(Payment payment) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}

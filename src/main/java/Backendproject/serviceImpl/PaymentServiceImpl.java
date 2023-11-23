package Backendproject.serviceImpl;

import Backendproject.dtos.PaymentDTO;
import Backendproject.entities.Booking;
import Backendproject.entities.Payment;
import Backendproject.exceptions.ResourceNotFoundException;
import Backendproject.repositories.BookingRepository;
import Backendproject.repositories.PaymentRepository;
import Backendproject.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentServiceImpl implements PaymentService {
    @Autowired
    PaymentRepository paymentRepository;
    @Autowired
    BookingRepository bookingRepository;


    @Override
    public List<Payment> listAll() {
        List<Payment> payments = paymentRepository.findAll();
        return payments;
    }

    // @Override
    // public void save(PaymentDTO pdto) {
    //     Optional<Booking> booking = bookingRepository.findById(pdto.getBookingId());
    
    //     // Pasar todos los datos del DTO a una nueva entidad
    //     Payment payment = new Payment();
    //     payment.convertDtoToEntity(pdto);
    
    //     // paymentRepository.save(payment);
    //     // booking.get().setPayment(payment);
    //     // bookingRepository.save(booking.get());
    // }

    @Override
    public void save(PaymentDTO pdto) {
        // Find the corresponding Booking entity
        Optional<Booking> bookingOpt = bookingRepository.findById(pdto.getBookingId());

        if (!bookingOpt.isPresent()) {
            return;
        }

        Booking booking = bookingOpt.get();

        Payment payment = new Payment();
        payment.convertDtoToEntity(pdto);

        paymentRepository.save(payment);
        booking.setPayment(payment);
        payment.setBooking(booking);

        bookingRepository.save(booking);
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


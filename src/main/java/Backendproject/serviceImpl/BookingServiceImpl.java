package Backendproject.serviceImpl;

import Backendproject.entities.Booking;
import Backendproject.entities.Review;
import Backendproject.repositories.BookingRepository;
import Backendproject.services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class BookingServiceImpl implements BookingService {

    @Autowired
    BookingRepository bookingRepository;
    @Override
    public List<Booking> listAll() {
        List<Booking> bookings=bookingRepository.findAll();
        return bookings;
    }

    @Override
    public Booking save(Booking booking) {
        return bookingRepository.save(booking);
    }

    @Override
    public void delete(Long id) {
        Booking booking = findById(id);
        bookingRepository.delete(booking);
    }

    @Override
    public Booking findById(Long id) {
        Booking bookingFound = bookingRepository.findById(id).orElse(null);
        return bookingFound;
    }
}

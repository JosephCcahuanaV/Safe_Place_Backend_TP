package Backendproject.serviceImpl;

import Backendproject.entities.Booking;
import Backendproject.repositories.BookingRepository;
import Backendproject.repositories.ContractRepository;
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
        return null;
    }

    @Override
    public Booking save(Booking booking) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public Booking findById(Long id) {
        return null;
    }
}

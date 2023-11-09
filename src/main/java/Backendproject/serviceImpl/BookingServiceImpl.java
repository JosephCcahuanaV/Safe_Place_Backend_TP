package Backendproject.serviceImpl;

import Backendproject.entities.Booking;
import Backendproject.entities.Review;
import Backendproject.exceptions.ResourceNotFoundException;
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
        List<Booking> bookings= bookingRepository.findAll();
        return bookings;
    }

    @Override
    public Booking save(Booking booking) {

        List<Booking> historial=bookingRepository.findByClientId(booking.getClient().getId());
        for(Booking b: historial){
            if(b.getLocal().getId().equals(booking.getLocal().getId()) ){
                throw new RuntimeException("El local ya se encuentra reservado");
            }
        }


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

        if (bookingFound == null) {
            throw new ResourceNotFoundException("There are no object with the id: "+String.valueOf(id));
        }

        return bookingFound;
    }
}

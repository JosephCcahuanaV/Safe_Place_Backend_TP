package Backendproject.serviceImpl;

import Backendproject.entities.Booking;
import Backendproject.entities.Client;
import Backendproject.entities.Review;
import Backendproject.exceptions.ResourceNotFoundException;
import Backendproject.repositories.BookingRepository;
import Backendproject.repositories.ClientRepository;
import Backendproject.services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class BookingServiceImpl implements BookingService {

    @Autowired
    BookingRepository bookingRepository;
    @Autowired
    ClientRepository clientRepository;
    @Override
    public List<Booking> listAll() {
        List<Booking> bookings= bookingRepository.findAll();
        return bookings;
    }

    @Override
    public Booking save(Booking booking, String clientName) {
        System.out.println("---------------------------------------------------");
        Client client = clientRepository.findByName(clientName);
        System.out.println(client);
        System.out.println(booking);

        booking.setClient(client);
        System.out.println("---------------------------------------------------");
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

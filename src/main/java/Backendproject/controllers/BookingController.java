package Backendproject.controllers;

import Backendproject.entities.Booking;
import Backendproject.entities.Client;
import Backendproject.repositories.ClientRepository;
import Backendproject.services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class BookingController {

    @Autowired
    BookingService bookingService;

    @Autowired
    ClientRepository clientRepository;
    @GetMapping("/bookings/{username}")
    public ResponseEntity<List<Booking>> getAllReviews(@PathVariable("username") String username) {
        Client client = clientRepository.findByName(username);

        if (client == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        if (client.getBookings().isEmpty() || client.getBookings() == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        List<Booking> bookings = client.getBookings();
        for(Booking book : bookings) {
            book.setClient(null);
            
            if (book.getPayment() != null) {
                book.getPayment().setBooking(null);
            } else {
                book.setPayment(null);
            }
        }
        return new ResponseEntity<List<Booking>>(bookings, HttpStatus.OK);
    }

    @PostMapping("/bookings/create")
    public ResponseEntity<String> createRenter(@RequestBody Booking booking, @RequestParam String username) {
         bookingService.save(booking,username);
        return new ResponseEntity<String>("", HttpStatus.CREATED);
    }
    @DeleteMapping("/bookings/delete/{id}")
    public ResponseEntity<HttpStatus> deleteReview(@PathVariable("id") Long id) {
        bookingService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}

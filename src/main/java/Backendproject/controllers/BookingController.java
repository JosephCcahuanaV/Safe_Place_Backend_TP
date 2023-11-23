package Backendproject.controllers;

import Backendproject.entities.Booking;
import Backendproject.entities.Client;
import Backendproject.entities.Review;
import Backendproject.repositories.ClientRepository;
import Backendproject.services.BookingService;
import Backendproject.services.ReviewService;
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
    public ResponseEntity<List<Booking>> getAllBookings(@PathVariable("username") String username) {
        Client client = clientRepository.findByName(username);
        List<Booking> bookings = client.getBookings();
        for(Booking book : bookings) {
            book.setClient(null);
        }
        return new ResponseEntity<List<Booking>>(bookings, HttpStatus.OK);
    }
    @PostMapping("/bookings/create")
    public ResponseEntity<String> createBooking(@RequestBody Booking booking, @RequestParam String username) {
        bookingService.save(booking,username);
        return new ResponseEntity<String>("", HttpStatus.CREATED);
    }
    @DeleteMapping("/bookings/delete/{id}")
    public ResponseEntity<HttpStatus> deleteBooking(@PathVariable("id") Long id) {
        bookingService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}

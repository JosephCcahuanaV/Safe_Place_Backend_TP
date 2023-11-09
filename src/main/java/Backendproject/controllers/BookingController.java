package Backendproject.controllers;

import Backendproject.entities.Booking;
import Backendproject.entities.Review;
import Backendproject.services.BookingService;
import Backendproject.services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BookingController {

    @Autowired
    BookingService bookingService;

    @GetMapping("/bookings")
    public ResponseEntity<List<Booking>> getAllBookings() {
        List<Booking> bookings = bookingService.listAll();
        return new ResponseEntity<List<Booking>>(bookings, HttpStatus.OK);
    }
    @PostMapping("/bookings/create")
    public ResponseEntity<Booking> createBooking(@RequestBody Booking booking) {
        Booking newBooking = bookingService.save(booking);
        return new ResponseEntity<Booking>(newBooking, HttpStatus.CREATED);
    }
    @DeleteMapping("/bookings/delete/{id}")
    public ResponseEntity<HttpStatus> deleteBooking(@PathVariable("id") Long id) {
        bookingService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}

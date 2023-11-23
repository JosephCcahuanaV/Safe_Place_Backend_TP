package Backendproject.controllers;

import Backendproject.entities.Review;
import Backendproject.services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "**")
public class ReviewController {
    @Autowired
    ReviewService reviewService;

    @GetMapping("/reviews")
    public ResponseEntity<List<Review>> getAllReviews() {
        List<Review> reviews = reviewService.listAll();
        return new ResponseEntity<List<Review>>(reviews, HttpStatus.OK);
    }

    @PostMapping("/reviews/create")
    public ResponseEntity<Review> createRenter(@RequestBody Review review) {
        Review newReview = reviewService.save(review);
        return new ResponseEntity<Review>(newReview, HttpStatus.CREATED);
    }
    @DeleteMapping("/reviews/delete/{id}")
    public ResponseEntity<HttpStatus> deleteReview(@PathVariable("id") Long id) {
        reviewService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/reviews/{id}")
    public ResponseEntity<Review> getAReviewById(@PathVariable("id") Long id) {
        Review review = reviewService.findById(id);
        return new ResponseEntity<Review>(review, HttpStatus.OK);
    }

}

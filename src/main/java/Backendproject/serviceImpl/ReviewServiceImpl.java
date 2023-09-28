package Backendproject.serviceImpl;


import Backendproject.entities.Renter;
import Backendproject.entities.Review;
import Backendproject.exceptions.ResourceNotFoundException;
import Backendproject.repositories.ReviewRepository;
import Backendproject.services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    ReviewRepository reviewRepository;

    @Override
    public List<Review> listAll() {

        List<Review> reviews=reviewRepository.findAll();
        return reviews;
    }

    @Override
    public Review save(Review review) {
        return reviewRepository.save(review);
    }

    @Override
    public void delete(Long id) {
        Review review = findById(id);
        reviewRepository.delete(review);
    }

    @Override
    public Review findById(Long id) {
        Review reviewFound = reviewRepository.findById(id).orElse(null);

        if (reviewFound == null) {
            throw new ResourceNotFoundException("There are no object with the id: "+String.valueOf(id));
        }

        return reviewFound;
    }
}

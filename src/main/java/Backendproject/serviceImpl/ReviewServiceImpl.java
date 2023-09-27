package Backendproject.serviceImpl;


import Backendproject.entities.Review;
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
        return null;
    }

    @Override
    public Review save(Review review) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}

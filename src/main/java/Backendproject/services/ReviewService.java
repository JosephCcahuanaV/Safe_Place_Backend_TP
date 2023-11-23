package Backendproject.services;

import Backendproject.entities.Renter;
import Backendproject.entities.Review;

import java.util.List;

public interface ReviewService {

    public List<Review> listAll();
    public Review save(Review review);
    public void delete(Long id);

    public Review findById(Long id);

}

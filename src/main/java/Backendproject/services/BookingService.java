package Backendproject.services;

import Backendproject.entities.Booking;
import Backendproject.entities.Client;

import java.util.List;

public interface BookingService {

    public List<Booking> listAll();
    public Booking save(Booking booking);
    public void delete(Long id);

    public Booking findById(Long id);

}

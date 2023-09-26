package Backendproject.services;

import Backendproject.entities.Renter;

import java.util.List;

public interface RenterService {
    public List<Renter> listAll();
    public Renter save(Renter renter);
    public void delete(Long id);

}

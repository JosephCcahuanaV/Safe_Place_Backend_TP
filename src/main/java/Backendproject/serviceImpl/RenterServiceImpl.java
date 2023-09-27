package Backendproject.serviceImpl;

import Backendproject.entities.Renter;
import Backendproject.repositories.RenterRepository;
import Backendproject.services.RenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RenterServiceImpl implements RenterService {
    @Autowired
    RenterRepository renterRepository;

    @Override
    public List<Renter> listAll() {
        return null;
    }

    @Override
    public Renter save(Renter renter) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}

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

        List<Renter> renters=renterRepository.findAll();
        return renters;
    }

    @Override
    public Renter save(Renter renter) {

        return renterRepository.save(renter);
    }

    @Override
    public void delete(Long id){
        Renter renter=findById(id);
        renterRepository.delete(renter);
    }

    @Override
    public Renter findById(Long id) {
        Renter renterFound=renterRepository.findById(id).orElse(null);
        return renterFound;
    }


}

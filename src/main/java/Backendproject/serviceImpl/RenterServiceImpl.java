package Backendproject.serviceImpl;

import Backendproject.entities.Renter;
import Backendproject.exceptions.IncompleteDataException;
import Backendproject.exceptions.KeyRepeatedDataException;
import Backendproject.exceptions.ResourceNotFoundException;
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

        if (renter.getName()==null || renter.getName().isEmpty()) {
            throw new IncompleteDataException("name can not be null or empty");
        }

        return renterRepository.save(renter);
    }

    @Override
    public void delete(Long id){
        Renter renter=findById(id);
        renterRepository.delete(renter);
    }

    @Override
    public Renter findById(Long id) {
        Renter renterFound = renterRepository.findById(id).orElse(null);
        if (renterFound == null) {
            throw new ResourceNotFoundException("There are no object with the id: "+String.valueOf(id));
        }


        return renterFound;
    }


}

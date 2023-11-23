package Backendproject.serviceImpl;

import Backendproject.dtos.ClientDTO;
import Backendproject.dtos.RenterDTO;
import Backendproject.entities.Renter;
import Backendproject.exceptions.IncompleteDataException;
import Backendproject.exceptions.KeyRepeatedDataException;
import Backendproject.exceptions.ResourceNotFoundException;
import Backendproject.repositories.RenterRepository;
import Backendproject.repositories.UserSecurityRepository;
import Backendproject.services.RenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RenterServiceImpl implements RenterService {
    @Autowired
    RenterRepository renterRepository;
    @Autowired
    UserSecurityRepository securityRepository;

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
        // Solucion pendeja
        String username = securityRepository.findById(id).orElse(null).getUserName();
        Renter renterFound = renterRepository.findByName(username);
        if (renterFound == null) {
            throw new ResourceNotFoundException("There are no object with the id: "+String.valueOf(id));
        }
        return renterFound;
    }

    /*@Override
    public List<Object[]> countRentersByNationality() {
        return renterRepository.countRentersByNationality();
    }*/

    public List<RenterDTO> countRentersByNationality2() {
        List<Object[]> results = renterRepository.countRentersByNationality();
        List<RenterDTO> renterDTOS = new ArrayList<>();

        for (Object[] result : results) {
            String nacionality = (String) result[0];
            Long count = (Long) result[1];
            RenterDTO renterDTO = new RenterDTO(nacionality, count);
            renterDTOS.add(renterDTO);
        }

        return renterDTOS;
    }


}

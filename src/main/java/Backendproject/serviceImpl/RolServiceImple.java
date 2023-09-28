package Backendproject.serviceImpl;


import Backendproject.entities.Review;
import Backendproject.entities.Rol;
import Backendproject.exceptions.IncompleteDataException;
import Backendproject.exceptions.KeyRepeatedDataException;
import Backendproject.exceptions.ResourceNotFoundException;
import Backendproject.repositories.RolRepository;
import Backendproject.services.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RolServiceImple implements RolService {

    @Autowired
    RolRepository rolRepository;
    @Override
    public List<Rol> listAll() {
        List<Rol> rols=rolRepository.findAll();
        return rols;
    }

    @Override
    public Rol save(Rol rol) {

        if (rol.getName()==null || rol.getName().isEmpty()) {
            throw new IncompleteDataException("name can not be null or empty");
        }
        return rolRepository.save(rol);
    }

    @Override
    public void delete(Long id){
        Rol rol=findById(id);
        rolRepository.delete(rol);
    }

    @Override
    public Rol findById(Long id){
        Rol rolFound = rolRepository.findById(id).orElse(null);
        if (rolFound == null) {
            throw new ResourceNotFoundException("There are no object with the id: "+String.valueOf(id));
        }

        return rolFound;
    }


}

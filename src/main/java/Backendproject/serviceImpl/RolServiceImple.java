package Backendproject.serviceImpl;


import Backendproject.entities.Review;
import Backendproject.entities.Rol;
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
        return rolFound;
    }


}

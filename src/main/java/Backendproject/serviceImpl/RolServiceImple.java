package Backendproject.serviceImpl;


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
        return null;
    }

    @Override
    public Rol save(Rol rol) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}

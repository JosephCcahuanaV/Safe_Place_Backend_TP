package Backendproject.services;

import Backendproject.entities.Review;
import Backendproject.entities.Rol;

import java.util.List;

public interface RolService {

    public List<Rol> listAll();
    public Rol save(Rol rol);
    public void delete(Long id);

    public Rol findById(Long id);


}

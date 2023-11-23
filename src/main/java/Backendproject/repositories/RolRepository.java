package Backendproject.repositories;


import Backendproject.entities.Rol;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RolRepository extends JpaRepository<Rol, Long> {

    //List<Rol> findByNameContaining(String name);
}
